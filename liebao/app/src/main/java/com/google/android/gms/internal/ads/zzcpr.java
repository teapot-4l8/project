package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpr {
    private final zzebs zzgka;
    private final zzeru<zzcqb> zzgqd;
    private final zzcpe zzgru;

    public zzcpr(zzebs zzebsVar, zzcpe zzcpeVar, zzeru<zzcqb> zzeruVar) {
        this.zzgka = zzebsVar;
        this.zzgru = zzcpeVar;
        this.zzgqd = zzeruVar;
    }

    private final <RetT> zzebt<RetT> zza(zzauj zzaujVar, zzcpy<InputStream> zzcpyVar, zzcpy<InputStream> zzcpyVar2, zzear<InputStream, RetT> zzearVar) {
        zzebt zzb;
        String str = zzaujVar.packageName;
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzem(str)) {
            zzb = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INTERNAL_ERROR));
        } else {
            zzb = zzebh.zzb(zzcpyVar.zzq(zzaujVar), ExecutionException.class, zzcpq.zzbpa, this.zzgka);
        }
        return zzebc.zzg(zzb).zzb(zzearVar, this.zzgka).zza(zzcpo.class, new zzear(this, zzcpyVar2, zzaujVar, zzearVar) { // from class: com.google.android.gms.internal.ads.zzcpt
            private final zzcpr zzgrv;
            private final zzcpy zzgrw;
            private final zzauj zzgrx;
            private final zzear zzgry;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrv = this;
                this.zzgrw = zzcpyVar2;
                this.zzgrx = zzaujVar;
                this.zzgry = zzearVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgrv.zza(this.zzgrw, this.zzgrx, this.zzgry, (zzcpo) obj);
            }
        }, this.zzgka);
    }

    public final zzebt<zzauj> zzl(zzauj zzaujVar) {
        zzear zzearVar = new zzear(zzaujVar) { // from class: com.google.android.gms.internal.ads.zzcps
            private final zzauj zzgca;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgca = zzaujVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                zzauj zzaujVar2 = this.zzgca;
                zzaujVar2.zzdyv = new String(zzdzz.toByteArray((InputStream) obj), zzdxu.UTF_8);
                return zzebh.zzag(zzaujVar2);
            }
        };
        zzcpe zzcpeVar = this.zzgru;
        zzcpeVar.getClass();
        return zza(zzaujVar, zzcpv.zza(zzcpeVar), new zzcpy(this) { // from class: com.google.android.gms.internal.ads.zzcpu
            private final zzcpr zzgrv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrv = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcpy
            public final zzebt zzq(zzauj zzaujVar2) {
                return this.zzgrv.zzp(zzaujVar2);
            }
        }, zzearVar);
    }

    public final zzebt<Void> zzm(zzauj zzaujVar) {
        if (zzfh.zzar(zzaujVar.zzdyv)) {
            return zzebh.immediateFailedFuture(new zzcnp(zzdqj.INVALID_REQUEST, "Pool key missing from removeUrl call."));
        }
        return zza(zzaujVar, new zzcpy(this) { // from class: com.google.android.gms.internal.ads.zzcpw
            private final zzcpr zzgrv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrv = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcpy
            public final zzebt zzq(zzauj zzaujVar2) {
                return this.zzgrv.zzo(zzaujVar2);
            }
        }, new zzcpy(this) { // from class: com.google.android.gms.internal.ads.zzcpz
            private final zzcpr zzgrv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrv = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcpy
            public final zzebt zzq(zzauj zzaujVar2) {
                return this.zzgrv.zzn(zzaujVar2);
            }
        }, zzcpx.zzbpa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzn(zzauj zzaujVar) {
        return this.zzgqd.get().zzgk(zzaujVar.zzdyv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzo(zzauj zzaujVar) {
        return this.zzgru.zzgj(zzaujVar.zzdyv);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzp(zzauj zzaujVar) {
        return this.zzgqd.get().zzc(zzaujVar, Binder.getCallingUid());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzcpy zzcpyVar, zzauj zzaujVar, zzear zzearVar, zzcpo zzcpoVar) {
        return zzebh.zzb(zzcpyVar.zzq(zzaujVar), zzearVar, this.zzgka);
    }
}
