package com.lhs.pay.test;

import com.lhs.pay.common.config.PublicConfig;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.facade.user.service.UserManagementFacade;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TestUserAuditRecordClose
 *
 * @author longhuashen
 * @since 16/7/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring/spring-context.xml")
public class TestUserAuditRecordClose {

    @Autowired
    private UserManagementFacade userManagementFacade;

    @Test
    public void testGetByUserNo_auditStatus() {
        UserInfo userInfo = userManagementFacade.merchantLogin("1288888888@gzzyzz.com", DigestUtils.sha1Hex("123456"), PublicConfig.PWD_ERROR_LIMIT_TIMES, PublicConfig.PWD_ERROR_LIMIT_TIME);
    }
}
