package com.bin.easymobilecare.ApiPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by binodPokhrel on 7/3/17.
 */

public class NotificationResponse {
    @SerializedName("ack")
    @Expose
    private String ack;
    @SerializedName("ack_msg")
    @Expose
    private String ackMsg;
    @SerializedName("result")
    @Expose
    private List<NotificationRequest> result = null;

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getAckMsg() {
        return ackMsg;
    }

    public void setAckMsg(String ackMsg) {
        this.ackMsg = ackMsg;
    }

    public List<NotificationRequest> getResult() {
        return result;
    }

    public void setResult(List<NotificationRequest> result) {
        this.result = result;
    }
}
