package cn.jpush.android.n;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f4391a;

    /* renamed from: b  reason: collision with root package name */
    private static ExecutorService f4392b = Executors.newSingleThreadExecutor();
    private static final Object f = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Handler f4393c;

    /* renamed from: d  reason: collision with root package name */
    private Context f4394d;

    /* renamed from: e  reason: collision with root package name */
    private String f4395e;

    private a(Context context) {
        this.f4393c = null;
        this.f4394d = null;
        this.f4395e = "";
        Logger.d("JPushLocalNotificationCenter", "Constructor : JPushLocalNotificationCenter");
        this.f4393c = new Handler(Looper.getMainLooper());
        this.f4394d = context;
        this.f4395e = context.getPackageName();
    }

    public static a a(Context context) {
        Logger.v("JPushLocalNotificationCenter", "getInstance");
        if (f4391a == null) {
            synchronized (f) {
                if (f4391a == null) {
                    f4391a = new a(context);
                }
            }
        }
        return f4391a;
    }

    private synchronized void a(final long j, long j2, int i) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification scheduleReadiedLN");
        if (this.f4393c != null) {
            Runnable runnable = new Runnable() { // from class: cn.jpush.android.n.a.2
                @Override // java.lang.Runnable
                public void run() {
                    long a2;
                    int i2;
                    int i3;
                    int i4;
                    String d2;
                    long f2;
                    long e2;
                    try {
                        b a3 = b.a(a.this.f4394d);
                        c a4 = a3.a(j, 0);
                        if (a4 != null) {
                            if (a4.c() == 1) {
                                Logger.d("JPushLocalNotificationCenter", "remove ");
                                a2 = a4.a();
                                i2 = 0;
                                i3 = 1;
                                i4 = 0;
                                d2 = a4.d();
                                f2 = a4.f();
                                e2 = a4.e();
                            } else if (a4.b() > 1) {
                                Logger.d("JPushLocalNotificationCenter", "repeat add");
                                a3.b(a4.a(), a4.b() - 1, 0, 0, a4.d(), a4.f(), a4.e());
                                return;
                            } else if (a4.b() != 1) {
                                Logger.d("JPushLocalNotificationCenter", "already triggered");
                                return;
                            } else {
                                Logger.d("JPushLocalNotificationCenter", "send broadcast");
                                if (a4.f() > System.currentTimeMillis()) {
                                    Logger.d("JPushLocalNotificationCenter", "repeat add");
                                    return;
                                }
                                a.this.a(a.this.f4394d, a4.d());
                                a2 = a4.a();
                                i2 = 0;
                                i3 = 0;
                                i4 = 0;
                                d2 = a4.d();
                                f2 = a4.f();
                                e2 = a4.e();
                            }
                            a3.b(a2, i2, i3, i4, d2, f2, e2);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Logger.e("JPushLocalNotificationCenter", "exception:" + e3.getMessage());
                    }
                }
            };
            if (j2 <= 0) {
                Logger.d("JPushLocalNotificationCenter", "post right now ");
                this.f4393c.post(runnable);
            } else {
                Logger.d("JPushLocalNotificationCenter", "post delayed : " + j2);
                this.f4393c.postDelayed(runnable, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        Logger.d("JPushLocalNotificationCenter", "start LocalNotification broadCastToPushService");
        Bundle bundle = new Bundle();
        bundle.putString("local_notify_msg", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "show_local_notify", bundle);
        Logger.d("JPushLocalNotificationCenter", "end LocalNotification broadCastToPushService");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: all -> 0x0091, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:15:0x004f, B:16:0x0052, B:29:0x0081, B:30:0x0084, B:31:0x0087, B:27:0x007b, B:32:0x0088), top: B:40:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void e(Context context) {
        Cursor a2;
        Logger.d("JPushLocalNotificationCenter", "triggerLNKillProcess");
        b a3 = b.a(context);
        if (a3.a(false)) {
            Cursor cursor = null;
            try {
                try {
                    a2 = a3.a(1, System.currentTimeMillis());
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        cursor = a2;
                        Logger.ww("JPushLocalNotificationCenter", "triggerLNKillProcess: " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a3.b(false);
                    } catch (Throwable th) {
                        th = th;
                        cursor = a2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a3.b(false);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (a2.moveToFirst()) {
                do {
                    c a4 = b.a(a2);
                    if (a4 != null) {
                        a(context, a4.d());
                        a3.b(a4.a(), 0, 0, 0, a4.d(), a4.f(), a4.e());
                    }
                } while (a2.moveToNext());
                if (a2 != null) {
                    a2.close();
                }
                a3.b(false);
            } else {
                if (a2 != null) {
                }
                a3.b(false);
            }
        } else {
            Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt: db open failed");
        }
    }

    public synchronized boolean a(Context context, long j) {
        c a2;
        Logger.dd("JPushLocalNotificationCenter", "remove LocalNotification ");
        long j2 = (int) j;
        try {
            b a3 = b.a(context);
            if (a3.a(j2, 0) != null) {
                Logger.d("JPushLocalNotificationCenter", "remove local count : " + a2.b());
                a3.a(j2);
                JPushInterface.clearNotificationById(this.f4394d, (int) j2);
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("JPushLocalNotificationCenter", "exception:" + e2.getMessage());
            return false;
        }
    }

    public synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification) {
        Logger.dd("JPushLocalNotificationCenter", "add LocalNotification");
        long currentTimeMillis = System.currentTimeMillis();
        long broadcastTime = jPushLocalNotification.getBroadcastTime() - currentTimeMillis;
        if (cn.jpush.android.cache.a.c(context)) {
            Logger.d("JPushLocalNotificationCenter", "push has stopped");
        }
        long notificationId = jPushLocalNotification.getNotificationId();
        try {
            b a2 = b.a(context);
            if (a2.a(notificationId, 0) != null) {
                a2.b(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            } else {
                a2.a(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("JPushLocalNotificationCenter", "exception:" + e2.getMessage());
        }
        if (broadcastTime < 300000) {
            a(jPushLocalNotification.getNotificationId(), broadcastTime, 0);
            return true;
        }
        return true;
    }

    public synchronized void b(Context context) {
        Logger.dd("JPushLocalNotificationCenter", "clear all local notification ");
        int[] a2 = b.a(context).a();
        if (a2 != null && a2.length > 0) {
            Logger.d("JPushLocalNotificationCenter", " success");
            for (int i : a2) {
                JPushInterface.clearNotificationById(this.f4394d, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[Catch: all -> 0x007a, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:14:0x0042, B:15:0x0045, B:22:0x0064, B:27:0x0071, B:6:0x0014, B:8:0x0025, B:10:0x002b, B:11:0x003a, B:20:0x004c), top: B:37:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void c(Context context) {
        long currentTimeMillis;
        Logger.d("JPushLocalNotificationCenter", "init LocalNotification");
        b a2 = b.a(context);
        if (a2.a(false)) {
            Cursor cursor = null;
            try {
                currentTimeMillis = System.currentTimeMillis();
                cursor = a2.a(currentTimeMillis, 300000L);
            } catch (Exception e2) {
                Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt:" + e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (cursor.moveToFirst()) {
                do {
                    c a3 = b.a(cursor);
                    if (a3 != null) {
                        a(a3.a(), a3.f() - currentTimeMillis, 0);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                a2.b(false);
            } else {
                if (cursor != null) {
                }
                a2.b(false);
            }
        } else {
            Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt: db open failed");
        }
    }

    public void d(final Context context) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification onHeartBeat");
        f4392b.execute(new Runnable() { // from class: cn.jpush.android.n.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.e(context);
                a.this.c(context);
            }
        });
    }
}
