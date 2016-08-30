package com.lufficc.lightadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by lufficc on 2016/8/31.
 */

public abstract class ViewHolderProvider<Model, VH extends RecyclerView.ViewHolder> {
    public abstract VH onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup parent);

    public abstract void onBindViewHolder(Model model, VH viewHolder);
}
