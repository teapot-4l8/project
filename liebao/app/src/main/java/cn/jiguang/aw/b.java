package cn.jiguang.aw;

import cn.jiguang.an.d;
import cn.jiguang.at.e;
import cn.jiguang.f.k;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends a {
    private final int g;
    private ByteBuffer h = ByteBuffer.allocate(8192);

    public b(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    private boolean b(byte[] bArr) {
        try {
            if (!a()) {
                d.b("NioSocketClient", "send error - connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                int write = this.f3999b.write(ByteBuffer.wrap(bArr));
                if (write > 0) {
                    d.a("NioSocketClient", "isWritable has send len:" + write);
                    return true;
                } else if (write < 0) {
                    d.a("NioSocketClient", "isWritable error:" + write);
                    return false;
                } else {
                    return true;
                }
            }
            d.b("NioSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e2) {
            d.g("NioSocketClient", "send data error:" + e2);
            close();
            return false;
        }
    }

    @Override // cn.jiguang.aw.a
    public final synchronized int a(String str, int i) {
        super.a(str, i);
        this.f3999b = SocketChannel.open();
        this.f4001d = Selector.open();
        this.f3999b.configureBlocking(false);
        this.f3999b.connect(new InetSocketAddress(str, i));
        d.b("NioSocketClient", "tcp connecting...");
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.f3999b.finishConnect()) {
            if (!this.f4002e) {
                d.b("NioSocketClient", "has close channel when connect...");
                return -991;
            }
            Thread.sleep(10L);
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                close();
                return -994;
            }
        }
        if (!this.f4002e) {
            d.b("NioSocketClient", "has close channel when connected...");
            return -991;
        }
        d.b("NioSocketClient", "tcp connected");
        this.f3999b.register(this.f4001d, 1);
        return 0;
    }

    @Override // cn.jiguang.aw.a
    public final int a(byte[] bArr) {
        if (bArr == null) {
            d.b("NioSocketClient", "sendData failed, send data was null");
            return 103;
        }
        d.b("NioSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.g) {
            return b(bArr) ? 0 : 103;
        }
        d.b("NioSocketClient", "sendData failed, data length must less than " + this.g);
        return 6026;
    }

    @Override // cn.jiguang.aw.a
    public final ByteBuffer a(int i) {
        ByteBuffer b2;
        try {
            if (a()) {
                int b3 = b();
                if (b3 <= 0 || (b2 = b(b3)) == null) {
                    int i2 = 0;
                    int i3 = 1048576;
                    while (a() && this.f4000c < i3) {
                        int select = i > 0 ? this.f4001d.select(i) : this.f4001d.select();
                        if (select == 0) {
                            d.b("NioSocketClient", "readSelect:" + select + ",time out:" + i);
                            if (i > 0) {
                                throw new e(-994, "recv time out");
                            }
                        } else {
                            Iterator<SelectionKey> it = this.f4001d.selectedKeys().iterator();
                            while (it.hasNext()) {
                                SelectionKey next = it.next();
                                SocketChannel socketChannel = (SocketChannel) next.channel();
                                if (next.isReadable()) {
                                    int read = socketChannel.read(this.h);
                                    if (read < 0) {
                                        throw new e(-996, "read len < 0:" + read);
                                    }
                                    this.h.flip();
                                    int limit = this.h.limit();
                                    if (this.f3998a.remaining() < limit) {
                                        throw new e(-996, "the total buf remaining less than readLen,remaining:" + this.f3998a.remaining() + ",readLen:" + limit);
                                    }
                                    this.f3998a.put(this.h);
                                    this.f4000c += limit;
                                    this.h.compact();
                                    if (this.f4000c < this.f) {
                                        d.b("NioSocketClient", "totalbuf can not parse head:" + this.f4000c + ",peerNetData len:" + limit + ",read:" + read);
                                    } else {
                                        i3 = b();
                                    }
                                    i2 = limit;
                                } else {
                                    next.isWritable();
                                }
                                it.remove();
                            }
                            continue;
                        }
                    }
                    if (i3 != 1048576) {
                        d.b("NioSocketClient", "read len:" + i2 + ",recvTotalLen:" + this.f4000c + ",shouldLen:" + i3);
                        ByteBuffer b4 = b(i3);
                        if (b4 != null) {
                            return b4;
                        }
                        throw new e(-1001, "parse error");
                    }
                    throw new e(-997, "recv empty data or tcp has close");
                }
                return b2;
            }
            throw new e(-991, "recv error,the connect is invalid");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                throw new e(-994, th.getMessage());
            }
            if (th instanceof e) {
                throw th;
            }
            throw new e(-997, th.getMessage());
        }
    }

    @Override // cn.jiguang.aw.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d.b("NioSocketClient", "close this connect");
        super.close();
        if (this.f4001d != null) {
            try {
                this.f4001d.close();
            } catch (IOException unused) {
            }
        }
        k.a(this.f3999b);
        this.f3999b = null;
    }
}
