package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbjk implements zzdbc {
    private zzbsj zzfbg;
    private final /* synthetic */ zzbie zzfhy;
    private zzdbs zzfsm;

    private zzbjk(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbc
    public final zzdbd zzajg() {
        zzesg.zza(this.zzfbg, zzbsj.class);
        zzesg.zza(this.zzfsm, zzdbs.class);
        return new zzbjj(this.zzfhy, this.zzfsm, new zzbqi(), new zzcmo(), this.zzfbg, new zzdqo());
    }

    @Override // com.google.android.gms.internal.ads.zzdbc
    @Deprecated
    public final /* synthetic */ zzdbc zzg(zzbxr zzbxrVar) {
        zzesg.checkNotNull(zzbxrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdbc
    public final /* synthetic */ zzdbc zza(zzdbs zzdbsVar) {
        this.zzfsm = (zzdbs) zzesg.checkNotNull(zzdbsVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdbc
    public final /* synthetic */ zzdbc zzg(zzbsj zzbsjVar) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsjVar);
        return this;
    }
}
