package com.nb.s5dabai;

import androidx.appcompat.app.AppCompatActivity;

import com.nb.s5dabai.Utils.DexHashChecker;
import com.nb.s5dabai.Utils.EmulatorDetectUtil;  // Import statement for EmulatorDetectUtil class in Utils package.

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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

        // TODO: bug not found remember to uncomment them :)
/*
        String result = Advancedmd5.encrypt("123456");
        System.out.println("[*]" + result);
        Log.e("[*]", result);


        String dynamicres = DynamicUtils.dymMD5("123456");
        System.out.println("[*]DYM[*]" + dynamicres);
        Log.e("[*]DYM[*]", dynamicres);

        boolean useProxy = DeviceUtils.proxyDetector(MainActivity.this);
        System.out.println("[*] if use proxy ->" + useProxy);
        Log.e("[*] if use proxy ->", String.valueOf(useProxy));
*/

        Context context = getApplicationContext();
        PackageManager packageManager = MainActivity.this.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            String apkPath = applicationInfo.sourceDir;
            // Do something with the APK path
//        8709678734adad10f1cec23c26d9f1eb50ab66252b379a7965aa52430ab451ff
//        76f50a566360b0fa1f7412ffafae3777391ac299065bf3633b71bbaec51a69d3
            boolean haschange = DexHashChecker.isDexHashValid(apkPath);
            System.out.println("[*] if current hash code equals the origin " + haschange);
            Log.e("[*] if equals", String.valueOf(haschange));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        /*
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
        */

        /* these code has some error
        int isemulator = DeviceUtils.EmulatorDetectUtil();
        System.out.println("[*] is emulator ->" + isemulator);
        */
        /*
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
        */
    }
}