package com.lhs.pay.test;

import com.lhs.pay.web.permission.dao.IPmsActionDao;
import com.lhs.pay.web.permission.dao.IPmsMenuDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TestBase
 *
 * @author longhuashen
 * @since 16/4/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring/spring-context.xml")
public class TestBase {

    @Autowired
    private IPmsActionDao pmsActionDao;

    @Test
    public void testInsert() {
System.out.println("..." + pmsActionDao.listByMenuId(2l));
    }
}
