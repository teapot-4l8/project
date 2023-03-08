package com.demo.crackme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.net.Proxy;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private TextView txtUser, txtPwd;
    private Button btnLogin, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建intent对象
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
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
                loginForm();
            }
        });
    }

    /**
     * 点击登录，执行此方法
     * @param intent
     */
    private void loginForm() {
        // 1.获取用户名和密码
        String username = String.valueOf(txtUser.getText());
        String password = String.valueOf(txtPwd.getText());

        // 2.校验用户名和密码不能为空
        // root123
        StringBuilder sb = new StringBuilder();

        // {username:"root",password:"123"}
        HashMap<String, String> dataMap = new HashMap<String, String>();

        boolean hasEmpty = false;

        // {username:txtUser, password:txtPwd}
        HashMap<String, TextView> mapping = new HashMap<String, TextView>();
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

            dataMap.put(key, value);
            sb.append(value);
        }

        if (hasEmpty) {
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // sb="root123"
        // dataMap={username:"root",password:"123"}

        // 3.用md5做一个签名
        // dataMap={username:"root",password:"123","sign":"xxxxdfsdfsdfsdfdfd"}
        String signString = md5(sb.toString());
        dataMap.put("sign", signString);

        // com.nb.liyang E/加密后的结果：: cb2921a386719d7467412b5573973529
        Log.e("sign加密后的结果：", signString);

        // 创建拦截器
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                // 1988812212 + 固定字符串 => md5加密
                Request request = chain.request().newBuilder().addHeader("ts", String.valueOf(System.currentTimeMillis())).addHeader("sign", "xxxx").build();
                // 请求前
                Response response = chain.proceed(request);
                // 请求后
                return response;
            }
        };

        // 4.将三个值：用户名、密码、签名 网络请求发送API（校验）
        // okhttp，安装 & 引入 & 使用（创建一个线程去执行）
        // 5.获取返回值

        new Thread() {
            @Override
            public void run() {
                // 线程执行的内容
                // user=xxx&pwd=xxx&sign=xxxx
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
//                FormBody form = new FormBody.Builder()
//                        .add("user", dataMap.get("username"))
//                        .add("pwd", dataMap.get("password"))
//                        .add("sign", dataMap.get("sign")).build();

                // {"user":...}
                JSONObject json = new JSONObject(dataMap);
                String jsonString = json.toString();
                RequestBody reqbody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonString);

                Request req = new Request.Builder().url("http://192.168.43.71:5000").post(reqbody).build();
                Call call = client.newCall(req);
                try {
                    Response res = call.execute();
                    ResponseBody body = res.body();
                    String dataString = body.string();
                    // {"status": true, "token": "dafkauekjsoiuksjdfuxdf", "name": "武沛齐"}

                    // 反序列化
//                    HttpResponse obj = new Gson().fromJson(dataString,HttpResponse.class);
//                    if(obj.status){
//                        // token保存本地xml文件
//                        // /data/data/com.nb.liyang
//                        SharedPreferences sp = getSharedPreferences("sp_city", MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sp.edit();
//                        editor.putString("token",obj.token);
//                        editor.commit();
//
//                    }
                    Log.e("url->", req.toString());
                    Log.e("请求发送成功", dataString);
// TODO: 跳转至activity2
                    // 数据传入activity2
//                    MainActivity.this.intent.putExtra("return", dataString);
                    // 开启
//                    startActivity(MainActivity.this.intent);
                } catch (IOException ex) {
                    Log.e("url->", req.toString());
                    Log.e("Main", "网络请求异常");
                }
            }
        }.start();
        Toast.makeText(this, "登录", Toast.LENGTH_SHORT).show();
    }


    /**
     * md5加密
     *
     * @param dataString 待加密的字符串
     * @return 加密结果
     */
    private String md5(String dataString) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] nameBytes = instance.digest(dataString.getBytes());

            // 十六进制展示
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nameBytes.length; i++) {
                int val = nameBytes[i] & 255;  // 负数转换为正数
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}