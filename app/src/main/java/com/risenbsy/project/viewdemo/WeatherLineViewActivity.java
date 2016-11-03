package com.risenbsy.project.viewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.risenbsy.project.R;
import com.risenbsy.project.base.BaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/3.
 */

public class WeatherLineViewActivity extends BaseActivity {
    RecyclerView rvHome;
    private List<WeatherDailyModel> mWeatherModels=new ArrayList<>();
    private WeatherLineAdapter mWeaDataAdapter;
    private ColumnAndLineAdapter adapter;
    List<WeatherDailyModel> list,list1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_weatherline);
        rvHome = (RecyclerView)findViewById(R.id.rvHome);
//初始数据
        list = new ArrayList<>();
        for (int i=0;i<15;i++){
            /**
             * date : 2016-05-30
             * text_day : 多云
             * code_day : 4
             * text_night : 阴
             * code_night : 9
             * high : 34
             * low : 22
             */
            WeatherDailyModel w = new WeatherDailyModel();
            w.setCode_day(0);
            w.setCode_night(12);
            w.setDate("2016-05-"+i+10);
            w.setHigh(5+new Random().nextInt(9) + 2);
            w.setLow(5-new Random().nextInt(20));
            w.setText_day("晴");
            w.setText_night("多云");
            list.add(w);
        }
        list1 = new ArrayList<>();
        WeatherDailyModel w = new WeatherDailyModel();
        w.setStart(true);
        w.setCode_day(0);
        w.setCode_night(12);
        w.setDate("2016-05-"+9);
        w.setHigh(new Random().nextInt(9) + 2);
        w.setLow(5-new Random().nextInt(20));
        w.setText_day("晴");
        w.setText_night("多云");
        list1.add(w);
        for (int i=0;i<14;i++){
            /**
             * date : 2016-05-30
             * text_day : 多云
             * code_day : 4
             * text_night : 阴
             * code_night : 9
             * high : 34
             * low : 22
             */

            WeatherDailyModel w1 = new WeatherDailyModel();
            w1.setStart(false);
            w1.setCode_day(0);
            w1.setCode_night(12);
            w1.setDate("2016-05-"+i+10);
            w1.setHigh(new Random().nextInt(9) + 2);
            w1.setLow(new Random().nextInt(30));
            w1.setText_day("1"+i+":"+i+2);
            w1.setText_night("多云");
            list1.add(w1);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 设置布局管理器
        rvHome.setLayoutManager(layoutManager);
        fillDataRecyclerView(list,true);

        TextView but = (TextView) findViewById(R.id.tvButton);
        TextView but1 = (TextView) findViewById(R.id.tvButton2);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fillDataRecyclerView(list,true);
            }
        });

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fillDataRecyclerView(list1,false);
            }
        });
    }

    private void fillDataRecyclerView(List<WeatherDailyModel> daily, boolean isO) {
        mWeatherModels.clear();
        mWeatherModels.addAll(daily);


        if(isO){
            Collections.sort(daily, new Comparator<WeatherDailyModel>() {
                @Override
                public int compare(WeatherDailyModel lhs,
                                   WeatherDailyModel rhs) {
                    // 排序找到温度最低的，按照最低温度升序排列
                    return lhs.getLow() - rhs.getLow();
                }
            });

            int low = daily.get(0).getLow();
            Collections.sort(daily, new Comparator<WeatherDailyModel>() {
                @Override
                public int compare(WeatherDailyModel lhs,
                                   WeatherDailyModel rhs) {
                    // 排序找到温度最高的，按照最高温度降序排列
                    return rhs.getHigh() - lhs.getHigh();
                }
            });
            int high = daily.get(0).getHigh();
            mWeaDataAdapter = new WeatherLineAdapter(this, mWeatherModels, low, high);
            rvHome.setAdapter(mWeaDataAdapter);
        }else{
            Collections.sort(mWeatherModels, new Comparator<WeatherDailyModel>() {
                @Override
                public int compare(WeatherDailyModel lhs,
                                   WeatherDailyModel rhs) {
                    // 排序找到温度最低的，按照最低温度升序排列
                    return lhs.getLow() - rhs.getLow();

                }
            });
            for (int i = 0; i < mWeatherModels.size(); i++) {
                Log.i("home","\n"+mWeatherModels.get(i).getLow());
            }
            int min = mWeatherModels.get(0).getLow();
            int max = mWeatherModels.get(daily.size()-1).getLow();
            Collections.sort(mWeatherModels, new Comparator<WeatherDailyModel>() {
                @Override
                public int compare(WeatherDailyModel lhs,
                                   WeatherDailyModel rhs) {
                    // 排序找到温度最高的，按照最高温度降序排列
                    return rhs.getHigh() - lhs.getHigh();
                }
            });
            int high = mWeatherModels.get(0).getHigh();
            adapter = new ColumnAndLineAdapter(this, daily, min, max,high);
            rvHome.setAdapter(adapter);
            Log.i("home","max="+max);
            Log.i("home","min="+min);
        }
    }
}
