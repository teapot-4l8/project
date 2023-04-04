package a.a.a.d;

/* compiled from: Section.java */
/* loaded from: classes.dex */
public final class ck {

    /* renamed from: a  reason: collision with root package name */
    private static ay f228a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f229b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f230c;

    static {
        ay ayVar = new ay("Message Section", 3);
        f228a = ayVar;
        f229b = new String[4];
        f230c = new String[4];
        ayVar.b(3);
        f228a.a(true);
        f228a.a(0, "qd");
        f228a.a(1, "an");
        f228a.a(2, "au");
        f228a.a(3, com.umeng.analytics.pro.ak.aw);
        String[] strArr = f229b;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = f230c;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i) {
        return f228a.c(i);
    }

    public static String b(int i) {
        f228a.a(i);
        return f229b[i];
    }

    public static String c(int i) {
        f228a.a(i);
        return f230c[i];
    }
}
