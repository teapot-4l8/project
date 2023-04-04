package cn.jpush.android.m;

import android.content.Context;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.d;
import cn.jpush.android.u.f;

/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f4385a = {117, 125, 89, 80, 123, 103, 119, 99, 84};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f4386b = {65, 119, 108, 100, 126, 89, 68, 55, 107, 121, Byte.MAX_VALUE, 68, 69, 119, 124, 56, 82, 92, 73, 105, 76, 119, 101, 81};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f4387c = {78, 124, Byte.MAX_VALUE, 70, 125, 81, 73, 119, 92, 115, 105, 68};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f4388d = {123, 115, 101, 96, 82, 112, 101, 119, 99, 73, 99, 117, 97, 102};

    public static Object a(Context context) {
        return context.getSystemService(d.b(f4385a));
    }

    public static Object a(String str) {
        try {
            return f.a(Class.forName(d.b(f4386b)), d.b(f4387c), new Object[]{"", str}, new Class[]{CharSequence.class, CharSequence.class});
        } catch (Throwable th) {
            Logger.w("CopyGuard", "newData e:" + th);
            return null;
        }
    }

    public static void a(Object obj, Object obj2) {
        try {
            f.a(obj, d.b(f4388d), new Class[]{Class.forName(d.b(f4386b))}, new Object[]{obj2});
        } catch (Throwable th) {
            Logger.w("CopyGuard", "setData e:" + th);
        }
    }
}
