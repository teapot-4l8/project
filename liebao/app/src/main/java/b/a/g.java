package b.a;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    private static CountDownLatch f3187b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private static String f3188c;

    /* renamed from: d  reason: collision with root package name */
    private static Object f3189d;

    /* renamed from: a  reason: collision with root package name */
    private b.a.k.e f3190a = b.a.k.e.a("PlayInstallReferrer");

    /* loaded from: classes.dex */
    static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private b.a.k.e f3194a = b.a.k.e.a("StateListenerHandler");

        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"onInstallReferrerSetupFinished".equalsIgnoreCase(method.getName())) {
                if ("onInstallReferrerServiceDisconnected".equalsIgnoreCase(method.getName())) {
                    if (b.a.k.d.f3261a) {
                        b.a.k.d.a("StateListenerHandler : InstallReferrerService Disconnected", new Object[0]);
                        return null;
                    }
                    return null;
                } else if (b.a.k.d.f3261a) {
                    b.a.k.d.a("StateListenerHandler : no such method : " + method.getName(), new Object[0]);
                    return null;
                } else {
                    return null;
                }
            }
            try {
                int intValue = ((Integer) objArr[0]).intValue();
                if (b.a.k.d.f3261a) {
                    b.a.k.d.a("StateListenerHandler : onInstallReferrerSetupFinished code=" + intValue, new Object[0]);
                }
                if (intValue == 0) {
                    Class<?> cls = Class.forName("com.android.installreferrer.api.InstallReferrerClient");
                    String unused = g.f3188c = (String) Class.forName("com.android.installreferrer.api.ReferrerDetails").getDeclaredMethod("getInstallReferrer", new Class[0]).invoke(cls.getDeclaredMethod("getInstallReferrer", new Class[0]).invoke(g.f3189d, new Object[0]), new Object[0]);
                    cls.getDeclaredMethod("endConnection", new Class[0]).invoke(g.f3189d, new Object[0]);
                }
            } catch (Exception e2) {
                if (b.a.k.d.f3261a) {
                    e2.printStackTrace();
                }
            }
            g.f3187b.countDown();
            return null;
        }
    }

    public String a() {
        try {
            f3187b.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            if (b.a.k.d.f3261a) {
                e2.printStackTrace();
            }
        }
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("PlayInstallReferrer getReferrer : %s", f3188c);
        }
        return f3188c;
    }

    public void a(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            f3189d = Class.forName("com.android.installreferrer.api.InstallReferrerClient$Builder").getDeclaredMethod("build", new Class[0]).invoke(cls.getDeclaredMethod("newBuilder", Context.class).invoke(null, context), new Object[0]);
            Class<?> cls2 = Class.forName("com.android.installreferrer.api.InstallReferrerStateListener");
            cls.getDeclaredMethod("startConnection", cls2).invoke(f3189d, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{cls2}, new a()));
        } catch (Exception e2) {
            f3187b.countDown();
            if (b.a.k.d.f3261a) {
                e2.printStackTrace();
            }
        }
    }
}
