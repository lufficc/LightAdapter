package com.lufficc.demolightadapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.lufficc.demolightadapter.model.ImgModel;
import com.lufficc.demolightadapter.viewprovider.ImgViewProvider;
import com.lufficc.lightadapter.FooterModel;
import com.lufficc.lightadapter.FooterState;
import com.lufficc.lightadapter.FooterViewHolderProvider;
import com.lufficc.lightadapter.LightAdapter;
import com.lufficc.lightadapter.OnDataClickListener;
import com.lufficc.lightadapter.OnHeaderClickListener;

public class LoadMoreActivity extends AppCompatActivity implements OnDataClickListener, OnHeaderClickListener, FooterModel.LoadMoreListener, FooterModel.OnFooterClickListener, SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recyclerView;

    LightAdapter adapter;

    FooterModel footerModel;

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        register();

        adapter.addFooter(footerModel = new FooterModel());
        adapter.setOnDataClickListener(this);
        adapter.setOnHeaderClickListener(this);
        addData();
        footerModel.setLoadMoreListener(this);
        footerModel.setOnFooterClickListener(this);
    }

    private void init() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DefaultItemDecoration(
                ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.divider),
                getResources().getDimensionPixelSize(R.dimen.zero)));
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter = new LightAdapter());
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void register() {
        adapter.register(ImgModel.class, new ImgViewProvider());
        adapter.register(FooterModel.class, new FooterViewHolderProvider());
    }

    void addData() {
        adapter.addData(DataSource.ImgModel());
    }

    @Override
    public void onDataClick(int position, Object data) {
        Log.i("main", "pos:" + position);
        adapter.removeData(position);
    }

    @Override
    public void onHeaderClick(int position, Object header) {
        adapter.removeHeader(position);
    }

    int step = 0;

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (step == 0) {
                    addData();
                } else if (step == 1) {
                    footerModel.noMoreData();
                } else if (step == 2) {
                    footerModel.errorOccur();
                } else {
                    addData();
                }
                step++;
                if (step > 2)
                    step = 0;
            }
        }, 1000);
    }

    @Override
    public void onFooterClick(int state) {
        if (state == FooterState.STATE_ERROR) {
            footerModel.canLoadMore();
            onLoadMore();
        } else if (state == FooterState.STATE_NO_MORE) {
            footerModel.canLoadMore();
            onLoadMore();
        }
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                adapter.clearData();
                footerModel.canLoadMore();
                addData();
            }
        }, 1000);
    }
}
