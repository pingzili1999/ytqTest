package com.risenbsy.risenbsylib.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by FengYi on 2016/10/9.
 */
public abstract class RisActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    public abstract RisActivity showTitle(String titleName);

    public abstract RisActivity withBack();

    public abstract RisActivity withRightText(String text, View.OnClickListener onClickListener);

    public abstract RisActivity withRightIcon(int iconResourceId, View.OnClickListener onClickListener);


    public void showProgressDialog(String message, boolean cancelAble) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(message);
        progressDialog.setCancelable(cancelAble);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
