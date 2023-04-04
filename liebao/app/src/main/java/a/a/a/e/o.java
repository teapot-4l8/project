package a.a.a.e;

import a.a.a.c.i.a;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* compiled from: PortScanTCP.java */
/* loaded from: classes.dex */
public class o {
    public static a.C0002a a(InetAddress inetAddress, int i, int i2) {
        a.C0002a c0002a = new a.C0002a();
        long currentTimeMillis = System.currentTimeMillis();
        Socket socket = null;
        try {
            try {
                Socket socket2 = new Socket();
                try {
                    socket2.connect(new InetSocketAddress(inetAddress, i), i2);
                    c0002a.a(true);
                    socket2.close();
                } catch (IOException unused) {
                    socket = socket2;
                    if (socket != null) {
                        socket.close();
                    }
                    c0002a.a(i);
                    c0002a.a(System.currentTimeMillis() - currentTimeMillis);
                    return c0002a;
                } catch (Throwable th) {
                    th = th;
                    socket = socket2;
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        c0002a.a(i);
        c0002a.a(System.currentTimeMillis() - currentTimeMillis);
        return c0002a;
    }
}
