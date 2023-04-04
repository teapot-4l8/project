package androidx.core.h;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final ae f1688a = new a().a().i().h().g();

    /* renamed from: b  reason: collision with root package name */
    private final e f1689b;

    private ae(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1689b = new i(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.f1689b = new h(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f1689b = new g(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f1689b = new f(this, windowInsets);
        } else {
            this.f1689b = new e(this);
        }
    }

    public ae(ae aeVar) {
        if (aeVar != null) {
            e eVar = aeVar.f1689b;
            if (Build.VERSION.SDK_INT >= 29 && (eVar instanceof i)) {
                this.f1689b = new i(this, (i) eVar);
                return;
            } else if (Build.VERSION.SDK_INT >= 28 && (eVar instanceof h)) {
                this.f1689b = new h(this, (h) eVar);
                return;
            } else if (Build.VERSION.SDK_INT >= 21 && (eVar instanceof g)) {
                this.f1689b = new g(this, (g) eVar);
                return;
            } else if (Build.VERSION.SDK_INT >= 20 && (eVar instanceof f)) {
                this.f1689b = new f(this, (f) eVar);
                return;
            } else {
                this.f1689b = new e(this);
                return;
            }
        }
        this.f1689b = new e(this);
    }

    public static ae a(WindowInsets windowInsets) {
        return new ae((WindowInsets) androidx.core.g.f.a(windowInsets));
    }

    public int a() {
        return j().f1604b;
    }

    public int b() {
        return j().f1605c;
    }

    public int c() {
        return j().f1606d;
    }

    public int d() {
        return j().f1607e;
    }

    public boolean e() {
        return !j().equals(androidx.core.graphics.b.f1603a);
    }

    public boolean f() {
        return this.f1689b.b();
    }

    public ae g() {
        return this.f1689b.c();
    }

    @Deprecated
    public ae a(int i2, int i3, int i4, int i5) {
        return new a(this).a(androidx.core.graphics.b.a(i2, i3, i4, i5)).a();
    }

    public ae h() {
        return this.f1689b.d();
    }

    public ae i() {
        return this.f1689b.f();
    }

    public androidx.core.graphics.b j() {
        return this.f1689b.g();
    }

    public ae b(int i2, int i3, int i4, int i5) {
        return this.f1689b.a(i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ae) {
            return androidx.core.g.c.a(this.f1689b, ((ae) obj).f1689b);
        }
        return false;
    }

    public int hashCode() {
        e eVar = this.f1689b;
        if (eVar == null) {
            return 0;
        }
        return eVar.hashCode();
    }

    public WindowInsets k() {
        e eVar = this.f1689b;
        if (eVar instanceof f) {
            return ((f) eVar).f1699b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        final ae f1698a;

        boolean a() {
            return false;
        }

        boolean b() {
            return false;
        }

        androidx.core.h.c e() {
            return null;
        }

        e(ae aeVar) {
            this.f1698a = aeVar;
        }

        ae c() {
            return this.f1698a;
        }

        ae d() {
            return this.f1698a;
        }

        ae f() {
            return this.f1698a;
        }

        androidx.core.graphics.b g() {
            return androidx.core.graphics.b.f1603a;
        }

        androidx.core.graphics.b h() {
            return androidx.core.graphics.b.f1603a;
        }

        ae a(int i, int i2, int i3, int i4) {
            return ae.f1688a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                return a() == eVar.a() && b() == eVar.b() && androidx.core.g.c.a(g(), eVar.g()) && androidx.core.g.c.a(h(), eVar.h()) && androidx.core.g.c.a(e(), eVar.e());
            }
            return false;
        }

        public int hashCode() {
            return androidx.core.g.c.a(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class f extends e {

        /* renamed from: b  reason: collision with root package name */
        final WindowInsets f1699b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.core.graphics.b f1700c;

        f(ae aeVar, WindowInsets windowInsets) {
            super(aeVar);
            this.f1700c = null;
            this.f1699b = windowInsets;
        }

        f(ae aeVar, f fVar) {
            this(aeVar, new WindowInsets(fVar.f1699b));
        }

        @Override // androidx.core.h.ae.e
        boolean a() {
            return this.f1699b.isRound();
        }

        @Override // androidx.core.h.ae.e
        final androidx.core.graphics.b g() {
            if (this.f1700c == null) {
                this.f1700c = androidx.core.graphics.b.a(this.f1699b.getSystemWindowInsetLeft(), this.f1699b.getSystemWindowInsetTop(), this.f1699b.getSystemWindowInsetRight(), this.f1699b.getSystemWindowInsetBottom());
            }
            return this.f1700c;
        }

        @Override // androidx.core.h.ae.e
        ae a(int i, int i2, int i3, int i4) {
            a aVar = new a(ae.a(this.f1699b));
            aVar.a(ae.a(g(), i, i2, i3, i4));
            aVar.b(ae.a(h(), i, i2, i3, i4));
            return aVar.a();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class g extends f {

        /* renamed from: c  reason: collision with root package name */
        private androidx.core.graphics.b f1701c;

        g(ae aeVar, WindowInsets windowInsets) {
            super(aeVar, windowInsets);
            this.f1701c = null;
        }

        g(ae aeVar, g gVar) {
            super(aeVar, gVar);
            this.f1701c = null;
        }

        @Override // androidx.core.h.ae.e
        boolean b() {
            return this.f1699b.isConsumed();
        }

        @Override // androidx.core.h.ae.e
        ae d() {
            return ae.a(this.f1699b.consumeStableInsets());
        }

        @Override // androidx.core.h.ae.e
        ae c() {
            return ae.a(this.f1699b.consumeSystemWindowInsets());
        }

        @Override // androidx.core.h.ae.e
        final androidx.core.graphics.b h() {
            if (this.f1701c == null) {
                this.f1701c = androidx.core.graphics.b.a(this.f1699b.getStableInsetLeft(), this.f1699b.getStableInsetTop(), this.f1699b.getStableInsetRight(), this.f1699b.getStableInsetBottom());
            }
            return this.f1701c;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class h extends g {
        h(ae aeVar, WindowInsets windowInsets) {
            super(aeVar, windowInsets);
        }

        h(ae aeVar, h hVar) {
            super(aeVar, hVar);
        }

        @Override // androidx.core.h.ae.e
        androidx.core.h.c e() {
            return androidx.core.h.c.a(this.f1699b.getDisplayCutout());
        }

        @Override // androidx.core.h.ae.e
        ae f() {
            return ae.a(this.f1699b.consumeDisplayCutout());
        }

        @Override // androidx.core.h.ae.e
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                return C$r8$backportedMethods$utility$Objects$2$equals.equals(this.f1699b, ((h) obj).f1699b);
            }
            return false;
        }

        @Override // androidx.core.h.ae.e
        public int hashCode() {
            return this.f1699b.hashCode();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class i extends h {

        /* renamed from: c  reason: collision with root package name */
        private androidx.core.graphics.b f1702c;

        /* renamed from: d  reason: collision with root package name */
        private androidx.core.graphics.b f1703d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.core.graphics.b f1704e;

        i(ae aeVar, WindowInsets windowInsets) {
            super(aeVar, windowInsets);
            this.f1702c = null;
            this.f1703d = null;
            this.f1704e = null;
        }

        i(ae aeVar, i iVar) {
            super(aeVar, iVar);
            this.f1702c = null;
            this.f1703d = null;
            this.f1704e = null;
        }

        @Override // androidx.core.h.ae.f, androidx.core.h.ae.e
        ae a(int i, int i2, int i3, int i4) {
            return ae.a(this.f1699b.inset(i, i2, i3, i4));
        }
    }

    static androidx.core.graphics.b a(androidx.core.graphics.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.f1604b - i2);
        int max2 = Math.max(0, bVar.f1605c - i3);
        int max3 = Math.max(0, bVar.f1606d - i4);
        int max4 = Math.max(0, bVar.f1607e - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : androidx.core.graphics.b.a(max, max2, max3, max4);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f1690a;

        public a() {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1690a = new d();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f1690a = new c();
            } else {
                this.f1690a = new b();
            }
        }

        public a(ae aeVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1690a = new d(aeVar);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f1690a = new c(aeVar);
            } else {
                this.f1690a = new b(aeVar);
            }
        }

        public a a(androidx.core.graphics.b bVar) {
            this.f1690a.a(bVar);
            return this;
        }

        public a b(androidx.core.graphics.b bVar) {
            this.f1690a.b(bVar);
            return this;
        }

        public ae a() {
            return this.f1690a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final ae f1691a;

        void a(androidx.core.graphics.b bVar) {
        }

        void b(androidx.core.graphics.b bVar) {
        }

        b() {
            this(new ae((ae) null));
        }

        b(ae aeVar) {
            this.f1691a = aeVar;
        }

        ae a() {
            return this.f1691a;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private static Field f1692a = null;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f1693b = false;

        /* renamed from: c  reason: collision with root package name */
        private static Constructor<WindowInsets> f1694c = null;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f1695d = false;

        /* renamed from: e  reason: collision with root package name */
        private WindowInsets f1696e;

        c() {
            this.f1696e = b();
        }

        c(ae aeVar) {
            this.f1696e = aeVar.k();
        }

        @Override // androidx.core.h.ae.b
        void a(androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f1696e;
            if (windowInsets != null) {
                this.f1696e = windowInsets.replaceSystemWindowInsets(bVar.f1604b, bVar.f1605c, bVar.f1606d, bVar.f1607e);
            }
        }

        @Override // androidx.core.h.ae.b
        ae a() {
            return ae.a(this.f1696e);
        }

        private static WindowInsets b() {
            if (!f1693b) {
                try {
                    f1692a = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f1693b = true;
            }
            Field field = f1692a;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f1695d) {
                try {
                    f1694c = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f1695d = true;
            }
            Constructor<WindowInsets> constructor = f1694c;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsets.Builder f1697a;

        d() {
            this.f1697a = new WindowInsets.Builder();
        }

        d(ae aeVar) {
            WindowInsets.Builder builder;
            WindowInsets k = aeVar.k();
            if (k != null) {
                builder = new WindowInsets.Builder(k);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f1697a = builder;
        }

        @Override // androidx.core.h.ae.b
        void a(androidx.core.graphics.b bVar) {
            this.f1697a.setSystemWindowInsets(bVar.a());
        }

        @Override // androidx.core.h.ae.b
        void b(androidx.core.graphics.b bVar) {
            this.f1697a.setStableInsets(bVar.a());
        }

        @Override // androidx.core.h.ae.b
        ae a() {
            return ae.a(this.f1697a.build());
        }
    }
}
