package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: b  reason: collision with root package name */
    int f2355b;

    /* renamed from: c  reason: collision with root package name */
    int f2356c;

    /* renamed from: d  reason: collision with root package name */
    int f2357d;

    /* renamed from: e  reason: collision with root package name */
    int f2358e;
    boolean h;
    boolean i;

    /* renamed from: a  reason: collision with root package name */
    boolean f2354a = true;
    int f = 0;
    int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.u uVar) {
        int i = this.f2356c;
        return i >= 0 && i < uVar.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar) {
        View c2 = pVar.c(this.f2356c);
        this.f2356c += this.f2357d;
        return c2;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2355b + ", mCurrentPosition=" + this.f2356c + ", mItemDirection=" + this.f2357d + ", mLayoutDirection=" + this.f2358e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
