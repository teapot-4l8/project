package e.a.a;

import e.r;
import javax.annotation.Nullable;

/* compiled from: Result.java */
/* loaded from: classes.dex */
public final class e<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final r<T> f6999a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f7000b;

    public static <T> e<T> a(Throwable th) {
        if (th == null) {
            throw new NullPointerException("error == null");
        }
        return new e<>(null, th);
    }

    public static <T> e<T> a(r<T> rVar) {
        if (rVar == null) {
            throw new NullPointerException("response == null");
        }
        return new e<>(rVar, null);
    }

    private e(@Nullable r<T> rVar, @Nullable Throwable th) {
        this.f6999a = rVar;
        this.f7000b = th;
    }
}
