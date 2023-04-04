package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: b  reason: collision with root package name */
    private static u f6242b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6243a;

    /* renamed from: d  reason: collision with root package name */
    private final Context f6245d;
    private long f;
    private long g;
    private String k;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, Long> f6246e = new HashMap();
    private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue<>();
    private final Object j = new Object();
    private byte[] l = null;
    private long m = 0;
    private byte[] n = null;
    private long o = 0;
    private String p = null;

    /* renamed from: q  reason: collision with root package name */
    private long f6247q = 0;
    private final Object r = new Object();
    private boolean s = false;
    private final Object t = new Object();
    private int u = 0;

    /* renamed from: c  reason: collision with root package name */
    private final p f6244c = p.a();

    static /* synthetic */ int b(u uVar) {
        int i = uVar.u - 1;
        uVar.u = i;
        return i;
    }

    private u(Context context) {
        this.k = null;
        this.f6243a = true;
        this.f6245d = context;
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException unused) {
            x.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.f6243a = false;
        }
        if (this.f6243a) {
            this.k = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB";
        }
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (f6242b == null) {
                f6242b = new u(context);
            }
            uVar = f6242b;
        }
        return uVar;
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = f6242b;
        }
        return uVar;
    }

    public final void a(int i, ap apVar, String str, String str2, t tVar, long j, boolean z) {
        try {
            a(new v(this.f6245d, i, apVar.g, com.tencent.bugly.proguard.a.a((Object) apVar), str, str2, tVar, this.f6243a, z), true, true, j);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i, int i2, byte[] bArr, String str, String str2, t tVar, int i3, int i4, boolean z, Map<String, String> map) {
        try {
            a(new v(this.f6245d, i, i2, bArr, str, str2, tVar, this.f6243a, i3, i4, false, map), z, false, 0L);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i, ap apVar, String str, String str2, t tVar, boolean z) {
        a(i, apVar.g, com.tencent.bugly.proguard.a.a((Object) apVar), str, str2, tVar, 0, 0, z, null);
    }

    public final long a(boolean z) {
        long j;
        long b2 = z.b();
        int i = z ? 5 : 3;
        List<r> a2 = this.f6244c.a(i);
        if (a2 != null && a2.size() > 0) {
            j = 0;
            try {
                r rVar = a2.get(0);
                if (rVar.f6238e >= b2) {
                    j = z.c(rVar.g);
                    if (i == 3) {
                        this.f = j;
                    } else {
                        this.g = j;
                    }
                    a2.remove(rVar);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            if (a2.size() > 0) {
                this.f6244c.a(a2);
            }
        } else {
            j = z ? this.g : this.f;
        }
        x.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(long j, boolean z) {
        int i = z ? 5 : 3;
        r rVar = new r();
        rVar.f6235b = i;
        rVar.f6238e = z.b();
        rVar.f6236c = "";
        rVar.f6237d = "";
        rVar.g = z.c(j);
        this.f6244c.b(i);
        this.f6244c.a(rVar);
        if (z) {
            this.g = j;
        } else {
            this.f = j;
        }
        x.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    public final synchronized void a(int i, long j) {
        if (i < 0) {
            x.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
            return;
        }
        this.f6246e.put(Integer.valueOf(i), Long.valueOf(j));
        r rVar = new r();
        rVar.f6235b = i;
        rVar.f6238e = j;
        rVar.f6236c = "";
        rVar.f6237d = "";
        rVar.g = new byte[0];
        this.f6244c.b(i);
        this.f6244c.a(rVar);
        x.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), z.a(j));
    }

    public final synchronized long a(int i) {
        long j = 0;
        if (i >= 0) {
            Long l = this.f6246e.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<r> a2 = this.f6244c.a(i);
            if (a2 != null && a2.size() > 0) {
                if (a2.size() > 1) {
                    for (r rVar : a2) {
                        if (rVar.f6238e > j) {
                            j = rVar.f6238e;
                        }
                    }
                    this.f6244c.b(i);
                } else {
                    j = a2.get(0).f6238e;
                }
            }
        } else {
            x.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return j;
    }

    public final boolean b(int i) {
        if (com.tencent.bugly.b.f5969c) {
            x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i);
        x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis < 30000) {
            x.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }

    private static boolean c() {
        x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            p a2 = p.a();
            if (a2 == null) {
                x.d("[UploadManager] Failed to get Database", new Object[0]);
                return false;
            }
            return a2.a(555, "security_info", (o) null, true);
        } catch (Throwable th) {
            x.a(th);
            return false;
        }
    }

    private boolean d() {
        x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            p a2 = p.a();
            if (a2 == null) {
                x.d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder sb = new StringBuilder();
            if (this.n != null) {
                sb.append(Base64.encodeToString(this.n, 0));
                sb.append("#");
                if (this.o != 0) {
                    sb.append(Long.toString(this.o));
                } else {
                    sb.append("null");
                }
                sb.append("#");
                if (this.p != null) {
                    sb.append(this.p);
                } else {
                    sb.append("null");
                }
                sb.append("#");
                if (this.f6247q != 0) {
                    sb.append(Long.toString(this.f6247q));
                } else {
                    sb.append("null");
                }
                a2.a(555, "security_info", sb.toString().getBytes(), (o) null, true);
                return true;
            }
            x.c("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            x.a(th);
            c();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        boolean z;
        x.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            p a2 = p.a();
            if (a2 == null) {
                x.d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            Map<String, byte[]> a3 = a2.a(555, (o) null, true);
            if (a3 != null && a3.containsKey("security_info")) {
                String str = new String(a3.get("security_info"));
                String[] split = str.split("#");
                if (split.length == 4) {
                    if (!split[0].isEmpty() && !split[0].equals("null")) {
                        this.n = Base64.decode(split[0], 0);
                    }
                    z = false;
                    if (0 == 0 && !split[1].isEmpty() && !split[1].equals("null")) {
                        this.o = Long.parseLong(split[1]);
                    }
                    if (0 == 0 && !split[2].isEmpty() && !split[2].equals("null")) {
                        this.p = split[2];
                    }
                    if (0 == 0 && !split[3].isEmpty() && !split[3].equals("null")) {
                        this.f6247q = Long.parseLong(split[3]);
                    }
                } else {
                    x.a("SecurityInfo = %s, Strings.length = %d", str, Integer.valueOf(split.length));
                    z = true;
                }
                if (z) {
                    c();
                }
            }
            return true;
        } catch (Throwable th) {
            x.a(th);
            return false;
        }
    }

    protected final boolean b() {
        if (this.p == null || this.f6247q == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.m;
        long j = this.f6247q;
        if (j < currentTimeMillis) {
            x.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(j), new Date(this.f6247q).toString(), Long.valueOf(currentTimeMillis), new Date(currentTimeMillis).toString());
            return false;
        }
        return true;
    }

    public final void b(boolean z) {
        synchronized (this.r) {
            x.c("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.n = null;
            this.p = null;
            this.f6247q = 0L;
        }
        if (z) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #3 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:22:0x0061, B:27:0x006b, B:33:0x008c, B:36:0x0092, B:42:0x00b3, B:43:0x00b6, B:17:0x0058, B:19:0x005c, B:38:0x009c, B:29:0x0075), top: B:87:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092 A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #3 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:22:0x0061, B:27:0x006b, B:33:0x008c, B:36:0x0092, B:42:0x00b3, B:43:0x00b6, B:17:0x0058, B:19:0x005c, B:38:0x009c, B:29:0x0075), top: B:87:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i) {
        int i2;
        int i3;
        int i4;
        if (i < 0) {
            x.a("[UploadManager] Number of task to execute should >= 0", new Object[0]);
            return;
        }
        w a2 = w.a();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.j) {
            x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.h.size();
            final int size2 = this.i.size();
            if (size == 0 && size2 == 0) {
                x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (i != 0) {
                if (i < size) {
                    size2 = 0;
                    size2 = (a2 == null && a2.c()) ? 0 : 0;
                    for (i2 = 0; i2 < i; i2++) {
                        Runnable peek = this.h.peek();
                        if (peek == null) {
                            break;
                        }
                        linkedBlockingQueue.put(peek);
                        this.h.poll();
                    }
                    for (i3 = 0; i3 < size2; i3++) {
                        Runnable peek2 = this.i.peek();
                        if (peek2 == null) {
                            break;
                        }
                        linkedBlockingQueue2.put(peek2);
                        this.i.poll();
                    }
                    if (i > 0) {
                        x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    }
                    for (i4 = 0; i4 < i; i4++) {
                        final Runnable runnable = (Runnable) linkedBlockingQueue.poll();
                        if (runnable == null) {
                            break;
                        }
                        synchronized (this.j) {
                            if (this.u >= 2 && a2 != null) {
                                a2.a(runnable);
                            } else {
                                x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                                if (z.a(new Runnable() { // from class: com.tencent.bugly.proguard.u.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        runnable.run();
                                        synchronized (u.this.j) {
                                            u.b(u.this);
                                        }
                                    }
                                }, "BUGLY_ASYNC_UPLOAD") != null) {
                                    synchronized (this.j) {
                                        this.u++;
                                    }
                                } else {
                                    x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                                    a(runnable, true);
                                }
                            }
                        }
                    }
                    if (size2 > 0) {
                        x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    }
                    if (a2 == null) {
                        a2.a(new Runnable(this) { // from class: com.tencent.bugly.proguard.u.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                Runnable runnable2;
                                for (int i5 = 0; i5 < size2 && (runnable2 = (Runnable) linkedBlockingQueue2.poll()) != null; i5++) {
                                    runnable2.run();
                                }
                            }
                        });
                        return;
                    }
                    return;
                } else if (i < size + size2) {
                    size2 = i - size;
                }
            }
            i = size;
            if (a2 == null) {
            }
            while (i2 < i) {
            }
            while (i3 < size2) {
            }
            if (i > 0) {
            }
            while (i4 < i) {
            }
            if (size2 > 0) {
            }
            if (a2 == null) {
            }
        }
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            x.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.j) {
                if (z) {
                    this.h.put(runnable);
                } else {
                    this.i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable, long j) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a2 = z.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a2 == null) {
            x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a2.join(j);
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.p != null) {
            if (b()) {
                x.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z2) {
                    a(runnable, j);
                    return;
                }
                a(runnable, z);
                c(0);
                return;
            }
            x.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            b(false);
        }
        synchronized (this.t) {
            if (this.s) {
                a(runnable, z);
                return;
            }
            this.s = true;
            x.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            if (z2) {
                a(new a(this.f6245d, runnable, j), 0L);
                return;
            }
            a(runnable, z);
            a aVar = new a(this.f6245d);
            x.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
            if (z.a(aVar, "BUGLY_ASYNC_UPLOAD") == null) {
                x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                w a2 = w.a();
                if (a2 != null) {
                    a2.a(aVar);
                    return;
                }
                x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                synchronized (this.t) {
                    this.s = false;
                }
            }
        }
    }

    public final void a(int i, aq aqVar) {
        if (this.f6243a) {
            boolean z = true;
            if (i == 2) {
                x.c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                b(true);
            } else {
                synchronized (this.t) {
                    if (!this.s) {
                        return;
                    }
                    if (aqVar != null) {
                        x.c("[UploadManager] Record security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        try {
                            Map<String, String> map = aqVar.g;
                            if (map != null && map.containsKey("S1") && map.containsKey("S2")) {
                                long currentTimeMillis = aqVar.f6171e - System.currentTimeMillis();
                                this.m = currentTimeMillis;
                                x.c("[UploadManager] Time lag of server is: %d", Long.valueOf(currentTimeMillis));
                                String str = map.get("S1");
                                this.p = str;
                                x.c("[UploadManager] Session ID from server is: %s", str);
                                if (this.p.length() > 0) {
                                    try {
                                        long parseLong = Long.parseLong(map.get("S2"));
                                        this.f6247q = parseLong;
                                        x.c("[UploadManager] Session expired time from server is: %d(%s)", Long.valueOf(parseLong), new Date(this.f6247q).toString());
                                        if (this.f6247q < 1000) {
                                            x.d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new Object[0]);
                                            this.f6247q = 259200000L;
                                        }
                                    } catch (NumberFormatException unused) {
                                        x.d("[UploadManager] Session expired time is invalid, will set to default value", new Object[0]);
                                        this.f6247q = 259200000L;
                                    }
                                    if (d()) {
                                        z = false;
                                    } else {
                                        x.c("[UploadManager] Failed to record database", new Object[0]);
                                    }
                                    c(0);
                                } else {
                                    x.c("[UploadManager] Session ID from server is invalid, try next time", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            x.a(th);
                        }
                        if (z) {
                            b(false);
                        }
                    } else {
                        x.c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        b(false);
                    }
                }
            }
            synchronized (this.t) {
                if (this.s) {
                    this.s = false;
                    z.b(this.f6245d, "security_info");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6252a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f6253b;

        /* renamed from: c  reason: collision with root package name */
        private final long f6254c;

        public a(Context context) {
            this.f6252a = context;
            this.f6253b = null;
            this.f6254c = 0L;
        }

        public a(Context context, Runnable runnable, long j) {
            this.f6252a = context;
            this.f6253b = runnable;
            this.f6254c = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (z.a(this.f6252a, "security_info", 30000L)) {
                if (!u.this.e()) {
                    x.d("[UploadManager] Failed to load security info from database", new Object[0]);
                    u.this.b(false);
                }
                if (u.this.p != null) {
                    if (u.this.b()) {
                        x.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        Runnable runnable = this.f6253b;
                        if (runnable != null) {
                            u.this.a(runnable, this.f6254c);
                        }
                        u.this.c(0);
                        z.b(this.f6252a, "security_info");
                        synchronized (u.this.t) {
                            u.this.s = false;
                        }
                        return;
                    }
                    x.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                    u.this.b(true);
                }
                byte[] a2 = z.a(128);
                if (a2 != null && (a2.length << 3) == 128) {
                    u.this.n = a2;
                    x.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    Runnable runnable2 = this.f6253b;
                    if (runnable2 != null) {
                        u.this.a(runnable2, this.f6254c);
                        return;
                    } else {
                        u.this.c(1);
                        return;
                    }
                }
                x.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                u.this.b(false);
                z.b(this.f6252a, "security_info");
                synchronized (u.this.t) {
                    u.this.s = false;
                }
                return;
            }
            x.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", 5000, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            z.b(5000L);
            if (z.a(this, "BUGLY_ASYNC_UPLOAD") == null) {
                x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                w a3 = w.a();
                if (a3 != null) {
                    a3.a(this);
                } else {
                    x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                }
            }
        }
    }

    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = this.n;
        if (bArr2 == null || (bArr2.length << 3) != 128) {
            x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return null;
        }
        return z.a(1, bArr, bArr2);
    }

    public final byte[] b(byte[] bArr) {
        byte[] bArr2 = this.n;
        if (bArr2 == null || (bArr2.length << 3) != 128) {
            x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return null;
        }
        return z.a(2, bArr, bArr2);
    }

    public final boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str = this.p;
        if (str != null) {
            map.put("secureSessionId", str);
            return true;
        }
        byte[] bArr = this.n;
        if (bArr == null || (bArr.length << 3) != 128) {
            x.d("[UploadManager] AES key is invalid", new Object[0]);
            return false;
        }
        if (this.l == null) {
            byte[] decode = Base64.decode(this.k, 0);
            this.l = decode;
            if (decode == null) {
                x.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
                return false;
            }
        }
        byte[] b2 = z.b(1, this.n, this.l);
        if (b2 == null) {
            x.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
            return false;
        }
        String encodeToString = Base64.encodeToString(b2, 0);
        if (TextUtils.isEmpty(encodeToString)) {
            x.e("[UploadManager] Failed to encode AES key", new Object[0]);
            return false;
        }
        map.put("raKey", encodeToString);
        return true;
    }
}
