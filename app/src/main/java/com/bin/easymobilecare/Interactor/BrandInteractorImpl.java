package com.bin.easymobilecare.Interactor;

import com.bin.easymobilecare.ApiPojo.BrandCategoryResponse;
import com.bin.easymobilecare.Interactor.iInterface.BrandInteractor;
import com.bin.easymobilecare.api.Api;
import com.bin.easymobilecare.api.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by binodPokhrel on 7/6/17.
 */

public class BrandInteractorImpl {

    public void getBrand(final BrandInteractor interactor){
        RetrofitHelper helper = RetrofitHelper.getInstance();
        Api service = helper.getService(Api.class);
        Call<List<BrandCategoryResponse>> call = service.getBrand();
        call.enqueue(new Callback<List<BrandCategoryResponse>>() {
            @Override
            public void onResponse(Call<List<BrandCategoryResponse>> call, Response<List<BrandCategoryResponse>> response) {
                if(response.code() == 200) {
                    List<BrandCategoryResponse> categoryResponseList = new ArrayList<>();
                    categoryResponseList.addAll(response.body());
                    interactor.success(categoryResponseList);
                }else
                    interactor.onFailure("");

            }

            @Override
            public void onFailure(Call<List<BrandCategoryResponse>> call, Throwable t) {

            }
        });
    }
}
