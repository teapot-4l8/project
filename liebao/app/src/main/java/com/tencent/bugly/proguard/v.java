package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private int f6256a;

    /* renamed from: b  reason: collision with root package name */
    private int f6257b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6258c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6259d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f6260e;
    private final com.tencent.bugly.crashreport.common.info.a f;
    private final com.tencent.bugly.crashreport.common.strategy.a g;
    private final s h;
    private final u i;
    private final int j;
    private final t k;
    private final t l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private long f6261q;
    private long r;
    private boolean s;
    private boolean t;

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, tVar, z, 2, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        this.f6256a = 2;
        this.f6257b = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.m = null;
        this.p = 0;
        this.f6261q = 0L;
        this.r = 0L;
        this.s = true;
        this.t = false;
        this.f6258c = context;
        this.f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f6260e = bArr;
        this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.h = s.a(context);
        this.i = u.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        this.l = null;
        this.s = z;
        this.f6259d = i2;
        if (i3 > 0) {
            this.f6256a = i3;
        }
        if (i4 > 0) {
            this.f6257b = i4;
        }
        this.t = z2;
        this.o = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(aq aqVar, boolean z, int i, String str, int i2) {
        String str2;
        t tVar;
        t tVar2;
        int i3 = this.f6259d;
        if (i3 != 630) {
            if (i3 != 640) {
                if (i3 != 830) {
                    if (i3 != 840) {
                        str2 = String.valueOf(i3);
                        if (z) {
                            x.a("[Upload] Success: %s", str2);
                        } else {
                            x.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i), str2, str);
                            if (this.s) {
                                this.i.a(i2, (aq) null);
                            }
                        }
                        if (this.f6261q + this.r > 0) {
                            this.i.a(this.i.a(this.t) + this.f6261q + this.r, this.t);
                        }
                        tVar = this.k;
                        if (tVar != null) {
                            tVar.a(z);
                        }
                        tVar2 = this.l;
                        if (tVar2 != null) {
                            tVar2.a(z);
                            return;
                        }
                        return;
                    }
                }
            }
            str2 = "userinfo";
            if (z) {
            }
            if (this.f6261q + this.r > 0) {
            }
            tVar = this.k;
            if (tVar != null) {
            }
            tVar2 = this.l;
            if (tVar2 != null) {
            }
        }
        str2 = "crash";
        if (z) {
        }
        if (this.f6261q + this.r > 0) {
        }
        tVar = this.k;
        if (tVar != null) {
        }
        tVar2 = this.l;
        if (tVar2 != null) {
        }
    }

    private static boolean a(aq aqVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (aqVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        } else if (aqVar.f6167a != 0) {
            x.e("resp result error %d", Byte.valueOf(aqVar.f6167a));
            return false;
        } else {
            try {
                if (!z.a(aqVar.f6170d) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(aqVar.f6170d)) {
                    p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f6022a, "gateway", aqVar.f6170d.getBytes("UTF-8"), (o) null, true);
                    aVar.d(aqVar.f6170d);
                }
                if (!z.a(aqVar.f) && !com.tencent.bugly.crashreport.common.info.a.b().j().equals(aqVar.f)) {
                    p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f6022a, "device", aqVar.f.getBytes("UTF-8"), (o) null, true);
                    aVar.e(aqVar.f);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            aVar.j = aqVar.f6171e;
            if (aqVar.f6168b == 510) {
                if (aqVar.f6169c == null) {
                    x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(aqVar.f6168b));
                    return false;
                }
                as asVar = (as) a.a(aqVar.f6169c, as.class);
                if (asVar == null) {
                    x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(aqVar.f6168b));
                    return false;
                }
                aVar2.a(asVar);
            }
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f9 A[Catch: all -> 0x042f, TryCatch #2 {all -> 0x042f, blocks: (B:3:0x0007, B:5:0x0019, B:8:0x0027, B:11:0x002c, B:13:0x0040, B:15:0x0044, B:17:0x0048, B:20:0x004e, B:22:0x0056, B:24:0x0062, B:26:0x0088, B:27:0x008d, B:29:0x0092, B:31:0x00c2, B:33:0x00ce, B:35:0x00d4, B:37:0x00e0, B:39:0x00e8, B:41:0x00f4, B:42:0x010a, B:45:0x0112, B:47:0x0129, B:48:0x0136, B:50:0x0148, B:51:0x014d, B:54:0x017e, B:55:0x0193, B:59:0x019f, B:62:0x01a6, B:65:0x01ae, B:77:0x01f9, B:79:0x0225, B:80:0x022d, B:82:0x0233, B:83:0x0254, B:89:0x0291, B:91:0x029c, B:92:0x02b1, B:94:0x02f3, B:99:0x0313, B:67:0x01b8, B:69:0x01be, B:70:0x01c6, B:72:0x01d4, B:73:0x01e0, B:74:0x01ed, B:101:0x033c, B:103:0x034e, B:105:0x0351, B:106:0x0359, B:108:0x035f, B:109:0x037a, B:111:0x0386, B:113:0x038e, B:115:0x039a, B:117:0x03a1, B:119:0x03ad, B:121:0x03b5, B:123:0x03c1, B:125:0x03c5, B:126:0x03ca, B:130:0x03df, B:132:0x03f2, B:134:0x03fe, B:129:0x03dc, B:136:0x040a, B:138:0x0417, B:140:0x0423), top: B:151:0x0007 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        byte[] a2;
        Map<String, String> map;
        String str;
        boolean z;
        long j;
        String str2 = "Bugly-Version";
        int i = 0;
        try {
            this.p = 0;
            this.f6261q = 0L;
            this.r = 0L;
            byte[] bArr = this.f6260e;
            if (com.tencent.bugly.crashreport.common.info.b.c(this.f6258c) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArr != null && bArr.length != 0) {
                x.c("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f6259d));
                if (this.f6258c != null && this.f != null && this.g != null && this.h != null) {
                    StrategyBean c2 = this.g.c();
                    if (c2 == null) {
                        a(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("prodId", this.f.f());
                    hashMap.put("bundleId", this.f.f6007c);
                    hashMap.put("appVer", this.f.k);
                    if (this.o != null) {
                        hashMap.putAll(this.o);
                    }
                    int i2 = 2;
                    if (this.s) {
                        hashMap.put("cmd", Integer.toString(this.f6259d));
                        hashMap.put("platformId", Byte.toString((byte) 1));
                        hashMap.put("sdkVer", this.f.f);
                        hashMap.put("strategylastUpdateTime", Long.toString(c2.p));
                        if (!this.i.a(hashMap)) {
                            a(null, false, 0, "failed to add security info to HTTP headers", 0);
                            return;
                        }
                        byte[] a3 = z.a(bArr, 2);
                        if (a3 == null) {
                            a(null, false, 0, "failed to zip request body", 0);
                            return;
                        }
                        bArr = this.i.a(a3);
                        if (bArr == null) {
                            a(null, false, 0, "failed to encrypt request body", 0);
                            return;
                        }
                    }
                    this.i.a(this.j, System.currentTimeMillis());
                    t tVar = this.k;
                    t tVar2 = this.l;
                    String str3 = this.m;
                    int i3 = 0;
                    int i4 = -1;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        if (i5 < this.f6256a) {
                            if (i6 > 1) {
                                x.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i6));
                                z.b(this.f6257b);
                                if (i6 == this.f6256a) {
                                    x.d("[Upload] Use the back-up url at the last time: %s", this.n);
                                    str3 = this.n;
                                }
                            }
                            x.c("[Upload] Send %d bytes", Integer.valueOf(bArr.length));
                            if (this.s) {
                                str3 = a(str3);
                            }
                            Object[] objArr = new Object[4];
                            objArr[0] = str3;
                            objArr[1] = Integer.valueOf(this.f6259d);
                            objArr[i2] = Integer.valueOf(Process.myPid());
                            objArr[3] = Integer.valueOf(Process.myTid());
                            x.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", objArr);
                            a2 = this.h.a(str3, bArr, this, hashMap);
                            if (a2 == null) {
                                Object[] objArr2 = new Object[i2];
                                objArr2[0] = 1;
                                objArr2[1] = "Failed to upload for no response!";
                                x.e("[Upload] Failed to upload(%d): %s", objArr2);
                                i5 = i6;
                                i3 = 1;
                            } else {
                                map = this.h.f6240a;
                                if (!this.s) {
                                    break;
                                }
                                if (map != null && map.size() != 0) {
                                    if (!map.containsKey("status")) {
                                        x.d("[Upload] Headers does not contain %s", "status");
                                    } else if (map.containsKey(str2)) {
                                        String str4 = map.get(str2);
                                        if (str4.contains("bugly")) {
                                            str = str2;
                                            x.c("[Upload] Bugly version from headers is: %s", str4);
                                            z = true;
                                            if (z) {
                                            }
                                            i3 = 1;
                                            i2 = 2;
                                        } else {
                                            str = str2;
                                            x.d("[Upload] Bugly version is not valid: %s", str4);
                                            z = false;
                                            if (z) {
                                                x.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for no status header.");
                                                if (map != null) {
                                                    for (Map.Entry<String, String> entry : map.entrySet()) {
                                                        x.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                                                    }
                                                }
                                                x.c("[Upload] Failed to upload for no status header.", new Object[0]);
                                                i5 = i6;
                                                str2 = str;
                                            } else {
                                                try {
                                                    int parseInt = Integer.parseInt(map.get("status"));
                                                    try {
                                                        x.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(parseInt), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                        if (parseInt != 0) {
                                                            if (parseInt == 2) {
                                                                if (this.f6261q + this.r > 0) {
                                                                    this.i.a(this.i.a(this.t) + this.f6261q + this.r, this.t);
                                                                }
                                                                this.i.a(parseInt, (aq) null);
                                                                x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                                                this.i.a(this.j, this.f6259d, this.f6260e, this.m, this.n, this.k, this.f6256a, this.f6257b, true, this.o);
                                                                return;
                                                            }
                                                            a(null, false, 1, "status of server is " + parseInt, parseInt);
                                                            return;
                                                        }
                                                        i4 = parseInt;
                                                    } catch (Throwable unused) {
                                                        j = 0;
                                                        i4 = parseInt;
                                                        x.e("[Upload] Failed to upload(%d): %s", 1, "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i4));
                                                        i5 = i6;
                                                        str2 = str;
                                                        i3 = 1;
                                                        i2 = 2;
                                                    }
                                                } catch (Throwable unused2) {
                                                    j = 0;
                                                }
                                            }
                                            i3 = 1;
                                            i2 = 2;
                                        }
                                    } else {
                                        x.d("[Upload] Headers does not contain %s", str2);
                                    }
                                    str = str2;
                                    z = false;
                                    if (z) {
                                    }
                                    i3 = 1;
                                    i2 = 2;
                                }
                                str = str2;
                                x.d("[Upload] Headers is empty.", new Object[0]);
                                z = false;
                                if (z) {
                                }
                                i3 = 1;
                                i2 = 2;
                            }
                        } else {
                            a(null, false, i3, "failed after many attempts", 0);
                            return;
                        }
                    }
                    x.c("[Upload] Received %d bytes", Integer.valueOf(a2.length));
                    if (this.s) {
                        if (a2.length == 0) {
                            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                                x.c("[Upload] HTTP headers from server: key = %s, value = %s", entry2.getKey(), entry2.getValue());
                            }
                            a(null, false, 1, "response data from server is empty", 0);
                            return;
                        }
                        byte[] b2 = this.i.b(a2);
                        if (b2 == null) {
                            a(null, false, 1, "failed to decrypt response from server", 0);
                            return;
                        }
                        a2 = z.b(b2, 2);
                        if (a2 == null) {
                            a(null, false, 1, "failed unzip(Gzip) response from server", 0);
                            return;
                        }
                    }
                    aq a4 = a.a(a2, this.s);
                    if (a4 == null) {
                        a(null, false, 1, "failed to decode response package", 0);
                        return;
                    }
                    if (this.s) {
                        this.i.a(i4, a4);
                    }
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(a4.f6168b);
                    if (a4.f6169c != null) {
                        i = a4.f6169c.length;
                    }
                    objArr3[1] = Integer.valueOf(i);
                    x.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr3);
                    if (!a(a4, this.f, this.g)) {
                        a(a4, false, 2, "failed to process response package", 0);
                        return;
                    } else {
                        a(a4, true, 2, "successfully uploaded", 0);
                        return;
                    }
                }
                a(null, false, 0, "illegal access error", 0);
                return;
            }
            a(null, false, 0, "request package is empty!", 0);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(long j) {
        this.p++;
        this.f6261q += j;
    }

    public final void b(long j) {
        this.r += j;
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }
}
