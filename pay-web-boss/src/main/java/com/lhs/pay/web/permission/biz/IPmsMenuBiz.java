package com.lhs.pay.web.permission.biz;

import com.lhs.pay.web.permission.exception.PermissionException;

/**
 * IPmsMenuBiz
 *
 * @author longhuashen
 * @since 16/4/12
 */
public interface IPmsMenuBiz {

    String getTreeMenu(String actionUrl);

    String buildPermissionTree(String roleIds) throws PermissionException;
}
