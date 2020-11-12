package com.example.modulelibs.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author: ZPF
 * Time: 2020/7/4 16:05
 * Desc:
 */

public class BaseApplication extends Application {

    public static boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if(isDebug){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
