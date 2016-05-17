package com.lhs.pay.common.exceptions;

/**
 * BizException
 *
 * 业务异常基类
 *
 * @author longhuashen
 * @since 16/3/21
 */
public class BizException extends RuntimeException {

    /**
     * 数据库操作，insert返回0
     */
    public static final BizException DB_INSERT_RESULT_0 = new BizException(90040001, "数据库操作，insert返回0");    /**

     /**
     * 数据库操作，insert返回0
     */
    public static final BizException DB_UPDATE_RESULT_0 = new BizException(90040002, "数据库操作，insert返回0");

    /**
     * 数据库操作，selectOne返回null
     */
    public static final BizException DB_SELECTONE_IS_NULL = new BizException(90040003, "数据库操作，insert返回0");

    /**
     * 数据库操作，list返回null
     */
    public static final BizException DB_LIST_IS_NULL = new BizException(90040004, "数据库操作，list返回null");

    /**
     * Token验证不通过
     */
    public static final BizException TOKEN_IS_ILLICIT = new BizException(90040005, "Token验证非法");

    /**
     * 会话超时，获取session时，如果是空,throws下面这个异常，拦截器会拦截会话超时页面
     */
    public static final BizException SESSION_IS_OUT_TIME = new BizException(90040006, "会话超时");

    /**
     * 获取序列出错
     */
    public static final BizException DB_GET_SEQ_NEXT_VALUE_ERROR = new BizException(90040007, "获取序列出错");

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 异常具体码
     */
    protected int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public BizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizException() {
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String msg) {
        super(msg);
    }
}
