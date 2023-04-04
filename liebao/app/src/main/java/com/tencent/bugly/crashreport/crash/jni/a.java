package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class a implements NativeExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6120a;

    /* renamed from: b  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f6121b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6122c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f6123d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.f6120a = context;
        this.f6121b = bVar;
        this.f6122c = aVar;
        this.f6123d = aVar2;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean k = c.a().k();
        if (k) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f6036b = 1;
        crashDetailBean.f6039e = this.f6122c.h();
        crashDetailBean.f = this.f6122c.k;
        crashDetailBean.g = this.f6122c.w();
        crashDetailBean.m = this.f6122c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = k ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        crashDetailBean.f6040q = str5 != null ? str5 : "";
        crashDetailBean.r = j;
        crashDetailBean.u = z.b(crashDetailBean.f6040q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f6122c.y();
        crashDetailBean.h = this.f6122c.v();
        crashDetailBean.i = this.f6122c.J();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a2 = b.a(dumpFilePath, str8);
        if (!z.a(a2)) {
            crashDetailBean.U = a2;
        }
        crashDetailBean.V = b.b(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.f6078e, null, false);
        crashDetailBean.x = b.a(str10, c.f6078e, null, true);
        crashDetailBean.J = str7;
        crashDetailBean.K = str6;
        crashDetailBean.L = str11;
        crashDetailBean.F = this.f6122c.p();
        crashDetailBean.G = this.f6122c.o();
        crashDetailBean.H = this.f6122c.q();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = z.a(this.f6120a, c.f6078e, (String) null);
            }
            crashDetailBean.y = y.a();
            crashDetailBean.M = this.f6122c.f6005a;
            crashDetailBean.N = this.f6122c.a();
            crashDetailBean.P = this.f6122c.H();
            crashDetailBean.Q = this.f6122c.I();
            crashDetailBean.R = this.f6122c.B();
            crashDetailBean.S = this.f6122c.G();
            crashDetailBean.z = z.a(c.f, false);
            int indexOf2 = crashDetailBean.f6040q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.f6040q.length()) {
                String substring = crashDetailBean.f6040q.substring(i, crashDetailBean.f6040q.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.f6040q = crashDetailBean.f6040q.substring(0, i);
                    crashDetailBean.f6040q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f6122c.f6008d;
            }
            this.f6121b.d(crashDetailBean);
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.M = -1L;
            crashDetailBean.P = -1;
            crashDetailBean.Q = -1;
            crashDetailBean.R = map;
            crashDetailBean.S = this.f6122c.G();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        x.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011d A[Catch: all -> 0x0291, TryCatch #0 {all -> 0x0291, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:95:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014d A[Catch: all -> 0x0291, TryCatch #0 {all -> 0x0291, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:95:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ac A[Catch: all -> 0x0291, TryCatch #0 {all -> 0x0291, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:95:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bf A[Catch: all -> 0x0291, TRY_ENTER, TryCatch #0 {all -> 0x0291, blocks: (B:3:0x0010, B:6:0x001c, B:15:0x0069, B:18:0x0071, B:20:0x0074, B:22:0x0078, B:24:0x0093, B:25:0x009c, B:26:0x00a6, B:28:0x00b0, B:30:0x00ba, B:32:0x00c2, B:34:0x00ce, B:36:0x00d8, B:39:0x00df, B:41:0x00ee, B:43:0x00fa, B:46:0x0101, B:47:0x0117, B:49:0x011d, B:51:0x012d, B:54:0x014d, B:56:0x0187, B:58:0x01ac, B:59:0x01b3, B:62:0x01bf, B:64:0x01c7, B:55:0x0165, B:40:0x00ea, B:27:0x00a9, B:9:0x0041, B:10:0x0045, B:12:0x004f), top: B:95:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0223 A[Catch: all -> 0x028d, TryCatch #2 {all -> 0x028d, blocks: (B:67:0x021d, B:69:0x0223, B:71:0x022c), top: B:99:0x021d }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022c A[Catch: all -> 0x028d, TRY_LEAVE, TryCatch #2 {all -> 0x028d, blocks: (B:67:0x021d, B:69:0x0223, B:71:0x022c), top: B:99:0x021d }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleNativeException2(int r27, int r28, long r29, long r31, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, int r40, int r41, java.lang.String r42, java.lang.String r43, java.lang.String[] r44) {
        /*
            Method dump skipped, instructions count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}
