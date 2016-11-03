package com.risenbsy.project.base;

import android.view.View;

import com.risenbsy.risenbsylib.base.RisActivity;

/**
 * Created by FengYi on 2016/10/9.
 */
public class BaseActivity extends RisActivity {

    @Override
    public RisActivity showTitle(String titleName) {
        return this;
    }

    @Override
    public RisActivity withBack() {
        return this;
    }

    @Override
    public RisActivity withRightText(String text, View.OnClickListener onClickListener) {
        return null;
    }

    @Override
    public RisActivity withRightIcon(int iconResourceId, View.OnClickListener onClickListener) {
        return null;
    }
    //TODO 处理标题栏背景等相关
    public RisActivity setBackground(int titleResID){
//        if(!isTitleShow)return  this;
//        getView().findViewById(R.id.titleBar).setBackgroundResource(titleResID);
        return this;
    }
}
