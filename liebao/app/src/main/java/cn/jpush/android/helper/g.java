package cn.jpush.android.helper;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static long f4362a = 1;

    public static long a() {
        long j = f4362a + 1;
        f4362a = j;
        if (j >= 2147483647L) {
            f4362a = 1L;
        }
        return f4362a;
    }
}
