package cn.jiguang.au;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.an.d;
import cn.jiguang.f.i;
import cn.jiguang.f.j;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f3979a;

    /* renamed from: b  reason: collision with root package name */
    private static c f3980b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f3981c = new HashMap();

    private c() {
    }

    private static int a(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            boolean z2 = false;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!i.a(nextElement.getName(), "dummy")) {
                    boolean a2 = i.a(nextElement.getName(), "wlan");
                    if (!z || a2) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && a(nextElement2)) {
                                if (a2) {
                                    return 3;
                                }
                                z2 = true;
                            }
                        }
                        continue;
                    }
                }
            }
            return z2 ? 0 : 1;
        } catch (Exception unused) {
            d.f("IpvxHelper", "checkIpvxSupport:");
            return 0;
        }
    }

    public static c a() {
        if (f3980b == null) {
            synchronized (c.class) {
                if (f3980b == null) {
                    f3980b = new c();
                }
            }
        }
        return f3980b;
    }

    public static void a(int i) {
        if (i > 3 || i < 0) {
            return;
        }
        f3979a = i;
    }

    private static boolean a(InetAddress inetAddress) {
        try {
            if (inetAddress instanceof Inet6Address) {
                if (!inetAddress.getHostAddress().substring(0, 4).equalsIgnoreCase("fe80")) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int b(int i) {
        int i2 = f3979a;
        if (i2 == 2 || i2 == 1) {
            return f3979a;
        }
        if (i != 1) {
            if (i != 2) {
                return i2;
            }
            return 2;
        }
        return 1;
    }

    public final int a(Context context) {
        int i;
        int i2 = 0;
        try {
            String c2 = j.c(context);
            String str = "";
            boolean equals = "wifi".equals(c2);
            if (equals && cn.jiguang.d.a.i(context)) {
                str = cn.jiguang.f.a.k(context);
            }
            boolean z = !TextUtils.isEmpty(str);
            if (!equals || z) {
                Integer num = this.f3981c.get(c2 + str);
                if (num != null && num.intValue() != 0) {
                    d.b("IpvxHelper", "net=" + c2 + " " + str + " get cache support=" + num);
                    return num.intValue();
                }
            }
            if (z) {
                i = ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.g(str))).intValue();
                try {
                    d.b("IpvxHelper", "net=" + c2 + " " + str + " get wifi history support=" + i);
                } catch (Throwable th) {
                    th = th;
                    i2 = i;
                    d.f("IpvxHelper", "getPreferVx e:" + th);
                    return i2;
                }
            } else {
                i = 0;
            }
            if (i == 0) {
                i = a(equals);
                d.b("IpvxHelper", "net=" + c2 + " " + str + " get networkinterface support=" + i);
                if (z) {
                    cn.jiguang.g.b.a(context, cn.jiguang.g.a.g(str).a((cn.jiguang.g.a<Integer>) Integer.valueOf(i)));
                }
            }
            i2 = i;
            if (!equals || z) {
                this.f3981c.put(c2 + str, Integer.valueOf(i2));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return i2;
    }

    public final void a(Context context, int i) {
        String c2 = j.c(context);
        boolean equals = "wifi".equals(c2);
        String k = (equals && cn.jiguang.d.a.i(context)) ? cn.jiguang.f.a.k(context) : "";
        boolean z = !TextUtils.isEmpty(k);
        if (!equals || z) {
            this.f3981c.put(c2 + k, Integer.valueOf(i));
        }
        if (z) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.g(k).a((cn.jiguang.g.a<Integer>) Integer.valueOf(i)));
        }
    }
}
