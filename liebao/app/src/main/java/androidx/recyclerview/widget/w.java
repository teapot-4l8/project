package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class w extends RecyclerView.f {
    boolean h = true;

    public abstract boolean a(RecyclerView.x xVar);

    public abstract boolean a(RecyclerView.x xVar, int i, int i2, int i3, int i4);

    public abstract boolean a(RecyclerView.x xVar, RecyclerView.x xVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(RecyclerView.x xVar);

    public void c(RecyclerView.x xVar, boolean z) {
    }

    public void d(RecyclerView.x xVar, boolean z) {
    }

    public void o(RecyclerView.x xVar) {
    }

    public void p(RecyclerView.x xVar) {
    }

    public void q(RecyclerView.x xVar) {
    }

    public void r(RecyclerView.x xVar) {
    }

    public void s(RecyclerView.x xVar) {
    }

    public void t(RecyclerView.x xVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean h(RecyclerView.x xVar) {
        return !this.h || xVar.isInvalid();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i = cVar.f2131a;
        int i2 = cVar.f2132b;
        View view = xVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f2131a;
        int top = cVar2 == null ? view.getTop() : cVar2.f2132b;
        if (!xVar.isRemoved() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a(xVar, i, i2, left, top);
        }
        return a(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar != null && (cVar.f2131a != cVar2.f2131a || cVar.f2132b != cVar2.f2132b)) {
            return a(xVar, cVar.f2131a, cVar.f2132b, cVar2.f2131a, cVar2.f2132b);
        }
        return b(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean c(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.f2131a != cVar2.f2131a || cVar.f2132b != cVar2.f2132b) {
            return a(xVar, cVar.f2131a, cVar.f2132b, cVar2.f2131a, cVar2.f2132b);
        }
        j(xVar);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.x xVar, RecyclerView.x xVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f2131a;
        int i4 = cVar.f2132b;
        if (xVar2.shouldIgnore()) {
            int i5 = cVar.f2131a;
            i2 = cVar.f2132b;
            i = i5;
        } else {
            i = cVar2.f2131a;
            i2 = cVar2.f2132b;
        }
        return a(xVar, xVar2, i3, i4, i, i2);
    }

    public final void i(RecyclerView.x xVar) {
        p(xVar);
        f(xVar);
    }

    public final void j(RecyclerView.x xVar) {
        t(xVar);
        f(xVar);
    }

    public final void k(RecyclerView.x xVar) {
        r(xVar);
        f(xVar);
    }

    public final void a(RecyclerView.x xVar, boolean z) {
        d(xVar, z);
        f(xVar);
    }

    public final void l(RecyclerView.x xVar) {
        o(xVar);
    }

    public final void m(RecyclerView.x xVar) {
        s(xVar);
    }

    public final void n(RecyclerView.x xVar) {
        q(xVar);
    }

    public final void b(RecyclerView.x xVar, boolean z) {
        c(xVar, z);
    }
}
