package com.plane.missyou.plane.http.api;

import java.sql.Time;

/**
 * Created by MissC on 2017/5/5.
 */

public class ApiResponse<T> {

    private String resultInfo;
    private Integer resultCode;
    private boolean resultStatus;
    private T resultData;
    private String resultError;
    private Time resultDate;

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public boolean isResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(boolean resultStatus) {
        this.resultStatus = resultStatus;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public String getResultError() {
        return resultError;
    }

    public void setResultError(String resultError) {
        this.resultError = resultError;
    }

    public Time getResultDate() {
        return resultDate;
    }

    public void setResultDate(Time resultDate) {
        this.resultDate = resultDate;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "resultInfo='" + resultInfo + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", resultStatus=" + resultStatus +
                ", resultData=" + resultData +
                ", resultError='" + resultError + '\'' +
                ", resultDate=" + resultDate +
                '}';
    }
}
