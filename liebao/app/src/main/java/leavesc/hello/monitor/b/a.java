package leavesc.hello.monitor.b;

import java.util.Date;

/* compiled from: Converters.java */
/* loaded from: classes2.dex */
public class a {
    public static Date a(Long l) {
        if (l == null) {
            return null;
        }
        return new Date(l.longValue());
    }

    public static Long a(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }
}
