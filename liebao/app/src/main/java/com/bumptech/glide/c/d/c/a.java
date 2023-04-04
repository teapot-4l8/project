package com.bumptech.glide.c.d.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.b.f;

/* compiled from: DrawableDecoderCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f5051a = true;

    public static Drawable a(Context context, Context context2, int i) {
        return a(context, context2, i, null);
    }

    public static Drawable a(Context context, int i, Resources.Theme theme) {
        return a(context, context, i, theme);
    }

    private static Drawable a(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (f5051a) {
                return b(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            return androidx.core.content.b.a(context2, i);
        } catch (NoClassDefFoundError unused2) {
            f5051a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return c(context2, i, theme);
    }

    private static Drawable b(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            context = new androidx.appcompat.view.d(context, theme);
        }
        return androidx.appcompat.a.a.a.b(context, i);
    }

    private static Drawable c(Context context, int i, Resources.Theme theme) {
        return f.a(context.getResources(), i, theme);
    }
}
