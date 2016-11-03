package com.risenbsy.risenbsylib.network;

import android.util.Log;

import com.risenbsy.risenbsylib.RisConstants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Vone (codeofshield@gmail.com) on 2016/8/7.
 */
public class RisHttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        if (RisConstants.IS_DEBUG)
            Log.d("RisHttpInterceptor", String.format("响应请求 %s %.1fms", response.request().url(), (t2 - t1) / 1e6d));
        return response;
    }
}
