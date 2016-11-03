package com.risenbsy.risenbsylib.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.risenbsy.risenbsylib.RisConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fengyi on 2016/8/5.
 */
public class RisHttp {


    private static Gson gson;

    private static Retrofit retrofit;

    public static Gson GsonInstance() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd hh:mm:ss")
                    .create();

        }
        return gson;
    }

    public static  <T> T createApi(final Class<T> api)
    {
        return Instance().create(api);
    }


    private static Retrofit Instance() {

        if (retrofit == null) {

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(false)
                    .addInterceptor(new RisHttpInterceptor())
                    .connectTimeout(RisConstants.HTTP_TIMEOUT, TimeUnit.SECONDS);

            if (RisConstants.IS_DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
                okHttpClient.addInterceptor(httpLoggingInterceptor);
            }


            retrofit = new Retrofit.Builder()
                    .baseUrl(RisConstants.HTTP_BASE_URL)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create(GsonInstance()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
