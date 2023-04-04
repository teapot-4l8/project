package cn.jiguang.aw;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: classes.dex */
public abstract class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    protected SocketChannel f3999b;

    /* renamed from: c  reason: collision with root package name */
    protected int f4000c;

    /* renamed from: d  reason: collision with root package name */
    protected Selector f4001d;
    protected int f = 20;

    /* renamed from: a  reason: collision with root package name */
    protected ByteBuffer f3998a = ByteBuffer.allocate(49152);

    /* renamed from: e  reason: collision with root package name */
    protected boolean f4002e = false;

    public int a(String str, int i) {
        if (this.f3998a == null) {
            this.f3998a = ByteBuffer.allocate(49152);
        }
        this.f3998a.clear();
        this.f4000c = 0;
        this.f4002e = true;
        return 0;
    }

    public abstract int a(byte[] bArr);

    public abstract ByteBuffer a(int i);

    public final boolean a() {
        SocketChannel socketChannel;
        return this.f4002e && (socketChannel = this.f3999b) != null && socketChannel.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b() {
        if (this.f4000c < this.f) {
            return 0;
        }
        int position = this.f3998a.position();
        this.f3998a.position(0);
        int i = this.f3998a.getShort() & Short.MAX_VALUE;
        this.f3998a.position(position);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuffer b(int i) {
        int i2 = this.f4000c;
        if (i2 >= i) {
            this.f4000c = i2 - i;
            byte[] bArr = new byte[i];
            this.f3998a.flip();
            this.f3998a.get(bArr, 0, i);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f3998a.compact();
            return wrap;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4002e = false;
        ByteBuffer byteBuffer = this.f3998a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f4000c = 0;
    }
}
