package com.bin.easymobilecare.ApiPojo.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by binodPokhrel on 7/14/17.
 */

public class LoginResponseData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("subscribe_date")
    @Expose
    private String subscribeDate;
    @SerializedName("activate_date")
    @Expose
    private Object activateDate;
    @SerializedName("enable_optin")
    @Expose
    private Object enableOptin;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("enable_reset")
    @Expose
    private String enableReset;
    @SerializedName("enable_sound")
    @Expose
    private String enableSound;
    @SerializedName("promo_notification")
    @Expose
    private String promoNotification;
    @SerializedName("event_notification")
    @Expose
    private String eventNotification;
    @SerializedName("token")
    @Expose
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(String subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public Object getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Object activateDate) {
        this.activateDate = activateDate;
    }

    public Object getEnableOptin() {
        return enableOptin;
    }

    public void setEnableOptin(Object enableOptin) {
        this.enableOptin = enableOptin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnableReset() {
        return enableReset;
    }

    public void setEnableReset(String enableReset) {
        this.enableReset = enableReset;
    }

    public String getEnableSound() {
        return enableSound;
    }

    public void setEnableSound(String enableSound) {
        this.enableSound = enableSound;
    }

    public String getPromoNotification() {
        return promoNotification;
    }

    public void setPromoNotification(String promoNotification) {
        this.promoNotification = promoNotification;
    }

    public String getEventNotification() {
        return eventNotification;
    }

    public void setEventNotification(String eventNotification) {
        this.eventNotification = eventNotification;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
