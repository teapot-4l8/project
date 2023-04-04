package a.a.a.d;

import java.io.EOFException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.security.SecureRandom;

/* compiled from: UDPClient.java */
/* loaded from: classes.dex */
final class dc extends m {

    /* renamed from: c  reason: collision with root package name */
    private static SecureRandom f277c = new SecureRandom();

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f278d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f279e;

    static {
        new Thread(new Runnable() { // from class: a.a.a.d.dc.1
            @Override // java.lang.Runnable
            public void run() {
                dc.f277c.nextInt();
                boolean unused = dc.f278d = false;
            }
        }).start();
    }

    public dc(long j) {
        super(DatagramChannel.open(), j);
        this.f279e = false;
    }

    private void a(InetSocketAddress inetSocketAddress) {
        InetSocketAddress inetSocketAddress2;
        if (f278d) {
            try {
                Thread.sleep(2L);
            } catch (InterruptedException unused) {
            }
            if (f278d) {
                return;
            }
        }
        DatagramChannel datagramChannel = (DatagramChannel) this.f321b.channel();
        for (int i = 0; i < 1024; i++) {
            try {
                int nextInt = f277c.nextInt(64511) + 1024;
                if (inetSocketAddress != null) {
                    inetSocketAddress2 = new InetSocketAddress(inetSocketAddress.getAddress(), nextInt);
                } else {
                    inetSocketAddress2 = new InetSocketAddress(nextInt);
                }
                datagramChannel.socket().bind(inetSocketAddress2);
                this.f279e = true;
                return;
            } catch (SocketException unused2) {
            }
        }
    }

    void a(SocketAddress socketAddress) {
        if (socketAddress == null || ((socketAddress instanceof InetSocketAddress) && ((InetSocketAddress) socketAddress).getPort() == 0)) {
            a((InetSocketAddress) socketAddress);
            if (this.f279e) {
                return;
            }
        }
        if (socketAddress != null) {
            ((DatagramChannel) this.f321b.channel()).socket().bind(socketAddress);
            this.f279e = true;
        }
    }

    void b(SocketAddress socketAddress) {
        if (!this.f279e) {
            a((SocketAddress) null);
        }
        ((DatagramChannel) this.f321b.channel()).connect(socketAddress);
    }

    void a(byte[] bArr) {
        DatagramChannel datagramChannel = (DatagramChannel) this.f321b.channel();
        a("UDP write", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr);
        datagramChannel.write(ByteBuffer.wrap(bArr));
    }

    byte[] a(int i) {
        DatagramChannel datagramChannel = (DatagramChannel) this.f321b.channel();
        byte[] bArr = new byte[i];
        this.f321b.interestOps(1);
        while (true) {
            try {
                if (this.f321b.isReadable()) {
                    break;
                }
                a(this.f321b, this.f320a);
            } finally {
                if (this.f321b.isValid()) {
                    this.f321b.interestOps(0);
                }
            }
        }
        long read = datagramChannel.read(ByteBuffer.wrap(bArr));
        if (read <= 0) {
            throw new EOFException();
        }
        int i2 = (int) read;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        a("UDP read", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr2);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, int i, long j) {
        dc dcVar = new dc(j);
        try {
            dcVar.a(socketAddress);
            dcVar.b(socketAddress2);
            dcVar.a(bArr);
            return dcVar.a(i);
        } finally {
            dcVar.a();
        }
    }
}
