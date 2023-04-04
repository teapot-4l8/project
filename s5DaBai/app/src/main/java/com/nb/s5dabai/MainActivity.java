package com.nb.s5dabai;

import androidx.appcompat.app.AppCompatActivity;

import com.nb.s5dabai.Utils.EmulatorDetectUtil;  // Import statement for EmulatorDetectUtil class in Utils package. 

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String TAG = "MainActivity";
        // 检测手机是否被 root
        if (DeviceUtils.isDeviceRooted1()) {
            Toast.makeText(this, "法一检测到设备已被root", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "法一检测到设备已被 root！");
//            finish();  // 关闭当前 Activity（退出应用）TODO:release -> remember to uncomment it
        } else {
            Log.e(TAG, "法一未检测到root。");
            // TODO: 继续应用正常启动流程
        }

        if (DeviceUtils.isDeviceRooted2()) {
            Toast.makeText(this, "法二检测到设备已被root", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "法二检测到设备已被 root！");
//            finish();  // 关闭当前 Activity（退出应用）TODO:release -> remember to uncomment it
        } else {
            Log.e(TAG, "法二未检测到root。");
            // TODO: 继续应用正常启动流程
        }

        if (DeviceUtils.isDeviceRooted3()) {
            Toast.makeText(this, "法三检测到设备已被root", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "法三检测到设备已被 root！");
//            finish();  // 关闭当前 Activity（退出应用）TODO:release -> remember to uncomment it
        } else {
            Log.e(TAG, "法三未检测到root。");
            // TODO: 继续应用正常启动流程
        }

        // 检测是否解锁bl
        if (DeviceUtils.isBootloaderUnlocked1()) {
            Toast.makeText(this, "法一检测到bl已解锁", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "1.bl已解锁");
//            finish();  // 关闭当前 Activity（退出应用）TODO:release -> remember to uncomment it
        } else {
            Log.e(TAG, "法一未检测到bl解锁");
            // TODO: 继续应用正常启动流程
        }
        if (DeviceUtils.isBootloaderUnlocked2()) {
            Toast.makeText(this, "法二检测到bl已解锁", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "2.bl已解锁");
//            finish();  // 关闭当前 Activity（退出应用）TODO:release -> remember to uncomment it
        } else {
            Log.e(TAG, "法二未检测到bl解锁");
            // TODO: 继续应用正常启动流程
        }


        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);

        // 调用核心算法，获取签名的值，发送到后端的API。
        String signString = EncryptUtils.v0(11, "alex");

        // 更NB的算法，让他以C语言的形式实现。
        int sign1 = EncryptUtils.v1(11, 22);
        Log.e("---->", String.valueOf(sign1)); //  133

        // 静态注册
        String sign2 = EncryptUtils.v2("root");
        Log.e("---->", sign2); //  rwxt

        SignQuery3 obj = EncryptUtils.ss("aid=123&page=9&size=19");
        String result = obj.toString();  // SignQuery3的toString方法 获得拼接结果
        Log.e("---->", result); // aid=123&page=9&size=19&sign=hahahahhaha
        Log.e("[*]---->", obj.token);  // hahahahhaha
        Log.e("[*]---->", obj.params); //  aid=123&page=9&size=19

        // 动态注册
        String value = DynamicUtils.ssss(11,22);
        Log.e("---->", value); //  rwxt
    }
}