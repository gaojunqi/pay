package com.lhs.pay.common.web.constant;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PermissionConstant
 * 会话键常量
 *
 * @author longhuashen
 * @since 16/3/18
 */
public class PermissionConstant {

    private static final Log LOG = LogFactory.getLog(PermissionConstant.class);

    /**
     * 登陆操作员的session键名
     */
    public static final String OPERATOR_SESSION_KEY = "pmsOperator";

    /**
     * 登陆操作员拥有的权限集合的session键名
     */
    public static final String ACTIONS_SESSION_KEY = "actions";

    /**
     * 操作员在线用户数限制(默认100)
     */
    public static int WEB_ONLINE_LIMIT = 100;

    /**
     * 操作员密码连续输错次数限制
     */
    public static int WEB_PWD_INPUT_LIMIT = 5;

    /**
     * 只加载一次
     */
    static {
        try {
            LOG.info("=== load permission.properties and init");
            InputStream proFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("permission.properties");
            Properties properties = new Properties();
            properties.load(proFile);
            init(properties);
        } catch (IOException e) {
            LOG.error("=== load and init permission.properties exception:", e);
        }

    }

    private static void init(Properties properties) {
        String web_online_limit = properties.getProperty("web_online_limit");
        if (StringUtils.isNotBlank(web_online_limit)) {
            WEB_ONLINE_LIMIT = Integer.valueOf(web_online_limit);
            LOG.info("===> WEB_ONLINE_LIMIT:" + web_online_limit);
        }

        String web_pwd_input_error_limit = properties.getProperty("web_pwd_input_error_limit");
        if (StringUtils.isNotBlank(web_pwd_input_error_limit)) {
            WEB_PWD_INPUT_LIMIT = Integer.valueOf(web_pwd_input_error_limit);
            LOG.info("===> WEB_PWD_INPUT_LIMIT:" + web_pwd_input_error_limit);
        }
    }
}
