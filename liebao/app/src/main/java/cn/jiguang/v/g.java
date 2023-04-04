package cn.jiguang.v;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4240a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f4241b = new ConcurrentHashMap<>();

    public static String a(long j) {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date(j));
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f4241b.get(str);
        if (threadLocal == null) {
            synchronized (f4240a) {
                threadLocal = f4241b.get(str);
                if (threadLocal == null) {
                    threadLocal = new h(str);
                    f4241b.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(long j, long j2) {
        if (j2 > 0) {
            return j <= 0 || System.currentTimeMillis() > j + j2;
        }
        throw new AssertionError();
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(byteArrayOutputStream);
            a(gZIPOutputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            a(byteArrayOutputStream);
            a(gZIPOutputStream2);
            throw th;
        }
    }
}
