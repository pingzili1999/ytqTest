package com.risenbsy.project.ui.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.risenbsy.project.R;
import com.risenbsy.project.adapter.sample.SampleAdapter;
import com.risenbsy.project.api.sample.SampleApi;
import com.risenbsy.project.dto.sample.SampleDto;
import com.risenbsy.project.viewdemo.Moji24Activity;
import com.risenbsy.project.viewdemo.WeatherLineViewActivity;
import com.risenbsy.risenbsylib.network.RisHttp;
import com.risenbsy.risenbsylib.network.RisHttpResult;
import com.risenbsy.risenbsylib.network.RisSubscriber;
import com.risenbsy.risenbsylib.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class SampleActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.sampleRecycleView)
    RecyclerView sampleRecycleView;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.button2)
    Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerViewTest();
        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
    }

    public void recyclerViewTest() {
        SampleAdapter sampleAdapter = new SampleAdapter(this);
        sampleRecycleView.setLayoutManager(new LinearLayoutManager(this));
        List<SampleDto> data = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            data.add(new SampleDto("" + (char) i));
        }
        sampleRecycleView.setAdapter(sampleAdapter);
        sampleAdapter.freshData(data);
    }



    public void httpTest() {

        RisHttp.createApi(SampleApi.class)
                .getWithParamListResult(1, "hello")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RisSubscriber<List<SampleDto>>() {
                    @Override
                    public void onSuccess(List<SampleDto> t) {

                    }

                    @Override
                    public void onFail(String msg) {

                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                startActivity(new Intent(this, WeatherLineViewActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, Moji24Activity.class));
                break;

        }
    }
}
