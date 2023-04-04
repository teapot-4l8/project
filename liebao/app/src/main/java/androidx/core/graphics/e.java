package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
class e extends j {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f1638a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Constructor<?> f1639b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Method f1640c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f1641d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f1642e = false;

    private static void a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f1642e) {
            return;
        }
        f1642e = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f1639b = constructor;
        f1638a = cls;
        f1640c = method2;
        f1641d = method;
    }

    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static Object b() {
        a();
        try {
            return f1639b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface a(Object obj) {
        a();
        try {
            Object newInstance = Array.newInstance(f1638a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1641d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, String str, int i, boolean z) {
        a();
        try {
            return ((Boolean) f1640c.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0034b[] c0034bArr, int i) {
        if (c0034bArr.length < 1) {
            return null;
        }
        b.C0034b a2 = a(c0034bArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.a(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File a3 = a(openFileDescriptor);
            if (a3 != null && a3.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(a3);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                Typeface a4 = super.a(context, fileInputStream);
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return a4;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0031c[] a2;
        Object b2 = b();
        for (c.C0031c c0031c : bVar.a()) {
            File a3 = k.a(context);
            if (a3 == null) {
                return null;
            }
            try {
                if (!k.a(a3, resources, c0031c.f())) {
                    return null;
                }
                if (!a(b2, a3.getPath(), c0031c.b(), c0031c.c())) {
                    return null;
                }
                a3.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a3.delete();
            }
        }
        return a(b2);
    }
}
