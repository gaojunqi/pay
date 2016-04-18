package com.lhs.pay.web.permission.exception;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * PermissionException
 *
 * @author longhuashen
 * @since 16/4/12
 */
public class PermissionException extends Exception {

    /**
     * 该用户没有分配菜单权限
     */
    public static final Integer PERMISSION_USER_NOT_MENU = 1001;

    /**
     * 根据角色查询菜单出现错误
     */
    public static final Integer PERMISSION_QUERY_MENU_BY_ROLE_ERROR = 1002;

    /**
     * 跟配菜单权限时，角色不能为空
     */
    public static final Integer PERMISSION_ASSIGN_MENU_ROLE_NULL = 1003;

    /**
     * 错误代码
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public PermissionException(Integer code) {
        this.code = code;
    }

    public PermissionException(String message) {
        super(message);
    }

    public static List<Field> getErrCodeFields() {
        Class<PermissionException> exceptionClass = PermissionException.class;
        //取得所有声明的字段
        Field[] fields = exceptionClass.getDeclaredFields();
        List<Field> errorCodeFields = new ArrayList<>();
        int fMod;
        for (Field f : fields) {
            fMod = f.getModifiers();
            if (Modifier.isFinal(fMod) && Modifier.isPublic(fMod) && Modifier.isStatic(fMod) && f.getType().equals(Integer.class)) {
                errorCodeFields.add(f);
            }
        }
        return errorCodeFields;
    }
}
