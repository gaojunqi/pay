package com.lhs.pay.web.permission.controller;

import com.lhs.pay.common.enums.OperatorStatusEnum;
import com.lhs.pay.common.web.constant.PermissionConstant;
import com.lhs.pay.web.permission.biz.IPmsActionBiz;
import com.lhs.pay.web.permission.biz.IPmsMenuBiz;
import com.lhs.pay.web.permission.biz.IPmsOperatorBiz;
import com.lhs.pay.web.permission.biz.IPmsRoleBiz;
import com.lhs.pay.web.permission.entity.PmsAction;
import com.lhs.pay.web.permission.entity.PmsOperator;
import com.lhs.pay.web.permission.exception.PermissionException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PmsLoginController
 *
 * @author longhuashen
 * @since 16/3/19
 */
@Controller
public class PmsLoginController {

    private static final Log log = LogFactory.getLog(PmsLoginController.class);

    @Autowired
    private IPmsOperatorBiz pmsOperatorBiz;

    @Autowired
    private IPmsRoleBiz pmsRoleBiz;

    @Autowired
    private IPmsMenuBiz pmsMenuBiz;

    @Autowired
    private IPmsActionBiz pmsActionBiz;

    /**
     * 进入登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String operateLogin(@RequestParam(value = "loginName", required = true) String loginName
            , @RequestParam(value = "loginPwd", required = true) String pwd
            , @RequestParam(value = "code", required = true) String code
            , ModelMap model
            , HttpServletRequest request) {
        try {
            if (StringUtils.isBlank(loginName)) {
                model.put("loginNameMsg", "用户名不能为空");
                return "login";
            }
            model.put("loginName", loginName);
            Object operatorSession = request.getSession().getAttribute(PermissionConstant.OPERATOR_SESSION_KEY);

            //校验验证码
            if (operatorSession == null) {
                String kaptchaCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
                if (StringUtils.isBlank(code)) {
                    model.put("codeMsg", "请输入验证码");
                    return "login";
                } else if (!code.equalsIgnoreCase(kaptchaCode)) {
                    model.put("codeMsg", "验证码不正确");
                    return "login";
                }
            }

            PmsOperator operator = pmsOperatorBiz.findOperatorByLoginName(loginName);
            if (operator == null) {
                log.warn("====> 登录名【" + loginName + "】不存在");
                model.put("loginNameMsg", "用户名或密码不正确");
                return "login";
            }

            if (OperatorStatusEnum.INACTIVE.getValue() == operator.getStatus().intValue()) {
                log.warn("====> 账号【" + loginName + "】已被冻结");
                model.put("loginNameMsg", "该账号已被冻结");
                return "login";
            }

            if (StringUtils.isBlank(pwd)) {
                model.put("loginPwdMsg", "密码不能为空");
                return "login";
            }

            //加密明文密码，验证密码
            if (operator.getLoginPwd().equals(DigestUtils.sha1Hex(pwd))) {//密码正确
                int currentLoginCount = 0;
                if (currentLoginCount > PermissionConstant.WEB_ONLINE_LIMIT) {
                    log.info("===>系统繁忙，已超最大在线用户数限制【" + PermissionConstant.WEB_ONLINE_LIMIT + "】");
                    model.put("errMsg", "系统繁忙，已超最大用户数限制");
                    return "login";
                }

                //用户信息，包括登陆信息和权限
                request.getSession().setAttribute(PermissionConstant.OPERATOR_SESSION_KEY, operator);
                request.getSession().setAttribute(PermissionConstant.ACTIONS_SESSION_KEY, getActions(operator));
                model.put("loginName", loginName);
                model.put("realName", operator.getRealName());
                model.put("lastLoginTime", operator.getLastLoginTime());


                try {
                    //获取用户的菜单权限
                    model.put("tree", buildOperatorPermissionMenu(operator));

                    //更新登陆数据
                    operator.setLastLoginTime(new Date());
                    operator.setPwdErrorCount(0);
                    pmsOperatorBiz.update(operator);
                } catch (Exception e) {
                    log.error("===>登陆异常", e);
                    model.put("errMsg", "登陆出错");
                    return "login";
                }

                model.put("isChangePwd", operator.getIsChangedPwd());
                return "index";

            } else {//密码错误
                log.warn("密码错误");
                Integer pwdErrorCount = operator.getPwdErrorCount();
                if (pwdErrorCount == null) {
                    pwdErrorCount = 0;
                }
                operator.setPwdErrorCount(pwdErrorCount + 1);
                operator.setPwdErrorTime(new Date());//设为当前时间
                String msg = "";
                if (operator.getPwdErrorCount().intValue() >= PermissionConstant.WEB_PWD_INPUT_LIMIT) {
                    //超过5次就冻结账号
                    operator.setStatus(OperatorStatusEnum.INACTIVE.getValue());
                    msg += "<br/>密码已连续输错【" + PermissionConstant.WEB_PWD_INPUT_LIMIT + "】次，账号已被冻结";
                } else {
                    msg += "<br/>密码错误，再输错【" + (PermissionConstant.WEB_PWD_INPUT_LIMIT - operator.getPwdErrorCount().intValue()) + "】次，将冻结账号！";
                }

                pmsOperatorBiz.update(operator);
                model.put("loginPwdMsg", msg);
                return "login";
            }
        } catch (RuntimeException e) {
            log.error("login exception", e);
            model.put("errorMsg", "登陆出错");
            return "login";
        } catch (Exception e) {
            log.error("login exception", e);
            model.put("errorMsg", "登陆出错");
            return "login";
        }
    }

    private String buildOperatorPermissionMenu(PmsOperator operator) throws PermissionException {
        //根据用户id得到该用户的所有角色拼成的字符串
        String roleIds = pmsRoleBiz.getRoleIdsByOperatorId(operator.getId());
        if (StringUtils.isBlank(roleIds)) {
            log.error("===>用户[" + operator.getLoginName() + "]没有配置对应的权限角色");
            throw new RuntimeException("该账号已被取消所有系统权限");
        }
        //根据操作员拥有的角色ID,构建管理后台的树形权限功能菜单
        return pmsMenuBiz.buildPermissionTree(roleIds);
    }

    private Object getActions(PmsOperator operator) {
        //根据用户ID得到该用户的所有角色拼成的字符串
        String roleIds = pmsRoleBiz.getRoleIdsByOperatorId(operator.getId());
        //根据角色ID字符串得到该用户的所有权限拼成的字符串
        String actionIds = "";
        if (StringUtils.isNotBlank(roleIds)) {
            actionIds = pmsActionBiz.getActionIdsByRoleIds(roleIds);
        }
        //根据权限ID字符串得到权限列表
        List<PmsAction> pmsActionList = new ArrayList<>();
        if (!"".equals(actionIds)) {
            pmsActionList = pmsActionBiz.findActionsByIdStr(actionIds);
        }
        //将权限放入HashMap中，其中key为权限，值为权限对象
        List<String> actionList = new ArrayList<>();
        for (PmsAction pmsAction : pmsActionList) {
            actionList.add(pmsAction.getAction());
        }
        return actionList;
    }
}
