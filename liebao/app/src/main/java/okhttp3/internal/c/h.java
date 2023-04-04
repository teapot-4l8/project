package okhttp3.internal.c;

import javax.annotation.Nullable;
import okhttp3.ad;
import okhttp3.v;

/* compiled from: RealResponseBody.java */
/* loaded from: classes.dex */
public final class h extends ad {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f7485a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7486b;

    /* renamed from: c  reason: collision with root package name */
    private final c.e f7487c;

    public h(@Nullable String str, long j, c.e eVar) {
        this.f7485a = str;
        this.f7486b = j;
        this.f7487c = eVar;
    }

    @Override // okhttp3.ad
    public v a() {
        String str = this.f7485a;
        if (str != null) {
            return v.b(str);
        }
        return null;
    }

    @Override // okhttp3.ad
    public long b() {
        return this.f7486b;
    }

    @Override // okhttp3.ad
    public c.e c() {
        return this.f7487c;
    }
}
