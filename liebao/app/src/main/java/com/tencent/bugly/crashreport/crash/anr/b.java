package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class b implements ac {

    /* renamed from: c  reason: collision with root package name */
    private final Context f6062c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6063d;

    /* renamed from: e  reason: collision with root package name */
    private final w f6064e;
    private final com.tencent.bugly.crashreport.common.strategy.a f;
    private final String g;
    private final com.tencent.bugly.crashreport.crash.b h;
    private FileObserver i;
    private ab k;
    private int l;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f6060a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private long f6061b = -1;
    private boolean j = true;
    private ActivityManager.ProcessErrorStateInfo m = new ActivityManager.ProcessErrorStateInfo();

    public b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, w wVar, com.tencent.bugly.crashreport.crash.b bVar) {
        this.f6062c = z.a(context);
        this.g = context.getDir("bugly", 0).getAbsolutePath();
        this.f6063d = aVar2;
        this.f6064e = wVar;
        this.f = aVar;
        this.h = bVar;
    }

    private ActivityManager.ProcessErrorStateInfo a(Context context, long j) {
        try {
            x.c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int i = 0;
            while (true) {
                x.c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            x.c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                z.b(500L);
                int i2 = i + 1;
                if (i >= 20) {
                    x.c("end!", new Object[0]);
                    return null;
                }
                i = i2;
            }
        } catch (Exception e2) {
            x.b(e2);
            return null;
        } catch (OutOfMemoryError e3) {
            this.m.pid = Process.myPid();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = this.m;
            processErrorStateInfo2.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e3.getMessage();
            return this.m;
        }
    }

    private CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
            crashDetailBean.F = this.f6063d.p();
            crashDetailBean.G = this.f6063d.o();
            crashDetailBean.H = this.f6063d.q();
            if (!com.tencent.bugly.crashreport.common.info.b.t()) {
                crashDetailBean.w = z.a(this.f6062c, c.f6078e, (String) null);
            }
            crashDetailBean.f6036b = 3;
            crashDetailBean.f6039e = this.f6063d.h();
            crashDetailBean.f = this.f6063d.k;
            crashDetailBean.g = this.f6063d.w();
            crashDetailBean.m = this.f6063d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.f6040q = aVar.g;
            crashDetailBean.O = new HashMap();
            crashDetailBean.O.put("BUGLY_CR_01", aVar.f6059e);
            int indexOf = crashDetailBean.f6040q != null ? crashDetailBean.f6040q.indexOf("\n") : -1;
            crashDetailBean.p = indexOf > 0 ? crashDetailBean.f6040q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.f6057c;
            if (crashDetailBean.f6040q != null) {
                crashDetailBean.u = z.b(crashDetailBean.f6040q.getBytes());
            }
            crashDetailBean.z = aVar.f6056b;
            crashDetailBean.A = aVar.f6055a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f6063d.y();
            crashDetailBean.h = this.f6063d.v();
            crashDetailBean.i = this.f6063d.J();
            crashDetailBean.v = aVar.f6058d;
            crashDetailBean.L = this.f6063d.o;
            crashDetailBean.M = this.f6063d.f6005a;
            crashDetailBean.N = this.f6063d.a();
            crashDetailBean.P = this.f6063d.H();
            crashDetailBean.Q = this.f6063d.I();
            crashDetailBean.R = this.f6063d.B();
            crashDetailBean.S = this.f6063d.G();
            if (!com.tencent.bugly.crashreport.common.info.b.t()) {
                this.h.d(crashDetailBean);
            }
            crashDetailBean.y = y.a();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private static boolean a(String str, String str2, String str3) {
        Throwable th;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.f6054d == null || readTargetDumpInfo.f6054d.size() <= 0) {
            x.e("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                x.e("backup file create fail %s", str2);
                return false;
            }
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                    try {
                        String[] strArr = readTargetDumpInfo.f6054d.get("main");
                        int i = 3;
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            String str5 = strArr[1];
                            String str6 = strArr[2];
                            bufferedWriter2.write("\"main\" tid=" + str6 + " :\n" + str4 + "\n" + str5 + "\n\n");
                            bufferedWriter2.flush();
                        }
                        for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f6054d.entrySet()) {
                            if (!entry.getKey().equals("main")) {
                                if (entry.getValue() != null && entry.getValue().length >= i) {
                                    String str7 = entry.getValue()[0];
                                    String str8 = entry.getValue()[1];
                                    String str9 = entry.getValue()[2];
                                    bufferedWriter2.write("\"" + entry.getKey() + "\" tid=" + str9 + " :\n" + str7 + "\n" + str8 + "\n\n");
                                    bufferedWriter2.flush();
                                }
                                i = 3;
                            }
                        }
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e2) {
                            if (!x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter = bufferedWriter2;
                        if (!x.a(e)) {
                            e.printStackTrace();
                        }
                        x.e("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e4) {
                                if (!x.a(e4)) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e5) {
                                if (!x.a(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e7) {
            if (!x.a(e7)) {
                e7.printStackTrace();
            }
            x.e("backup file create error! %s  %s", e7.getClass().getName() + ":" + e7.getMessage(), str2);
            return false;
        }
    }

    public final boolean a() {
        return this.f6060a.get() != 0;
    }

    private boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir, "bugly/bugly_trace_" + j + ".txt");
        a aVar = new a();
        aVar.f6057c = j;
        aVar.f6058d = file.getAbsolutePath();
        aVar.f6055a = processErrorStateInfo != null ? processErrorStateInfo.processName : "";
        aVar.f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f6059e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.f6056b = map;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2.startsWith("main(")) {
                    aVar.g = map.get(str2);
                }
            }
        }
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(aVar.f6057c);
        objArr[1] = aVar.f6058d;
        objArr[2] = aVar.f6055a;
        objArr[3] = aVar.f;
        objArr[4] = aVar.f6059e;
        objArr[5] = Integer.valueOf(aVar.f6056b == null ? 0 : aVar.f6056b.size());
        x.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        if (!this.f.b()) {
            x.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), aVar.f6055a, "main", aVar.f6059e, null);
            return false;
        } else if (!this.f.c().j) {
            x.d("ANR Report is closed!", new Object[0]);
            return false;
        } else {
            x.a("found visiable anr , start to upload!", new Object[0]);
            CrashDetailBean a2 = a(aVar);
            if (a2 == null) {
                x.e("pack anr fail!", new Object[0]);
                return false;
            }
            c.a().a(a2);
            if (a2.f6035a >= 0) {
                x.a("backup anr record success!", new Object[0]);
            } else {
                x.d("backup anr record fail!", new Object[0]);
            }
            if (str != null && new File(str).exists()) {
                this.f6060a.set(3);
                if (a(str, aVar.f6058d, aVar.f6055a)) {
                    x.a("backup trace success", new Object[0]);
                }
            }
            com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), aVar.f6055a, "main", aVar.f6059e, a2);
            if (!this.h.a(a2)) {
                this.h.a(a2, 3000L, true);
            }
            this.h.c(a2);
            return true;
        }
    }

    public final void a(String str) {
        synchronized (this) {
            if (this.f6060a.get() != 0) {
                x.c("trace started return ", new Object[0]);
                return;
            }
            this.f6060a.set(1);
            try {
                x.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j = readFirstDumpInfo != null ? readFirstDumpInfo.f6053c : -1L;
                if (j == -1) {
                    x.d("trace dump fail could not get time!", new Object[0]);
                    j = System.currentTimeMillis();
                }
                long j2 = j;
                if (Math.abs(j2 - this.f6061b) < 10000) {
                    x.d("should not process ANR too Fre in %d", 10000);
                } else {
                    this.f6061b = j2;
                    this.f6060a.set(1);
                    Map<String, String> a2 = z.a(c.f, false);
                    if (a2 != null && a2.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo a3 = a(this.f6062c, 10000L);
                        this.m = a3;
                        if (a3 == null) {
                            x.c("proc state is unvisiable!", new Object[0]);
                        } else if (a3.pid != Process.myPid()) {
                            x.c("not mind proc!", this.m.processName);
                        } else {
                            x.a("found visiable anr , start to process!", new Object[0]);
                            a(this.f6062c, str, this.m, j2, a2);
                        }
                    }
                    x.d("can't get all thread skip this anr", new Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    private synchronized void f() {
        if (h()) {
            x.d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str == null) {
                    return;
                }
                String str2 = "/data/anr/" + str;
                if (!str2.contains("trace")) {
                    x.d("not anr file %s", str2);
                } else {
                    b.this.a(str2);
                }
            }
        };
        this.i = fileObserver;
        fileObserver.startWatching();
        x.a("start anr monitor!", new Object[0]);
        this.f6064e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b();
            }
        });
    }

    private synchronized void g() {
        if (!h()) {
            x.d("close when closed!", new Object[0]);
            return;
        }
        this.i.stopWatching();
        this.i = null;
        x.d("close anr monitor!", new Object[0]);
    }

    private synchronized boolean h() {
        return this.i != null;
    }

    private synchronized void b(boolean z) {
        if (z) {
            f();
        } else {
            g();
        }
    }

    private synchronized boolean i() {
        return this.j;
    }

    private synchronized void c(boolean z) {
        if (this.j != z) {
            x.a("user change anr %b", Boolean.valueOf(z));
            this.j = z;
        }
    }

    public final void a(boolean z) {
        c(z);
        boolean i = i();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            i = i && a2.c().g;
        }
        if (i != h()) {
            x.a("anr changed to %b", Boolean.valueOf(i));
            b(i);
        }
    }

    protected final void b() {
        int indexOf;
        long b2 = z.b() - c.g;
        File file = new File(this.g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (name.startsWith("bugly_trace_") && (((indexOf = name.indexOf(".txt")) <= 0 || Long.parseLong(name.substring(12, indexOf)) < b2) && file2.delete())) {
                            i++;
                        }
                    }
                    x.c("Number of overdue trace files that has deleted: " + i, new Object[0]);
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    public final synchronized void c() {
        x.d("customer decides whether to open or close.", new Object[0]);
    }

    @Override // com.tencent.bugly.proguard.ac
    public final boolean a(Thread thread) {
        Map<String, String> hashMap = new HashMap<>();
        if (thread.getName().contains("main")) {
            ActivityManager.ProcessErrorStateInfo a2 = a(this.f6062c, 10000L);
            this.m = a2;
            if (a2 == null) {
                x.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
                return false;
            } else if (a2.pid != Process.myPid()) {
                x.c("onThreadBlock not mind proc!", this.m.processName);
                return false;
            } else {
                try {
                    hashMap = z.a(200000, false);
                } catch (Throwable th) {
                    x.b(th);
                    hashMap.put("main", th.getMessage());
                }
                Map<String, String> map = hashMap;
                x.c("onThreadBlock found visiable anr , start to process!", new Object[0]);
                a(this.f6062c, "", this.m, System.currentTimeMillis(), map);
            }
        } else {
            x.c("anr handler onThreadBlock only care main thread", new Object[0]);
        }
        return true;
    }

    public final boolean d() {
        ab abVar = this.k;
        if (abVar == null || !abVar.isAlive()) {
            ab abVar2 = new ab();
            this.k = abVar2;
            StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
            int i = this.l;
            this.l = i + 1;
            sb.append(i);
            abVar2.setName(sb.toString());
            this.k.a();
            this.k.a(this);
            return this.k.d();
        }
        return false;
    }

    public final boolean e() {
        ab abVar = this.k;
        if (abVar != null) {
            boolean c2 = abVar.c();
            this.k.b();
            this.k.b(this);
            this.k = null;
            return c2;
        }
        return false;
    }
}
