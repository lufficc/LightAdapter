package com.lufficc.demolightadapter.viewprovider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lufficc.demolightadapter.R;
import com.lufficc.demolightadapter.model.BigImgModel;
import com.lufficc.lightadapter.ViewHolderProvider;

/**
 * Created by lufficc on 2016/8/31.
 */

public class BigImgViewProvider extends ViewHolderProvider<BigImgModel, BigImgViewProvider.HeaderViewHolder> {
    @Override
    public HeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup parent) {
        return new HeaderViewHolder(layoutInflater.inflate(R.layout.header_view, parent, false));
    }

    @Override
    public void onBindViewHolder(BigImgModel model, HeaderViewHolder viewHolder,int position) {
        viewHolder.textView.setText(model.getInfo());
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        HeaderViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
