package a.a.a.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Dns.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f358a = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};

    private static String[] b(Context context) {
        ConnectivityManager connectivityManager;
        Network[] allNetworks;
        LinkedList linkedList = new LinkedList();
        if (Build.VERSION.SDK_INT >= 21 && context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            connectivityManager.getActiveNetworkInfo();
            for (Network network : connectivityManager.getAllNetworks()) {
                connectivityManager.getNetworkInfo(network);
                for (InetAddress inetAddress : connectivityManager.getLinkProperties(network).getDnsServers()) {
                    linkedList.add(inetAddress.getHostAddress());
                }
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    private static String[] b() {
        String hostAddress;
        LinkedList linkedList = new LinkedList();
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1) {
                    String substring = readLine.substring(1, indexOf);
                    String substring2 = readLine.substring(indexOf + 4, readLine.length() - 1);
                    if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                        InetAddress byName = InetAddress.getByName(substring2);
                        if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                            linkedList.add(hostAddress);
                        }
                    }
                }
            }
        } catch (IOException unused) {
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static String[] a() {
        String hostAddress;
        a.a();
        LinkedList linkedList = new LinkedList();
        for (String str : f358a) {
            String a2 = a.a(str, "");
            if (a2 != null && !a2.isEmpty()) {
                try {
                    InetAddress byName = InetAddress.getByName(a2);
                    if (byName != null && (hostAddress = byName.getHostAddress()) != null && !hostAddress.isEmpty()) {
                        linkedList.add(hostAddress);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Dns.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static boolean f359a = false;

        /* renamed from: b  reason: collision with root package name */
        private static Method f360b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f361c;

        public static void a() {
            if (f359a) {
                return;
            }
            f359a = true;
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Method declaredMethod = cls.getDeclaredMethod("set", String.class, String.class);
                f361c = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod("get", String.class, String.class);
                f360b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (Throwable unused) {
            }
        }

        public static String a(String str, String str2) {
            Method method = f360b;
            if (method != null) {
                try {
                    return (String) method.invoke(null, str, str2);
                } catch (Throwable unused) {
                    return str2;
                }
            }
            return str2;
        }
    }

    public static String[] a(Context context) {
        String[] b2 = b(context);
        if (b2.length == 0) {
            String[] a2 = a();
            return a2.length == 0 ? b() : a2;
        }
        return b2;
    }

    public static List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        InetAddress[] inetAddressArr = new InetAddress[0];
        try {
            inetAddressArr = InetAddress.getAllByName(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        for (InetAddress inetAddress : inetAddressArr) {
            if (inetAddress instanceof Inet4Address) {
                arrayList.add(inetAddress.getHostAddress());
            }
        }
        return arrayList;
    }
}
