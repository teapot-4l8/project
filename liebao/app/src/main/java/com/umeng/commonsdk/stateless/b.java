package com.umeng.commonsdk.stateless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* compiled from: UMSLNetWorkSender.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6802a = 273;

    /* renamed from: b  reason: collision with root package name */
    private static Context f6803b = null;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f6804c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f6805d = null;
    private static final int f = 274;
    private static final int g = 275;
    private static final int h = 512;
    private static a i;
    private static IntentFilter j;

    /* renamed from: e  reason: collision with root package name */
    private static Object f6806e = new Object();
    private static boolean k = false;
    private static LinkedList<String> l = new LinkedList<>();
    private static BroadcastReceiver m = new BroadcastReceiver() { // from class: com.umeng.commonsdk.stateless.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            if (context == null || intent == null) {
                return;
            }
            try {
                if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Context unused = b.f6803b = context.getApplicationContext();
                    if (b.f6803b != null && (connectivityManager = (ConnectivityManager) b.f6803b.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                            boolean unused2 = b.k = true;
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
                            b.b(b.f);
                        } else {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
                            boolean unused3 = b.k = false;
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void r() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMSLNetWorkSender.java */
    /* loaded from: classes2.dex */
    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a((int) b.f);
        }
    }

    public static boolean a() {
        synchronized (f6806e) {
            return i != null;
        }
    }

    public b(Context context) {
        synchronized (f6806e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    f6803b = applicationContext;
                    if (applicationContext != null && f6804c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f6804c = handlerThread;
                        handlerThread.start();
                        if (i == null) {
                            String str = f6803b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f6805d == null) {
                            f6805d = new Handler(f6804c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.2
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case 273:
                                                b.m();
                                                return;
                                            case b.f /* 274 */:
                                                b.o();
                                                return;
                                            case b.g /* 275 */:
                                                b.q();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.r();
                                }
                            };
                        }
                        if (DeviceConfig.checkPermission(f6803b, "android.permission.ACCESS_NETWORK_STATE")) {
                            ULog.i("walle", "[stateless] begin register receiver");
                            if (j == null) {
                                IntentFilter intentFilter = new IntentFilter();
                                j = intentFilter;
                                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                if (m != null) {
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：注册网络状态监听器。");
                                    f6803b.registerReceiver(m, j);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(int i2) {
        Handler handler;
        if (!k || (handler = f6805d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f6805d.sendMessage(obtainMessage);
    }

    public static void b(int i2) {
        try {
            if (!k || f6805d == null || f6805d.hasMessages(i2)) {
                return;
            }
            Message obtainMessage = f6805d.obtainMessage();
            obtainMessage.what = i2;
            f6805d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f6803b, th);
        }
    }

    private static void j() {
        File[] c2 = d.c(f6803b);
        if (c2 != null) {
            if (l.size() > 0) {
                l.clear();
            }
            for (File file : c2) {
                l.add(file.getAbsolutePath());
            }
        }
    }

    private static String k() {
        String str = null;
        try {
            String peek = l.peek();
            if (peek != null) {
                try {
                    l.removeFirst();
                    return peek;
                } catch (Throwable unused) {
                    str = peek;
                    return str;
                }
            }
            return peek;
        } catch (Throwable unused2) {
        }
    }

    private static void l() {
        String k2;
        if (l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            if (Build.VERSION.SDK_INT >= 9) {
                k2 = l.pollFirst();
            } else {
                k2 = k();
            }
            if (!TextUtils.isEmpty(k2)) {
                File file = new File(k2);
                if (!file.exists()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                    continue;
                } else {
                    c cVar = new c(f6803b);
                    byte[] bArr = null;
                    try {
                        bArr = d.a(k2);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : ak.aG;
                    String d2 = d.d(name);
                    String str = com.umeng.commonsdk.stateless.a.j;
                    String c2 = d.c(d2);
                    if (com.umeng.commonsdk.vchannel.a.f6962c.equalsIgnoreCase(c2)) {
                        str = com.umeng.commonsdk.vchannel.a.f6960a;
                    }
                    if (cVar.a(bArr, c2, str, substring) && !file.delete()) {
                        file.delete();
                        continue;
                    }
                }
            }
        } while (k2 != null);
        l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        File a2;
        if (!k || f6803b == null) {
            return;
        }
        do {
            try {
                a2 = d.a(f6803b);
                if (a2 != null && a2.getParentFile() != null && !TextUtils.isEmpty(a2.getParentFile().getName())) {
                    c cVar = new c(f6803b);
                    String str = new String(Base64.decode(a2.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.f6746a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f6747b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.D.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = d.a(a2.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = com.umeng.commonsdk.vchannel.a.f6962c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f6960a : "";
                        String str3 = ak.aG;
                        if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str3 = ak.aB;
                        }
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = ak.ax;
                        }
                        if (cVar.a(bArr, str, str2, str3)) {
                            ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                            File file = new File(a2.getAbsolutePath());
                            if (file.delete()) {
                                continue;
                            } else {
                                ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                                file.delete();
                                continue;
                            }
                        } else {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                    }
                    new File(a2.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f6803b, th);
            }
        } while (a2 != null);
        n();
    }

    private static void n() {
        try {
            File file = new File(f6803b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f6801e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        if (!k || f6803b == null) {
            return;
        }
        j();
        l();
        c();
    }

    private static void p() {
        try {
            File file = new File(f6803b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f6801e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
        p();
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f);
    }

    public static void c() {
        b(g);
    }

    public static void d() {
        b(512);
    }
}
