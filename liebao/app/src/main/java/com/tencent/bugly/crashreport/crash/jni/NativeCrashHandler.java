package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {

    /* renamed from: a  reason: collision with root package name */
    private static NativeCrashHandler f6114a = null;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean o = true;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6115b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6116c;

    /* renamed from: d  reason: collision with root package name */
    private final w f6117d;

    /* renamed from: e  reason: collision with root package name */
    private NativeExceptionHandler f6118e;
    private String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private com.tencent.bugly.crashreport.crash.b n;

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i, String str);

    protected native void testCrash();

    protected native String unregist();

    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, w wVar, boolean z, String str) {
        this.f6115b = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f6007c + "/app_bugly";
        }
        this.n = bVar;
        this.f = str;
        this.f6116c = aVar;
        this.f6117d = wVar;
        this.g = z;
        this.f6118e = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f6114a == null) {
                f6114a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
            }
            nativeCrashHandler = f6114a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f6114a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f = str;
    }

    public static void setShouldHandleInJava(boolean z) {
        o = z;
        NativeCrashHandler nativeCrashHandler = f6114a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(999, sb.toString());
        }
    }

    public static boolean isShouldHandleInJava() {
        return o;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:14|(1:16)(16:41|(1:43)|18|19|(1:21)|22|(1:24)|26|(1:28)(1:39)|29|(1:31)(1:38)|32|(1:34)|35|36|37)|17|18|19|(0)|22|(0)|26|(0)(0)|29|(0)(0)|32|(0)|35|36|37) */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c A[Catch: all -> 0x008a, TryCatch #2 {all -> 0x008a, blocks: (B:21:0x0072, B:23:0x007c, B:24:0x007e, B:26:0x0088), top: B:72:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #2 {all -> 0x008a, blocks: (B:21:0x0072, B:23:0x007c, B:24:0x007e, B:26:0x0088), top: B:72:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[Catch: all -> 0x00ef, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:61:0x01c3, B:42:0x00f8, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x0059, B:27:0x008a, B:29:0x008e, B:31:0x009d, B:33:0x00a1, B:35:0x00b0, B:37:0x00c8, B:38:0x00de, B:34:0x00a9, B:30:0x0096, B:17:0x0061, B:19:0x0067), top: B:71:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096 A[Catch: all -> 0x00ef, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:61:0x01c3, B:42:0x00f8, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x0059, B:27:0x008a, B:29:0x008e, B:31:0x009d, B:33:0x00a1, B:35:0x00b0, B:37:0x00c8, B:38:0x00de, B:34:0x00a9, B:30:0x0096, B:17:0x0061, B:19:0x0067), top: B:71:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[Catch: all -> 0x00ef, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:61:0x01c3, B:42:0x00f8, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x0059, B:27:0x008a, B:29:0x008e, B:31:0x009d, B:33:0x00a1, B:35:0x00b0, B:37:0x00c8, B:38:0x00de, B:34:0x00a9, B:30:0x0096, B:17:0x0061, B:19:0x0067), top: B:71:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9 A[Catch: all -> 0x00ef, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:61:0x01c3, B:42:0x00f8, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x0059, B:27:0x008a, B:29:0x008e, B:31:0x009d, B:33:0x00a1, B:35:0x00b0, B:37:0x00c8, B:38:0x00de, B:34:0x00a9, B:30:0x0096, B:17:0x0061, B:19:0x0067), top: B:71:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8 A[Catch: all -> 0x00ef, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:61:0x01c3, B:42:0x00f8, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x0059, B:27:0x008a, B:29:0x008e, B:31:0x009d, B:33:0x00a1, B:35:0x00b0, B:37:0x00c8, B:38:0x00de, B:34:0x00a9, B:30:0x0096, B:17:0x0061, B:19:0x0067), top: B:71:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(boolean z) {
        StringBuilder sb;
        String str;
        if (this.j) {
            x.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.i) {
            String regist = regist(this.f, z, 1);
            if (regist != null) {
                x.a("[Native] Native Crash Report enable.", new Object[0]);
                x.c("[Native] Check extra jni for Bugly NDK v%s", regist);
                String replace = "2.1.1".replace(".", "");
                String replace2 = "2.3.0".replace(".", "");
                String replace3 = regist.replace(".", "");
                if (replace3.length() != 2) {
                    if (replace3.length() == 1) {
                        sb = new StringBuilder();
                        sb.append(replace3);
                        str = "00";
                    }
                    if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                        l = true;
                    }
                    if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                        m = true;
                    }
                    if (m) {
                        x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
                    } else {
                        x.a("[Native] Info setting jni can be accessed.", new Object[0]);
                    }
                    if (l) {
                        x.d("[Native] Extra jni can not be accessed.", new Object[0]);
                    } else {
                        x.a("[Native] Extra jni can be accessed.", new Object[0]);
                    }
                    this.f6116c.o = regist;
                    if (!this.f6116c.f.contains("-".concat(this.f6116c.o))) {
                        this.f6116c.f = this.f6116c.f.concat("-").concat(this.f6116c.o);
                    }
                    x.a("comInfo.sdkVersion %s", this.f6116c.f);
                    this.j = true;
                    return;
                }
                sb = new StringBuilder();
                sb.append(replace3);
                str = "0";
                sb.append(str);
                replace3 = sb.toString();
                if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                }
                if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                }
                if (m) {
                }
                if (l) {
                }
                this.f6116c.o = regist;
                if (!this.f6116c.f.contains("-".concat(this.f6116c.o))) {
                }
                x.a("comInfo.sdkVersion %s", this.f6116c.f);
                this.j = true;
                return;
            }
        } else if (this.h) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.f;
                objArr[1] = com.tencent.bugly.crashreport.common.info.b.a(this.f6115b, false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str2 = (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str2 == null) {
                    Class[] clsArr2 = {String.class, String.class, Integer.TYPE};
                    com.tencent.bugly.crashreport.common.info.a.b();
                    str2 = (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, clsArr2, new Object[]{this.f, com.tencent.bugly.crashreport.common.info.b.a(this.f6115b, false), Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.K())});
                }
                if (str2 != null) {
                    this.j = true;
                    this.f6116c.o = str2;
                    Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str2});
                    if (bool != null) {
                        l = bool.booleanValue();
                    }
                    z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        this.i = false;
        this.h = false;
    }

    public synchronized void startNativeMonitor() {
        if (!this.i && !this.h) {
            String str = "Bugly";
            boolean z = !z.a(this.f6116c.n);
            String str2 = this.f6116c.n;
            if (z) {
                str = str2;
            } else {
                this.f6116c.getClass();
            }
            boolean a2 = a(str, z);
            this.i = a2;
            if (a2 || this.h) {
                a(this.g);
                if (l) {
                    setNativeAppVersion(this.f6116c.k);
                    setNativeAppChannel(this.f6116c.m);
                    setNativeAppPackage(this.f6116c.f6007c);
                    setNativeUserId(this.f6116c.g());
                    setNativeIsAppForeground(this.f6116c.a());
                    setNativeLaunchTime(this.f6116c.f6005a);
                }
                return;
            }
            return;
        }
        a(this.g);
    }

    public void checkUploadRecordCrash() {
        this.f6117d.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (z.a(NativeCrashHandler.this.f6115b, "native_record_lock", 10000L)) {
                    if (!NativeCrashHandler.o) {
                        NativeCrashHandler.this.a(999, Bugly.SDK_IS_DEV);
                    }
                    CrashDetailBean a2 = b.a(NativeCrashHandler.this.f6115b, NativeCrashHandler.this.f, NativeCrashHandler.this.f6118e);
                    if (a2 != null) {
                        x.a("[Native] Get crash from native record.", new Object[0]);
                        if (!NativeCrashHandler.this.n.a(a2)) {
                            NativeCrashHandler.this.n.a(a2, 3000L, false);
                        }
                        b.a(false, NativeCrashHandler.this.f);
                    }
                    NativeCrashHandler.this.a();
                    z.b(NativeCrashHandler.this.f6115b, "native_record_lock");
                    return;
                }
                x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            }
        });
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                x.d(th.getMessage(), new Object[0]);
                x.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    private synchronized void c() {
        if (!this.j) {
            x.d("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
            this.j = false;
        } else {
            z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.j = false;
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    public void testNativeCrash() {
        if (!this.i) {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f6118e;
    }

    protected final void a() {
        long b2 = z.b() - c.g;
        long b3 = z.b() + 86400000;
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i++;
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    x.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f);
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.k;
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            x.a("user change native %b", Boolean.valueOf(z));
            this.k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().g;
        }
        if (isUserOpened != this.j) {
            x.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.g != this.j) {
                x.d("server native changed to %b", Boolean.valueOf(strategyBean.g));
            }
        }
        boolean z = com.tencent.bugly.crashreport.common.strategy.a.a().c().g && this.k;
        if (z != this.j) {
            x.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.h || this.i) && l && str != null && str2 != null && str3 != null) {
            try {
                if (this.i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public String getLogFromNative() {
        if ((this.h || this.i) && l) {
            try {
                if (this.i) {
                    return getNativeLog();
                }
                return (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
            } catch (UnsatisfiedLinkError unused) {
                l = false;
                return null;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.h || this.i) && l && str != null && str2 != null) {
            try {
                if (this.i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str) {
        if (this.i && m) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : Bugly.SDK_IS_DEV);
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e2) {
            if (x.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }
}
