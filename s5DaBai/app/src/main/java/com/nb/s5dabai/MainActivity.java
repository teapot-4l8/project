package com.nb.s5dabai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);


        // 调用核心算法，获取签名的值，发送到后端的API。
        String signString = EncryptUtils.v0(11, "alex");

        // 更NB的算法，让他以C语言的形式实现。
        int sign1 = EncryptUtils.v1(11, 22);
        Log.e("---->", String.valueOf(sign1)); //  133

        String sign2 = EncryptUtils.v2("root");
        Log.e("---->", sign2); //  rwxt

        SignQuery3 obj = EncryptUtils.ss("aid=123&page=9&size=19");
        String result = obj.toString();
        Log.e("---->", result); //  rwxt

        String value = DynamicUtils.ssss(11,22);
        Log.e("---->", value); //  rwxt
    }
}