package com.all.myapplication;

import MyUtil.SecurityUtil;
import MyUtil.Domain;
import MyUtil.AppUtils;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Map;
import java.util.TreeMap;

import MyUtil.SignManager;
import MyUtil.ToastUtils;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.Call;
import okhttp3.Response;

public class MainactivityCZY extends AppCompatActivity {
    private TextView txtUser;
    private TextView txtPwd;
    private Button btnLogin, btnReset;
    public static final String LOGIN_URL = "/tradercloud/sealed/login/login.ashx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_czy);

        initView();
        initListener();
    }

    private void initView() {
        // 先找到所有的有用的标签
        txtUser = findViewById(R.id.txt_user);
        txtPwd = findViewById(R.id.txt_pwd);
        btnLogin = findViewById(R.id.btn_login);
        btnReset = findViewById(R.id.btn_reset);
    }

    private void initListener() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击btn_reset标签，执行方法
                txtUser.setText("");
                txtPwd.setText("");
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginByPassword();
            }
        });
    }


    public void loginByPassword() {
        // 1.获取输入框内容
        String username = String.valueOf(txtUser.getText());
        String password = String.valueOf(txtPwd.getText());

        String encpwd = SecurityUtil.encodeMD5(password);

        // 2.校验用户名和密码不能为空
        StringBuilder sb = new StringBuilder();
        // {username:"root",password:"123"}
//        HashMap<String, String> dataMap = new HashMap<String, String>();
        boolean hasEmpty = false;
        // {username:txtUser, password:txtPwd}
        TreeMap<String, TextView> mapping = new TreeMap<>();
        mapping.put("username", txtUser);
        mapping.put("password", txtPwd);
        for (Map.Entry<String, TextView> entry : mapping.entrySet()) {
            String key = entry.getKey();
            TextView obj = entry.getValue();
            String value = String.valueOf(obj.getText());
            if (value.trim().isEmpty()) {
                hasEmpty = true;
                break;
            }
            sb.append(value);
        }

        if (hasEmpty) {
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String udid = AppUtils.getUDID(MainactivityCZY.this);
        TreeMap<String, String> map = new TreeMap<>();
        map.put("_appid", "atc.android");
        map.put("appversion", "2.8.2");
        map.put("channelid", "csy");
        map.put("udid", udid);
        map.put("username", username);
        map.put("pwd", encpwd);
        Log.e("[*]map->", map.toString());

        new Thread(() -> {
            OkHttpClient client = new OkHttpClient.Builder().build();

            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> entry: map.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
            formBodyBuilder.add("_sign", SignManager.signByType(1, map));
//            FormBody form = new FormBody.Builder()
//                    .add("_appid", "atc.android")
//                    .add("appversion", "2.8.2")
//                    .add("channelid", "csy")
//                    .add("username", username)
//                    .add("_sign", SignManager.signByType(1, map))
//                    .add("udid", udid)
//                    .add("pwd", Objects.requireNonNull(encpwd)).build();
            Log.e("[*]_sign", SignManager.signByType(1, map));
            Request req = new Request.Builder().url(Domain.CZY+LOGIN_URL).post(formBodyBuilder.build()).build();
            Call call = client.newCall(req);
            try{
                Response res = call.execute();
                ResponseBody body = res.body();
                String dataString = body.string();
                Log.e("[*]receive->", dataString);
                ToastUtils.show(MainactivityCZY.this, parse(dataString));
            } catch (Exception e) {
                // getApplicationContext()是一个Context类的方法，它用于获取当前应用程序的上下文
                Toast.makeText(getApplicationContext(), "网络请求异常", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }).start();

    }

    private String parse(String dataString) {
        JSONObject responseJson = null;
        try {
            responseJson = new JSONObject(dataString);
            String message = responseJson.getString("message");
            Log.e("message", message);
            return message;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "message not found";
    }

}
