package com.lhs.pay.web.boss.controller;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.user.enums.UserTypeEnum;
import com.lhs.pay.facade.user.service.MemberInfoFacade;
import com.lhs.pay.web.boss.base.BossBaseController;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * MemberInfoController
 *
 * @author longhuashen
 * @since 16/3/19
 */
@Controller
@RequestMapping("/member")
public class MemberInfoController extends BossBaseController {

    @Autowired
    private MemberInfoFacade memberInfoFacade;

    @RequestMapping("/listMemberInfo")
    public String listMemberInfo() {
        return "member/memberInfoList";
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(@RequestParam(value = "memberNo", defaultValue = "") String memberNo,
                                              @RequestParam(value = "realName", defaultValue = "") String realName,
                                              @RequestParam(value = "cardNo", defaultValue = "") String cardNo,
                                              @RequestParam(value = "startDate", required = false) Date startDate,
                                              @RequestParam(value = "endDate", required = false) Date endDate,
                                              @RequestParam(value = "status", required = false) String status,
                                              @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                                              @RequestParam(value = "rows", defaultValue = "10", required = false) Integer rows) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        //校验时间
        if (startDate != null && endDate != null) {
            paramMap.put("startDate", startDate);
            paramMap.put("endDate", endDate);
        }
        paramMap.put("status", status);
        paramMap.put("userType", UserTypeEnum.CUSTOMER.getValue());


        PageBean pageBean = memberInfoFacade.listPage(new PageParam(page, rows), paramMap);
        //model.addAttribute("memberStatusList", MemberStatusEnum)
        resultMap.put("total", pageBean.getTotalCount());
        resultMap.put("rows", pageBean.getRecordList());
        return resultMap;
    }
}
