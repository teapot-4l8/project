package cn.jiguang.as;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f3874a;

    /* renamed from: b  reason: collision with root package name */
    private int f3875b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f3876c = -1;

    public c(byte[] bArr) {
        this.f3874a = ByteBuffer.wrap(bArr);
    }

    private void c(int i) {
        if (i > this.f3874a.remaining()) {
            throw new IOException("end of input");
        }
    }

    public final int a() {
        return this.f3874a.position();
    }

    public final void a(int i) {
        if (i > this.f3874a.capacity() - this.f3874a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f3874a;
        byteBuffer.limit(byteBuffer.position() + i);
    }

    public final void a(byte[] bArr, int i, int i2) {
        c(i2);
        this.f3874a.get(bArr, 1, i2);
    }

    public final int b() {
        return this.f3874a.remaining();
    }

    public final void b(int i) {
        if (i >= this.f3874a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f3874a.position(i);
        ByteBuffer byteBuffer = this.f3874a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public final void c() {
        ByteBuffer byteBuffer = this.f3874a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public final void d() {
        this.f3875b = this.f3874a.position();
        this.f3876c = this.f3874a.limit();
    }

    public final void e() {
        int i = this.f3875b;
        if (i < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f3874a.position(i);
        this.f3874a.limit(this.f3876c);
        this.f3875b = -1;
        this.f3876c = -1;
    }

    public final int f() {
        c(1);
        return this.f3874a.get() & 255;
    }

    public final int g() {
        c(2);
        return this.f3874a.getShort() & 65535;
    }

    public final long h() {
        c(4);
        return this.f3874a.getInt() & 4294967295L;
    }
}
