package a.a.a.d;

import java.nio.ByteBuffer;

/* compiled from: DNSInput.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f337a;

    /* renamed from: b  reason: collision with root package name */
    private int f338b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f339c = -1;

    public t(byte[] bArr) {
        this.f337a = ByteBuffer.wrap(bArr);
    }

    public int a() {
        return this.f337a.position();
    }

    public int b() {
        return this.f337a.remaining();
    }

    private void e(int i) {
        if (i > b()) {
            throw new dg("end of input");
        }
    }

    public void a(int i) {
        if (i > this.f337a.capacity() - this.f337a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f337a;
        byteBuffer.limit(byteBuffer.position() + i);
    }

    public void c() {
        ByteBuffer byteBuffer = this.f337a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public int d() {
        return this.f337a.limit();
    }

    public void b(int i) {
        if (i > this.f337a.capacity()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f337a;
        byteBuffer.limit(byteBuffer.position());
    }

    public void c(int i) {
        if (i >= this.f337a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f337a.position(i);
        ByteBuffer byteBuffer = this.f337a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void e() {
        this.f338b = this.f337a.position();
        this.f339c = this.f337a.limit();
    }

    public void f() {
        int i = this.f338b;
        if (i < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f337a.position(i);
        this.f337a.limit(this.f339c);
        this.f338b = -1;
        this.f339c = -1;
    }

    public int g() {
        e(1);
        return this.f337a.get() & 255;
    }

    public int h() {
        e(2);
        return this.f337a.getShort() & 65535;
    }

    public long i() {
        e(4);
        return this.f337a.getInt() & 4294967295L;
    }

    public void a(byte[] bArr, int i, int i2) {
        e(i2);
        this.f337a.get(bArr, i, i2);
    }

    public byte[] d(int i) {
        e(i);
        byte[] bArr = new byte[i];
        this.f337a.get(bArr, 0, i);
        return bArr;
    }

    public byte[] j() {
        int b2 = b();
        byte[] bArr = new byte[b2];
        this.f337a.get(bArr, 0, b2);
        return bArr;
    }

    public byte[] k() {
        return d(g());
    }
}
