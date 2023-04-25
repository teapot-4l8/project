package com.all.myapplication;

import android.media.audiofx.LoudnessEnhancer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;

import Util.AppUtils;
import Util.BiliAPI;

public class MainActivityBilibili extends AppCompatActivity {
    private Button btnBvid;
    private EditText txtbvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_play);

        initView();
        initListener();
    }

    private void initView() {
        btnBvid = findViewById(R.id.execute);
        txtbvid = findViewById(R.id.BV);
    }

    private void initListener() {
        btnBvid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bvid = getBvid();
                try {
                    initVideoInfo(bvid);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private String getBvid() {
        return String.valueOf(txtbvid);
    }

    private void initVideoInfo (String bvid) throws JSONException, IOException {
        BiliAPI.getVideoIdInfo(bvid, new BiliAPI.VideoIdInfoCallback() {
            @Override
            public void onResult(String[] result) {
                // Use result here
                StringBuilder builder = new StringBuilder();
                for (String info : result) {
                    builder.append(info).append("\n");
                }
                Log.e("[*B]", String.valueOf(builder));
            }
        });
    }

}
