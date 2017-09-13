package com.bin.easymobilecare.api;

import com.bin.easymobilecare.ApiPojo.BrandCategoryResponse;
import com.bin.easymobilecare.ApiPojo.Login.LoginRequest;
import com.bin.easymobilecare.ApiPojo.Login.LoginStatusResponse;
import com.bin.easymobilecare.ApiPojo.NotificationRequest;
import com.bin.easymobilecare.ApiPojo.NotificationResponse;
import com.bin.easymobilecare.ApiPojo.Signup.SignupRequest;
import com.bin.easymobilecare.ApiPojo.Signup.SignupResponseStatusResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by pranishshrestha on 5/2/17.
 */

public interface Api {
//@Path use to dend dynamic path
    @POST("getNotification")
    Call<NotificationResponse> getNotification(@Body NotificationRequest notificationRequest);

   // @GET("Categories/discover")

    @GET("productsGet")
    Call<List<BrandCategoryResponse>> getBrand();

    @POST("Account/login")
    Call<LoginStatusResponse> getLoginData(@Body LoginRequest loginRequest);

    @POST("mobSignUp")
    Call<SignupResponseStatusResponse> getSignupData(@Body SignupRequest signupRequest);

}
