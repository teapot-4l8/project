package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqd<T> {
    private final Executor executor;
    private final zzcov zzfzf;
    private final zzdpm zzfzg;
    private final zzdtg zzfzh;
    private final zzbkl zzfzi;
    private final zzcwr<T> zzfzj;
    private final zzbxf zzfzk;
    private final zzdpi zzfzl;
    private final zzcpr zzfzm;
    private final zzbsc zzfzn;
    private final zzcpk zzfzo;
    private final zzctc zzfzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqd(zzcov zzcovVar, zzdpm zzdpmVar, zzdtg zzdtgVar, zzbkl zzbklVar, zzcwr<T> zzcwrVar, zzbxf zzbxfVar, zzdpi zzdpiVar, zzcpr zzcprVar, zzbsc zzbscVar, Executor executor, zzcpk zzcpkVar, zzctc zzctcVar) {
        this.zzfzf = zzcovVar;
        this.zzfzg = zzdpmVar;
        this.zzfzh = zzdtgVar;
        this.zzfzi = zzbklVar;
        this.zzfzj = zzcwrVar;
        this.zzfzk = zzbxfVar;
        this.zzfzl = zzdpiVar;
        this.zzfzm = zzcprVar;
        this.zzfzn = zzbscVar;
        this.executor = executor;
        this.zzfzo = zzcpkVar;
        this.zzfzp = zzctcVar;
    }

    private final zzebt<zzdpi> zza(zzebt<zzauj> zzebtVar) {
        if (this.zzfzl != null) {
            return this.zzfzh.zzt(zzdth.SERVER_TRANSACTION).zze(zzebh.zzag(this.zzfzl)).zzayi();
        }
        com.google.android.gms.ads.internal.zzr.zzlb().zzna();
        if (this.zzfzg.zzhnx.zzcip != null) {
            return this.zzfzh.zzt(zzdth.SERVER_TRANSACTION).zze(this.zzfzf.zzasl()).zzayi();
        }
        zzdsy<I> zza = this.zzfzh.zza((zzdtg) zzdth.SERVER_TRANSACTION, (zzebt) zzebtVar);
        zzcpk zzcpkVar = this.zzfzo;
        zzcpkVar.getClass();
        return zza.zza(zzbqc.zza(zzcpkVar)).zzayi();
    }

    public final zzebt<zzdpi> zza(zzauj zzaujVar) {
        return zza(zzebh.zzag(zzaujVar));
    }

    public final zzebt<zzdpi> zzalu() {
        return zza(this.zzfzn.zzamd());
    }

    public final zzebt<T> zzb(zzebt<zzdpi> zzebtVar) {
        zzdsy zza = this.zzfzh.zza((zzdtg) zzdth.RENDERER, (zzebt) zzebtVar).zzb(new zzdsr(this) { // from class: com.google.android.gms.internal.ads.zzbqf
            private final zzbqd zzfzq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzq = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdsr
            public final Object apply(Object obj) {
                return this.zzfzq.zzc((zzdpi) obj);
            }
        }).zza(this.zzfzj);
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcxh)).booleanValue()) {
            zza = zza.zza(((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS);
        }
        return zza.zzayi();
    }

    public final zzebt<T> zzb(zzauj zzaujVar) {
        return zzb(zza(zzaujVar));
    }

    public final zzebt<T> zzalv() {
        return zzb(zzalu());
    }

    public final zzbxf zzalw() {
        return this.zzfzk;
    }

    public final zzebt<zzauj> zza(final zzdrc zzdrcVar) {
        zzdst zzayi = this.zzfzh.zza((zzdtg) zzdth.GET_CACHE_KEY, (zzebt) this.zzfzn.zzamd()).zza(new zzear(this, zzdrcVar) { // from class: com.google.android.gms.internal.ads.zzbqe
            private final zzbqd zzfzq;
            private final zzdrc zzfzr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzq = this;
                this.zzfzr = zzdrcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzfzq.zza(this.zzfzr, (zzauj) obj);
            }
        }).zzayi();
        zzebh.zza(zzayi, new zzbqh(this), this.executor);
        return zzayi;
    }

    public final zzebt<Void> zzc(zzauj zzaujVar) {
        zzdst zzayi = this.zzfzh.zza((zzdtg) zzdth.NOTIFY_CACHE_HIT, (zzebt) this.zzfzm.zzm(zzaujVar)).zzayi();
        zzebh.zza(zzayi, new zzbqg(this), this.executor);
        return zzayi;
    }

    public final zzvh zze(Throwable th) {
        return zzdqh.zza(th, this.zzfzp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdrc zzdrcVar, zzauj zzaujVar) {
        zzaujVar.zzdyu = zzdrcVar;
        return this.zzfzm.zzl(zzaujVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdpi zzc(zzdpi zzdpiVar) {
        this.zzfzi.zzb(zzdpiVar);
        return zzdpiVar;
    }
}
