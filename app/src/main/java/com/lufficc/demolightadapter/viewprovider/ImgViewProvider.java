package com.lufficc.demolightadapter.viewprovider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lufficc.demolightadapter.R;
import com.lufficc.demolightadapter.model.ImgModel;
import com.lufficc.lightadapter.ViewHolderProvider;

import java.util.Random;

/**
 * Created by lufficc on 2016/8/31.
 */

public class ImgViewProvider extends ViewHolderProvider<ImgModel, ImgViewProvider.ImgViewHolder> {
    private int position = 0;
    private Random random = new Random();

    @Override
    public ImgViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup parent) {
        return new ImgViewHolder(layoutInflater.inflate(R.layout.item_img, parent, false));
    }

    @Override
    public void onBindViewHolder(ImgModel imgModel, ImgViewHolder viewHolder) {
        viewHolder.imageView.setImageResource(imgModel.getImgId());
    }

    class ImgViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImgViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
        }

    }
}
