package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdsy<O> {
    private final E zzhsw;
    private final String zzhsx;
    private final List<zzebt<?>> zzhsz;
    final /* synthetic */ zzdss zzhta;
    private final zzebt<?> zzhtb;
    private final zzebt<O> zzhtc;

    private zzdsy(zzdss zzdssVar, E e2, String str, zzebt<?> zzebtVar, List<zzebt<?>> list, zzebt<O> zzebtVar2) {
        this.zzhta = zzdssVar;
        this.zzhsw = e2;
        this.zzhsx = str;
        this.zzhtb = zzebtVar;
        this.zzhsz = list;
        this.zzhtc = zzebtVar2;
    }

    public final zzdsy<O> zzgv(String str) {
        return new zzdsy<>(this.zzhta, this.zzhsw, str, this.zzhtb, this.zzhsz, this.zzhtc);
    }

    public final <O2> zzdsy<O2> zzb(final zzdsr<O, O2> zzdsrVar) {
        return zza(new zzear(zzdsrVar) { // from class: com.google.android.gms.internal.ads.zzdtb
            private final zzdsr zzhte;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhte = zzdsrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return zzebh.zzag(this.zzhte.apply(obj));
            }
        });
    }

    public final <O2> zzdsy<O2> zza(zzear<O, O2> zzearVar) {
        zzebs zzebsVar;
        zzebsVar = this.zzhta.zzgka;
        return zza(zzearVar, zzebsVar);
    }

    private final <O2> zzdsy<O2> zza(zzear<O, O2> zzearVar, Executor executor) {
        return new zzdsy<>(this.zzhta, this.zzhsw, this.zzhsx, this.zzhtb, this.zzhsz, zzebh.zzb(this.zzhtc, zzearVar, executor));
    }

    public final <O2> zzdsy<O2> zze(zzebt<O2> zzebtVar) {
        return zza(new zzear(zzebtVar) { // from class: com.google.android.gms.internal.ads.zzdta
            private final zzebt zzgkr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkr = zzebtVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgkr;
            }
        }, zzbat.zzekj);
    }

    public final <T extends Throwable> zzdsy<O> zza(Class<T> cls, final zzdsr<T, O> zzdsrVar) {
        return zza(cls, new zzear(zzdsrVar) { // from class: com.google.android.gms.internal.ads.zzdtd
            private final zzdsr zzhte;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhte = zzdsrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return zzebh.zzag(this.zzhte.apply((Throwable) obj));
            }
        });
    }

    public final <T extends Throwable> zzdsy<O> zza(Class<T> cls, zzear<T, O> zzearVar) {
        zzebs zzebsVar;
        zzdss zzdssVar = this.zzhta;
        E e2 = this.zzhsw;
        String str = this.zzhsx;
        zzebt<?> zzebtVar = this.zzhtb;
        List<zzebt<?>> list = this.zzhsz;
        zzebt<O> zzebtVar2 = this.zzhtc;
        zzebsVar = zzdssVar.zzgka;
        return new zzdsy<>(zzdssVar, e2, str, zzebtVar, list, zzebh.zzb(zzebtVar2, cls, zzearVar, zzebsVar));
    }

    public final zzdsy<O> zza(long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService;
        zzdss zzdssVar = this.zzhta;
        E e2 = this.zzhsw;
        String str = this.zzhsx;
        zzebt<?> zzebtVar = this.zzhtb;
        List<zzebt<?>> list = this.zzhsz;
        zzebt<O> zzebtVar2 = this.zzhtc;
        scheduledExecutorService = zzdssVar.zzfvp;
        return new zzdsy<>(zzdssVar, e2, str, zzebtVar, list, zzebh.zza(zzebtVar2, j, timeUnit, scheduledExecutorService));
    }

    public final zzdst<E, O> zzayi() {
        zzdte zzdteVar;
        E e2 = this.zzhsw;
        String str = this.zzhsx;
        if (str == null) {
            str = this.zzhta.zzu(e2);
        }
        final zzdst<E, O> zzdstVar = new zzdst<>(e2, str, this.zzhtc);
        zzdteVar = this.zzhta.zzhsv;
        zzdteVar.zza(zzdstVar);
        this.zzhtb.addListener(new Runnable(this, zzdstVar) { // from class: com.google.android.gms.internal.ads.zzdtc
            private final zzdsy zzhtf;
            private final zzdst zzhtg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhtf = this;
                this.zzhtg = zzdstVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzdte zzdteVar2;
                zzdsy zzdsyVar = this.zzhtf;
                zzdst zzdstVar2 = this.zzhtg;
                zzdteVar2 = zzdsyVar.zzhta.zzhsv;
                zzdteVar2.zzb(zzdstVar2);
            }
        }, zzbat.zzekj);
        zzebh.zza(zzdstVar, new zzdtf(this, zzdstVar), zzbat.zzekj);
        return zzdstVar;
    }

    public final zzdsy<O> zzv(E e2) {
        return this.zzhta.zza((zzdss) e2, (zzebt) zzayi());
    }
}
