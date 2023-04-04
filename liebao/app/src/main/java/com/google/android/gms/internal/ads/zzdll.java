package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;
import com.google.android.gms.internal.ads.zzuh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdll<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdmh<R, AdT> {
    private final Executor executor;
    private final zzdmh<R, AdT> zzhim;
    private final zzdmh<R, zzdly<AdT>> zzhjv;
    private final zzdrr<AdT> zzhjw;
    private R zzhjx;

    public zzdll(zzdmh<R, AdT> zzdmhVar, zzdmh<R, zzdly<AdT>> zzdmhVar2, zzdrr<AdT> zzdrrVar, Executor executor) {
        this.zzhim = zzdmhVar;
        this.zzhjv = zzdmhVar2;
        this.zzhjw = zzdrrVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzdmh
    /* renamed from: zzavn */
    public final synchronized R zzavm() {
        return this.zzhjx;
    }

    @Override // com.google.android.gms.internal.ads.zzdmh
    public final synchronized zzebt<AdT> zza(zzdmm zzdmmVar, zzdmj<R> zzdmjVar) {
        zzdpm zzaia;
        zzaia = zzdmjVar.zzc(zzdmmVar.zzhku).zzahg().zzaia();
        return zzebc.zzg(this.zzhjv.zza(zzdmmVar, zzdmjVar)).zzb(new zzear(this, zzdmmVar, new zzdls(zzdmjVar, zzdmmVar, zzaia.zzhnx, zzaia.zzhny, this.executor, zzaia.zzhob, null), zzdmjVar) { // from class: com.google.android.gms.internal.ads.zzdlo
            private final zzdll zzhka;
            private final zzdmm zzhkb;
            private final zzdls zzhkc;
            private final zzdmj zzhkd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhka = this;
                this.zzhkb = zzdmmVar;
                this.zzhkc = r3;
                this.zzhkd = zzdmjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzhka.zza(this.zzhkb, this.zzhkc, this.zzhkd, (zzdly) obj);
            }
        }, this.executor);
    }

    private final zzebt<AdT> zza(zzdrj<AdT> zzdrjVar, zzdmm zzdmmVar, zzdmj<R> zzdmjVar) {
        zzbsg<R> zzc = zzdmjVar.zzc(zzdmmVar.zzhku);
        if (zzdrjVar.zzhrk != null) {
            R zzahg = zzc.zzahg();
            if (zzahg.zzaib() != null) {
                zzdrjVar.zzhrk.zzalm().zzb(zzahg.zzaib());
            }
            return zzebh.zzag(zzdrjVar.zzhrk);
        }
        zzc.zza(zzdrjVar.zzfbh);
        zzebt<AdT> zza = this.zzhim.zza(zzdmmVar, new zzdmj(zzc) { // from class: com.google.android.gms.internal.ads.zzdln
            private final zzbsg zzhjz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhjz = zzc;
            }

            @Override // com.google.android.gms.internal.ads.zzdmj
            public final zzbsg zzc(zzdmk zzdmkVar) {
                return this.zzhjz;
            }
        });
        this.zzhjx = this.zzhim.zzavm();
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdmj zzdmjVar, zzdrv zzdrvVar) {
        if (zzdrvVar != null && zzdrvVar.zzhko != null && zzdrvVar.zzhsa != null) {
            zzdrvVar.zzhko.zzhrj.zzalw().zze((zzuh.zzb) ((zzena) zzuh.zzb.zznt().zza(zzuh.zzb.zza.zznr().zzb(zzuh.zzb.zzc.IN_MEMORY).zza(zzuh.zzb.zzd.zznv())).zzbjv()));
            return zza(zzdrvVar.zzhko, ((zzdls) zzdrvVar.zzhsa).zzhki, zzdmjVar);
        }
        throw new zzcnp(zzdqj.INTERNAL_ERROR, "Empty prefetch");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdmm zzdmmVar, zzdls zzdlsVar, zzdmj zzdmjVar, zzdly zzdlyVar) {
        if (zzdlyVar != null) {
            zzdls zzdlsVar2 = new zzdls(zzdlsVar.zzhkh, zzdlsVar.zzhki, zzdlsVar.zzdvn, zzdlsVar.zzbvf, zzdlsVar.executor, zzdlsVar.zzhdy, zzdlyVar.zzhkj);
            if (zzdlyVar.zzhko != null) {
                this.zzhjx = null;
                this.zzhjw.zzb(zzdlsVar2);
                return zza(zzdlyVar.zzhko, zzdmmVar, zzdmjVar);
            }
            zzebt<zzdrv<AdT>> zzc = this.zzhjw.zzc(zzdlsVar2);
            if (zzc != null) {
                this.zzhjx = (R) zzdmjVar.zzc(zzdmmVar.zzhku).zzahg();
                return zzebh.zzb(zzc, new zzear(this, zzdmjVar) { // from class: com.google.android.gms.internal.ads.zzdlq
                    private final zzdll zzhka;
                    private final zzdmj zzhkf;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhka = this;
                        this.zzhkf = zzdmjVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzear
                    public final zzebt zzf(Object obj) {
                        return this.zzhka.zza(this.zzhkf, (zzdrv) obj);
                    }
                }, this.executor);
            }
            this.zzhjw.zzb(zzdlsVar2);
            zzdmmVar = new zzdmm(zzdmmVar.zzhku, zzdlyVar.zzgrg);
        }
        zzebt<AdT> zza = this.zzhim.zza(zzdmmVar, zzdmjVar);
        this.zzhjx = this.zzhim.zzavm();
        return zza;
    }
}
