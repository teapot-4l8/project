package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class f extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f1643a;

    /* renamed from: b  reason: collision with root package name */
    private static final Constructor<?> f1644b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f1645c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f1646d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f1644b = constructor;
        f1643a = cls;
        f1645c = method2;
        f1646d = method;
    }

    public static boolean a() {
        if (f1645c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f1645c != null;
    }

    private static Object b() {
        try {
            return f1644b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f1645c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f1643a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1646d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0034b[] c0034bArr, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        androidx.b.g gVar = new androidx.b.g();
        for (b.C0034b c0034b : c0034bArr) {
            Uri a2 = c0034b.a();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(a2);
            if (byteBuffer == null) {
                byteBuffer = k.a(context, cancellationSignal, a2);
                gVar.put(a2, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, c0034b.b(), c0034b.c(), c0034b.d())) {
                return null;
            }
        }
        Typeface a3 = a(b2);
        if (a3 == null) {
            return null;
        }
        return Typeface.create(a3, i);
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0031c[] a2;
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0031c c0031c : bVar.a()) {
            ByteBuffer a3 = k.a(context, resources, c0031c.f());
            if (a3 == null || !a(b2, a3, c0031c.e(), c0031c.b(), c0031c.c())) {
                return null;
            }
        }
        return a(b2);
    }
}
