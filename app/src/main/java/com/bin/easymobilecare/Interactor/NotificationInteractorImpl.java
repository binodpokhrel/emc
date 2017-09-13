package com.bin.easymobilecare.Interactor;

import com.bin.easymobilecare.ApiPojo.NotificationRequest;
import com.bin.easymobilecare.ApiPojo.NotificationResponse;
import com.bin.easymobilecare.Interactor.iInterface.NotificationInteractor;
import com.bin.easymobilecare.api.Api;
import com.bin.easymobilecare.api.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by binodPokhrel on 7/3/17.
 */

public class NotificationInteractorImpl {

    public void getNotification(final NotificationInteractor interactor) {
        RetrofitHelper retrofit = RetrofitHelper.getInstance();
        Api services = retrofit.getService(Api.class);
        NotificationRequest request = new NotificationRequest();
        request.setUserId("87");
        Call<NotificationResponse> call = services.getNotification(request);
        call.enqueue(new Callback<NotificationResponse>() {
            @Override
            public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
                if (response.code() == 200)
                    interactor.onSuccess(response.body());
                else
                    interactor.onFailure("");
            }

            @Override
            public void onFailure(Call<NotificationResponse> call, Throwable t) {
                interactor.onFailure("");
            }
        });
    }
}
