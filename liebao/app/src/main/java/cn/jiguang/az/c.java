package cn.jiguang.az;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    int f4029a;

    /* renamed from: b  reason: collision with root package name */
    int f4030b;

    /* renamed from: c  reason: collision with root package name */
    int f4031c;

    /* renamed from: d  reason: collision with root package name */
    Long f4032d;

    /* renamed from: e  reason: collision with root package name */
    int f4033e;
    long f;
    private boolean g;

    public c(boolean z, int i, int i2, int i3, long j, int i4, long j2) {
        this.g = false;
        this.g = z;
        this.f4029a = i;
        this.f4030b = i2;
        this.f4031c = i3;
        this.f4032d = Long.valueOf(j);
        this.f4033e = i4;
        this.f = j2;
    }

    public c(boolean z, int i, int i2, long j) {
        this(z, 0, i, i2, j, 0, 0L);
    }

    public c(boolean z, byte[] bArr) {
        this.g = false;
        this.g = z;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s = wrap.getShort();
        this.f4029a = s;
        this.f4029a = s & Short.MAX_VALUE;
        this.f4030b = wrap.get();
        this.f4031c = wrap.get();
        Long valueOf = Long.valueOf(wrap.getLong());
        this.f4032d = valueOf;
        this.f4032d = Long.valueOf(valueOf.longValue() & 65535);
        if (z) {
            this.f4033e = wrap.getInt();
        }
        this.f = wrap.getLong();
    }

    public final int a() {
        return this.f4031c;
    }

    public final void a(int i) {
        this.f4029a = i;
    }

    public final void a(long j) {
        this.f = j;
    }

    public final Long b() {
        return this.f4032d;
    }

    public final void b(int i) {
        this.f4033e = i;
    }

    public final long c() {
        return this.f;
    }

    public final int d() {
        return this.f4033e;
    }

    public final int e() {
        return this.f4030b;
    }

    public final byte[] f() {
        if (this.f4029a != 0) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.putShort((short) this.f4029a);
            allocate.put((byte) this.f4030b);
            allocate.put((byte) this.f4031c);
            allocate.putLong(this.f4032d.longValue());
            if (this.g) {
                allocate.putInt(this.f4033e);
            }
            allocate.putLong(this.f);
            allocate.flip();
            return ProtocolUtil.getBytesConsumed(allocate);
        }
        throw new IllegalStateException("The head is not initialized yet.");
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[JHead] - len:");
        sb.append(this.f4029a);
        sb.append(", version:");
        sb.append(this.f4030b);
        sb.append(", command:");
        sb.append(this.f4031c);
        sb.append(", rid:");
        sb.append(this.f4032d);
        if (this.g) {
            str = ", sid:" + this.f4033e;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f);
        return sb.toString();
    }
}
