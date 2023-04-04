package com.google.android.gms.internal.ads;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-ads-base@@19.8.0 */
/* loaded from: classes.dex */
public final class zzekz {
    private static final zzeky zziog;
    private static final int zzioh;

    public static void zza(Throwable th, Throwable th2) {
        zziog.zza(th, th2);
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@19.8.0 */
    /* loaded from: classes.dex */
    static final class zza extends zzeky {
        zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzeky
        public final void zza(Throwable th, Throwable th2) {
        }

        @Override // com.google.android.gms.internal.ads.zzeky
        public final void zza(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        zziog.zza(th, printWriter);
    }

    private static Integer zzbgw() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    static {
        Integer num;
        zzeky zzaVar;
        try {
            num = zzbgw();
        } catch (Throwable th) {
            th = th;
            num = null;
        }
        if (num != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                PrintStream printStream = System.err;
                String name = zza.class.getName();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
                sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                sb.append(name);
                sb.append("will be used. The error is: ");
                printStream.println(sb.toString());
                th.printStackTrace(System.err);
                zzaVar = new zza();
                zziog = zzaVar;
                zzioh = num != null ? num.intValue() : 1;
            }
            if (num.intValue() >= 19) {
                zzaVar = new zzele();
                zziog = zzaVar;
                zzioh = num != null ? num.intValue() : 1;
            }
        }
        if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
            zzaVar = new zzelc();
        } else {
            zzaVar = new zza();
        }
        zziog = zzaVar;
        zzioh = num != null ? num.intValue() : 1;
    }
}
