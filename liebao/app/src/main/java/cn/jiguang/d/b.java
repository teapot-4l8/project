package cn.jiguang.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.an.d;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Long f4045a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Long f4046b;

    public static long a(Context context, long j) {
        return (j + c(context)) / 1000;
    }

    public static boolean a(Context context) {
        String str;
        if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue() <= 0) {
            str = "isValidRegistered uid <= 0";
        } else if (!TextUtils.isEmpty((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.d()))) {
            return true;
        } else {
            str = "isValidRegistered regId is empty";
        }
        d.a("SpHelper", str);
        return false;
    }

    public static long b(Context context) {
        return a(context, System.currentTimeMillis());
    }

    public static void b(Context context, long j) {
        if (j > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            f4045a = Long.valueOf(j);
            f4046b = Long.valueOf(currentTimeMillis);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.h().a((cn.jiguang.g.a<Long>) Long.valueOf(j)), cn.jiguang.g.a.g().a((cn.jiguang.g.a<Long>) Long.valueOf(currentTimeMillis)));
        }
    }

    public static long c(Context context) {
        if (f4045a == null || f4046b == null) {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.g())).longValue();
            long longValue2 = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.h())).longValue();
            if (longValue == 0 || longValue2 == 0) {
                return 0L;
            }
            f4045a = Long.valueOf(longValue2);
            f4046b = Long.valueOf(longValue);
            return longValue2 - longValue;
        }
        return f4045a.longValue() - f4046b.longValue();
    }
}
