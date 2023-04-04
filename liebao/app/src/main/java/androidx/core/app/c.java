package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
final class c {
    private static final Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f1411a = d();

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f1412b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f1413c = c();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f1414d = a(f1411a);

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f1415e = b(f1411a);
    protected static final Method f = c(f1411a);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f == null) {
            return false;
        } else {
            if (f1415e == null && f1414d == null) {
                return false;
            }
            try {
                final Object obj2 = f1413c.get(activity);
                if (obj2 == null || (obj = f1412b.get(activity)) == null) {
                    return false;
                }
                final Application application = activity.getApplication();
                final a aVar = new a(activity);
                application.registerActivityLifecycleCallbacks(aVar);
                g.post(new Runnable() { // from class: androidx.core.app.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f1422a = obj2;
                    }
                });
                if (a()) {
                    f.invoke(obj, obj2, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                g.post(new Runnable() { // from class: androidx.core.app.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f1422a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f1423b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1424c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1425d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1426e = false;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        a(Activity activity) {
            this.f1423b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f1423b == activity) {
                this.f1424c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f1425d || this.f1426e || this.f1424c || !c.a(this.f1422a, activity)) {
                return;
            }
            this.f1426e = true;
            this.f1422a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f1423b == activity) {
                this.f1423b = null;
                this.f1425d = true;
            }
        }
    }

    protected static boolean a(Object obj, Activity activity) {
        try {
            final Object obj2 = f1413c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = f1412b.get(activity);
            g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.c.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.f1414d != null) {
                            c.f1414d.invoke(obj3, obj2, false, "AppCompat recreation");
                        } else {
                            c.f1415e.invoke(obj3, obj2, false);
                        }
                    } catch (RuntimeException e2) {
                        if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                    } catch (Throwable th) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    private static Method c(Class<?> cls) {
        if (a() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
