package cn.jiguang.n;

import android.text.TextUtils;
import cn.jiguang.v.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a {
    public static String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i & 255);
        stringBuffer.append('.');
        stringBuffer.append((i >> 8) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i >> 16) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i >> 24) & 255);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[1] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[2] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[3] & 255);
        return stringBuffer.toString();
    }

    public static List<cn.jiguang.m.a> a(String str) {
        cn.jiguang.m.a b2;
        List<String> a2 = f.a(new String[]{"cat /proc/net/arp"}, 1);
        if (a2 == null || a2.isEmpty()) {
            cn.jiguang.ad.a.d("JArpHelper", "execute command failed");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : a2) {
            if (!TextUtils.isEmpty(str2) && (b2 = b(str2)) != null && b2.f4138c.equals("0x2") && !str.equals(b2.f4136a) && !b2.f4139d.equals("00:00:00:00:00:00")) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    public static void a(String str, byte[] bArr) {
        new b(str, 300).a(bArr, 0, 255);
    }

    private static cn.jiguang.m.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        cn.jiguang.m.a aVar = new cn.jiguang.m.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i >= bytes.length - 1) {
                break;
            }
            i++;
            if (bytes[i] == 32) {
                int i4 = i - i2;
                if (i4 > 1) {
                    String str2 = new String(bytes, i2, i4);
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    aVar.f4139d = str2;
                                    break;
                                }
                            } else {
                                aVar.f4138c = str2;
                            }
                        } else {
                            aVar.f4137b = str2;
                        }
                    } else {
                        aVar.f4136a = str2;
                    }
                    i3++;
                }
                i2 = i + 1;
            }
        }
        return aVar;
    }
}
