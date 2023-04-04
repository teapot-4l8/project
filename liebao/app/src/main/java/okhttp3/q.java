package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: FormBody.java */
/* loaded from: classes.dex */
public final class q extends ab {

    /* renamed from: a  reason: collision with root package name */
    private static final v f7698a = v.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f7699b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f7700c;

    q(List<String> list, List<String> list2) {
        this.f7699b = okhttp3.internal.c.a(list);
        this.f7700c = okhttp3.internal.c.a(list2);
    }

    public int a() {
        return this.f7699b.size();
    }

    public String a(int i) {
        return this.f7699b.get(i);
    }

    public String b(int i) {
        return t.a(a(i), true);
    }

    public String c(int i) {
        return this.f7700c.get(i);
    }

    public String d(int i) {
        return t.a(c(i), true);
    }

    @Override // okhttp3.ab
    public v b() {
        return f7698a;
    }

    @Override // okhttp3.ab
    public long c() {
        return a((c.d) null, true);
    }

    @Override // okhttp3.ab
    public void a(c.d dVar) {
        a(dVar, false);
    }

    private long a(@Nullable c.d dVar, boolean z) {
        c.c c2;
        if (z) {
            c2 = new c.c();
        } else {
            c2 = dVar.c();
        }
        int size = this.f7699b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                c2.i(38);
            }
            c2.b(this.f7699b.get(i));
            c2.i(61);
            c2.b(this.f7700c.get(i));
        }
        if (z) {
            long b2 = c2.b();
            c2.u();
            return b2;
        }
        return 0L;
    }

    /* compiled from: FormBody.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f7701a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f7702b;

        /* renamed from: c  reason: collision with root package name */
        private final Charset f7703c;

        public a() {
            this(null);
        }

        public a(Charset charset) {
            this.f7701a = new ArrayList();
            this.f7702b = new ArrayList();
            this.f7703c = charset;
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                this.f7701a.add(t.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f7703c));
                this.f7702b.add(t.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f7703c));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public a b(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                this.f7701a.add(t.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f7703c));
                this.f7702b.add(t.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f7703c));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public q a() {
            return new q(this.f7701a, this.f7702b);
        }
    }
}
