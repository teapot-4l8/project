package androidx.recyclerview.widget;

import androidx.core.g.e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public class a implements r.a {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<b> f2204a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f2205b;

    /* renamed from: c  reason: collision with root package name */
    final InterfaceC0052a f2206c;

    /* renamed from: d  reason: collision with root package name */
    Runnable f2207d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f2208e;
    final r f;
    private e.a<b> g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a {
        RecyclerView.x a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0052a interfaceC0052a) {
        this(interfaceC0052a, false);
    }

    a(InterfaceC0052a interfaceC0052a, boolean z) {
        this.g = new e.b(30);
        this.f2204a = new ArrayList<>();
        this.f2205b = new ArrayList<>();
        this.h = 0;
        this.f2206c = interfaceC0052a;
        this.f2208e = z;
        this.f = new r(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        a(this.f2204a);
        a(this.f2205b);
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f.a(this.f2204a);
        int size = this.f2204a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f2204a.get(i);
            int i2 = bVar.f2209a;
            if (i2 == 1) {
                f(bVar);
            } else if (i2 == 2) {
                c(bVar);
            } else if (i2 == 4) {
                d(bVar);
            } else if (i2 == 8) {
                b(bVar);
            }
            Runnable runnable = this.f2207d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2204a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        int size = this.f2205b.size();
        for (int i = 0; i < size; i++) {
            this.f2206c.b(this.f2205b.get(i));
        }
        a(this.f2205b);
        this.h = 0;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        boolean z;
        char c2;
        int i = bVar.f2210b;
        int i2 = bVar.f2210b + bVar.f2212d;
        int i3 = bVar.f2210b;
        char c3 = 65535;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f2206c.a(i3) != null || d(i3)) {
                if (c3 == 0) {
                    e(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c3 = c2;
        }
        if (i4 != bVar.f2212d) {
            a(bVar);
            bVar = a(2, i, i4, null);
        }
        if (c3 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i = bVar.f2210b;
        int i2 = bVar.f2210b + bVar.f2212d;
        char c2 = 65535;
        int i3 = 0;
        for (int i4 = bVar.f2210b; i4 < i2; i4++) {
            if (this.f2206c.a(i4) != null || d(i4)) {
                if (c2 == 0) {
                    e(a(4, i, i3, bVar.f2211c));
                    i = i4;
                    i3 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i, i3, bVar.f2211c));
                    i = i4;
                    i3 = 0;
                }
                c2 = 0;
            }
            i3++;
        }
        if (i3 != bVar.f2212d) {
            Object obj = bVar.f2211c;
            a(bVar);
            bVar = a(4, i, i3, obj);
        }
        if (c2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void e(b bVar) {
        int i;
        if (bVar.f2209a == 1 || bVar.f2209a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d2 = d(bVar.f2210b, bVar.f2209a);
        int i2 = bVar.f2210b;
        int i3 = bVar.f2209a;
        if (i3 == 2) {
            i = 0;
        } else if (i3 != 4) {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        } else {
            i = 1;
        }
        int i4 = 1;
        for (int i5 = 1; i5 < bVar.f2212d; i5++) {
            int d3 = d(bVar.f2210b + (i * i5), bVar.f2209a);
            int i6 = bVar.f2209a;
            if (i6 == 2 ? d3 == d2 : i6 == 4 && d3 == d2 + 1) {
                i4++;
            } else {
                b a2 = a(bVar.f2209a, d2, i4, bVar.f2211c);
                a(a2, i2);
                a(a2);
                if (bVar.f2209a == 4) {
                    i2 += i4;
                }
                d2 = d3;
                i4 = 1;
            }
        }
        Object obj = bVar.f2211c;
        a(bVar);
        if (i4 > 0) {
            b a3 = a(bVar.f2209a, d2, i4, obj);
            a(a3, i2);
            a(a3);
        }
    }

    void a(b bVar, int i) {
        this.f2206c.a(bVar);
        int i2 = bVar.f2209a;
        if (i2 == 2) {
            this.f2206c.a(i, bVar.f2212d);
        } else if (i2 == 4) {
            this.f2206c.a(i, bVar.f2212d, bVar.f2211c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int d(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f2205b.size() - 1; size >= 0; size--) {
            b bVar = this.f2205b.get(size);
            if (bVar.f2209a == 8) {
                if (bVar.f2210b < bVar.f2212d) {
                    i3 = bVar.f2210b;
                    i4 = bVar.f2212d;
                } else {
                    i3 = bVar.f2212d;
                    i4 = bVar.f2210b;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == bVar.f2210b) {
                        if (i2 == 1) {
                            bVar.f2212d++;
                        } else if (i2 == 2) {
                            bVar.f2212d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.f2210b++;
                        } else if (i2 == 2) {
                            bVar.f2210b--;
                        }
                        i--;
                    }
                } else if (i < bVar.f2210b) {
                    if (i2 == 1) {
                        bVar.f2210b++;
                        bVar.f2212d++;
                    } else if (i2 == 2) {
                        bVar.f2210b--;
                        bVar.f2212d--;
                    }
                }
            } else if (bVar.f2210b <= i) {
                if (bVar.f2209a == 1) {
                    i -= bVar.f2212d;
                } else if (bVar.f2209a == 2) {
                    i += bVar.f2212d;
                }
            } else if (i2 == 1) {
                bVar.f2210b++;
            } else if (i2 == 2) {
                bVar.f2210b--;
            }
        }
        for (int size2 = this.f2205b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f2205b.get(size2);
            if (bVar2.f2209a == 8) {
                if (bVar2.f2212d == bVar2.f2210b || bVar2.f2212d < 0) {
                    this.f2205b.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f2212d <= 0) {
                this.f2205b.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private boolean d(int i) {
        int size = this.f2205b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2205b.get(i2);
            if (bVar.f2209a == 8) {
                if (a(bVar.f2212d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f2209a == 1) {
                int i3 = bVar.f2210b + bVar.f2212d;
                for (int i4 = bVar.f2210b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.f2205b.add(bVar);
        int i = bVar.f2209a;
        if (i == 1) {
            this.f2206c.c(bVar.f2210b, bVar.f2212d);
        } else if (i == 2) {
            this.f2206c.b(bVar.f2210b, bVar.f2212d);
        } else if (i == 4) {
            this.f2206c.a(bVar.f2210b, bVar.f2212d, bVar.f2211c);
        } else if (i == 8) {
            this.f2206c.d(bVar.f2210b, bVar.f2212d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f2204a.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return (i & this.h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    int a(int i, int i2) {
        int size = this.f2205b.size();
        while (i2 < size) {
            b bVar = this.f2205b.get(i2);
            if (bVar.f2209a == 8) {
                if (bVar.f2210b == i) {
                    i = bVar.f2212d;
                } else {
                    if (bVar.f2210b < i) {
                        i--;
                    }
                    if (bVar.f2212d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f2210b > i) {
                continue;
            } else if (bVar.f2209a == 2) {
                if (i < bVar.f2210b + bVar.f2212d) {
                    return -1;
                }
                i -= bVar.f2212d;
            } else if (bVar.f2209a == 1) {
                i += bVar.f2212d;
            }
            i2++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f2204a.add(a(4, i, i2, obj));
        this.h |= 4;
        return this.f2204a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2204a.add(a(1, i, i2, null));
        this.h |= 1;
        return this.f2204a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2204a.add(a(2, i, i2, null));
        this.h |= 2;
        return this.f2204a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f2204a.add(a(8, i, i2, null));
        this.h |= 8;
        return this.f2204a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        c();
        int size = this.f2204a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f2204a.get(i);
            int i2 = bVar.f2209a;
            if (i2 == 1) {
                this.f2206c.b(bVar);
                this.f2206c.c(bVar.f2210b, bVar.f2212d);
            } else if (i2 == 2) {
                this.f2206c.b(bVar);
                this.f2206c.a(bVar.f2210b, bVar.f2212d);
            } else if (i2 == 4) {
                this.f2206c.b(bVar);
                this.f2206c.a(bVar.f2210b, bVar.f2212d, bVar.f2211c);
            } else if (i2 == 8) {
                this.f2206c.b(bVar);
                this.f2206c.d(bVar.f2210b, bVar.f2212d);
            }
            Runnable runnable = this.f2207d;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f2204a);
        this.h = 0;
    }

    public int c(int i) {
        int size = this.f2204a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2204a.get(i2);
            int i3 = bVar.f2209a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (bVar.f2210b == i) {
                            i = bVar.f2212d;
                        } else {
                            if (bVar.f2210b < i) {
                                i--;
                            }
                            if (bVar.f2212d <= i) {
                                i++;
                            }
                        }
                    }
                } else if (bVar.f2210b > i) {
                    continue;
                } else if (bVar.f2210b + bVar.f2212d > i) {
                    return -1;
                } else {
                    i -= bVar.f2212d;
                }
            } else if (bVar.f2210b <= i) {
                i += bVar.f2212d;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this.f2205b.isEmpty() || this.f2204a.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f2209a;

        /* renamed from: b  reason: collision with root package name */
        int f2210b;

        /* renamed from: c  reason: collision with root package name */
        Object f2211c;

        /* renamed from: d  reason: collision with root package name */
        int f2212d;

        b(int i, int i2, int i3, Object obj) {
            this.f2209a = i;
            this.f2210b = i2;
            this.f2212d = i3;
            this.f2211c = obj;
        }

        String a() {
            int i = this.f2209a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2210b + "c:" + this.f2212d + ",p:" + this.f2211c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f2209a;
            if (i != bVar.f2209a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f2212d - this.f2210b) == 1 && this.f2212d == bVar.f2210b && this.f2210b == bVar.f2212d) {
                return true;
            }
            if (this.f2212d == bVar.f2212d && this.f2210b == bVar.f2210b) {
                Object obj2 = this.f2211c;
                if (obj2 != null) {
                    if (!obj2.equals(bVar.f2211c)) {
                        return false;
                    }
                } else if (bVar.f2211c != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f2209a * 31) + this.f2210b) * 31) + this.f2212d;
        }
    }

    @Override // androidx.recyclerview.widget.r.a
    public b a(int i, int i2, int i3, Object obj) {
        b a2 = this.g.a();
        if (a2 == null) {
            return new b(i, i2, i3, obj);
        }
        a2.f2209a = i;
        a2.f2210b = i2;
        a2.f2212d = i3;
        a2.f2211c = obj;
        return a2;
    }

    @Override // androidx.recyclerview.widget.r.a
    public void a(b bVar) {
        if (this.f2208e) {
            return;
        }
        bVar.f2211c = null;
        this.g.a(bVar);
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}
