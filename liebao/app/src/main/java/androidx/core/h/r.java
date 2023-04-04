package androidx.core.h;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private int f1729a;

    /* renamed from: b  reason: collision with root package name */
    private int f1730b;

    public r(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f1730b = i;
        } else {
            this.f1729a = i;
        }
    }

    public int a() {
        return this.f1729a | this.f1730b;
    }

    public void a(View view, int i) {
        if (i == 1) {
            this.f1730b = 0;
        } else {
            this.f1729a = 0;
        }
    }
}
