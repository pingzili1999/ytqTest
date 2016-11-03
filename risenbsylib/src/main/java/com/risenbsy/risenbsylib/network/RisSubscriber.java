package com.risenbsy.risenbsylib.network;


import com.risenbsy.risenbsylib.RisConstants;
import com.risenbsy.risenbsylib.base.RisApplication;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Fengyi on 2016/8/9.
 */
public abstract class RisSubscriber<E> extends Subscriber<RisHttpResult> {


    public abstract void onSuccess(E t);

    public abstract void onFail(String msg);


    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {

    }

    public void onSessionExpire() {
        if (RisConstants.APPLICATION_CONTEXT != null)
            ((RisApplication) RisConstants.APPLICATION_CONTEXT).userLoginExpire();
    }

    @Override
    public void onError(Throwable e) {
        if (RisConstants.IS_DEBUG) {
            e.printStackTrace();
        }
        if (e instanceof HttpException) {
            HttpException exception = (HttpException) e;
            onFail(exception.message());
        } else {
            if (RisConstants.IS_DEBUG) {
                onFail(e.getMessage());
                e.printStackTrace();
            } else
                onFail("发生未知错误，请重试");
        }
    }

    @Override
    public void onNext(RisHttpResult risHttpResult) {
        if (0 == risHttpResult.getCode()) {
            if (risHttpResult.getData() != null)
                onSuccess((E) risHttpResult.getData());
            else
                onSuccess(null);
        } else if (2 == risHttpResult.getCode()) {
            onSessionExpire();
        } else {
            onFail(risHttpResult.getMsg());
        }
    }
}
