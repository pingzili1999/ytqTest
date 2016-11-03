package com.risenbsy.project.adapter.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.risenbsy.project.R;
import com.risenbsy.project.adapter.sample.viewholder.SampleViewHolder;
import com.risenbsy.project.dto.sample.SampleDto;
import com.risenbsy.risenbsylib.ui.RisRecycleAdapter;
import com.risenbsy.risenbsylib.ui.RisViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vone (codeofshield@gmail.com) on 2016/10/7.
 */

public class SampleAdapter extends RisRecycleAdapter<SampleDto> {

    public SampleAdapter(Context context) {
        super(context);
    }

    @Override
    public RisViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_sample, parent, false);
        return new SampleViewHolder(view);
    }

}