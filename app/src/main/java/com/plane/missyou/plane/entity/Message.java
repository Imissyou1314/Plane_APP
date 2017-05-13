package com.plane.missyou.plane.entity;

import java.util.Date;

/**
 * Created by MissC on 2017/5/5.
 */

public class Message{
    private int Id;
    private Integer planeId;
    private Integer toUserId;
    private Integer fromUserId;
    private Boolean isRead;
    private String Context;
    private String imageUrl;
    private Date sendTime;
    private Date readTime;
    private String address;
    private Float log;
    private Float don;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getLog() {
        return log;
    }

    public void setLog(Float log) {
        this.log = log;
    }

    public Float getDon() {
        return don;
    }

    public void setDon(Float don) {
        this.don = don;
    }

    @Override
    public String toString() {
        return "Message[" +
                "Id=" + Id +
                ", planeId=" + planeId +
                ", toUserId=" + toUserId +
                ", fromUserId=" + fromUserId +
                ", isRead=" + isRead +
                ", Context='" + Context + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", sendTime=" + sendTime +
                ", readTime=" + readTime +
                ", address='" + address + '\'' +
                ", log=" + log +
                ", don=" + don +
                ']';
    }
}
