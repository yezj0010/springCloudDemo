package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbCheckCCount {
    private Long id;

    private String equipmentId;

    private String checkBatchNo;

    private Integer successNum;

    private BigDecimal successAmt;

    private Integer errNum;

    private BigDecimal errAmt;

    private Integer correctNum;

    private BigDecimal correctAmt;

    private Integer unknownNum;

    private BigDecimal unknownAmt;

    private Date createTime;

    private Date updateTime;

    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getCheckBatchNo() {
        return checkBatchNo;
    }

    public void setCheckBatchNo(String checkBatchNo) {
        this.checkBatchNo = checkBatchNo == null ? null : checkBatchNo.trim();
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public BigDecimal getSuccessAmt() {
        return successAmt;
    }

    public void setSuccessAmt(BigDecimal successAmt) {
        this.successAmt = successAmt;
    }

    public Integer getErrNum() {
        return errNum;
    }

    public void setErrNum(Integer errNum) {
        this.errNum = errNum;
    }

    public BigDecimal getErrAmt() {
        return errAmt;
    }

    public void setErrAmt(BigDecimal errAmt) {
        this.errAmt = errAmt;
    }

    public Integer getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(Integer correctNum) {
        this.correctNum = correctNum;
    }

    public BigDecimal getCorrectAmt() {
        return correctAmt;
    }

    public void setCorrectAmt(BigDecimal correctAmt) {
        this.correctAmt = correctAmt;
    }

    public Integer getUnknownNum() {
        return unknownNum;
    }

    public void setUnknownNum(Integer unknownNum) {
        this.unknownNum = unknownNum;
    }

    public BigDecimal getUnknownAmt() {
        return unknownAmt;
    }

    public void setUnknownAmt(BigDecimal unknownAmt) {
        this.unknownAmt = unknownAmt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}