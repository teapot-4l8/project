package com.all.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import MyUtil.EnvUtils.*;



public class EnvironmentDetectActiviy extends AppCompatActivity {

    static {
        System.loadLibrary("SoUtils");
    }
    private static final String TAG = "[*JNI]";
    TextView CheckPort23946ByTcpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_env);

        // TextView checkPort23946ByTcpTV = findViewById(R.id.CheckPort23946ByTcp_text);
        // String checkPort23946ByTcp = CheckPort23946ByTcp();
        // checkPort23946ByTcpTV.setText(checkPort23946ByTcp);
        setTextViewText(R.id.CheckPort23946ByTcp_text, CheckPort23946ByTcp());

        String searchObjProcess = SearchObjProcess();
        setTextViewText(R.id.SearchObjProcess_text, searchObjProcess);

        String checkParents =  CheckParents();
        setTextViewText(R.id.CheckParents_text, checkParents);

        String checkTaskCount = CheckTaskCount();
        setTextViewText(R.id.CheckTaskCount_text, checkTaskCount);

        String nativeIsDBGConnected = NativeIsDBGConnected();
        setTextViewText(R.id.NativeIsDBGConnected_text, nativeIsDBGConnected);

        String ptraceCheck_ = ptraceCheck();
        setTextViewText(R.id.ptraceCheck_text, ptraceCheck_);


        String checkBreakPoint = CheckBreakPoint();
        setTextViewText(R.id.checkbkpt_text, checkBreakPoint);

//        String checkSystem = CheckSystem(); // TODO: fix bug 11.
//        Log.e(TAG, checkSystem);

//        String sigTrap = SigTrap();  // TODO: fix bug 12.
//        setTextViewText(R.id., checkBreakPoint);

        String interceptedSignalCheck = InterceptedSignalCheck();
        setTextViewText(R.id.InterceptedSignalCheck_text, interceptedSignalCheck);

        String idaCracked = IDACracked();
        setTextViewText(R.id.IDACracked_text, idaCracked);

        String codeExecutionTimeCheck = CodeExecutionTimeCheck();
        setTextViewText(R.id.CodeExecutionTimeCheck_text, codeExecutionTimeCheck);

        String thread_watchDumpPagemap = Thread_watchDumpPagemap();
        setTextViewText(R.id.thread_watchDumpPagemap_text, thread_watchDumpPagemap);

        setTextViewText(R.id.frida_text, String.valueOf(FridaDetect.isFridaServerRunning()));

        setTextViewText(R.id.root_text_1, String.valueOf(DeviceUtils.isDeviceRooted1()));
        setTextViewText(R.id.root_text_2, String.valueOf(DeviceUtils.isDeviceRooted2()));
        setTextViewText(R.id.root_text_3, String.valueOf(DeviceUtils.isDeviceRooted3()));

        setTextViewText(R.id.bl_text_1, String.valueOf(DeviceUtils.isBootloaderUnlocked1()));
        setTextViewText(R.id.bl_text_2, String.valueOf(DeviceUtils.isBootloaderUnlocked2()));

        setTextViewText(R.id.isEmulator_text, String.valueOf(DeviceUtils.isEmulator()));

        XposedDetect xposedDetect = XposedDetect.a(getPackageManager());
        setTextViewText(R.id.xposed_text0, String.valueOf(DeviceUtils.isXposedInstalled()));
        setTextViewText(R.id.xposed_text1, String.valueOf(xposedDetect.a()));
        setTextViewText(R.id.lsposed_text, String.valueOf(DeviceUtils.isLSposedInstalled()));

        setTextViewText(R.id.proxy_text, String.valueOf(DeviceUtils.proxyDetector(EnvironmentDetectActiviy.this)));

        setTextViewText(R.id.magisk_text, String.valueOf(DeviceUtils.MagiskExisted()));
        setTextViewText(R.id.kernelSU_text, String.valueOf(DeviceUtils.KernelSU()));

    }

    private void setTextViewText(int textViewId, String text) {
        TextView textView = findViewById(textViewId);
        textView.setText(text);
    }

    // IDA调试端口检测
    public static native String CheckPort23946ByTcp();

    // 调试器进程名检测
    public static native String SearchObjProcess();

    // 父进程名检测
    public static native String CheckParents();

    // apk线程检测
    public static native String CheckTaskCount();

    // TODO: apk进程fd文件检测
//    public static native String

    // 安卓系统自带调试检测函数
    public static native String NativeIsDBGConnected();

    // ptrace检测
    public static native String ptraceCheck();

    // TODO: 函数hash值检测

    // 断点指令检测
    public static native String CheckBreakPoint();

    // 系统源码修改检测
    public static native String CheckSystem();

    // 单步调试陷阱
    public static native String SigTrap();

    // 利用IDA先截获信号特性的检测
    public static native String InterceptedSignalCheck();

    //利用IDA解析缺陷反调试
    public static native String IDACracked();

    // 五种代码执行时间检测 TODO: use them in a function
    public static native String CodeExecutionTimeCheck();

    // Inotify事件监控dump
    public static native String Thread_watchDumpPagemap();
}
