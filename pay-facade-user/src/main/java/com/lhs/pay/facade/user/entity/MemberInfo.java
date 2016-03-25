package com.lhs.pay.facade.user.entity;

/**
 * MemberInfo
 * 会员信息实体
 *
 * @author longhuashen
 * @since 16/3/21
 */
public class MemberInfo {

    /**
     * 会员编号
     */
    private String memberNo;

    /**
     * 账户编号
     */
    private String accountNo;

    /**
     * 状态（100：激活， 101：冻结，102：已销户）
     */
    private Integer status;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String cardNo;

    /**
     * 地址
     */
    private String adddress;

    /**
     * 固定电话
     */
    private String telNo;

    /**
     * 传真号
     */
    private String fax;

    /**
     * qq号
     */
    private String qq;

    /**
     * 职业
     */
    private String profession;

    /**
     * 国籍
     */
    private String country;
}
