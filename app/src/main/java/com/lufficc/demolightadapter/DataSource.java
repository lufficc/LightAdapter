package com.lufficc.demolightadapter;

import com.lufficc.demolightadapter.model.ImgModel;
import com.lufficc.demolightadapter.model.TextModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lufficc on 2016/8/31.
 */

public class DataSource {
    private static Random random = new Random();
    static List<Object> data()
    {
        List<Object> list = new ArrayList<>();
        for (int i=0;i<50;i++)
        {
            if (random.nextBoolean())
                list.add(new TextModel("Stay hungry,stay foolish  "+i));
            else
                list.add(new ImgModel(R.mipmap.ic_img));
        }
        return list;
    }
}
