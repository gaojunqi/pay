package com.lhs.pay.test;

import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.user.enums.UserTypeEnum;
import com.lhs.pay.facade.user.service.MemberInfoFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * TestMemberInfo
 *
 * @author longhuashen
 * @since 16/4/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring/spring-context.xml")
public class TestMemberInfo {

    @Autowired
    private MemberInfoFacade memberInfoFacade;

    @Test
    public void testListMemberInfo() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startDate", "2013-1-1");
        paramMap.put("endDate", "2015-1-1");
        paramMap.put("userType", UserTypeEnum.CUSTOMER.getValue());
System.out.println("================" + memberInfoFacade.listPage(new PageParam(0,20),paramMap));
    }
}
