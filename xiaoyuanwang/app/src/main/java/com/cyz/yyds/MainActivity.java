package com.cyz.yyds;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private TextView mResultTextView;

    private static final String URL = "http://202.204.67.15/include/auth_action.php";
    private static final String PREFERENCE_NAME = "login_preference";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameEditText = (EditText) findViewById(R.id.username_edit_text);
        mPasswordEditText = (EditText) findViewById(R.id.password_edit_text);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mResultTextView = (TextView) findViewById(R.id.result_text_view);

        // 读取保存的用户名和密码
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        String username = preferences.getString(USERNAME_KEY, "");
        String password = preferences.getString(PASSWORD_KEY, "");

        if (!username.isEmpty() && !password.isEmpty()) {
            mUsernameEditText.setText(username);
            mPasswordEditText.setText(password);
            new LoginTask().execute(username, password);
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                // 保存用户名和密码到本地
                SharedPreferences.Editor editor = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
                editor.putString(USERNAME_KEY, username);
                editor.putString(PASSWORD_KEY, password);
                editor.apply();

                new LoginTask().execute(username, password);
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String username = params[0];
            String password = params[1];

            // 设置请求参数
            Map<String, String> parameters = new HashMap<>();
            parameters.put("action", "login");
            parameters.put("username", username);
            parameters.put("password", password);
            parameters.put("ac_id", "1");
            parameters.put("user_ip", "");
            parameters.put("nas_ip", "");
            parameters.put("user_mac", "");
            parameters.put("save_me", "1");
            parameters.put("ajax", "1");

            try {
                URL obj = new URL(URL);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // 设置请求方法和 User-Agent
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");

                // 构建请求参数字符串
                StringBuilder postData = new StringBuilder();
                for (Map.Entry<String, String> param : parameters.entrySet()) {
                    if (postData.length() != 0)
                        postData.append('&');
                    postData.append(param.getKey());
                    postData.append('=');
                    postData.append(param.getValue());
                }

                // 发送请求
                con.setDoOutput(true);
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = postData.toString().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                // 读取响应内容并返回
                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                        response.append('\n');
                    }
                }

                result = response.toString();
//                Log.e("res ->", result);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                mResultTextView.setText(result);
            } else {
                mResultTextView.setText("登录失败");
            }
        }
    }
}