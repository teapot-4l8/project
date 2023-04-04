package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdlu<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdmh<R, zzdly<AdT>> {
    private final Executor executor;
    private final zzdqz zzhkm;
    private zzebi<Void> zzhkn = new zzdlv(this);

    public zzdlu(zzdqz zzdqzVar, Executor executor) {
        this.zzhkm = zzdqzVar;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdmh
    public final /* bridge */ /* synthetic */ Object zzavm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdmh
    public final zzebt<zzdly<AdT>> zza(zzdmm zzdmmVar, zzdmj<R> zzdmjVar) {
        return zzebc.zzg(new zzdmb(this.zzhkm, zzdmmVar.zzhku, zzdmjVar, this.executor).zzavr()).zzb(new zzear(this, zzdmmVar, zzdmjVar) { // from class: com.google.android.gms.internal.ads.zzdlt
            private final zzdmm zzhkb;
            private final zzdlu zzhkk;
            private final zzdmj zzhkl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhkk = this;
                this.zzhkb = zzdmmVar;
                this.zzhkl = zzdmjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzhkk.zza(this.zzhkb, this.zzhkl, (zzdmf) obj);
            }
        }, this.executor).zza(Exception.class, new zzdlw(this), this.executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdmm zzdmmVar, zzdmj zzdmjVar, zzdmf zzdmfVar) {
        zzdri zzdriVar = zzdmfVar.zzhkj;
        zzauj zzaujVar = zzdmfVar.zzgrg;
        zzdrj<?> zza = zzdriVar != null ? this.zzhkm.zza(zzdriVar) : null;
        if (zzdriVar == null) {
            return zzebh.zzag(null);
        }
        if (zza != null && zzaujVar != null) {
            zzebh.zza(((zzbsh) zzdmjVar.zzc(zzdmmVar.zzhku).zzahg()).zzahd().zzc(zzaujVar), this.zzhkn, this.executor);
        }
        return zzebh.zzag(new zzdly(zzdriVar, zzaujVar, zza));
    }
}
