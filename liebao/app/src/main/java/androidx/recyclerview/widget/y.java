package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck.java */
/* loaded from: classes.dex */
class y {

    /* renamed from: a  reason: collision with root package name */
    final b f2371a;

    /* renamed from: b  reason: collision with root package name */
    a f2372b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(b bVar) {
        this.f2371a = bVar;
    }

    /* compiled from: ViewBoundsCheck.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2373a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f2374b;

        /* renamed from: c  reason: collision with root package name */
        int f2375c;

        /* renamed from: d  reason: collision with root package name */
        int f2376d;

        /* renamed from: e  reason: collision with root package name */
        int f2377e;

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        void a(int i, int i2, int i3, int i4) {
            this.f2374b = i;
            this.f2375c = i2;
            this.f2376d = i3;
            this.f2377e = i4;
        }

        void a(int i) {
            this.f2373a = i | this.f2373a;
        }

        void a() {
            this.f2373a = 0;
        }

        boolean b() {
            int i = this.f2373a;
            if ((i & 7) == 0 || (i & (a(this.f2376d, this.f2374b) << 0)) != 0) {
                int i2 = this.f2373a;
                if ((i2 & 112) == 0 || (i2 & (a(this.f2376d, this.f2375c) << 4)) != 0) {
                    int i3 = this.f2373a;
                    if ((i3 & 1792) == 0 || (i3 & (a(this.f2377e, this.f2374b) << 8)) != 0) {
                        int i4 = this.f2373a;
                        return (i4 & 28672) == 0 || (i4 & (a(this.f2377e, this.f2375c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f2371a.a();
        int b2 = this.f2371a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f2371a.a(i);
            this.f2372b.a(a2, b2, this.f2371a.a(a3), this.f2371a.b(a3));
            if (i3 != 0) {
                this.f2372b.a();
                this.f2372b.a(i3);
                if (this.f2372b.b()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f2372b.a();
                this.f2372b.a(i4);
                if (this.f2372b.b()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f2372b.a(this.f2371a.a(), this.f2371a.b(), this.f2371a.a(view), this.f2371a.b(view));
        if (i != 0) {
            this.f2372b.a();
            this.f2372b.a(i);
            return this.f2372b.b();
        }
        return false;
    }
}
