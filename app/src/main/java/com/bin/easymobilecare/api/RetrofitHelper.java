package com.bin.easymobilecare.api;

import com.bin.easymobilecare.util.constants.ApiConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pranishshrestha on 5/2/17.
 */

public class RetrofitHelper {

    private static RetrofitHelper instance;
    private final Retrofit retrofit;

    private RetrofitHelper() {

        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder().build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build();
//BASE_URL
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public static RetrofitHelper getInstance() {
        if (instance == null)
            instance = new RetrofitHelper();
        return instance;
    }

    public Api getService(Class<Api> api) {
        return retrofit.create(api);
    }
}
