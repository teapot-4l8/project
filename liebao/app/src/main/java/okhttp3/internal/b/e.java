package okhttp3.internal.b;

import java.io.IOException;

/* compiled from: RouteException.java */
/* loaded from: classes2.dex */
public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private IOException f7449a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f7450b;

    public e(IOException iOException) {
        super(iOException);
        this.f7449a = iOException;
        this.f7450b = iOException;
    }

    public IOException a() {
        return this.f7449a;
    }

    public IOException b() {
        return this.f7450b;
    }

    public void a(IOException iOException) {
        okhttp3.internal.c.a((Throwable) this.f7449a, (Throwable) iOException);
        this.f7450b = iOException;
    }
}
