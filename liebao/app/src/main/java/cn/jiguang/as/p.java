package cn.jiguang.as;

import com.umeng.analytics.pro.ak;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static g f3919a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f3920b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f3921c;

    static {
        g gVar = new g("Message Section", 3);
        f3919a = gVar;
        f3920b = new String[4];
        f3921c = new String[4];
        gVar.a(3);
        f3919a.a(true);
        f3919a.a(0, "qd");
        f3919a.a(1, "an");
        f3919a.a(2, "au");
        f3919a.a(3, ak.aw);
        String[] strArr = f3920b;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = f3921c;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i) {
        return f3919a.b(i);
    }
}
