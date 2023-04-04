package a.a.a.d;

import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* compiled from: Client.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: c  reason: collision with root package name */
    private static br f319c;

    /* renamed from: a  reason: collision with root package name */
    protected long f320a;

    /* renamed from: b  reason: collision with root package name */
    protected SelectionKey f321b;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(SelectableChannel selectableChannel, long j) {
        Selector selector;
        this.f320a = j;
        try {
            selector = Selector.open();
        } catch (Throwable th) {
            th = th;
            selector = null;
        }
        try {
            selectableChannel.configureBlocking(false);
            this.f321b = selectableChannel.register(selector, 1);
        } catch (Throwable th2) {
            th = th2;
            if (selector != null) {
                selector.close();
            }
            selectableChannel.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(SelectionKey selectionKey, long j) {
        int selectNow;
        long currentTimeMillis = j - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            selectNow = selectionKey.selector().select(currentTimeMillis);
        } else {
            selectNow = currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0;
        }
        if (selectNow == 0) {
            throw new SocketTimeoutException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr) {
        if (bo.b("verbosemsg")) {
            System.err.println(a.a.a.d.a.d.a(str, bArr));
        }
        br brVar = f319c;
        if (brVar != null) {
            brVar.a(str, socketAddress, socketAddress2, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f321b.selector().close();
        this.f321b.channel().close();
    }
}
