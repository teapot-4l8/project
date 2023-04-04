package com.speed.speed_library.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import kotlin.d.b.i;

/* compiled from: StatusBarUtil.kt */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f5876a = new h();

    private h() {
    }

    public final void a(Activity activity, int i, boolean z) {
        i.b(activity, "activity");
        if (Build.VERSION.SDK_INT >= 23) {
            a(activity, i);
            if (z) {
                a(activity);
            } else {
                b(activity);
            }
        }
    }

    public final void a(Activity activity, int i) {
        i.b(activity, "activity");
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            Window window = activity.getWindow();
            i.a((Object) window, "activity.window");
            window.setStatusBarColor(i);
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            Window window2 = activity.getWindow();
            i.a((Object) window2, "activity.window");
            View decorView = window2.getDecorView();
            if (decorView == null) {
                throw new kotlin.i("null cannot be cast to non-null type android.view.ViewGroup");
            }
            a((ViewGroup) decorView, i);
            a(activity, true);
        }
    }

    private final void a(Activity activity, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        i.a((Object) viewGroup, "parent");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(z);
                ((ViewGroup) childAt).setClipToPadding(z);
            }
        }
    }

    private final void a(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            View findViewById = viewGroup.findViewById(16908331);
            if (findViewById == null && i != 0) {
                findViewById = new View(viewGroup.getContext());
                findViewById.setId(16908331);
                Context context = viewGroup.getContext();
                i.a((Object) context, "viewGroup.context");
                viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, a(context)));
            }
            if (findViewById != null) {
                findViewById.setBackgroundColor(i);
            }
        }
    }

    private final int a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public final void a(Activity activity) {
        i.b(activity, "activity");
        Window window = activity.getWindow();
        i.a((Object) window, "activity.window");
        a(window, true);
    }

    public final void b(Activity activity) {
        i.b(activity, "activity");
        Window window = activity.getWindow();
        i.a((Object) window, "activity.window");
        a(window, false);
    }

    private final void a(Window window, boolean z) {
        if (a()) {
            d(window, z);
        } else if (b()) {
            c(window, z);
        }
        b(window, z);
    }

    private final void b(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            i.a((Object) decorView, "window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            int i = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
            View decorView2 = window.getDecorView();
            i.a((Object) decorView2, "window.decorView");
            decorView2.setSystemUiVisibility(i);
        }
    }

    private final void c(Window window, boolean z) {
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            i.a((Object) cls2, "Class.forName(\"android.v…owManager\\$LayoutParams\")");
            Field field = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            i.a((Object) field, "layoutParams.getField(\"E…AG_STATUS_BAR_DARK_MODE\")");
            int i = field.getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            i.a((Object) method, "clazz.getMethod(\"setExtr…:class.javaPrimitiveType)");
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Exception unused) {
            Log.e("StatusBar", "darkIcon: failed");
        }
    }

    private final void d(Window window, boolean z) {
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            i.a((Object) declaredField, "WindowManager.LayoutPara…AG_DARK_STATUS_BAR_ICON\")");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            i.a((Object) declaredField2, "WindowManager.LayoutPara…claredField(\"meizuFlags\")");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (i ^ (-1)) & i2);
            window.setAttributes(attributes);
        } catch (Exception unused) {
            Log.e("StatusBar", "darkIcon: failed");
        }
    }

    private final boolean a() {
        String str = Build.FINGERPRINT;
        i.a((Object) str, "Build.FINGERPRINT");
        if (!kotlin.h.g.a((CharSequence) str, (CharSequence) "Flyme_OS_4", false, 2, (Object) null)) {
            String str2 = Build.VERSION.INCREMENTAL;
            i.a((Object) str2, "Build.VERSION.INCREMENTAL");
            if (!kotlin.h.g.a((CharSequence) str2, (CharSequence) "Flyme_OS_4", false, 2, (Object) null) && !Pattern.compile("Flyme OS [4|5]", 2).matcher(Build.DISPLAY).find()) {
                return false;
            }
        }
        return true;
    }

    private final boolean b() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            i.a((Object) cls, "Class.forName(\"android.os.SystemProperties\")");
            Method method = cls.getMethod("get", String.class);
            i.a((Object) method, "clz.getMethod(\"get\", String::class.java)");
            Object invoke = method.invoke(null, "ro.miui.ui.version.name");
            if (invoke != null) {
                return Integer.parseInt(new kotlin.h.f("[vV]").a((String) invoke, "")) >= 6;
            }
            throw new kotlin.i("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return false;
        }
    }
}
