package com.risenbsy.risenbsylib.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class RisPopUpView {
    private PopupWindow popupWindow;
    private View popView;
    private View.OnClickListener onClickListener;
    private PopupWindow.OnDismissListener onDismissListener;


    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        popupWindow.setOnDismissListener(onDismissListener);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        if (null != onClickListener) {
            List<View> views = getAllChildren(popView);
            for (View v : views) {
                v.setOnClickListener(onClickListener);
            }
        }
    }

    public View getInsideViewById(int resourceId) {
        return popView.findViewById(resourceId);
    }


    public RisPopUpView(Context context, int popViewResource) {
        this.popView = LayoutInflater.from(context).inflate(popViewResource, null);
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }


    public RisPopUpView(Context context, int popViewResource, View.OnClickListener clickListener) {
        this.popView = LayoutInflater.from(context).inflate(popViewResource, null);
        this.onClickListener = clickListener;
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        
        List<View> views = getAllChildren(popView);
        for (View v : views) {
            v.setOnClickListener(clickListener);
        }
    }

    public RisPopUpView(Context context, int popViewResource, View.OnClickListener clickListener, PopupWindow.OnDismissListener dismissListener) {
        this.popView = LayoutInflater.from(context).inflate(popViewResource, null);
        this.onClickListener = clickListener;
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOnDismissListener(dismissListener);

        List<View> views = getAllChildren(popView);
        for (View v : views) {
            v.setOnClickListener(clickListener);
        }
    }

    public void show(View rootView) {
        // 这个是为了点击“返回Back”也能使其消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        // 使其聚集
        popupWindow.setFocusable(true);
        // 设置弹出位置
        popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        // 刷新状态
        popupWindow.update();
    }

    public void dismiss() {
        popupWindow.dismiss();

    }

    private ArrayList<View> getAllChildren(View v) {
        if (!(v instanceof ViewGroup)) {
            ArrayList<View> viewArrayList = new ArrayList<>();
            viewArrayList.add(v);
            return viewArrayList;
        }

        ArrayList<View> result = new ArrayList<>();
        ViewGroup vg = (ViewGroup) v;
        for (int i = 0; i < vg.getChildCount(); i++) {
            View child = vg.getChildAt(i);
            ArrayList<View> viewArrayList = new ArrayList<>();
            viewArrayList.add(v);
            viewArrayList.addAll(getAllChildren(child));
            result.addAll(viewArrayList);
        }

        return result;
    }

}
