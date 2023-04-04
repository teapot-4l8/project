package org.b.b.c.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/* compiled from: IdentifierIdClient.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7777a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f7778b = false;

    /* renamed from: c  reason: collision with root package name */
    private static c f7779c;

    /* renamed from: d  reason: collision with root package name */
    private static c f7780d;

    /* renamed from: e  reason: collision with root package name */
    private static c f7781e;
    private static Object f = new Object();
    private static HandlerThread g = null;
    private static Handler h = null;
    private static String i = null;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static volatile b n = null;
    private static volatile a o = null;

    private b() {
    }

    public static b a(Context context) {
        if (n == null) {
            synchronized (b.class) {
                f7777a = context.getApplicationContext();
                n = new b();
            }
        }
        if (o == null) {
            synchronized (b.class) {
                f7777a = context.getApplicationContext();
                f();
                o = new a(f7777a);
                c();
            }
        }
        return n;
    }

    private static void f() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        g = handlerThread;
        handlerThread.start();
        h = new Handler(g.getLooper()) { // from class: org.b.b.c.a.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    String unused = b.i = b.o.a(message.getData().getInt(com.umeng.analytics.pro.d.y), message.getData().getString("appid"));
                    synchronized (b.f) {
                        b.f.notify();
                    }
                    return;
                }
                Log.e("VMS_IDLG_SDK_Client", "message type valid");
            }
        };
    }

    public boolean a() {
        return f7778b;
    }

    public String b() {
        if (a()) {
            String str = j;
            if (str != null) {
                return str;
            }
            a(0, (String) null);
            if (f7779c == null) {
                a(f7777a, 0, null);
            }
            return j;
        }
        return null;
    }

    public void a(int i2, String str) {
        synchronized (f) {
            b(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            } else if (i2 == 0) {
                j = i;
                i = null;
            } else if (i2 == 1) {
                if (i != null) {
                    k = i;
                    i = null;
                } else {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
            } else {
                if (i2 != 2) {
                    if (i2 != 4) {
                    }
                } else if (i != null) {
                    l = i;
                    i = null;
                } else {
                    Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                }
                m = i;
                i = null;
            }
        }
    }

    private void b(int i2, String str) {
        Message obtainMessage = h.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt(com.umeng.analytics.pro.d.y, i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        h.sendMessage(obtainMessage);
    }

    public static void c() {
        f7778b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            f7779c = new c(n, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f7779c);
        } else if (i2 == 1) {
            f7780d = new c(n, 1, str);
            ContentResolver contentResolver = context.getContentResolver();
            contentResolver.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f7780d);
        } else if (i2 != 2) {
        } else {
            f7781e = new c(n, 2, str);
            ContentResolver contentResolver2 = context.getContentResolver();
            contentResolver2.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, f7781e);
        }
    }
}
