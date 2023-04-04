package c;

import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: classes.dex */
public class i extends t {

    /* renamed from: a  reason: collision with root package name */
    private t f3552a;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3552a = tVar;
    }

    public final t a() {
        return this.f3552a;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3552a = tVar;
        return this;
    }

    @Override // c.t
    public t a(long j, TimeUnit timeUnit) {
        return this.f3552a.a(j, timeUnit);
    }

    @Override // c.t
    public long q_() {
        return this.f3552a.q_();
    }

    @Override // c.t
    public boolean o_() {
        return this.f3552a.o_();
    }

    @Override // c.t
    public long d() {
        return this.f3552a.d();
    }

    @Override // c.t
    public t a(long j) {
        return this.f3552a.a(j);
    }

    @Override // c.t
    public t p_() {
        return this.f3552a.p_();
    }

    @Override // c.t
    public t f() {
        return this.f3552a.f();
    }

    @Override // c.t
    public void g() {
        this.f3552a.g();
    }
}
