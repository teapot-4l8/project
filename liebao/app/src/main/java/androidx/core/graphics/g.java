package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    protected final Class<?> f1647a;

    /* renamed from: b  reason: collision with root package name */
    protected final Constructor<?> f1648b;

    /* renamed from: c  reason: collision with root package name */
    protected final Method f1649c;

    /* renamed from: d  reason: collision with root package name */
    protected final Method f1650d;

    /* renamed from: e  reason: collision with root package name */
    protected final Method f1651e;
    protected final Method f;
    protected final Method g;

    public g() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> a2 = a();
            constructor = a(a2);
            method2 = b(a2);
            method3 = c(a2);
            method4 = d(a2);
            method5 = e(a2);
            method = f(a2);
            cls = a2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f1647a = cls;
        this.f1648b = constructor;
        this.f1649c = method2;
        this.f1650d = method3;
        this.f1651e = method4;
        this.f = method5;
        this.g = method;
    }

    private boolean b() {
        if (this.f1649c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f1649c != null;
    }

    private Object c() {
        try {
            return this.f1648b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1649c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.f1650d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    protected Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1647a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.f1651e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void c(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // androidx.core.graphics.e, androidx.core.graphics.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0031c[] a2;
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        for (c.C0031c c0031c : bVar.a()) {
            if (!a(context, c2, c0031c.a(), c0031c.e(), c0031c.b(), c0031c.c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0031c.d()))) {
                c(c2);
                return null;
            }
        }
        if (b(c2)) {
            return a(c2);
        }
        return null;
    }

    @Override // androidx.core.graphics.e, androidx.core.graphics.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0034b[] c0034bArr, int i) {
        Typeface a2;
        if (c0034bArr.length < 1) {
            return null;
        }
        if (!b()) {
            b.C0034b a3 = a(c0034bArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a3.a(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a3.c()).setItalic(a3.d()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a4 = androidx.core.e.b.a(context, c0034bArr, cancellationSignal);
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        boolean z = false;
        for (b.C0034b c0034b : c0034bArr) {
            ByteBuffer byteBuffer = a4.get(c0034b.a());
            if (byteBuffer != null) {
                if (!a(c2, byteBuffer, c0034b.b(), c0034b.c(), c0034b.d() ? 1 : 0)) {
                    c(c2);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            c(c2);
            return null;
        } else if (b(c2) && (a2 = a(c2)) != null) {
            return Typeface.create(a2, i);
        } else {
            return null;
        }
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        if (!a(context, c2, str, 0, -1, -1, null)) {
            c(c2);
            return null;
        } else if (b(c2)) {
            return a(c2);
        } else {
            return null;
        }
    }

    protected Class<?> a() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> a(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    protected Method b(Class<?> cls) {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method c(Class<?> cls) {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method d(Class<?> cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    protected Method e(Class<?> cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method f(Class<?> cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
