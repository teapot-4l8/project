package b.a.e;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3132a = false;

    /* renamed from: b  reason: collision with root package name */
    private final int f3133b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3134c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f3135d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f3136e;

    private a(int i, String str, Long l, Long l2) {
        this.f3133b = i;
        this.f3134c = str;
        this.f3135d = l;
        this.f3136e = l2;
    }

    public static a a() {
        return new a(0, "$register", Long.valueOf(System.currentTimeMillis()), 1L);
    }

    public static a a(long j) {
        return new a(1, null, Long.valueOf(System.currentTimeMillis()), Long.valueOf(j));
    }

    public static a a(String str, long j) {
        return new a(2, str, Long.valueOf(System.currentTimeMillis()), Long.valueOf(j));
    }

    public void a(boolean z) {
        this.f3132a = z;
    }

    public int b() {
        return this.f3133b;
    }

    public boolean c() {
        return this.f3132a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f3134c)) {
            sb.append(this.f3134c);
            sb.append(",");
        }
        Long l = this.f3135d;
        if (l != null) {
            sb.append(l);
            sb.append(",");
        }
        Long l2 = this.f3136e;
        if (l2 != null) {
            sb.append(l2);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            sb.append(";");
        }
        return sb.toString();
    }
}
