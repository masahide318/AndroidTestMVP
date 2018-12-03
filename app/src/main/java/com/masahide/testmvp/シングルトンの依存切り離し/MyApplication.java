package com.masahide.testmvp.シングルトンの依存切り離し;

import android.app.Application;

public class MyApplication extends Application {
    private static Application instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
