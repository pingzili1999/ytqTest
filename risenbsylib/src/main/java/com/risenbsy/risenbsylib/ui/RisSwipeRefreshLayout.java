package com.risenbsy.risenbsylib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.risenbsy.risenbsylib.R;


/**
 * Created by Fengyi on 2016/8/11.
 */
public class RisSwipeRefreshLayout extends SuperSwipeRefreshLayout {


    private OnFreshOrMoreListener onFreshOrMoreListener;
    private int page = 1;

    public void showHeader(boolean isEnable) {
        super.setIsHeadEnable(isEnable);
    }

    public void showFooter(boolean isEnable) {
        super.setIsFootEnable(isEnable);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public OnFreshOrMoreListener getOnFreshOrMoreListener() {
        return onFreshOrMoreListener;
    }

    public void setOnFreshOrMoreListener(OnFreshOrMoreListener onFreshOrMoreListener) {
        this.onFreshOrMoreListener = onFreshOrMoreListener;
    }

    public RisSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setHeaderView(LayoutInflater.from(context).inflate(R.layout.view_fresh, null));
        this.setFooterView(LayoutInflater.from(context).inflate(R.layout.view_more, null));
        this.setOnPullRefreshListener(new OnPullRefreshListener() {
            @Override
            public void onRefresh() {
                if (onFreshOrMoreListener != null) {
                    page = 1;
                    onFreshOrMoreListener.OnFresh();

                }
            }

            @Override
            public void onPullDistance(int distance) {

            }

            @Override
            public void onPullEnable(boolean enable) {

            }
        });

        this.setOnPushLoadMoreListener(new OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (onFreshOrMoreListener != null) {
                    page++;
                    onFreshOrMoreListener.OnMore();
                }
            }

            @Override
            public void onPushDistance(int distance) {

            }

            @Override
            public void onPushEnable(boolean enable) {

            }
        });
    }


    public interface OnFreshOrMoreListener {
        void OnFresh();

        void OnMore();
    }


}
