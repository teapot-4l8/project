package cn.jiguang.v;

import android.text.TextUtils;
import cn.jiguang.f.i;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static long f4239a = 1;

    public static long a() {
        long j = f4239a + 1;
        f4239a = j;
        if (j >= 2147483647L) {
            f4239a = 1L;
        }
        return f4239a;
    }

    public static byte[] a(long j, String str) {
        cn.jiguang.w.a aVar = new cn.jiguang.w.a(20480);
        aVar.a(0);
        aVar.a(j);
        if (str != null && !TextUtils.isEmpty(str)) {
            byte[] j2 = i.j(str);
            aVar.a(j2.length);
            aVar.a(j2, 0, j2.length);
        }
        return aVar.a();
    }
}
