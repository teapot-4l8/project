package com.demo.crackme;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_login);

        // 接收结果
        Intent intent = this.getIntent();
        String retdata = intent.getStringExtra("return");

    }
}
