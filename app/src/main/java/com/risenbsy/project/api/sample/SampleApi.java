package com.risenbsy.project.api.sample;

import com.risenbsy.project.dto.sample.SampleDto;
import com.risenbsy.risenbsylib.network.RisEmptyBean;
import com.risenbsy.risenbsylib.network.RisHttpResult;
import com.risenbsy.risenbsylib.network.RisUploadBean;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Vone (codeofshield@gmail.com) on 2016/10/7.
 */

public interface SampleApi {

    //1.1 用户登录
    @GET("sampleController/getNoParamNoResult")
    Observable<RisHttpResult<RisEmptyBean>> getNoParamNoResult();

    @GET("sampleController/getNoParam")
    Observable<RisHttpResult<SampleDto>> getNoParam();

    @GET("sampleController/getWithParam")             //xxxxx.com/xxx/xxx?param1=1&param2='hello'
    Observable<RisHttpResult<SampleDto>> getWithParam(@Query("param1") int param1, @Query("param2") String param2);

    @Headers({
            "Accept: application/json",
            "User-Agent: Risenbsy"
    })
    @GET("sampleController/getWithParamListResult")
    Observable<RisHttpResult<List<SampleDto>>> getWithParamListResult(@Query("param1") int param1, @Query("param2") String param2);

    @FormUrlEncoded
    @POST("sampleController/postWithFormParam")
    Observable<RisHttpResult<SampleDto>> postWithFormParam(@Field("param1") int param1, @Field("param2") String param2);

    @FormUrlEncoded
    @POST("sampleController/postWithFormParamAndUrlParam")
    Observable<RisHttpResult<SampleDto>> postWithFormParamAndUrlParam(@Query("param1") int param1, @Field("param2") String param2);

    @POST("sampleController/postWithJsonBody")
    Observable<RisHttpResult<RisUploadBean>> postWithJsonBody(@Body SampleDto sampleDto);

    @Multipart
    @POST("sampleController/formupload")
    Observable<RisHttpResult<RisUploadBean>> formUpload(@Part() MultipartBody.Part requestBody);


}
