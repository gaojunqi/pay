package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * MemberInfo
 * 会员信息实体
 *
 * @author longhuashen
 * @since 16/3/21
 */
public class MemberInfo extends BaseEntity {

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

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
