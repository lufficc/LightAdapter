package com.lufficc.lightadapter;

/**
 * Created by lufficc on 2016/8/31.
 */

class CheckUtil {
    static void checkInRange(int size, int position) {
        if (position < 0 || position >= size)
            throw new IllegalArgumentException("position is out of range :" + position + "/" + size);
    }

    static void checkExits(int position) {
        if (position == -1)
            throw new IllegalArgumentException("the object you are removing doesn't exits");
    }
}
