package com.risenbsy.risenbsylib.network;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;


/**
 * 基于Retrofit的通用API
 */
public interface RisCommonApi {

    /**
     * 单文件上传
     * @param requestBody
     * @return
     */
    @Multipart
    @POST("upload/formupload")
    Observable<RisHttpResult<RisUploadBean>> formUpload(@Part() MultipartBody.Part requestBody);

    /**
     * 多文件上传
     * @param parts
     * @return
     */
    @Multipart
    @POST("upload/formuploads")
    Observable<RisHttpResult<RisUploadBean>> formUploads(@Part() List<MultipartBody.Part> parts);

    /**
     * 检查更新
     * @return
     */
    @POST("upload/update")
    Observable<RisHttpResult<RisUpdateBean>> update();
}
