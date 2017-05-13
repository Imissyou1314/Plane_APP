package com.plane.missyou.plane.entity;

import java.util.Date;

/**
 * Created by MissC on 2017/5/5.
 */

public class Plane {

    private int Id;
    private String planeName;
    private String imageUrl;
    private String userId;
    private Date playTime;
    private Date beginTime;
    private String beginAddress;
    private String resultAddress;
    private String email;
    private int watchNum;
    private boolean isBack;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getBeginAddress() {
        return beginAddress;
    }

    public void setBeginAddress(String beginAddress) {
        this.beginAddress = beginAddress;
    }

    public String getResultAddress() {
        return resultAddress;
    }

    public void setResultAddress(String resultAddress) {
        this.resultAddress = resultAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(int watchNum) {
        this.watchNum = watchNum;
    }

    public boolean isBack() {
        return isBack;
    }

    public void setBack(boolean back) {
        isBack = back;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "Id=" + Id +
                ", planeName='" + planeName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", userId='" + userId + '\'' +
                ", playTime=" + playTime +
                ", beginTime=" + beginTime +
                ", beginAddress='" + beginAddress + '\'' +
                ", resultAddress='" + resultAddress + '\'' +
                ", email='" + email + '\'' +
                ", watchNum=" + watchNum +
                ", isBack=" + isBack +
                '}';
    }
}
