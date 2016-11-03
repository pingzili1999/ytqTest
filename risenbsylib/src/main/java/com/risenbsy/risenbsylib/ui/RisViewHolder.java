package com.risenbsy.risenbsylib.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class RisViewHolder<M> extends RecyclerView.ViewHolder {


    public RisViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(M data);

    public Context getContext() {
        return itemView.getContext();
    }


}