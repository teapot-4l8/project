package a.a.a.e;

import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Date.java */
/* loaded from: classes.dex */
public class b {
    public static String a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }
}
