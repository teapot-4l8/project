package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    final b f2241a;

    /* renamed from: b  reason: collision with root package name */
    final a f2242b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f2243c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        View b(int i);

        RecyclerView.x b(View view);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f2241a = bVar;
    }

    private void g(View view) {
        this.f2243c.add(view);
        this.f2241a.c(view);
    }

    private boolean h(View view) {
        if (this.f2243c.remove(view)) {
            this.f2241a.d(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int f;
        if (i < 0) {
            f = this.f2241a.a();
        } else {
            f = f(i);
        }
        this.f2242b.a(f, z);
        if (z) {
            g(view);
        }
        this.f2241a.a(view, f);
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f2241a.a();
        int i2 = i;
        while (i2 < a2) {
            int e2 = i - (i2 - this.f2242b.e(i2));
            if (e2 == 0) {
                while (this.f2242b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        int a2 = this.f2241a.a(view);
        if (a2 < 0) {
            return;
        }
        if (this.f2242b.d(a2)) {
            h(view);
        }
        this.f2241a.a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        View b2 = this.f2241a.b(f);
        if (b2 == null) {
            return;
        }
        if (this.f2242b.d(f)) {
            h(b2);
        }
        this.f2241a.a(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i) {
        return this.f2241a.b(f(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f2242b.a();
        for (int size = this.f2243c.size() - 1; size >= 0; size--) {
            this.f2241a.d(this.f2243c.get(size));
            this.f2243c.remove(size);
        }
        this.f2241a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i) {
        int size = this.f2243c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f2243c.get(i2);
            RecyclerView.x b2 = this.f2241a.b(view);
            if (b2.getLayoutPosition() == i && !b2.isInvalid() && !b2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int f;
        if (i < 0) {
            f = this.f2241a.a();
        } else {
            f = f(i);
        }
        this.f2242b.a(f, z);
        if (z) {
            g(view);
        }
        this.f2241a.a(view, f, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2241a.a() - this.f2243c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f2241a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d(int i) {
        return this.f2241a.b(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        this.f2242b.d(f);
        this.f2241a.c(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        int a2 = this.f2241a.a(view);
        if (a2 == -1 || this.f2242b.c(a2)) {
            return -1;
        }
        return a2 - this.f2242b.e(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.f2243c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        int a2 = this.f2241a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2242b.a(a2);
        g(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view) {
        int a2 = this.f2241a.a(view);
        if (a2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (!this.f2242b.c(a2)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        } else {
            this.f2242b.b(a2);
            h(view);
        }
    }

    public String toString() {
        return this.f2242b.toString() + ", hidden list:" + this.f2243c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(View view) {
        int a2 = this.f2241a.a(view);
        if (a2 == -1) {
            h(view);
            return true;
        } else if (this.f2242b.c(a2)) {
            this.f2242b.d(a2);
            h(view);
            this.f2241a.a(a2);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f2244a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f2245b;

        a() {
        }

        void a(int i) {
            if (i >= 64) {
                b();
                this.f2245b.a(i - 64);
                return;
            }
            this.f2244a |= 1 << i;
        }

        private void b() {
            if (this.f2245b == null) {
                this.f2245b = new a();
            }
        }

        void b(int i) {
            if (i >= 64) {
                a aVar = this.f2245b;
                if (aVar != null) {
                    aVar.b(i - 64);
                    return;
                }
                return;
            }
            this.f2244a &= (1 << i) ^ (-1);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f2244a & (1 << i)) != 0;
            }
            b();
            return this.f2245b.c(i - 64);
        }

        void a() {
            this.f2244a = 0L;
            a aVar = this.f2245b;
            if (aVar != null) {
                aVar.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f2245b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2244a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f2244a;
            this.f2244a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.f2245b != null) {
                b();
                this.f2245b.a(0, z2);
            }
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f2245b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2244a & j) != 0;
            long j2 = this.f2244a & (j ^ (-1));
            this.f2244a = j2;
            long j3 = j - 1;
            this.f2244a = (j2 & j3) | Long.rotateRight((j3 ^ (-1)) & j2, 1);
            a aVar = this.f2245b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    a(63);
                }
                this.f2245b.d(0);
            }
            return z;
        }

        int e(int i) {
            a aVar = this.f2245b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f2244a);
                }
                return Long.bitCount(this.f2244a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f2244a & ((1 << i) - 1));
            } else {
                return aVar.e(i - 64) + Long.bitCount(this.f2244a);
            }
        }

        public String toString() {
            if (this.f2245b == null) {
                return Long.toBinaryString(this.f2244a);
            }
            return this.f2245b.toString() + "xx" + Long.toBinaryString(this.f2244a);
        }
    }
}
