package com.risenbsy.risenbsylib.base;

import android.app.Application;

import com.risenbsy.risenbsylib.RisConstants;

/**
 * Created by Vone (codeofshield@gmail.com) on 2016/10/7.
 */

public abstract class RisApplication extends Application {
    public abstract void risInit();

    public abstract void userLoginExpire();

    @Override
    public void onCreate() {
        super.onCreate();
        RisConstants.APPLICATION_CONTEXT = this;
    }
}
