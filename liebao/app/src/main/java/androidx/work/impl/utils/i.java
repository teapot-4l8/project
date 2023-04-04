package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import java.util.HashMap;
import java.util.WeakHashMap;

/* compiled from: WakeLocks.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3057a = androidx.work.h.a("WakeLocks");

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<PowerManager.WakeLock, String> f3058b = new WeakHashMap<>();

    public static PowerManager.WakeLock a(Context context, String str) {
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str2);
        synchronized (f3058b) {
            f3058b.put(newWakeLock, str2);
        }
        return newWakeLock;
    }

    public static void a() {
        HashMap hashMap = new HashMap();
        synchronized (f3058b) {
            hashMap.putAll(f3058b);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                androidx.work.h.a().d(f3057a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
    }
}
