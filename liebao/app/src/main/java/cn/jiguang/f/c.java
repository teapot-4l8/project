package cn.jiguang.f;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4069b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f4070c = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public static String f4068a = "yyyyMMdd_HHmm";

    public static String a() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static String a(long j) {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date(j));
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f4070c.get(str);
        if (threadLocal == null) {
            synchronized (f4069b) {
                threadLocal = f4070c.get(str);
                if (threadLocal == null) {
                    threadLocal = new d(str);
                    f4070c.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static boolean a(Date date, int i) {
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date.getTime());
        calendar.roll(6, -2);
        return calendar.after(calendar2);
    }

    public static String b() {
        return a(f4068a).format(new Date());
    }

    public static Date b(String str) {
        try {
            return a(f4068a).parse(str);
        } catch (ParseException e2) {
            cn.jiguang.an.d.b("DateUtil", "parse filename datetime error - " + str, e2);
            return null;
        }
    }
}
