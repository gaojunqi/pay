package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * UserVerificationCode
 *
 * 用户验证码
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class UserVerificationCode extends BaseEntity {

    /**
     * 用户编号(商户编号、会员编号)
     */
    private String userNo;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 验证码类型  参考枚举UserVerificationCodeTypeEnum
     */
    private Integer verificationType;

    /**
     * 状态  参考枚举UserVerificationCodeStatusEnum
     */
    private Integer status;

    /**
     * 验证码
     */
    private String verificationCode;

    /**
     * 验证码生成时间
     */
    private Date generateTime;

    /**
     * 验证码到期时间
     */
    private Date maturityTime;

    /**
     * 备注
     */
    private String remark;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(Integer verificationType) {
        this.verificationType = verificationType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public Date getMaturityTime() {
        return maturityTime;
    }

    public void setMaturityTime(Date maturityTime) {
        this.maturityTime = maturityTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
