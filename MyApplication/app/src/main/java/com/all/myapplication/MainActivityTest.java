package com.all.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.nio.charset.StandardCharsets;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.*;
import MyUtil.AesEncryptUtil;
import MyUtil.AppUtils;
import MyUtil.BiliAPI;
import MyUtil.report.CreateHeaders;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import MyUtil.ApiConfig;
import okhttp3.ResponseBody;

import static com.tg.android.anti.NativeLib.*;

import MyUtil.report.heartbeat;

import MyUtil.report.b;

public class MainActivityTest extends AppCompatActivity {
    private String TAG = "[TEST]";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String data1 = "aid=467109917&auto_play=0&build=6240300&cid=544349271&did=KREhESMUckN2EyMQbBBsFm5fOAw-XS1HIw&epid=&from_spmid=main.space-contribution.0.0&ftime=1646914092&lv=0&mid=0&mobi_app=android&part=1&sid=0&spmid=main.ugc-video-detail.0.0&stime=1646917308&sub_type=0&type=3";
        String res = b.b(data1);
        Log.e(TAG, res);//e61583f49efa13187b053d2ab1cf2cc8cd99360367f42a6b7d013a49de72108e

        String data2 = "aid=211800701&auto_play=0&build=6240300&cid=518087166&did=KREhESMUckN2EyMQbBBsFm5fOAw-XS1HIw&epid=&from_spmid=tm.recommend.0.0&ftime=1652364011&lv=0&mid=0&mobi_app=android&part=0&sid=0&spmid=main.ugc-video-detail-vertical.0.0&stime=1654324378&sub_type=0&type=3&sign=49fd0a286217e03941e775ee98b6366998b896e455f11b8518c375d66caa3bc8";
        byte[] res2 = b.a(data2);
        Log.e(TAG, Arrays.toString(res2));

//        String mac = AppUtils.createRandomMac(":");
//        System.out.println(mac);
//        String sn = AppUtils.genSn();
//        System.out.println(sn);
//        String prevDid = mac + "|||" + sn;
//        System.out.println(prevDid);

//        byte[] h7 = new BiliAPI().H7();

        CreateHeaders createHeaders = new CreateHeaders();
        String str = createHeaders.aa();
        Log.e(TAG, "->" + str); // Buvid

    }

}


