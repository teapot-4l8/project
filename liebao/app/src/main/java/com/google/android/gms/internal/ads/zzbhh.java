package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzbhh implements zzbki {
    private static zzbhh zzeyh;

    protected abstract zzdhw zza(zzdjb zzdjbVar);

    public abstract zzdtw zzafu();

    public abstract Executor zzafv();

    public abstract ScheduledExecutorService zzafw();

    public abstract Executor zzafx();

    public abstract zzebs zzafy();

    public abstract zzbve zzafz();

    public abstract zzckb zzaga();

    public abstract zzbjr zzagb();

    public abstract zzbod zzagc();

    public abstract zzdlh zzagd();

    public abstract zzbmj zzage();

    public abstract zzbms zzagf();

    public abstract zzdjy zzagg();

    public abstract zzcbi zzagh();

    public abstract zzdnc zzagi();

    public abstract zzcce zzagj();

    public abstract zzciv zzagk();

    public abstract zzdoo zzagl();

    public abstract zzdbc zzagm();

    public abstract zzdbf zzagn();

    public abstract zzcsr zzago();

    public abstract zzdqc<zzchu> zzagp();

    public static zzbhh zza(Context context, zzann zzannVar, int i) {
        zzbhh zzh = zzh(context, i);
        zzh.zzaga().zzb(zzannVar);
        return zzh;
    }

    @Deprecated
    public static zzbhh zzh(Context context, int i) {
        synchronized (zzbhh.class) {
            if (zzeyh != null) {
                return zzeyh;
            }
            return zza(new zzbar(204890000, i, true, false), context, new zzbib());
        }
    }

    @Deprecated
    private static synchronized zzbhh zza(zzbar zzbarVar, Context context, zzbjl.zza zzaVar) {
        zzbhh zzbhhVar;
        synchronized (zzbhh.class) {
            if (zzeyh == null) {
                zzeyh = new zzbix().zzc(new zzbhg(new zzbhg.zza().zza(zzbarVar).zzbz(context))).zza(new zzbjl(zzaVar)).zzaip();
                zzabq.initialize(context);
                com.google.android.gms.ads.internal.zzr.zzkz().zzd(context, zzbarVar);
                com.google.android.gms.ads.internal.zzr.zzlb().initialize(context);
                com.google.android.gms.ads.internal.zzr.zzkv().zzan(context);
                com.google.android.gms.ads.internal.zzr.zzkv().zzao(context);
                com.google.android.gms.ads.internal.util.zzb.zzam(context);
                com.google.android.gms.ads.internal.zzr.zzky().initialize(context);
                com.google.android.gms.ads.internal.zzr.zzlq().initialize(context);
                zzayt.zzaj(context);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue()) {
                    if (!((Boolean) zzww.zzra().zzd(zzabq.zzcph)).booleanValue()) {
                        zztz zztzVar = new zztz(new zzue(context));
                        zzcrl zzcrlVar = new zzcrl(new zzcrj(context), zzeyh.zzafy());
                        com.google.android.gms.ads.internal.zzr.zzkv();
                        new zzcsb(context, zzbarVar, zztzVar, zzcrlVar, com.google.android.gms.ads.internal.util.zzj.zzzr(), zzeyh.zzafu()).zzbo(com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzn());
                    }
                }
            }
            zzbhhVar = zzeyh;
        }
        return zzbhhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbki
    public final zzdhw zza(zzauj zzaujVar, int i) {
        return zza(new zzdjb(zzaujVar, i));
    }
}
