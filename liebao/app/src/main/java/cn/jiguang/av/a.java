package cn.jiguang.av;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a {
    public static Pair<c, ByteBuffer> a(Context context, byte[] bArr, String str) {
        ByteBuffer wrap;
        if (bArr.length < 20) {
            cn.jiguang.an.d.g("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        c cVar = new c(false, bArr2);
        cn.jiguang.an.d.b("JCommands", "parsed head - " + cVar.toString());
        int i = cVar.f3983a - 20;
        if (i < 0) {
            cn.jiguang.an.d.g("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        cn.jiguang.an.d.a("JCommands", "body size:" + i);
        if (TextUtils.isEmpty(str)) {
            str = b.a(context);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr, 20, bArr3, 0, i);
        cn.jiguang.an.d.b("JCommands", "decode algorithm:" + ((int) cVar.f3986d) + ", pwd:" + str);
        if (TextUtils.isEmpty(str)) {
            System.arraycopy(bArr, 20, bArr3, 0, i);
            wrap = ByteBuffer.wrap(bArr3);
        } else {
            try {
                wrap = ByteBuffer.wrap(cVar.f3986d == 2 ? new cn.jiguang.bb.c().b(bArr3, cn.jiguang.bb.c.a(str), str.substring(0, 16).getBytes("utf-8")) : cn.jiguang.bb.d.a(bArr3, str, str.substring(0, 16), false));
            } catch (Exception e2) {
                cn.jiguang.an.d.b("JCommands", "decryptBytes error:" + e2.getMessage());
                return null;
            }
        }
        return new Pair<>(cVar, wrap);
    }

    public static boolean a(Context context, byte[] bArr) {
        try {
            Pair<c, ByteBuffer> a2 = a(context, bArr, "");
            if (a2 != null) {
                long d2 = cn.jiguang.d.a.d(context);
                long j = ((c) a2.first).g;
                cn.jiguang.an.d.b("JCommands", "uid:" + d2 + ",msgUid:" + j + ",cmd:" + ((c) a2.first).f3985c);
                if (d2 == 0 || j == 0 || d2 == j) {
                    cn.jiguang.at.b.a();
                    cn.jiguang.at.b.a(context, (c) a2.first, (ByteBuffer) a2.second);
                    return true;
                }
                cn.jiguang.an.d.b("JCommands", "recv other app msg");
                cn.jiguang.e.a.a().a(context, j, bArr);
                return true;
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.an.d.g("JCommands", "dispatchMessage error:" + th.getMessage());
            return false;
        }
    }
}
