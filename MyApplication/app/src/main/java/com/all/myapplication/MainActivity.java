package com.all.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import Util.RequestUtil;

import com.all.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Used to load the 'myapplication' library on application startup.
    static {
        System.loadLibrary("myapplication");
    }

    private ActivityMainBinding binding;
    private Button btnCZY, btnDW, btnBplay, btnTEST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
//        TextView tv = binding.sampleText;
//        tv.setText(stringFromJNI());

        initView();
        initListener();

        boolean hasproxy = RequestUtil.hasproxy(MainActivity.this);
        System.out.println("[*] if use proxy ->" + hasproxy);
    }

    private void initView() {
        btnCZY = findViewById(R.id.chezhiying);
        btnDW = findViewById(R.id.dw);
        btnBplay = findViewById(R.id.Bplay);
        btnTEST = findViewById(R.id.test);
    }

    private void initListener() {
        btnCZY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainactivityCZY.class);
                startActivity(intent);
            }
        });
        btnDW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainactivityDW.class);
                startActivity(intent);
            }
        });
        btnBplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityBilibili.class);
                startActivity(intent);
            }
        });
        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityTest.class);
                startActivity(intent);
            }
        });
    }
}