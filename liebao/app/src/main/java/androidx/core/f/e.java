package androidx.core.f;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final androidx.core.f.d f1581a = new C0037e(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final androidx.core.f.d f1582b = new C0037e(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final androidx.core.f.d f1583c = new C0037e(b.f1588a, false);

    /* renamed from: d  reason: collision with root package name */
    public static final androidx.core.f.d f1584d = new C0037e(b.f1588a, true);

    /* renamed from: e  reason: collision with root package name */
    public static final androidx.core.f.d f1585e = new C0037e(a.f1586a, false);
    public static final androidx.core.f.d f = f.f1591a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static abstract class d implements androidx.core.f.d {

        /* renamed from: a  reason: collision with root package name */
        private final c f1589a;

        protected abstract boolean a();

        d(c cVar) {
            this.f1589a = cVar;
        }

        @Override // androidx.core.f.d
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            if (this.f1589a == null) {
                return a();
            }
            return b(charSequence, i, i2);
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            int a2 = this.f1589a.a(charSequence, i, i2);
            if (a2 != 0) {
                if (a2 != 1) {
                    return a();
                }
                return false;
            }
            return true;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: androidx.core.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0037e extends d {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f1590a;

        C0037e(c cVar, boolean z) {
            super(cVar);
            this.f1590a = z;
        }

        @Override // androidx.core.f.e.d
        protected boolean a() {
            return this.f1590a;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f1588a = new b();

        @Override // androidx.core.f.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f1586a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1587b;

        @Override // androidx.core.f.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.f1587b) {
                        return 1;
                    }
                } else if (this.f1587b) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f1587b ? 1 : 0;
            }
            return 2;
        }

        private a(boolean z) {
            this.f1587b = z;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class f extends d {

        /* renamed from: a  reason: collision with root package name */
        static final f f1591a = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.f.e.d
        protected boolean a() {
            return androidx.core.f.f.a(Locale.getDefault()) == 1;
        }
    }
}
