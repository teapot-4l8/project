package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1463a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Set<String> f1464b = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f1465e = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Context f1466c;

    /* renamed from: d  reason: collision with root package name */
    private final NotificationManager f1467d;

    public static l a(Context context) {
        return new l(context);
    }

    private l(Context context) {
        this.f1466c = context;
        this.f1467d = (NotificationManager) context.getSystemService("notification");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f1467d.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f1466c.getSystemService("appops");
            ApplicationInfo applicationInfo = this.f1466c.getApplicationInfo();
            String packageName = this.f1466c.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                return true;
            }
        }
        return true;
    }
}
