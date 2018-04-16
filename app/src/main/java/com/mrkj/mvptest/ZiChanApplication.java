package com.mrkj.mvptest;

import android.app.Application;
import android.app.Service;
import android.graphics.Bitmap;
import android.os.Vibrator;
import android.util.LruCache;



/**
 * Created by admin on 2017/5/9.
 */

public class ZiChanApplication extends Application {
    public static ZiChanApplication mApplication;
    private LruCache<String, Bitmap> imageLruCache;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        imageLruCache = new LruCache<>((int) (Runtime.getRuntime().maxMemory() / 8));
        Vibrator mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
    }


}
