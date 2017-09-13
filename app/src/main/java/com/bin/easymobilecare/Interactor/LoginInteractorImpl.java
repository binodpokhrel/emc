package com.bin.easymobilecare.Interactor;

import com.bin.easymobilecare.ApiPojo.Login.LoginRequest;
import com.bin.easymobilecare.ApiPojo.Login.LoginStatusResponse;
import com.bin.easymobilecare.Interactor.iInterface.LoginInteractor;
import com.bin.easymobilecare.api.Api;
import com.bin.easymobilecare.api.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by binodPokhrel on 7/14/17.
 */

public class LoginInteractorImpl {

    public void getLoginData(String userName, String password,final LoginInteractor loginInteractor){
        RetrofitHelper helper = RetrofitHelper.getInstance();
        Api service = helper.getService(Api.class);

        LoginRequest request = new LoginRequest();
        request.setEmail(userName);
        request.setPassword(password);

        Call<LoginStatusResponse> call = service.getLoginData(request);
        call.enqueue(new Callback<LoginStatusResponse>() {
            @Override
            public void onResponse(Call<LoginStatusResponse> call, Response<LoginStatusResponse> response) {

                if(response.code() == 201){
                    loginInteractor.success(response.body());
                }else {
                    loginInteractor.onFailure("");
                }
            }

            @Override
            public void onFailure(Call<LoginStatusResponse> call, Throwable t) {
                loginInteractor.onFailure("");
            }
        });

    }
}
