package cn.jiguang.as;

import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    protected long f3922a;

    /* renamed from: b  reason: collision with root package name */
    protected SelectionKey f3923b;

    private q(long j) {
        Selector selector;
        SocketChannel open = SocketChannel.open();
        this.f3922a = j;
        try {
            selector = Selector.open();
        } catch (Throwable th) {
            th = th;
            selector = null;
        }
        try {
            open.configureBlocking(false);
            this.f3923b = open.register(selector, 1);
        } catch (Throwable th2) {
            th = th2;
            if (selector != null) {
                selector.close();
            }
            open.close();
            throw th;
        }
    }

    private void a() {
        this.f3923b.selector().close();
        this.f3923b.channel().close();
    }

    private static void a(SelectionKey selectionKey, long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        if ((currentTimeMillis > 0 ? selectionKey.selector().select(currentTimeMillis) : currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    private byte[] a(int i) {
        SocketChannel socketChannel = (SocketChannel) this.f3923b.channel();
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f3923b.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.f3923b.isReadable()) {
                    long read = socketChannel.read(wrap);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) read;
                    if (i2 < i && System.currentTimeMillis() > this.f3922a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f3923b, this.f3922a);
                }
            } finally {
                if (this.f3923b.isValid()) {
                    this.f3923b.interestOps(0);
                }
            }
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) {
        q qVar = new q(j);
        try {
            SocketChannel socketChannel = (SocketChannel) qVar.f3923b.channel();
            if (!socketChannel.connect(socketAddress2)) {
                qVar.f3923b.interestOps(8);
                while (!socketChannel.finishConnect()) {
                    if (!qVar.f3923b.isConnectable()) {
                        a(qVar.f3923b, qVar.f3922a);
                    }
                }
                if (qVar.f3923b.isValid()) {
                    qVar.f3923b.interestOps(0);
                }
            }
            SocketChannel socketChannel2 = (SocketChannel) qVar.f3923b.channel();
            ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
            qVar.f3923b.interestOps(4);
            int i = 0;
            while (i < bArr.length + 2) {
                if (qVar.f3923b.isWritable()) {
                    long write = socketChannel2.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i += (int) write;
                    if (i < bArr.length + 2 && System.currentTimeMillis() > qVar.f3922a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(qVar.f3923b, qVar.f3922a);
                }
            }
            if (qVar.f3923b.isValid()) {
                qVar.f3923b.interestOps(0);
            }
            byte[] a2 = qVar.a(2);
            byte[] a3 = qVar.a(((a2[0] & 255) << 8) + (a2[1] & 255));
            qVar.f3923b.channel();
            return a3;
        } finally {
            qVar.a();
        }
    }
}
