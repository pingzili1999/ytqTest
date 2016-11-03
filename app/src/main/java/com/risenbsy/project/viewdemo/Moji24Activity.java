package com.risenbsy.project.viewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.risenbsy.project.R;
import com.risenbsy.project.view.IndexHorizontalScrollView;
import com.risenbsy.project.view.Today24HourView;

import java.util.ArrayList;
import java.util.List;

public class Moji24Activity extends AppCompatActivity {

    private IndexHorizontalScrollView indexHorizontalScrollView;
    private Today24HourView today24HourView;
    List<HourItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_moji24);
        initHourItems();
        initViews();
    }

    private void initViews() {

        indexHorizontalScrollView = (IndexHorizontalScrollView)findViewById(R.id.indexHorizontalScrollView);
        today24HourView = (Today24HourView)findViewById(R.id.today24HourView);
        today24HourView.setHourItems(listItems);
        indexHorizontalScrollView.setToday24HourView(today24HourView);
    }
    private static final int TEMP[] = {22, 23, 23, 23, 23,
            22, 23, 23, 23, 22,
            21, 21, 22, 22, 23,
            23, 24, 24, 25, 25,
            25, 26, 25, 24};
    private static final int WINDY[] = {2, 2, 3, 3, 3,
            4, 4, 4, 3, 3,
            3, 4, 4, 4, 4,
            2, 2, 2, 3, 3,
            3, 5, 5, 5};
    private static final int WEATHER_RES[] ={R.mipmap.w0, R.mipmap.w1, R.mipmap.w3, -1, -1
            ,R.mipmap.w5, R.mipmap.w7, R.mipmap.w9, -1, -1
            ,-1, R.mipmap.w10, R.mipmap.w15, -1, -1
            ,-1, -1, -1, -1, -1
            ,R.mipmap.w18, -1, -1, R.mipmap.w19};


    private void initHourItems(){
       listItems = new ArrayList<>();
        for(int i=0; i<24; i++){
            String time;
            if(i<10){
                time = "0" + i + ":00";
            } else {
                time = i + ":00";
            }
            HourItem hourItem = new HourItem();
            hourItem.time = time;
            hourItem.windy = WINDY[i];
            hourItem.temperature = TEMP[i];
            hourItem.res = WEATHER_RES[i];
            listItems.add(hourItem);
        }
    }
}
