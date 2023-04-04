package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdmb<R extends zzbsh<? extends zzbpc>> {
    private final Executor executor;
    private final zzdmj<R> zzhkh;
    private final zzdqz zzhkm;
    private final zzdmk zzhkp;
    private zzdmf zzhkq;

    public zzdmb(zzdqz zzdqzVar, zzdmk zzdmkVar, zzdmj<R> zzdmjVar, Executor executor) {
        this.zzhkm = zzdqzVar;
        this.zzhkp = zzdmkVar;
        this.zzhkh = zzdmjVar;
        this.executor = executor;
    }

    public final zzebt<zzdmf> zzavr() {
        zzebt zza;
        zzdmf zzdmfVar = this.zzhkq;
        if (zzdmfVar != null) {
            return zzebh.zzag(zzdmfVar);
        }
        if (!zzadr.zzdfo.get().booleanValue()) {
            zzdmf zzdmfVar2 = new zzdmf(null, zzavs(), null);
            this.zzhkq = zzdmfVar2;
            zza = zzebh.zzag(zzdmfVar2);
        } else {
            zza = zzebc.zzg(this.zzhkh.zzc(this.zzhkp).zza(new zzdlr(this.zzhkm.zzawv().zzhqs)).zzahg().zzahd().zza(this.zzhkm.zzawv())).zza(new zzdmg(this), this.executor).zza(zzcpo.class, new zzdmd(this), this.executor);
        }
        return zzebh.zzb(zza, zzdme.zzebv, this.executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzdri zzavs() {
        zzdpm zzaia = this.zzhkh.zzc(this.zzhkp).zzahg().zzaia();
        return this.zzhkm.zza(zzaia.zzhnx, zzaia.zzhny, zzaia.zzhob);
    }
}
