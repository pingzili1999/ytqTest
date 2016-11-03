package com.risenbsy.project.adapter.sample.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.risenbsy.project.R;
import com.risenbsy.project.dto.sample.SampleDto;
import com.risenbsy.risenbsylib.ui.RisViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vone (codeofshield@gmail.com) on 2016/10/7.
 */

public class SampleViewHolder extends RisViewHolder<SampleDto> {

    @BindView(R.id.tvName)
    TextView textView;

    public SampleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        textView = (TextView) itemView.findViewById(R.id.tvName);
    }

    @Override
    public void bindData(SampleDto data) {
        textView.setText(data.getName());
    }
}
