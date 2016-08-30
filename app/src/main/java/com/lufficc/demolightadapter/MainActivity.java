package com.lufficc.demolightadapter;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lufficc.demolightadapter.model.ImgModel;
import com.lufficc.demolightadapter.model.TextModel;
import com.lufficc.demolightadapter.viewprovider.ImgViewProvider;
import com.lufficc.demolightadapter.viewprovider.TextViewProvider;
import com.lufficc.lightadapter.LightAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random random = new Random();

    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recyclerView;

    LightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter = new LightAdapter());
        adapter.register(TextModel.class, new TextViewProvider());
        adapter.register(ImgModel.class, new ImgViewProvider());

        for (int i = 0; i < 50; i++) {
            if (random.nextBoolean())
                adapter.addData(new TextModel("I am text " + i));
            else
                adapter.addData(new ImgModel(R.mipmap.ic_launcher));
        }
    }
}
