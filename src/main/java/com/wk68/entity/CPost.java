package com.wk68.entity;

import java.io.Serializable;
import java.util.Date;

public class CPost implements Serializable {
    private Integer postId;

    private String pJobWantedUid;

    private String pJobUid;

    private String pName;

    private String pCompanyName;

    private String pWorkplace;

    private String pType;

    private String pMonthlyPay;

    private String pYears;

    private String pJobNature;

    private String pScale;

    private String pWelfare;

    private String pReply;

    private String pPhoto;

    private Date pTime;

    private String pOnline;

    private String pResponsibility;

    private String pRequested;

    private static final long serialVersionUID = 1L;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getpJobWantedUid() {
        return pJobWantedUid;
    }

    public void setpJobWantedUid(String pJobWantedUid) {
        this.pJobWantedUid = pJobWantedUid;
    }

    public String getpJobUid() {
        return pJobUid;
    }

    public void setpJobUid(String pJobUid) {
        this.pJobUid = pJobUid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpCompanyName() {
        return pCompanyName;
    }

    public void setpCompanyName(String pCompanyName) {
        this.pCompanyName = pCompanyName;
    }

    public String getpWorkplace() {
        return pWorkplace;
    }

    public void setpWorkplace(String pWorkplace) {
        this.pWorkplace = pWorkplace;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpMonthlyPay() {
        return pMonthlyPay;
    }

    public void setpMonthlyPay(String pMonthlyPay) {
        this.pMonthlyPay = pMonthlyPay;
    }

    public String getpYears() {
        return pYears;
    }

    public void setpYears(String pYears) {
        this.pYears = pYears;
    }

    public String getpJobNature() {
        return pJobNature;
    }

    public void setpJobNature(String pJobNature) {
        this.pJobNature = pJobNature;
    }

    public String getpScale() {
        return pScale;
    }

    public void setpScale(String pScale) {
        this.pScale = pScale;
    }

    public String getpWelfare() {
        return pWelfare;
    }

    public void setpWelfare(String pWelfare) {
        this.pWelfare = pWelfare;
    }

    public String getpReply() {
        return pReply;
    }

    public void setpReply(String pReply) {
        this.pReply = pReply;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public String getpOnline() {
        return pOnline;
    }

    public void setpOnline(String pOnline) {
        this.pOnline = pOnline;
    }

    public String getpResponsibility() {
        return pResponsibility;
    }

    public void setpResponsibility(String pResponsibility) {
        this.pResponsibility = pResponsibility;
    }

    public String getpRequested() {
        return pRequested;
    }

    public void setpRequested(String pRequested) {
        this.pRequested = pRequested;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", pJobWantedUid=").append(pJobWantedUid);
        sb.append(", pJobUid=").append(pJobUid);
        sb.append(", pName=").append(pName);
        sb.append(", pCompanyName=").append(pCompanyName);
        sb.append(", pWorkplace=").append(pWorkplace);
        sb.append(", pType=").append(pType);
        sb.append(", pMonthlyPay=").append(pMonthlyPay);
        sb.append(", pYears=").append(pYears);
        sb.append(", pJobNature=").append(pJobNature);
        sb.append(", pScale=").append(pScale);
        sb.append(", pWelfare=").append(pWelfare);
        sb.append(", pReply=").append(pReply);
        sb.append(", pPhoto=").append(pPhoto);
        sb.append(", pTime=").append(pTime);
        sb.append(", pOnline=").append(pOnline);
        sb.append(", pResponsibility=").append(pResponsibility);
        sb.append(", pRequested=").append(pRequested);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}