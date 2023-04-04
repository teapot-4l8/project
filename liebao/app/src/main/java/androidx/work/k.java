package androidx.work;

/* compiled from: Operation.java */
/* loaded from: classes.dex */
public interface k {

    /* renamed from: a  reason: collision with root package name */
    public static final a.c f3067a = new a.c();

    /* renamed from: b  reason: collision with root package name */
    public static final a.b f3068b = new a.b();

    /* compiled from: Operation.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        a() {
        }

        /* compiled from: Operation.java */
        /* loaded from: classes.dex */
        public static final class c extends a {
            public String toString() {
                return "SUCCESS";
            }

            private c() {
            }
        }

        /* compiled from: Operation.java */
        /* loaded from: classes.dex */
        public static final class b extends a {
            public String toString() {
                return "IN_PROGRESS";
            }

            private b() {
            }
        }

        /* compiled from: Operation.java */
        /* renamed from: androidx.work.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0063a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f3069a;

            public C0063a(Throwable th) {
                this.f3069a = th;
            }

            public Throwable a() {
                return this.f3069a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f3069a.getMessage());
            }
        }
    }
}
