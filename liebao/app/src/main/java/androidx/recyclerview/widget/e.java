package androidx.recyclerview.widget;

/* compiled from: BatchingListUpdateCallback.java */
/* loaded from: classes.dex */
public class e implements q {

    /* renamed from: a  reason: collision with root package name */
    final q f2236a;

    /* renamed from: b  reason: collision with root package name */
    int f2237b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f2238c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f2239d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f2240e = null;

    public e(q qVar) {
        this.f2236a = qVar;
    }

    public void a() {
        int i = this.f2237b;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.f2236a.a(this.f2238c, this.f2239d);
        } else if (i == 2) {
            this.f2236a.b(this.f2238c, this.f2239d);
        } else if (i == 3) {
            this.f2236a.a(this.f2238c, this.f2239d, this.f2240e);
        }
        this.f2240e = null;
        this.f2237b = 0;
    }

    @Override // androidx.recyclerview.widget.q
    public void a(int i, int i2) {
        int i3;
        if (this.f2237b == 1 && i >= (i3 = this.f2238c)) {
            int i4 = this.f2239d;
            if (i <= i3 + i4) {
                this.f2239d = i4 + i2;
                this.f2238c = Math.min(i, i3);
                return;
            }
        }
        a();
        this.f2238c = i;
        this.f2239d = i2;
        this.f2237b = 1;
    }

    @Override // androidx.recyclerview.widget.q
    public void b(int i, int i2) {
        int i3;
        if (this.f2237b == 2 && (i3 = this.f2238c) >= i && i3 <= i + i2) {
            this.f2239d += i2;
            this.f2238c = i;
            return;
        }
        a();
        this.f2238c = i;
        this.f2239d = i2;
        this.f2237b = 2;
    }

    @Override // androidx.recyclerview.widget.q
    public void c(int i, int i2) {
        a();
        this.f2236a.c(i, i2);
    }

    @Override // androidx.recyclerview.widget.q
    public void a(int i, int i2, Object obj) {
        int i3;
        if (this.f2237b == 3) {
            int i4 = this.f2238c;
            int i5 = this.f2239d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.f2240e == obj) {
                this.f2238c = Math.min(i, i4);
                this.f2239d = Math.max(i5 + i4, i3) - this.f2238c;
                return;
            }
        }
        a();
        this.f2238c = i;
        this.f2239d = i2;
        this.f2240e = obj;
        this.f2237b = 3;
    }
}
