package com.bin.easymobilecare.ApiPojo.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by binodPokhrel on 7/14/17.
 */

class LoginResponseContentUrl {
    @SerializedName("support_page")
    @Expose
    private String supportPage;
    @SerializedName("privacy_policy")
    @Expose
    private String privacyPolicy;
    @SerializedName("terms_and_conditions")
    @Expose
    private String termsAndConditions;
    @SerializedName("help_center")
    @Expose
    private String helpCenter;

    public String getSupportPage() {
        return supportPage;
    }

    public void setSupportPage(String supportPage) {
        this.supportPage = supportPage;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getHelpCenter() {
        return helpCenter;
    }

    public void setHelpCenter(String helpCenter) {
        this.helpCenter = helpCenter;
    }

}
