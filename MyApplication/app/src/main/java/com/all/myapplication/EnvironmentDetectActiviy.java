package com.all.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.all.myapplication.databinding.ActivityMainBinding;

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


        String checkPort23946ByTcp = CheckPort23946ByTcp();
//        Log.e(TAG, checkPort23946ByTcp);
        String searchObjProcess = SearchObjProcess();
//        Log.e(TAG, searchObjProcess);
        String checkParents =  CheckParents();

        String checkTaskCount = CheckTaskCount();

        String nativeIsDBGConnected = NativeIsDBGConnected();

        String ptraceCheck_ = ptraceCheck();
//        Log.e(TAG, ptraceCheck_);
        String checkBreakPoint = CheckBreakPoint();

//        String checkSystem = CheckSystem(); // TODO: fix bug 11.
//        Log.e(TAG, checkSystem);

        String sigTrap = SigTrap();  // TODO: fix bug 12.

        String interceptedSignalCheck = InterceptedSignalCheck();

        String idaCracked = IDACracked();

        String codeExecutionTimeCheck = CodeExecutionTimeCheck();

        String thread_watchDumpPagemap = Thread_watchDumpPagemap();
    }

// TODO: show these result
//    private void showResult() {
//        CheckPort23946ByTcpText = findViewById(R.id.CheckPort23946ByTcp_text);
//        CheckPort23946ByTcpText.setText(CheckPort23946ByTcpText);
//    }

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
