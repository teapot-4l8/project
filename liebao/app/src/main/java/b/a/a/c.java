package b.a.a;

import android.content.Context;
import android.os.Looper;
import b.a.k.d;
import b.a.k.e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static String f3094b;

    /* renamed from: c  reason: collision with root package name */
    private static final CountDownLatch f3095c = new CountDownLatch(1);

    /* renamed from: a  reason: collision with root package name */
    private final e f3096a = e.a("OAIDHelper");

    /* loaded from: classes.dex */
    static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private e f3097a = e.a("IdentifyListenerHandler");

        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Class<?> cls;
            try {
                if ("OnSupport".equals(method.getName())) {
                    try {
                        cls = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                    } catch (ClassNotFoundException unused) {
                        cls = Class.forName("com.bun.supplier.IdSupplier");
                    }
                    String unused2 = c.f3094b = (String) cls.getDeclaredMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                }
            } catch (Exception e2) {
                if (d.f3261a) {
                    e2.printStackTrace();
                }
            }
            c.f3095c.countDown();
            return null;
        }
    }

    public String a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            f3095c.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            if (d.f3261a) {
                e2.printStackTrace();
            }
        }
        return f3094b;
    }

    public void a(Context context) {
        Class<?> cls;
        try {
            try {
                Class.forName("com.bun.miitmdid.core.JLibrary").getDeclaredMethod("InitEntry", Context.class).invoke(null, context);
            } catch (ClassNotFoundException e2) {
                if (d.f3261a) {
                    e2.printStackTrace();
                }
            }
            try {
                cls = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("com.bun.supplier.IIdentifierListener");
            }
            Integer num = (Integer) Class.forName("com.bun.miitmdid.core.MdidSdkHelper").getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, cls).invoke(null, context, true, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{cls}, new a()));
        } catch (Exception e3) {
            f3095c.countDown();
            if (d.f3261a) {
                e3.printStackTrace();
            }
        }
    }
}
