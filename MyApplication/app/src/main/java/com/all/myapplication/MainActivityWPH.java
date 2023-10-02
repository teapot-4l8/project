package com.all.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import MyUtil.Domain;
import MyUtil.ApiConfig;
import MyUtil.wphAPI;

public class MainActivityWPH extends AppCompatActivity {
    static {
        System.loadLibrary("SoUtils");
    }
    public static native String getSKEY();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wphAPI.RegisterDevice(getSKEY());
    }
}
