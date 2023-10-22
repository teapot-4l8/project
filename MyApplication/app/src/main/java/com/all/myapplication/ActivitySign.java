package com.all.myapplication;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySign extends AppCompatActivity {
    private final String TAG = "[*]";
    private final String ctime = String.valueOf(System.currentTimeMillis());
    private final String key = "creeper?";
    private final String iv = "awwwwwwwwman";
    private final String manufacturer = Build.MANUFACTURER;  // 获取设备制造商（Manufacturer
    private final String  model = Build.MODEL;  //获取设备型号（Model）
    private final String brand = Build.BRAND; //获取设备品牌（Brand）
    private final String androidVersion = Build.VERSION.RELEASE;//获取设备的Android版本号
    private final int sdkVersion = Build.VERSION.SDK_INT;//获取设备的SDK版本号
    private String deviceId;
    private String screenResolution;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);


        getInfo();
    }

    private String getScreenResolution() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        screenResolution = screenWidth + "x" + screenHeight;
        return screenResolution;
    }

    @SuppressLint("HardwareIds")
    private void getInfo() {
        Log.e(TAG, "manufacturer:" + manufacturer);
        Log.e(TAG, "model:" + model);
        Log.e(TAG, "brand:" + brand);
        Log.e(TAG, "androidVersion:" + androidVersion);
        Log.e(TAG, "sdkVersion:" + sdkVersion);
        deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.e(TAG, "deviceId:" + deviceId);
        Log.e(TAG, "screenResolution:" + getScreenResolution());
    }
}
