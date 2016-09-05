package com.lufficc.demolightadapter.viewprovider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lufficc.demolightadapter.R;
import com.lufficc.demolightadapter.model.TextModel;
import com.lufficc.lightadapter.ViewHolderProvider;

/**
 * Created by lufficc on 2016/8/31.
 */

public class TextViewProvider extends ViewHolderProvider<TextModel, TextViewProvider.TextViewHolder> {
    private int position = 0;

    @Override
    public TextViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup parent) {
        return new TextViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(TextModel textModel, TextViewHolder viewHolder,int position) {
        viewHolder.textView.setText(textModel.getText());
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
