package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6268a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6269b = true;

    /* renamed from: c  reason: collision with root package name */
    private static SimpleDateFormat f6270c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f6271d = 30720;

    /* renamed from: e  reason: collision with root package name */
    private static StringBuilder f6272e = null;
    private static StringBuilder f = null;
    private static boolean g = false;
    private static a h = null;
    private static String i = null;
    private static String j = null;
    private static Context k = null;
    private static String l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;

    /* renamed from: q  reason: collision with root package name */
    private static final Object f6273q = new Object();

    static {
        try {
            f6270c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            x.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (y.class) {
            if (m || context == null || !f6268a) {
                return;
            }
            try {
                o = Executors.newSingleThreadExecutor();
                f = new StringBuilder(0);
                f6272e = new StringBuilder(0);
                k = context;
                com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                i = a2.f6008d;
                a2.getClass();
                j = "";
                l = k.getFilesDir().getPath() + "/buglylog_" + i + "_" + j + ".txt";
                p = Process.myPid();
            } catch (Throwable unused) {
            }
            m = true;
        }
    }

    public static void a(int i2) {
        synchronized (f6273q) {
            f6271d = i2;
            if (i2 < 0) {
                f6271d = 0;
            } else if (i2 > 30720) {
                f6271d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + z.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (y.class) {
            if (m && f6268a) {
                try {
                    o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.y.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            y.c(str, str2, str3);
                        }
                    });
                } catch (Exception e2) {
                    x.b(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2, String str3) {
        synchronized (y.class) {
            if (f6269b) {
                d(str, str2, str3);
            } else {
                e(str, str2, str3);
            }
        }
    }

    private static synchronized void d(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (f6273q) {
                f.append(a2);
                if (f.length() >= f6271d) {
                    f = f.delete(0, f.indexOf("\u0001\r\n") + 1);
                }
            }
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (f6273q) {
                try {
                    f.append(a2);
                } catch (Throwable unused) {
                }
                if (f.length() <= f6271d) {
                    return;
                }
                if (g) {
                    return;
                }
                g = true;
                if (h == null) {
                    h = new a(l);
                } else if (h.f6278b == null || h.f6278b.length() + f.length() > h.f6281e) {
                    h.a();
                }
                if (h.a(f.toString())) {
                    f.setLength(0);
                    g = false;
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String date;
        f6272e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f6270c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f6272e;
        sb.append(date);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f6272e.toString();
    }

    public static byte[] a() {
        if (f6269b) {
            if (f6268a) {
                return z.a((File) null, f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return b();
    }

    private static byte[] b() {
        if (f6268a) {
            StringBuilder sb = new StringBuilder();
            synchronized (f6273q) {
                if (h != null && h.f6277a && h.f6278b != null && h.f6278b.length() > 0) {
                    sb.append(z.a(h.f6278b, 30720, true));
                }
                if (f != null && f.length() > 0) {
                    sb.append(f.toString());
                }
            }
            return z.a((File) null, sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6277a;

        /* renamed from: b  reason: collision with root package name */
        private File f6278b;

        /* renamed from: c  reason: collision with root package name */
        private String f6279c;

        /* renamed from: d  reason: collision with root package name */
        private long f6280d;

        /* renamed from: e  reason: collision with root package name */
        private long f6281e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f6279c = str;
            this.f6277a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.f6279c);
                this.f6278b = file;
                if (file.exists() && !this.f6278b.delete()) {
                    this.f6277a = false;
                    return false;
                } else if (this.f6278b.createNewFile()) {
                    return true;
                } else {
                    this.f6277a = false;
                    return false;
                }
            } catch (Throwable th) {
                x.a(th);
                this.f6277a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            byte[] bytes;
            if (this.f6277a) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(this.f6278b, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f6280d += bytes.length;
                    this.f6277a = true;
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        x.a(th);
                        this.f6277a = false;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            return false;
        }
    }
}
