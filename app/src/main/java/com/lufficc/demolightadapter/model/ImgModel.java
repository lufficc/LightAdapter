package com.lufficc.demolightadapter.model;

import android.support.annotation.DrawableRes;

/**
 * Created by lufficc on 2016/8/31.
 */

public class ImgModel {

    @DrawableRes
    public int getImgId() {
        return imgId;
    }

    public ImgModel(int imgId) {
        this.imgId = imgId;
    }

    public void setImgId(@DrawableRes int imgId) {
        this.imgId = imgId;
    }

    @DrawableRes
    private int imgId;
}
