package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: AdapterListUpdateCallback.java */
/* loaded from: classes.dex */
public final class b implements q {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.a f2213a;

    public b(RecyclerView.a aVar) {
        this.f2213a = aVar;
    }

    @Override // androidx.recyclerview.widget.q
    public void a(int i, int i2) {
        this.f2213a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.q
    public void b(int i, int i2) {
        this.f2213a.notifyItemRangeRemoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.q
    public void c(int i, int i2) {
        this.f2213a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.q
    public void a(int i, int i2, Object obj) {
        this.f2213a.notifyItemRangeChanged(i, i2, obj);
    }
}
