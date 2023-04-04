package androidx.work;

import java.util.List;

/* compiled from: InputMerger.java */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2795a = h.a("InputMerger");

    public abstract e a(List<e> list);

    public static g a(String str) {
        try {
            return (g) Class.forName(str).newInstance();
        } catch (Exception e2) {
            h a2 = h.a();
            String str2 = f2795a;
            a2.e(str2, "Trouble instantiating + " + str, e2);
            return null;
        }
    }
}
