package com.all.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import MyUtil.AppUtils;
import MyUtil.Domain;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import MyUtil.SecurityUtil;
import MyUtil.jni.AHAPIHelper;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainactivityDW extends AppCompatActivity {
    private static final String REPLY_LIST = "/sns-itr/v1/reply/content-reply-list";
    private static final String GET_VISITOR_USERID = "/api/v1/app/user_core/users/getVisitorUserId";
    private static final String SHUMEI_ID = "20210807163758afabf6d66401eb2e4f234dbe68af5705014c79067d50b114";
    private static final String ctime = String.valueOf(System.currentTimeMillis());
    private static final String uuid = AppUtils.createAndroidId();
    Map<String, String> replyParamDict = new HashMap<>();
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw);

        responseText = (TextView) findViewById(R.id.response_text);
//        String xAuthToken = Get_x_auth_token();
//        TODO: 这是两个线程 同时执行 可能Get_x_auth_token还没返回结果Grab_comments的请求就发送过去了 优化一下结构！
        String xAuthToken = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2ODIyNTgzOTQsImV4cCI6MTcxMzc5NDM5NCwiaXNzIjoiZjcyOTM5MDM5OGM3MzYyOSIsInN1YiI6ImY3MjkzOTAzOThjNzM2MjkiLCJ1dWlkIjoiZjcyOTM5MDM5OGM3MzYyOSIsInVzZXJJZCI6MTQyOTUwNTMwMSwiaXNHdWVzdCI6dHJ1ZX0.Be1U9bkCH-Rt3LtL9v-sBlDFx8nKaWaKzUoN_-jhPMXpAiDJRGMQNLLj0mo27tnAPThPD2EYdZFuw1YKcNgXLRTkethW-LL-sdWlu7ocVv6un520l6xfxtdO19OyjkavOAYhy7VU6NBpaQlCMNFjVEjnlzEnI8a-ybLZixj6eQu2azkTvuV45uEhS4dH9GbIKjL1WhhBq-eR_4-OZLmExoJQ0dUwb8x5miSANBkT8UwKTH8pXxJR1IGBcZEUToRXe3S9kpJMudUFGQPP1tlu-m4h4ae_aBmchh4jbe5YGJDlJRcLY3wxJRiHiRw4NIWUm1Hor9N6Kh14NmDKRc78vg";

        GenSign();  // 往map里添加sign
//        String comments = Grab_comments(xAuthToken);
        Grab_comments(xAuthToken); // 获取评论数据
    }
    // TODO: 解决一下这个问题。似乎可以用回调函数
    private String Get_x_auth_token() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("platform", "android");
        map.put("v", "5.0.6");
        map.put("loginToken", "");
        map.put("uuid", uuid);
        map.put("timestamp", ctime);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }

        String result = sb.toString();
        Log.e("[**]", result);

        byte[] aesByte = AHAPIHelper.aesEncrypt(result); // TODO: -> so
        Log.e("[**aes_byte", Arrays.toString(aesByte));
        String aesString = Base64.getEncoder().encodeToString(aesByte);
        Log.e("[**aesstring]", aesString);
        String sign = SecurityUtil.md5(aesString.getBytes(StandardCharsets.UTF_8));
        Log.e("[**sign]",sign);
        map.put("newSign", sign);

        Gson gson = new Gson();
        String json = gson.toJson(map);

        new Thread(() -> {
            OkHttpClient client = new OkHttpClient.Builder().proxy(Proxy.NO_PROXY).build();

            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(Domain.DW+GET_VISITOR_USERID)
                    .post(body)
                    .addHeader("duuuid", uuid)
                    .addHeader("duplatform", "android")
                    .addHeader("appId", "duapp")
                    .addHeader("duv", "5.0.6")
                    .addHeader("duloginToken", "")
                    .addHeader("timestamp", ctime)
                    .addHeader("shumeiid", SHUMEI_ID)
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .build();
            Call call = client.newCall(request);
            try {
//                Response response = client.newCall(request).execute();
                Response response = call.execute();
                ResponseBody responseBody = response.body();
                assert responseBody != null;
                String dataString = responseBody.string();
                Log.e("[**token]", dataString);
                String xAuthToken = response.header("X-Auth-Token");
                Log.e("[*] X-Auth-Token", xAuthToken);
                /* 获取响应头内容
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println(headers.name(i) + ": " + headers.value(i));
                }
                */
//                return xAuthToken;
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "网络请求异常", Toast.LENGTH_SHORT).show();
                Log.e("error", String.valueOf(e));
            }
        }).start();
        return "";
    }

    private void Grab_comments(String xAuthToken) {
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder urlBuilder = HttpUrl.parse(Domain.DW + REPLY_LIST).newBuilder();
            for (Map.Entry<String, String> entry : replyParamDict.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
            String url = urlBuilder.build().toString();
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("X-Auth-Token", xAuthToken)
                    .addHeader("User-Agent", "duapp/5.0.6(android;10)")
                    .build();

            Call call = client.newCall(request);
            try {
                Response response = call.execute();
                ResponseBody body = response.body();
                String dataString = body.string();
                System.out.println(dataString);
                showResponse(dataString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    
    private void GenSign() {
        replyParamDict.put("contentId", "91820099");
        replyParamDict.put("contentType", "0");
        replyParamDict.put("anchorReplyId", "0");
        replyParamDict.put("lastId", "");
        replyParamDict.put("source", "");
        replyParamDict.put("limit", "5");

        Map<String, String> newDict = new HashMap<>(replyParamDict);
        newDict.put("loginToken", "");
        newDict.put("platform", "android");
        newDict.put("timestamp", Long.toString(System.currentTimeMillis()));
        newDict.put("uuid", uuid);
        newDict.put("v", "5.0.6");

        List<String> keys = new ArrayList<>(newDict.keySet());
        Collections.sort(keys);
        StringBuilder orderedString = new StringBuilder();
        for (String key : keys) {
            orderedString.append(key).append(newDict.get(key));
        }
        byte[] aesByte = AHAPIHelper.aesEncrypt(orderedString.toString());
        String aesString = Base64.getEncoder().encodeToString(aesByte);
        aesString = aesString.replace("\n", "");
        String signString = SecurityUtil.md5(aesString.getBytes());
        replyParamDict.put("newSign", signString);
    }

    //android 时不允许在子线程里面更新UI的 我们需要通过这个方法 将线程切换到主线程，然后再更新UI元素
    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }

}
