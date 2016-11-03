package com.risenbsy.project.base;

import com.risenbsy.risenbsylib.RisConstants;
import com.risenbsy.risenbsylib.base.RisApplication;

/**
 * Created by Vone (codeofshield@gmail.com) on 2016/10/7.
 */

public class BaseApplication extends RisApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void risInit() {
        RisConstants.IS_DEBUG = true;
        RisConstants.HTTP_BASE_URL = "";
        RisConstants.IMAGE_BASE_URL = "";
    }

    @Override
    public void userLoginExpire() {

    }


}
