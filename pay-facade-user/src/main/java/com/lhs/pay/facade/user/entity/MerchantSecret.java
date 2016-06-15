package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * MerchantSecret
 *
 * 商户秘钥信息
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class MerchantSecret extends BaseEntity {

    /**
     * 商户ID
     */
    private String merchantNo;

    /**
     *  平台公钥
     */
    private String publicKey;

    /**
     * 平台私钥
     */
    private String privateKey;

    /**
     * 商户公钥
     */
    private String merchantPublicKey;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getMerchantPublicKey() {
        return merchantPublicKey;
    }

    public void setMerchantPublicKey(String merchantPublicKey) {
        this.merchantPublicKey = merchantPublicKey;
    }
}
