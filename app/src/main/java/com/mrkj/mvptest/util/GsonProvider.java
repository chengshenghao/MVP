package com.mrkj.mvptest.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by admin on 2017/5/11.
 */

public class GsonProvider {
    /**
     * 返回一个可以转换NULL为空字符串的Gson对象
     * @return
     */
    public static Gson createNullStringAsEmptyGson(){
        return new GsonBuilder().serializeNulls().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
    }
}
