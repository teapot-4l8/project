package kotlin.h;

/* compiled from: StringsJVM.kt */
/* loaded from: classes2.dex */
public class o extends n {
    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return g.a(str, str2, z);
    }

    public static final boolean a(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return g.a(str, str2, str3, z);
    }

    public static final String a(String str, String str2, String str3, boolean z) {
        kotlin.d.b.i.b(str, "$this$replace");
        kotlin.d.b.i.b(str2, "oldValue");
        kotlin.d.b.i.b(str3, "newValue");
        return kotlin.g.c.a(g.a(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return g.b(str, str2, z);
    }

    public static final boolean b(String str, String str2, boolean z) {
        kotlin.d.b.i.b(str, "$this$startsWith");
        kotlin.d.b.i.b(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return g.a(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean c(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return g.c(str, str2, z);
    }

    public static final boolean c(String str, String str2, boolean z) {
        kotlin.d.b.i.b(str, "$this$endsWith");
        kotlin.d.b.i.b(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return g.a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        kotlin.d.b.i.b(str, "$this$regionMatches");
        kotlin.d.b.i.b(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
