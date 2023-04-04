package cn.jiguang.p;

import android.content.Context;
import cn.jiguang.f.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f4178a = {117, 125, 89, 80, 123, 103, 119, 99, 84};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f4179b = {122, 115, 124, 95, 86, 124, 88, 100, 120, 93, 65, 107, 113, 85, 125, 89, 80, 90, 96, 119, Byte.MAX_VALUE, 87, 69, 125, 68, Byte.MAX_VALUE, 98, 68, 69, 119, 109, 100};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f4180c = {81, 68, 125, 88, 100, 120, 93, 65, 107, 113, 85, 125, 89, 80, 90, 96, 119, Byte.MAX_VALUE, 87, 69, 125, 68, Byte.MAX_VALUE, 98, 68, 69, 119, 109, 100};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f4181d = {120, 102, 114, 99, 95, 73, 125, 38, 117, 126, 94, 84, 124, 102, 98, 63, 115, 76, 112, 120, 116, 126, 81, 82, 125, 69, 119, Byte.MAX_VALUE, 81, 71, 124, 122, 50, 94, 94, 112, 107, 97, 123, 112, 66, 89, 90, 100, Byte.MAX_VALUE, 97, 115, 72, 120, 102, 113, 116, 84, 108, 112, 123, 98, 116, 94, 69, 107};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f4182e = {103, 120, 65, 66, 73, 116, 105, 100, 104, 115, 76, 112, 120, 85, 121, 81, 78, 126, 109, 114};
    private static final byte[] f = {111, 115, 101, 96, 82, 112, 101, 119, 99, 73, 99, 117, 97, 102};
    private static final byte[] g = {113, 116, 68, 105, 109, 109, 123, 80, 68};
    private static final byte[] h = {67, 118, 109, 100, 114, 85, 116, 118, 92, 115, 105, 68};
    private static final byte[] i = {111, 115, 101, 116, 69, 106, 107, 100, 120, 64, 84, 112, 103, 120};
    private static final byte[] j = {71, 124, 124, 66, 120, 93, 69, 106, 124, 119, 124, 64};

    public static Object a(Context context) {
        return context.getSystemService(cn.jiguang.v.a.a(f4178a));
    }

    public static Object a(Object obj) {
        try {
            return h.a(obj, cn.jiguang.v.a.a(i), new Object[0], new Class[0]);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyGuard", "getDesc failed e:" + th);
            return null;
        }
    }

    public static String a(Context context, Object obj) {
        try {
            return h.a(h.a(obj, cn.jiguang.v.a.a(g), new Object[]{0}, new Class[]{Integer.TYPE}), cn.jiguang.v.a.a(h), new Object[]{context}, new Class[]{Context.class}).toString();
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyGuard", "getString failed e:" + th);
            return null;
        }
    }

    public static long b(Object obj) {
        try {
            Object a2 = h.a(obj, cn.jiguang.v.a.a(j), new Object[0], new Class[0]);
            if (a2 instanceof Long) {
                return ((Long) a2).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyGuard", "getTime failed e:" + th);
            return 0L;
        }
    }

    public static Object c(Object obj) {
        try {
            return h.a(obj, cn.jiguang.v.a.a(f), new Object[0], new Class[0]);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("CopyGuard", "getCopy failed e:" + th);
            return null;
        }
    }
}
