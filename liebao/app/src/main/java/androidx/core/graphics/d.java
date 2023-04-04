package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.b.c;
import androidx.core.content.b.f;
import androidx.core.e.b;

/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final j f1612a;

    /* renamed from: b  reason: collision with root package name */
    private static final androidx.b.e<String, Typeface> f1613b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f1612a = new i();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f1612a = new h();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f1612a = new g();
        } else if (Build.VERSION.SDK_INT >= 24 && f.a()) {
            f1612a = new f();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1612a = new e();
        } else {
            f1612a = new j();
        }
        f1613b = new androidx.b.e<>(16);
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return f1613b.a((androidx.b.e<String, Typeface>) b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.b() == 0) {
                z2 = true;
            }
            a2 = androidx.core.e.b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = f1612a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.callbackSuccessAsync(a2, handler);
                } else {
                    aVar2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (a2 != null) {
            f1613b.a(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = f1612a.a(context, resources, i, str, i2);
        if (a2 != null) {
            f1613b.a(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0034b[] c0034bArr, int i) {
        return f1612a.a(context, cancellationSignal, c0034bArr, i);
    }

    private static Typeface b(Context context, Typeface typeface, int i) {
        c.b a2 = f1612a.a(typeface);
        if (a2 == null) {
            return null;
        }
        return f1612a.a(context, a2, context.getResources(), i);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface b2;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (b2 = b(context, typeface, i)) == null) ? Typeface.create(typeface, i) : b2;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
