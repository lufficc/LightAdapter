package com.lufficc.demolightadapter.viewprovider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lufficc.demolightadapter.R;
import com.lufficc.demolightadapter.model.HeaderModel;
import com.lufficc.lightadapter.ViewHolderProvider;

/**
 * Created by lufficc on 2016/8/31.
 */

public class HeaderViewProvider extends ViewHolderProvider<HeaderModel, HeaderViewProvider.HeaderViewHolder> {
    @Override
    public HeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup parent) {
        return new HeaderViewHolder(layoutInflater.inflate(R.layout.header_view, parent, false));
    }

    @Override
    public void onBindViewHolder(HeaderModel model, HeaderViewHolder viewHolder) {
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        HeaderViewHolder(View itemView) {
            super(itemView);
        }

    }
}
