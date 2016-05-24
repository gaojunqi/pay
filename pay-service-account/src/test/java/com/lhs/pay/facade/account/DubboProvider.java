package com.lhs.pay.facade.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DubboProvider
 *
 * @author longhuashen
 * @since 16/5/24
 */
public class DubboProvider {

    private static final Logger log = LoggerFactory.getLogger(DubboProvider.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-context.xml");
            context.start();
        } catch (Exception e) {
            log.error("==>DubboProvider context start error:", e);
        }

        synchronized (DubboProvider.class) {
            while (true) {
                try {
                    DubboProvider.class.wait();
                } catch (InterruptedException e) {
                    log.error("===>synchronized error:", e);
                }
            }
        }
    }
}
