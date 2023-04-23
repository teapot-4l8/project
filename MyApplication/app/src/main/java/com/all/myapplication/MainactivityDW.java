package com.all.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import Util.AppUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

import Util.SecurityUtil;
import Util.jni.AHAPIHelper;
import okhttp3.Call;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw);

        String sign = GenSign();

        try {
            Get_x_auth_token();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Get_x_auth_token() throws IOException {
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
                    .url("https://app.dewu.com/api/v1/app/user_core/users/getVisitorUserId")
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

                String comments = Grab_comments();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "网络请求异常", Toast.LENGTH_SHORT).show();
                Log.e("error", String.valueOf(e));
            }
        }).start();
    }

    private String Grab_comments() {
        return "xxx";
    }
    
    private String GenSign() {
        return "123";
    }
}
