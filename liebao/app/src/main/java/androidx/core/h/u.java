package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private Object f1734a;

    private u(Object obj) {
        this.f1734a = obj;
    }

    public Object a() {
        return this.f1734a;
    }

    public static u a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new u(PointerIcon.getSystemIcon(context, i));
        }
        return new u(null);
    }
}
