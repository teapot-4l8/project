package a.a.a.e;

import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Base.java */
/* loaded from: classes.dex */
public class a {
    public static boolean a(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String a() {
        String e2 = a.a.a.a.a().e();
        try {
            return new URL(e2).getHost();
        } catch (Exception e3) {
            e3.printStackTrace();
            return e2;
        }
    }
}
