package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbij implements zzbms {
    private zzbsj zzfbg;
    private zzdpi zzfbh;
    private zzdmp zzfbk;
    private zzdlr zzfbl;
    private zzbxr zzfbo;
    private final /* synthetic */ zzbie zzfhy;

    private zzbij(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    @Deprecated
    public final /* synthetic */ zzbms zzb(zzbnd zzbndVar) {
        zzesg.checkNotNull(zzbndVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final /* synthetic */ zzbms zzb(zzbsj zzbsjVar) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsjVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    public final /* synthetic */ zzbms zzb(zzbxr zzbxrVar) {
        this.zzfbo = (zzbxr) zzesg.checkNotNull(zzbxrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbmt zzahg() {
        zzesg.zza(this.zzfbo, zzbxr.class);
        zzesg.zza(this.zzfbg, zzbsj.class);
        return new zzbim(this.zzfhy, new zzbqi(), new zzdqk(), new zzbrt(), new zzcmo(), this.zzfbo, this.zzfbg, new zzdqo(), this.zzfbh, this.zzfbk, this.zzfbl);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzbmt> zza(zzdlr zzdlrVar) {
        this.zzfbl = zzdlrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzbmt> zza(zzdmp zzdmpVar) {
        this.zzfbk = zzdmpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzbmt> zza(zzdpi zzdpiVar) {
        this.zzfbh = zzdpiVar;
        return this;
    }
}
