package cn.jiguang.av;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Integer f3982a;

    private static int a() {
        Integer num = f3982a;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(Math.abs(new SecureRandom().nextInt()));
        f3982a = valueOf;
        return valueOf.intValue();
    }

    public static String a(Context context) {
        long d2 = cn.jiguang.d.a.d(context);
        return d2 > 0 ? cn.jiguang.bb.d.a(d2) : cn.jiguang.bb.d.a(a());
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(int i, byte b2, long j, String str) {
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        bVar.b(0);
        bVar.a(0);
        bVar.b(j);
        bVar.a(str);
        return bVar.b();
    }

    public static byte[] a(long j, int i, long j2, short s) {
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        bVar.b(0);
        bVar.a(4);
        bVar.a(2);
        bVar.b(j);
        bVar.a(i);
        bVar.b(j2);
        bVar.a(1);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, long j2, String str, String str2, String str3, long j3, byte b2, int i, String str4, String str5, String str6, String str7) {
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        bVar.b(0);
        bVar.a(23);
        bVar.a(1);
        bVar.b(j);
        bVar.a(0L);
        bVar.b(j2);
        bVar.a(97);
        bVar.a(0);
        bVar.b(0);
        bVar.a(str);
        bVar.a(str3);
        bVar.a(str2);
        bVar.a(0);
        bVar.a(j3);
        bVar.a((int) b2);
        bVar.a(i);
        bVar.a(str4);
        bVar.a(str5);
        bVar.a(str6);
        bVar.a(str7);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, String str, String str2, String str3, String str4, long j2, String str5) {
        int a2 = a();
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        bVar.b(0);
        bVar.a(24);
        bVar.a(0);
        bVar.b(j);
        bVar.a(a2);
        bVar.b(0L);
        bVar.a(str);
        bVar.a(str2);
        bVar.a(str3);
        bVar.a(0);
        bVar.a(str4);
        bVar.a(j2);
        bVar.a(str5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, String str, long[] jArr) {
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                jSONArray.put(j);
                for (long j2 : jArr) {
                    jSONArray.put(j2);
                }
            }
            jSONObject.put("uids", jSONArray);
            cn.jiguang.an.d.b("CorePackage", "attach uids:" + jSONArray.toString());
            bVar.a(jSONObject.toString());
            return bVar.b();
        } catch (Throwable th) {
            cn.jiguang.an.d.f("CorePackage", "packageAttachInfo:" + th);
            return null;
        }
    }

    public static byte[] a(Context context, int i, int i2, long j, byte[] bArr, long j2) {
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        bVar.b(0);
        bVar.a(i2);
        bVar.a(i);
        bVar.b(j);
        bVar.a(JConstants.tcpSessionId);
        cn.jiguang.an.d.b("CorePackage", "packageSendData uid:" + j2);
        if (j2 == 0) {
            j2 = cn.jiguang.d.a.d(context);
            cn.jiguang.an.d.b("CorePackage", "use mine uid:" + j2);
        }
        bVar.b(j2);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return a(context, bVar.b());
    }

    public static byte[] a(Context context, byte[] bArr) {
        byte[] a2;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length - 24;
        byte[] bArr2 = new byte[24];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, 24);
        System.arraycopy(bArr, 24, bArr3, 0, length);
        String a3 = a(context);
        try {
            byte b2 = JConstants.tcpAlgorithm;
            cn.jiguang.an.d.b("CorePackage", "encryptBuf algorithm=" + ((int) b2) + ", key=" + a3);
            if (b2 == 2) {
                cn.jiguang.bb.c cVar = new cn.jiguang.bb.c();
                byte[] a4 = cn.jiguang.bb.c.a(a3);
                String substring = a3.substring(0, 16);
                cn.jiguang.an.d.b("SM4", "seed=" + a3);
                a2 = cVar.a(bArr3, a4, substring.getBytes("utf-8"));
            } else {
                a2 = cn.jiguang.bb.d.a(bArr3, a3, a3.substring(0, 16), true);
            }
            int length2 = a2.length + 24;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr4, 0, 24);
            System.arraycopy(a2, 0, bArr4, 24, a2.length);
            bArr4[0] = (byte) ((length2 >>> 8) & 255);
            bArr4[1] = (byte) (length2 & 255);
            bArr4[0] = (byte) (bArr4[0] | 128);
            bArr4[4] = b2;
            return bArr4;
        } catch (Exception e2) {
            cn.jiguang.an.d.f("CorePackage", "e:" + e2);
            cn.jiguang.an.d.g("CorePackage", "encrpt data failed");
            return null;
        }
    }

    public static byte[] a(String str, long[] jArr) {
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i <= 0; i++) {
                jSONArray.put(jArr[0]);
            }
            jSONObject.put("uids", jSONArray);
            bVar.a(jSONObject.toString());
            return bVar.b();
        } catch (Throwable th) {
            cn.jiguang.an.d.f("CorePackage", "packageDetachInfo:" + th);
            return null;
        }
    }

    public static byte[] a(short s, short s2, String str) {
        cn.jiguang.ay.b bVar = new cn.jiguang.ay.b(20480);
        bVar.a((int) s);
        bVar.a(1);
        bVar.a(str);
        return bVar.b();
    }
}
