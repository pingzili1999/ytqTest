package com.risenbsy.risenbsylib.base;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

/**
 * Created by FengYi on 2016/10/9.
 */
public class RisFragment extends Fragment {

    ProgressDialog progressDialog;

    public void showProgressDialog(String message, boolean cancelAble) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
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
