package com.tg.anti;

import android.app.Application;
import android.content.Context;

public class AntiApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        xCrash provides the Android app with the ability to capture java crash,
//        native crash and ANR. No root permission or any system permissions are required.
        xcrash.XCrash.init(this);
    }
}
