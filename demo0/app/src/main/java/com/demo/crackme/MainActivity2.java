package com.demo.crackme;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
//import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtUser, txtPwd;
    private Button btnLogin, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_login);

        // 接收结果
        Intent intent = this.getIntent();
        String responseString = intent.getStringExtra("data");

        // responseJson是服务器返回的JSON格式数据
        JSONObject responseJson = null;
        try {
            responseJson = new JSONObject(responseString);
            // 获取token值
            String token = responseJson.getString("token");
            Log.e("token", token);
        } catch (JSONException e) {
            e.printStackTrace();
        }

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

    private void loginForm() {
//        StringBuilder sb = new StringBuilder();
//        HashMap<String, String> dataMap = new HashMap<String, String>();
//        boolean hasEmpty = false;
//        HashMap<String, TextView> mapping = new HashMap<String, TextView>();
//        mapping.put("username", txtUser);
//        mapping.put("password", txtPwd);
//        for (Map.Entry<String, TextView> entry : mapping.entrySet()) {
//            String key = entry.getKey();
//            TextView obj = entry.getValue();
//            String value = String.valueOf(obj.getText());
//            if (value.trim().isEmpty()) {
//                hasEmpty = true;
//                break;
//            }
//
//            dataMap.put(key, value);
//            sb.append(value);
//        }

//        if (hasEmpty) {
//            Toast.makeText(this, "input content can't be null", Toast.LENGTH_SHORT).show();
//            return;
//        }
        // TODO: jni加密
//        String signString = md5(sb.toString());
//        dataMap.put("sign", signString);

        new Thread() {
            @Override
            public void run() {
                // 读取
                SharedPreferences sp = getSharedPreferences("LLLLLLLLLLLL", MODE_PRIVATE);
                String token = sp.getString("token","");
                Log.e("token from xml ->", token);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.43.71:5000").build();
                HttpReq req = retrofit.create(HttpReq.class);
                Call<ResponseBody> call = req.postLogin(txtUser.toString(), txtPwd.toString());
                try{
                    ResponseBody responseBody = call.execute().body();
                    String responseString = responseBody.string();
                    Log.e("Retrofit返回的结果", responseString);

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

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Toast.makeText(this, "native层加密", Toast.LENGTH_SHORT).show();
    }
}
