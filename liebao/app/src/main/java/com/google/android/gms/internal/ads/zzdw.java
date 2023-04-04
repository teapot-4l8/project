package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzdw {
    private static final ConditionVariable zzwi = new ConditionVariable();
    protected static volatile zzue zzwj = null;
    private static volatile Random zzwl = null;
    private zzfc zzwh;
    protected volatile Boolean zzwk;

    public zzdw(zzfc zzfcVar) {
        this.zzwh = zzfcVar;
        zzfcVar.zzch().execute(new zzdv(this));
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, null, null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzwi.block();
            if (!this.zzwk.booleanValue() || zzwj == null) {
                return;
            }
            zzbw.zza.zzb zzd = zzbw.zza.zzs().zzo(this.zzwh.context.getPackageName()).zzd(j);
            if (str != null) {
                zzd.zzr(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzekz.zza(exc, new PrintWriter(stringWriter));
                zzd.zzp(stringWriter.toString()).zzq(exc.getClass().getName());
            }
            zzui zzf = zzwj.zzf(((zzbw.zza) ((zzena) zzd.zzbjv())).toByteArray());
            zzf.zzby(i);
            if (i2 != -1) {
                zzf.zzbx(i2);
            }
            zzf.log();
        } catch (Exception unused) {
        }
    }

    public static int zzbv() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return zzbw().nextInt();
        } catch (RuntimeException unused) {
            return zzbw().nextInt();
        }
    }

    private static Random zzbw() {
        if (zzwl == null) {
            synchronized (zzdw.class) {
                if (zzwl == null) {
                    zzwl = new Random();
                }
            }
        }
        return zzwl;
    }
}
