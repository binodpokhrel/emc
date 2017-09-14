package com.bin.easymobilecare.ApiPojo.Signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ${hemnath} on ${7/31/2017}.
 */

public class SignupResponseStatusResponse {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("SignupResponseData")
    @Expose
    private SignupResponseData SignupResponseData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SignupResponseData getSignupResponseData() {
        return SignupResponseData;
    }

    public void setSignupResponseData(SignupResponseData SignupResponseData) {
        this.SignupResponseData = SignupResponseData;
    }
}
