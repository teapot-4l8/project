package b.a.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class f implements Cloneable {
    private static final byte[] i = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public int f3239a;

    /* renamed from: b  reason: collision with root package name */
    public int f3240b;

    /* renamed from: c  reason: collision with root package name */
    public int f3241c;

    /* renamed from: d  reason: collision with root package name */
    public int f3242d;

    /* renamed from: e  reason: collision with root package name */
    public long f3243e;
    public long f;
    public byte[] g = i;
    public long h;

    public int a() {
        return this.g.length + 22;
    }

    public ByteBuffer a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(a());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(101010256);
        allocate.putShort((short) this.f3239a);
        allocate.putShort((short) this.f3240b);
        allocate.putShort((short) this.f3241c);
        allocate.putShort((short) this.f3242d);
        allocate.putInt((int) this.f3243e);
        allocate.putInt((int) j);
        allocate.putShort((short) this.g.length);
        allocate.put(this.g);
        allocate.flip();
        return allocate;
    }

    public void a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            bArr = i;
        }
        this.g = bArr;
    }

    /* renamed from: b */
    public f clone() {
        try {
            return (f) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new Error(e2);
        }
    }
}
