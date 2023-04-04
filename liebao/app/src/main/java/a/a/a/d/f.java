package a.a.a.d;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class f {
    public static String a(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static int a(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int a(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress a(InetAddress inetAddress, int i) {
        int i2;
        int a2 = a(a(inetAddress)) * 8;
        if (i < 0 || i > a2) {
            throw new IllegalArgumentException("invalid mask length");
        }
        if (i == a2) {
            return inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i3 = i / 8;
        int i4 = i3 + 1;
        while (true) {
            if (i4 >= address.length) {
                break;
            }
            address[i4] = 0;
            i4++;
        }
        int i5 = 0;
        for (i2 = 0; i2 < i % 8; i2++) {
            i5 |= 1 << (7 - i2);
        }
        address[i3] = (byte) (address[i3] & i5);
        try {
            return InetAddress.getByAddress(address);
        } catch (UnknownHostException unused) {
            throw new IllegalArgumentException("invalid address");
        }
    }
}
