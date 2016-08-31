package com.lufficc.lightadapter;

/**
 * Created by lufficc on 2016/8/31.
 */

class CheckUtil {
    static boolean checkInRange(int size, int position) {
        return  (position >= 0 && position < size);
    }

    static boolean checkExits(int position) {
        return  (position != -1);
    }

    static boolean haveYouRegistered(int type) {
        return (type == -1);
    }
}
