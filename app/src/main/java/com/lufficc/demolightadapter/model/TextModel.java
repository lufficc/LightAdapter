package com.lufficc.demolightadapter.model;

/**
 * Created by lufficc on 2016/8/31.
 */

public class TextModel {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public TextModel(String text) {
        this.text = text;
    }
}
