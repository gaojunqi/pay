package com.lhs.pay.common.web.exception;

import java.text.MessageFormat;

/**
 * WebException
 * web应用异常类，所有web应用异常都必须继承于此异常
 *
 * @author longhuashen
 * @since 16/3/19
 */
public class WebException extends RuntimeException {

    /**
     * 异常id,用于表示某一异常实例，每一个异常实例都有一个唯一的id
     */
    protected String id;

    /**
     * 异常信息，包含必要的上下文业务信息，用于打印日志
     */
    protected String message;

    /**
     * 具体异常码，由各具体异常实例化时自己定义
     */
    protected String defineCode;

    /**
     * 异常类名
     */
    protected String realClassName;

    public WebException(String defineCode, String message) {
        super();
        this.defineCode = defineCode;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message, Object... args) {
        this.message = MessageFormat.format(message, args);
    }

    public String getDefineCode() {
        return defineCode;
    }
}
