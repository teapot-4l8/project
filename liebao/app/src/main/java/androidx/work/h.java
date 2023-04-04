package androidx.work;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f2796a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final int f2797b = 20;

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void c(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void e(String str, String str2, Throwable... thArr);

    public static synchronized void a(h hVar) {
        synchronized (h.class) {
            f2796a = hVar;
        }
    }

    public static String a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i = f2797b;
        if (length >= i) {
            sb.append(str.substring(0, i));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f2796a == null) {
                f2796a = new a(3);
            }
            hVar = f2796a;
        }
        return hVar;
    }

    public h(int i) {
    }

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public static class a extends h {

        /* renamed from: a  reason: collision with root package name */
        private int f2798a;

        public a(int i) {
            super(i);
            this.f2798a = i;
        }

        @Override // androidx.work.h
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f2798a <= 2) {
                if (thArr != null && thArr.length >= 1) {
                    Log.v(str, str2, thArr[0]);
                } else {
                    Log.v(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f2798a <= 3) {
                if (thArr != null && thArr.length >= 1) {
                    Log.d(str, str2, thArr[0]);
                } else {
                    Log.d(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void c(String str, String str2, Throwable... thArr) {
            if (this.f2798a <= 4) {
                if (thArr != null && thArr.length >= 1) {
                    Log.i(str, str2, thArr[0]);
                } else {
                    Log.i(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f2798a <= 5) {
                if (thArr != null && thArr.length >= 1) {
                    Log.w(str, str2, thArr[0]);
                } else {
                    Log.w(str, str2);
                }
            }
        }

        @Override // androidx.work.h
        public void e(String str, String str2, Throwable... thArr) {
            if (this.f2798a <= 6) {
                if (thArr != null && thArr.length >= 1) {
                    Log.e(str, str2, thArr[0]);
                } else {
                    Log.e(str, str2);
                }
            }
        }
    }
}
