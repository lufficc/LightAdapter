package com.lufficc.demolightadapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.lufficc.demolightadapter.model.BigImgModel;
import com.lufficc.demolightadapter.model.ImgModel;
import com.lufficc.demolightadapter.model.TextModel;
import com.lufficc.demolightadapter.viewprovider.BigImgViewProvider;
import com.lufficc.demolightadapter.viewprovider.ImgViewProvider;
import com.lufficc.demolightadapter.viewprovider.TextViewProvider;
import com.lufficc.lightadapter.LightAdapter;
import com.lufficc.lightadapter.OnDataClickListener;
import com.lufficc.lightadapter.OnFooterClickListener;
import com.lufficc.lightadapter.OnHeaderClickListener;


import java.util.Locale;

public class HeaderFooterActivity extends AppCompatActivity implements OnDataClickListener, OnHeaderClickListener, OnFooterClickListener {
    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recyclerView;

    LightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adapter.register(ImgModel.class, new ImgViewProvider());
        adapter.register(BigImgModel.class, new BigImgViewProvider());
        adapter.register(TextModel.class, new TextViewProvider());
        adapter.addFooter(new TextModel("I am a footer 1."));
        adapter.addFooter(new TextModel("I am a footer 2."));
        adapter.addFooter(new TextModel("I am a footer 3."));
        adapter.addHeader(new BigImgModel("I am a header."));


        adapter.setOnDataClickListener(this);
        adapter.setOnHeaderClickListener(this);
        adapter.setOnFooterClickListener(this);
        adapter.addData(DataSource.ImgModel());
    }

    private void init() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DefaultItemDecoration(
                ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.divider),
                getResources().getDimensionPixelSize(R.dimen.zero)));
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter = new LightAdapter());
    }

    @Override
    public void onDataClick(int position, Object data) {
        Log.i("main", "pos:" + position);
        adapter.removeData(position);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onHeaderClick(int position, Object header) {
        Toast.makeText(this, ((BigImgModel) header).getInfo() + String.format(Locale.CHINA, "[position:%d]", position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFooterClick(int position, Object footer) {
        Toast.makeText(this, ((TextModel) footer).getText() + String.format(Locale.CHINA, "[position:%d]", position), Toast.LENGTH_SHORT).show();
        if (position == 2)
            adapter.removeFooter(2);
    }
}
