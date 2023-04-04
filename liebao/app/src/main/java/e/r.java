package e;

import javax.annotation.Nullable;
import okhttp3.ac;
import okhttp3.ad;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class r<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ac f7116a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final T f7117b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ad f7118c;

    public static <T> r<T> a(@Nullable T t, ac acVar) {
        u.a(acVar, "rawResponse == null");
        if (!acVar.d()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new r<>(acVar, t, null);
    }

    public static <T> r<T> a(ad adVar, ac acVar) {
        u.a(adVar, "body == null");
        u.a(acVar, "rawResponse == null");
        if (acVar.d()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new r<>(acVar, null, adVar);
    }

    private r(ac acVar, @Nullable T t, @Nullable ad adVar) {
        this.f7116a = acVar;
        this.f7117b = t;
        this.f7118c = adVar;
    }

    public int a() {
        return this.f7116a.c();
    }

    public String b() {
        return this.f7116a.e();
    }

    public boolean c() {
        return this.f7116a.d();
    }

    @Nullable
    public T d() {
        return this.f7117b;
    }

    public String toString() {
        return this.f7116a.toString();
    }
}
