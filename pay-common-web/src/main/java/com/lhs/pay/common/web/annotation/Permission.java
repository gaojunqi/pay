package com.lhs.pay.common.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Permission
 * Action层权限配置注解
 * 模块标识和功能点标识共同构成唯一权限点
 *
 * @author longhuashen
 * @since 16/3/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {

    /**
     * 权限值
     */
    String value();
}
