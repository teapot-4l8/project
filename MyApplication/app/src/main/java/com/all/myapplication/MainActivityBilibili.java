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
    public String aid, cid, bvid;

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
                    BiliAPI api = new BiliAPI();
                    byte[] bytes = api.str2byteenc(aid, cid);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private String getBvid() {
        return String.valueOf(txtbvid.getText());
    }

    private void initVideoInfo (String bvid) throws JSONException, IOException {
        BiliAPI.getVideoIdInfo(bvid, new BiliAPI.VideoIdInfoCallback() {
            @Override
            public void onResult(String[] result) {
                // Use result here
                aid = result[0];
                String bvid = result[1];
                cid = result[2];
                String duration = result[3];
                String view_count = result[4];
                Log.e("[*B]--", aid);
                Log.e("[*B]", bvid);
                Log.e("[*B]", cid);
                Log.e("[*B]", duration);
                Log.e("[*B]--", view_count);

                // Use the variables here
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("aid: " + aid + "\nbvid: " + bvid + "\ncid: " + cid + "\nduration: " + duration + "\nview_count: " + view_count);
                    }
                });
            }
        });
    }

    private void play_vedio(String bvid) {

    }

}
