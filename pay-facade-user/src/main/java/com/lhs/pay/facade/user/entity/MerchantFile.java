package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * MerchantFile
 *
 * 商户资质文件
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class MerchantFile extends BaseEntity {

    /**
     * 商户编号
     */
    private String merchantNo;

    /**
     * 商业执照照片
     */
    private String tradeLicense;

    /**
     * 开户许可证照
     */
    private String openAccountLicense;

    /**
     * 身份证正面照
     */
    private String cardPositive;

    /**
     * 身份证反面照
     */
    private String cardNegative;

    /**
     * 手持身份证照
     */
    private String handleCard;

    /**
     * 银行卡照
     */
    private String bankCard;

    /**
     * 银行卡反面照
     */
    private String bankCardNegative;

    /**
     * 收银台照
     */
    private String cashier;

    /**
     * 经营场所照
     */
    private String tradeAddress;

    /**
     * 门头照
     */
    private String doorHead;

    /**
     * 其他
     */
    private String other;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTradeLicense() {
        return tradeLicense;
    }

    public void setTradeLicense(String tradeLicense) {
        this.tradeLicense = tradeLicense;
    }

    public String getOpenAccountLicense() {
        return openAccountLicense;
    }

    public void setOpenAccountLicense(String openAccountLicense) {
        this.openAccountLicense = openAccountLicense;
    }

    public String getCardPositive() {
        return cardPositive;
    }

    public void setCardPositive(String cardPositive) {
        this.cardPositive = cardPositive;
    }

    public String getCardNegative() {
        return cardNegative;
    }

    public void setCardNegative(String cardNegative) {
        this.cardNegative = cardNegative;
    }

    public String getHandleCard() {
        return handleCard;
    }

    public void setHandleCard(String handleCard) {
        this.handleCard = handleCard;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankCardNegative() {
        return bankCardNegative;
    }

    public void setBankCardNegative(String bankCardNegative) {
        this.bankCardNegative = bankCardNegative;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getTradeAddress() {
        return tradeAddress;
    }

    public void setTradeAddress(String tradeAddress) {
        this.tradeAddress = tradeAddress;
    }

    public String getDoorHead() {
        return doorHead;
    }

    public void setDoorHead(String doorHead) {
        this.doorHead = doorHead;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
