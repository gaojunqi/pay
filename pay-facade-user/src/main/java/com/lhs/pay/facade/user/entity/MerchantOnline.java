package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * MerchantOnline
 *
 * 在线商户信息
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class MerchantOnline extends BaseEntity {

    /**
     * 商户编号
     */
    private String merchantNo;

    /**
     * 账户编号
     */
    private String accountNo;

    /**
     * 商户状态（激活：100， 冻结：101， 用户已创建：102， 审核不通过：103， 注册中：104， 已注销：105）
     */
    private Integer status;

    /**
     * 商户类型（10：个人， 11：个体工商， 12：企业）
     */
    private Integer merchantType;

    /**
     * 商户秘钥
     */
    private String merchantKey;

    /**
     * 公司简称
     */
    private String shortName;

    /**
     * 公司全称
     */
    private String fullName;

    /**
     * 公司地址
     */
    private String address;

    /**
     * ICP备案号
     */
    private String icp;

    /**
     * 法人代表姓名
     */
    private String legalPerson;

    /**
     * 法人身份证号
     */
    private String cardNo;

    /**
     * 法人证件有效期
     */
    private String certificateExpiry;

    /**
     * 经营范围
     */
    private String scope;

    /**
     * 营业执照号
     */
    private String licenseNo;

    /**
     * 营业执照有效期
     */
    private String licenseExpiry;

    /**
     * 营业执照号到期日期
     */
    private Date licenseNoValid;

    /**
     * 组织机构代码
     */
    private String orgCode;

    /**
     * 税务登记证(国税)
     */
    private String nationalTax;

    /**
     * 税务登记证(地税)
     */
    private String landTax;

    /**
     * 签约时间
     */
    private Date signTime;

    /**
     * 合同到期日
     */
    private Date contractValid;

    /**
     * 业务联系人
     */
    private String busiContactName;

    /**
     * 业务联系人手机号码
     */
    private String busiContactMobileNo;

    /**
     * 业务联系人邮箱
     */
    private String busiContactEmail;

    /**
     * 业务联系人QQ
     */
    private String busiContactQq;

    /**
     * 技术联系人
     */
    private String techContactName;

    /**
     * 技术联系人手机号
     */
    private String techContactMobileNo;

    /**
     * 技术联系人邮箱
     */
    private String techContactEmail;

    /**
     * 技术联系人QQ
     */
    private String techContactQq;

    /**
     * 传真号
     */
    private String fax;

    /**
     * IP段
     */
    private String ipSeg;

    /**
     * 行业类型
     */
    private String mcc;

}
