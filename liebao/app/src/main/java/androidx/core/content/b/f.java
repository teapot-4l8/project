package androidx.core.content.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.b.c;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public final class f {
    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    public static Typeface a(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, new TypedValue(), 0, null, null, false);
    }

    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.content.b.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFontRetrieved(typeface);
                }
            });
        }

        public final void callbackFailAsync(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.content.b.f.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFontRetrievalFailed(i);
                }
            });
        }
    }

    public static void a(Context context, int i, a aVar, Handler handler) {
        androidx.core.g.f.a(aVar);
        if (context.isRestricted()) {
            aVar.callbackFailAsync(-4, handler);
        } else {
            a(context, i, new TypedValue(), 0, aVar, handler, false);
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a2 == null && aVar == null) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i, int i2, a aVar, Handler handler, boolean z) {
        if (typedValue.string == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (!charSequence.startsWith("res/")) {
            if (aVar != null) {
                aVar.callbackFailAsync(-3, handler);
            }
            return null;
        }
        Typeface a2 = androidx.core.graphics.d.a(resources, i, i2);
        if (a2 != null) {
            if (aVar != null) {
                aVar.callbackSuccessAsync(a2, handler);
            }
            return a2;
        }
        try {
            if (charSequence.toLowerCase().endsWith(".xml")) {
                c.a a3 = c.a(resources.getXml(i), resources);
                if (a3 == null) {
                    Log.e("ResourcesCompat", "Failed to find font-family tag");
                    if (aVar != null) {
                        aVar.callbackFailAsync(-3, handler);
                    }
                    return null;
                }
                return androidx.core.graphics.d.a(context, a3, resources, i, i2, aVar, handler, z);
            }
            Typeface a4 = androidx.core.graphics.d.a(context, resources, i, charSequence, i2);
            if (aVar != null) {
                if (a4 != null) {
                    aVar.callbackSuccessAsync(a4, handler);
                } else {
                    aVar.callbackFailAsync(-3, handler);
                }
            }
            return a4;
        } catch (IOException e2) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence, e2);
            if (aVar != null) {
                aVar.callbackFailAsync(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence, e3);
            if (aVar != null) {
            }
            return null;
        }
    }

    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static final class b {
        public static void a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                C0032b.a(theme);
            } else if (Build.VERSION.SDK_INT >= 23) {
                a.a(theme);
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: androidx.core.content.b.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0032b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f1497a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f1498b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f1499c;

            static void a(Resources.Theme theme) {
                synchronized (f1497a) {
                    if (!f1499c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f1498b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f1499c = true;
                    }
                    if (f1498b != null) {
                        try {
                            f1498b.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                            f1498b = null;
                        }
                    }
                }
            }
        }
    }
}
