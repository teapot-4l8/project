package a.a.a.e;

import android.util.Log;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Pattern;

/* compiled from: IPTools.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f369a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f370b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f371c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static boolean a(InetAddress inetAddress) {
        if (inetAddress == null) {
            return false;
        }
        if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
            return true;
        }
        try {
            return NetworkInterface.getByInetAddress(inetAddress) != null;
        } catch (SocketException unused) {
            return false;
        }
    }

    public static boolean b(InetAddress inetAddress) {
        return inetAddress != null && inetAddress.isSiteLocalAddress();
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            str = hexString.length() < 2 ? str + "0" + hexString : str + hexString;
        }
        return str;
    }

    public static String[] a() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                String str = "";
                if (nextElement.getHardwareAddress() != null && nextElement.getHardwareAddress().length > 0) {
                    str = a(nextElement.getHardwareAddress());
                }
                Log.d("222222222333333333-ni", nextElement.toString() + "hardwareAddress" + str + "MTU" + nextElement.getMTU() + "flags" + nextElement.supportsMulticast());
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    String hostAddress = nextElement2.getHostAddress();
                    String hostName = nextElement2.getHostName();
                    String canonicalHostName = nextElement2.getCanonicalHostName();
                    Log.d("222222-hostAddress", hostAddress);
                    Log.d("222222-hostName", hostName);
                    Log.d("22222-nicalHostName", canonicalHostName);
                    arrayList.add("name: " + nextElement.getName() + "\r\nhostAddress: " + hostAddress + "\r\ncanonicalHostName: " + canonicalHostName);
                }
            }
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        int size = arrayList.size();
        if (size > 0) {
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = (String) arrayList.get(i);
            }
            return strArr;
        }
        return null;
    }
}
