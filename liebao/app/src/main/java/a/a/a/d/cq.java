package a.a.a.d;

import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* compiled from: TCPClient.java */
/* loaded from: classes.dex */
final class cq extends m {
    public cq(long j) {
        super(SocketChannel.open(), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SocketAddress socketAddress) {
        ((SocketChannel) this.f321b.channel()).socket().bind(socketAddress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.f321b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.f321b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.f321b.isConnectable()) {
                    a(this.f321b, this.f320a);
                }
            } finally {
                if (this.f321b.isValid()) {
                    this.f321b.interestOps(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.f321b.channel();
        a("TCP write", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), bArr);
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.f321b.interestOps(4);
        int i = 0;
        while (i < bArr.length + 2) {
            try {
                if (this.f321b.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i += (int) write;
                    if (i < bArr.length + 2 && System.currentTimeMillis() > this.f320a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f321b, this.f320a);
                }
            } finally {
                if (this.f321b.isValid()) {
                    this.f321b.interestOps(0);
                }
            }
        }
    }

    private byte[] a(int i) {
        SocketChannel socketChannel = (SocketChannel) this.f321b.channel();
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f321b.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.f321b.isReadable()) {
                    long read = socketChannel.read(wrap);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) read;
                    if (i2 < i && System.currentTimeMillis() > this.f320a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f321b, this.f320a);
                }
            } finally {
                if (this.f321b.isValid()) {
                    this.f321b.interestOps(0);
                }
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() {
        byte[] a2 = a(2);
        byte[] a3 = a(((a2[0] & 255) << 8) + (a2[1] & 255));
        SocketChannel socketChannel = (SocketChannel) this.f321b.channel();
        a("TCP read", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), a3);
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) {
        cq cqVar = new cq(j);
        if (socketAddress != null) {
            try {
                cqVar.a(socketAddress);
            } finally {
                cqVar.a();
            }
        }
        cqVar.b(socketAddress2);
        cqVar.a(bArr);
        return cqVar.b();
    }
}
