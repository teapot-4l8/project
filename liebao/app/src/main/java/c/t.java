package c;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: c  reason: collision with root package name */
    public static final t f3582c = new t() { // from class: c.t.1
        @Override // c.t
        public t a(long j) {
            return this;
        }

        @Override // c.t
        public t a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // c.t
        public void g() {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f3583a;

    /* renamed from: b  reason: collision with root package name */
    private long f3584b;

    /* renamed from: d  reason: collision with root package name */
    private long f3585d;

    public t a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f3585d = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long q_() {
        return this.f3585d;
    }

    public boolean o_() {
        return this.f3583a;
    }

    public long d() {
        if (!this.f3583a) {
            throw new IllegalStateException("No deadline");
        }
        return this.f3584b;
    }

    public t a(long j) {
        this.f3583a = true;
        this.f3584b = j;
        return this;
    }

    public t p_() {
        this.f3585d = 0L;
        return this;
    }

    public t f() {
        this.f3583a = false;
        return this;
    }

    public void g() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f3583a && this.f3584b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
