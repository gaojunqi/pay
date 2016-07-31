package com.lhs.pay.facade.boss.exception;

import com.lhs.pay.common.exceptions.BizException;

/**
 * BossBizException
 *
 * BOSS接口异常类
 *
 * @author longhuashen
 * @since 16/7/31
 */
public class BossBizException extends BizException {

    public BossBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public BossBizException() {
    }

    public BossBizException(int code, String msg) {
        super(code, msg);
    }

    public BossBizException(String msg) {
        super(-1, msg);
    }
}
