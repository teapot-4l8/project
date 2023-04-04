package b.a.k;

import android.util.Base64;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class b {
    public static String a(String str) {
        return a(str, 0);
    }

    public static String a(String str, int i) {
        try {
            return new String(Base64.decode(str, i), Charset.forName("UTF-8"));
        } catch (Exception unused) {
            return str;
        }
    }

    public static String b(String str, int i) {
        try {
            return new String(Base64.encode(str.getBytes(Charset.forName("UTF-8")), i), Charset.forName("UTF-8"));
        } catch (Exception unused) {
            return str;
        }
    }
}
