package cn.jiguang.ar;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, cn.jiguang.aw.a aVar) {
        String str;
        String str2;
        String str3;
        byte[] a2;
        String str4;
        Pair<cn.jiguang.av.c, ByteBuffer> a3;
        long d2 = cn.jiguang.d.a.d(context);
        String k = cn.jiguang.f.i.k(cn.jiguang.d.a.f(context));
        String str5 = k == null ? "" : k;
        String a4 = cn.jiguang.am.a.a(context);
        cn.jiguang.at.b.a();
        String e2 = cn.jiguang.at.b.e();
        byte a5 = cn.jiguang.at.b.a(context);
        cn.jiguang.an.d.e("ConnectingHelper", "Login with - juid:" + d2 + ", appKey:" + a4 + ", sdkVersion:" + e2 + ", pluginPlatformType:" + ((int) a5));
        short c2 = cn.jiguang.at.b.c();
        int a6 = cn.jiguang.f.j.a(context);
        String a7 = cn.jiguang.bb.b.a(context);
        Object a8 = cn.jiguang.at.d.a(context, "get_loc_info", null);
        JSONObject jSONObject = new JSONObject();
        if (a8 instanceof Bundle) {
            try {
                Bundle bundle = (Bundle) a8;
                str = str5;
                str2 = a4;
                try {
                    jSONObject.put(com.umeng.analytics.pro.d.C, bundle.getDouble(com.umeng.analytics.pro.d.C, 200.0d));
                    jSONObject.put(com.umeng.analytics.pro.d.D, bundle.getDouble("lot", 200.0d));
                    jSONObject.put("time", bundle.getLong("time"));
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            String jSONObject2 = jSONObject.length() <= 0 ? jSONObject.toString() : "";
            str3 = !JCoreManager.isInternal() ? JConstants.testCountry : null;
            if (TextUtils.isEmpty(str3)) {
                str3 = cn.jiguang.f.a.l(context);
            }
            String b2 = cn.jiguang.f.i.b(String.format(Locale.ENGLISH, str3, new Object[0]));
            String upperCase = b2 != null ? "" : b2.toUpperCase();
            String c3 = cn.jiguang.d.a.c(context);
            cn.jiguang.an.d.b("ConnectingHelper", "login - juid:" + d2 + ", flag:" + ((int) c2) + " netType:" + a6 + " deviceId:" + a7 + " locInfo:" + jSONObject2 + " countryCode:" + upperCase + " accountId:" + c3 + ",sdkver:" + e2);
            byte[] a9 = cn.jiguang.av.b.a(b(context), d2, str, str2, e2, (long) c2, a5, a6, a7, jSONObject2, upperCase, c3);
            StringBuilder sb = new StringBuilder("pluginPlatformType:0b");
            sb.append(Integer.toBinaryString(a5 & 255));
            cn.jiguang.an.d.d("ConnectingHelper", sb.toString());
            a2 = cn.jiguang.av.b.a(context, a9);
            if (a2 == null && a2.length > 0 && aVar.a(a2) == 0) {
                try {
                    a3 = cn.jiguang.av.a.a(context, aVar.a(20000).array(), "");
                } catch (cn.jiguang.at.e e3) {
                    str4 = "Login failed - recv msg failed wit error:" + e3;
                }
                if (a3 == null || a3.first == null || a3.second == null || ((cn.jiguang.av.c) a3.first).f3985c != 1) {
                    str4 = "Login failed - can't parse a Login Response";
                    cn.jiguang.an.d.g("ConnectingHelper", str4);
                    return -1;
                }
                cn.jiguang.av.d dVar = new cn.jiguang.av.d((cn.jiguang.av.c) a3.first, (ByteBuffer) a3.second);
                cn.jiguang.an.d.b("ConnectingHelper", dVar.toString());
                int i = dVar.f3988a;
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.f().a((cn.jiguang.g.a<Integer>) Integer.valueOf(dVar.f3991d)));
                if (i == 0) {
                    JConstants.tcpSessionId = dVar.f3989b;
                    long j = dVar.f3990c * 1000;
                    cn.jiguang.ap.b.a(context, j);
                    cn.jiguang.ap.b.b(context, dVar.f3991d);
                    cn.jiguang.an.d.e("ConnectingHelper", "Login succeed - sid:" + JConstants.tcpSessionId + ", serverTime;" + j);
                } else {
                    cn.jiguang.an.d.g("ConnectingHelper", "Login failed with server error - code:" + cn.jiguang.ay.c.a(i));
                }
                return i;
            }
            return -1;
        }
        str = str5;
        str2 = a4;
        if (jSONObject.length() <= 0) {
        }
        if (!JCoreManager.isInternal()) {
        }
        if (TextUtils.isEmpty(str3)) {
        }
        String b22 = cn.jiguang.f.i.b(String.format(Locale.ENGLISH, str3, new Object[0]));
        if (b22 != null) {
        }
        String c32 = cn.jiguang.d.a.c(context);
        cn.jiguang.an.d.b("ConnectingHelper", "login - juid:" + d2 + ", flag:" + ((int) c2) + " netType:" + a6 + " deviceId:" + a7 + " locInfo:" + jSONObject2 + " countryCode:" + upperCase + " accountId:" + c32 + ",sdkver:" + e2);
        byte[] a92 = cn.jiguang.av.b.a(b(context), d2, str, str2, e2, (long) c2, a5, a6, a7, jSONObject2, upperCase, c32);
        StringBuilder sb2 = new StringBuilder("pluginPlatformType:0b");
        sb2.append(Integer.toBinaryString(a5 & 255));
        cn.jiguang.an.d.d("ConnectingHelper", sb2.toString());
        a2 = cn.jiguang.av.b.a(context, a92);
        if (a2 == null) {
        }
        return -1;
    }

    public static void a(Context context) {
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.I().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.J().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.d(false).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.d(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.N().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.K().a((cn.jiguang.g.a<Boolean>) null), cn.jiguang.g.a.L().a((cn.jiguang.g.a<Long>) null), cn.jiguang.g.a.b(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.b(false).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(false).a((cn.jiguang.g.a<String>) null));
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.c().a((cn.jiguang.g.a<Long>) null), cn.jiguang.g.a.d().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.e().a((cn.jiguang.g.a<String>) null));
    }

    private static synchronized byte[] a(String str, int i, byte[] bArr, boolean z, int i2) {
        byte[] b2;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str) || str.length() != 2 || bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("flag or body length error");
            }
            cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(300);
            bVar.b(0);
            bVar.a(str.getBytes());
            bVar.a(i);
            bVar.b(i2);
            bVar.a(bArr);
            bVar.b(bVar.a(), 0);
            bVar.a((int) ((byte) ((z ? 1 : 0) | 16)), 4);
            b2 = bVar.b();
        }
        return b2;
    }

    public static byte[] a(String str, String str2) {
        boolean z;
        byte[] a2;
        byte[] j = cn.jiguang.f.i.j(str2);
        try {
            a2 = cn.jiguang.f.k.a(j);
        } catch (IOException unused) {
        }
        if (a2.length < j.length) {
            j = a2;
            z = true;
            int length = j.length;
            int a3 = cn.jiguang.bb.d.a();
            String a4 = cn.jiguang.bb.d.a(a3);
            return a(str, a3, cn.jiguang.bb.d.a(j, a4, a4.substring(0, 16), true), z, length);
        }
        z = false;
        int length2 = j.length;
        int a32 = cn.jiguang.bb.d.a();
        String a42 = cn.jiguang.bb.d.a(a32);
        return a(str, a32, cn.jiguang.bb.d.a(j, a42, a42.substring(0, 16), true), z, length2);
    }

    public static byte[] a(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        datagramSocket.setSoTimeout(6000);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        cn.jiguang.an.d.c("ConnectingHelper", "udp Receiving...");
        datagramSocket.receive(datagramPacket2);
        int length = datagramPacket2.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, length);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new cn.jiguang.at.e(4, "response is empty!");
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.getShort();
            wrap.getShort();
            int i = wrap.getInt();
            int i2 = i >>> 24;
            long j = i & 16777215;
            wrap.getShort();
            int remaining = wrap.remaining();
            byte[] bArr2 = new byte[remaining];
            wrap.get(bArr2, 0, remaining);
            if (j != 0) {
                String a2 = cn.jiguang.bb.d.a(j);
                try {
                    bArr2 = cn.jiguang.bb.d.a(bArr2, a2, a2.substring(0, 16), false);
                    if (bArr2 == null) {
                        throw new cn.jiguang.at.e(5, "decrypt response error");
                    }
                } catch (Exception unused) {
                    throw new cn.jiguang.at.e(5, "decrypt response error");
                }
            }
            if ((i2 & 1) == 1) {
                try {
                    return cn.jiguang.f.k.b(bArr2);
                } catch (IOException unused2) {
                    return bArr2;
                }
            }
            return bArr2;
        } catch (Throwable th) {
            throw new cn.jiguang.at.e(4, "parse head error:" + th.getMessage());
        }
    }

    public static int b(Context context, cn.jiguang.aw.a aVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String a2 = cn.jiguang.ay.d.a(context);
        String str8 = cn.jiguang.ay.a.a(context).p;
        String str9 = b(a2, " ") + "$$" + b(str8, " ") + "$$" + context.getPackageName() + "$$" + cn.jiguang.am.a.a(context);
        String str10 = cn.jiguang.ay.a.a(context).f4012a;
        cn.jiguang.at.b.a();
        String d2 = cn.jiguang.at.b.d();
        cn.jiguang.an.d.b("ConnectingHelper", "regVersion:" + d2);
        cn.jiguang.ay.a a3 = cn.jiguang.ay.a.a(context);
        String str11 = b(a3.f4013b, " ") + "$$" + b(a3.f4014c, " ") + "$$" + b(a3.f4015d, " ") + "$$" + b(a3.f4016e, " ") + "$$" + b(cn.jiguang.am.a.b(context), " ") + "$$" + d2 + "$$" + a3.g + "$$" + a3.h;
        String str12 = cn.jiguang.ay.a.a(context).j;
        if ("unknown".equalsIgnoreCase(str12)) {
            str12 = " ";
        }
        String a4 = cn.jiguang.bb.b.a(context);
        int i = cn.jiguang.bb.b.f4041a;
        String str13 = cn.jiguang.ay.a.a(context).f4017q;
        String str14 = cn.jiguang.ay.a.a(context).i;
        String str15 = "";
        String f = cn.jiguang.d.a.i(context) ? cn.jiguang.f.a.f(context, "") : "";
        Object a5 = cn.jiguang.at.d.a(context, "get_all_ids", null);
        if (a5 == null || !(a5 instanceof JSONObject)) {
            str = str11;
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = "ConnectingHelper";
            str7 = str5;
        } else {
            cn.jiguang.an.d.b("ConnectingHelper", "parse ids:" + a5.toString());
            JSONObject jSONObject = (JSONObject) a5;
            String optString = jSONObject.optString("udid", "");
            String optString2 = jSONObject.optString("oaid", "");
            String optString3 = jSONObject.optString("vaid", "");
            String optString4 = jSONObject.optString("aaid", "");
            String optString5 = jSONObject.optString("gadid", "");
            str3 = optString3;
            str6 = "ConnectingHelper";
            str7 = optString2;
            str4 = optString4;
            str = str11;
            str15 = optString5;
            str2 = optString;
            str5 = "";
        }
        String str16 = i + "$$" + b(a4, " ") + "$$" + b(str13, " ") + "$$" + b(str14, " ") + "$$" + b(f, " ") + "$$" + b(str12, " ") + "$$" + b(str2, " ") + "$$" + b(str7, " ") + "$$" + b(str3, " ") + "$$" + b(str4, " ") + "$$" + b(str15, " ");
        cn.jiguang.at.b.a();
        long b2 = cn.jiguang.at.b.b();
        String c2 = cn.jiguang.d.a.c(context);
        StringBuilder sb = new StringBuilder("Register with: key:");
        sb.append(str9);
        sb.append(", apkVersion:");
        sb.append(str10);
        sb.append(", clientInfo:");
        String str17 = str;
        sb.append(str17);
        sb.append(", extKey:");
        sb.append(str16);
        sb.append(",reg business:");
        sb.append(b2);
        sb.append(" accountId:");
        sb.append(c2);
        String str18 = str6;
        cn.jiguang.an.d.b(str18, sb.toString());
        String str19 = str5;
        byte[] a6 = cn.jiguang.av.b.a(context, cn.jiguang.av.b.a(b(context), str9, str10, str17, str16, b2, c2));
        if (a6 == null) {
            cn.jiguang.an.d.g(str18, "Register failed - encrytor reg info failed");
            return -1;
        } else if (aVar.a(a6) != 0) {
            cn.jiguang.an.d.g(str18, "Register failed - send reg info failed");
            return -1;
        } else {
            try {
                Pair<cn.jiguang.av.c, ByteBuffer> a7 = cn.jiguang.av.a.a(context, aVar.a(20000).array(), str19);
                if (a7 == null || a7.first == null || a7.second == null || ((cn.jiguang.av.c) a7.first).f3985c != 0) {
                    cn.jiguang.an.d.g(str18, "Register failed - can't parse a Register Response");
                    return -1;
                }
                cn.jiguang.av.e eVar = new cn.jiguang.av.e((cn.jiguang.av.c) a7.first, (ByteBuffer) a7.second);
                cn.jiguang.an.d.b(str18, "register response:" + eVar);
                int i2 = eVar.f3993a;
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.A().a((cn.jiguang.g.a<Integer>) Integer.valueOf(i2)));
                if (i2 == 0) {
                    long j = eVar.f3994b;
                    String str20 = eVar.f3995c;
                    String str21 = eVar.f3996d;
                    String str22 = eVar.f3997e;
                    cn.jiguang.an.d.e(str18, "Register succeed - juid:" + j + ", registrationId:" + str21 + ", deviceId:" + str22);
                    if (cn.jiguang.f.i.a(str21) || 0 == j) {
                        cn.jiguang.an.d.i(str18, "Unexpected: registrationId/juid should not be empty. ");
                        return -1;
                    }
                    cn.jiguang.ap.b.a(context, str22);
                    cn.jiguang.ap.b.a(context, j, str20, str21);
                }
                return i2;
            } catch (cn.jiguang.at.e e2) {
                cn.jiguang.an.d.g(str18, "Register failed - recv msg failed with error:" + e2);
                return -1;
            }
        }
    }

    public static synchronized long b(Context context) {
        long j;
        synchronized (c.class) {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.G())).longValue();
            if (longValue == -1) {
                longValue = Math.abs(new Random().nextInt(10000));
            }
            j = (longValue + (longValue % 2 == 0 ? 1L : 2L)) % 10000;
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.G().a((cn.jiguang.g.a<Long>) Long.valueOf(j)));
        }
        return j;
    }

    private static String b(String str, String str2) {
        return !cn.jiguang.f.i.a(str) ? str : str2;
    }
}
