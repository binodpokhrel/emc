package com.bin.easymobilecare.ApiPojo.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by binodPokhrel on 7/14/17.
 */

public class LoginStatusResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private LoginResponseData data;
    @SerializedName("content_url")
    @Expose
    private LoginResponseContentUrl loginResponseContentUrl;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LoginResponseData getLoginResponseData() {
        return data;
    }

    public void setLoginResponseData(LoginResponseData data) {
        this.data = data;
    }

    public LoginResponseContentUrl getLoginResponseContentUrl() {
        return loginResponseContentUrl;
    }

    public void setLoginResponseContentUrl(LoginResponseContentUrl loginResponseContentUrl) {
        this.loginResponseContentUrl = loginResponseContentUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
