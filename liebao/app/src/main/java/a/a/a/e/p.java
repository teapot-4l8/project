package a.a.a.e;

import a.a.a.c.i.a;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/* compiled from: PortScanUDP.java */
/* loaded from: classes.dex */
public class p {
    public static a.C0002a a(InetAddress inetAddress, int i, int i2) {
        a.C0002a c0002a = new a.C0002a();
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        try {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[128], 128);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(i2);
            datagramSocket.connect(inetAddress, i);
            datagramSocket.send(datagramPacket);
            datagramSocket.isConnected();
            datagramSocket.receive(datagramPacket);
            datagramSocket.close();
            c0002a.a(true);
        } catch (SocketTimeoutException | Exception unused) {
        }
        c0002a.a(i);
        c0002a.a(System.currentTimeMillis() - valueOf.longValue());
        return c0002a;
    }
}
