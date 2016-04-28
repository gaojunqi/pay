package com.lhs.pay.web.boss.controller;

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
    public String listMemberInfo(
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        //校验时间
//        if (startDate != null && endDate != null) {
//            //取得两个日期之间的日数
//            DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
//            DateTime startDateTime = DateTime.parse(startDate, format);
//            DateTime endDateTime = DateTime.parse(endDate, format);
//            int days = Days.daysBetween(startDateTime, endDateTime).getDays();
//
//            if (days < 0) {
//                //return this.operateError("开始时间不能大于结束时间");
//            } else if ((startDate != null && endDate == null) || (startDate == null && endDate != null)) {
//                //do
//            }
//
//        }
//        paramMap.put("startDate", startDate);
//        paramMap.put("endDate", endDate);
//        paramMap.put("status", status);
//        paramMap.put("userType", UserTypeEnum.CUSTOMER.getValue());
//
//        String numPerPageStr =  request.getParameter("numPerPage");
//        int numPerPage = 20;
//        if (StringUtils.isNotBlank(numPerPageStr)) {
//            numPerPage = Integer.parseInt(numPerPageStr);
//        }
//        int a = getPageNum();
//System.out.println("=========================>" + memberInfoFacade.listPage(new PageParam(getPageNum(), numPerPage), paramMap));
//        model.addAttribute("recordList", memberInfoFacade.listPage(new PageParam(getPageNum(), numPerPage), paramMap));
        //model.addAttribute("memberStatusList", MemberStatusEnum)
        return "member/memberInfoList";
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam("memberNo") String memberNo,
                                              @RequestParam("realName") String realName,
                                              @RequestParam("cardNo") String cardNo,
                                              @RequestParam("startDate") String startDate,
                                              @RequestParam("endDate") String endDate,
                                              @RequestParam("status") String status,
                                              HttpServletRequest request,
                                              HttpServletResponse response,
                                              Model model) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        //校验时间
        if (startDate != null && endDate != null) {
            //取得两个日期之间的日数
            DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
            DateTime startDateTime = DateTime.parse(startDate, format);
            DateTime endDateTime = DateTime.parse(endDate, format);
            int days = Days.daysBetween(startDateTime, endDateTime).getDays();

            if (days < 0) {
                //return this.operateError("开始时间不能大于结束时间");
            } else if ((startDate != null && endDate == null) || (startDate == null && endDate != null)) {
                //do
            }

        }
        paramMap.put("startDate", startDate);
        paramMap.put("endDate", endDate);
        paramMap.put("status", status);
        paramMap.put("userType", UserTypeEnum.CUSTOMER.getValue());

        String numPerPageStr =  request.getParameter("numPerPage");
        int numPerPage = 20;
        if (StringUtils.isNotBlank(numPerPageStr)) {
            numPerPage = Integer.parseInt(numPerPageStr);
        }
        model.addAttribute("recordList", memberInfoFacade.listPage(new PageParam(getPageNum(), numPerPage), paramMap));
        //model.addAttribute("memberStatusList", MemberStatusEnum)
        return paramMap;
    }
}
