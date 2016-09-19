package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * ContractManagement
 *
 * 合同管理
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class ContractManagement extends BaseEntity {

    /**
     * 商户ID或者银行序号
     */
    private String userNo;

    /**
     * 商户名称或者银行接口名称
     */
    private String userName;

    /**
     * 合同保存路径
     */
    private String contractFile;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

    /**
     * 源文件名
     */
    private String fileName;

    /**
     * 文件性质(1.首次签约 2.续约 3.变更资料 4.其它)
     */
    private Integer fileProperties;

    /**
     * 描述
     */
    private String remark;

    /**
     * 签约日期
     */
    private Date signTime;

    /**
     * 合同到期日期
     */
    private Date contractValid;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContractFile() {
        return contractFile;
    }

    public void setContractFile(String contractFile) {
        this.contractFile = contractFile;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileProperties() {
        return fileProperties;
    }

    public void setFileProperties(Integer fileProperties) {
        this.fileProperties = fileProperties;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Date getContractValid() {
        return contractValid;
    }

    public void setContractValid(Date contractValid) {
        this.contractValid = contractValid;
    }
}
