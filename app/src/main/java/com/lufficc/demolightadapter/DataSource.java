package com.lufficc.demolightadapter;

import com.lufficc.demolightadapter.model.BigImgModel;
import com.lufficc.demolightadapter.model.ImgModel;
import com.lufficc.demolightadapter.model.TextModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by lufficc on 2016/8/31.
 */

public class DataSource {
    private static Random random = new Random();

    static List<Object> multiData() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (random.nextInt(100) > 90)
                list.add(new BigImgModel("Stay hungry,stay foolish  " + i));
            else if (random.nextInt(100) > 50)
                list.add(new ImgModel(R.mipmap.ic_img));
            else {
                list.add(new TextModel("Stay hungry,stay foolish  " + i));
            }
        }
        return list;
    }

    static List<Object> ImgModel() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ImgModel(R.mipmap.ic_img));
        }
        return list;
    }

    static List<Object> textModel() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new TextModel("Stay hungry,stay foolish  " + i));
        }
        return list;
    }

    static List<Object> randomTextModel() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (random.nextBoolean())
                list.add(new TextModel("Stay hungry,stay foolish  " + i));
            else
                list.add(new TextModel("Stay hungry,stay foolish  " + UUID.randomUUID().toString()));
        }
        return list;
    }
}
