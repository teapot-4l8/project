package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class UMConfigureImpl {

    /* renamed from: a  reason: collision with root package name */
    private static String f6693a = "delayed_transmission_flag_new";

    /* renamed from: e  reason: collision with root package name */
    private static final int f6697e = 1000;
    private static ScheduledExecutorService f;
    private static Context g;

    /* renamed from: b  reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f6694b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f6695c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f6696d = false;
    private static int h = 0;
    private static Runnable i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f6695c == 0 || UMConfigureImpl.h >= 10) {
                    if (!UMConfigureImpl.f6696d) {
                        boolean unused = UMConfigureImpl.f6696d = true;
                        UMConfigureImpl.b(UMConfigureImpl.g);
                    }
                    if (UMConfigureImpl.f != null) {
                        UMConfigureImpl.f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i2 = h;
        h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        g = context;
        try {
            if (f6695c >= 1) {
                if (!d(context)) {
                    UMEnvelopeBuild.setTransmissionSendFlag(false);
                    c(context);
                    if (f == null) {
                        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                        f = newScheduledThreadPool;
                        newScheduledThreadPool.scheduleAtFixedRate(i, 0L, 100L, TimeUnit.MILLISECONDS);
                    }
                } else {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                }
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                if (f6694b != null && f6694b.size() > 0) {
                    Iterator<onMessageSendListener> it = f6694b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (f6694b != null) {
                    f6694b.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && f6694b != null && f6694b.size() > 0) {
                    Iterator<onMessageSendListener> it = f6694b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (f6694b != null) {
                    f6694b.remove(onmessagesendlistener);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f6695c++;
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f6695c--;
            } catch (Exception unused) {
            }
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f6693a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(f6693a, true);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f6693a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(f6693a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
