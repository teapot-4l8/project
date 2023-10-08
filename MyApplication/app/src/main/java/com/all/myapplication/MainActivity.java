package com.all.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.all.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CardView cardLogin, cardChat, cardVideo, cardShop, cardEnv, cardCert, cardFingerPrint, cardMd5, cardGighub, cardTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initView();
        initListener();
    }

    private void initView() {
        cardLogin = findViewById(R.id.login);
        cardChat = findViewById(R.id.chat);
        cardVideo = findViewById(R.id.play);
        cardShop = findViewById(R.id.shop);
        cardEnv = findViewById(R.id.environment);
        cardCert = findViewById(R.id.certificate);
        cardTest = findViewById(R.id.test);
        cardMd5 = findViewById(R.id.md);
        cardFingerPrint = findViewById(R.id.signature);
    }

    private void initListener() {
        cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainactivityCZY.class);
                startActivity(intent);
            }
        });
        cardChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainactivityDW.class);
                startActivity(intent);
            }
        });
        cardVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityBilibili.class);
                startActivity(intent);
            }
        });
        cardTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityTest.class);
                startActivity(intent);
            }
        });

        cardShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityWPH.class);
                startActivity(intent);
            }
        });

        cardEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnvironmentDetectActiviy.class);
                startActivity(intent);
            }
        });

        cardCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CertifVerfyActivity.class);
                startActivity(intent);
            }
        });
        cardMd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityMd.class);
                startActivity(intent);
            }
        });
        cardFingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitySign.class);
                startActivity(intent);
            }
        });

    }
}