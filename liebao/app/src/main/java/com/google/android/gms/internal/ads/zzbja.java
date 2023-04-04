package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbja implements zzcbi {
    private zzbsj zzfbg;
    private zzdpi zzfbh;
    private zzdmp zzfbk;
    private zzdlr zzfbl;
    private zzbxr zzfbo;
    private final /* synthetic */ zzbie zzfhy;
    private zzcyo zzfon;

    private zzbja(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    /* renamed from: zzair */
    public final zzcbj zzahg() {
        zzesg.zza(this.zzfbo, zzbxr.class);
        zzesg.zza(this.zzfbg, zzbsj.class);
        zzesg.zza(this.zzfon, zzcyo.class);
        return new zzbiz(this.zzfhy, new zzbqi(), new zzdqk(), new zzbrt(), new zzcmo(), this.zzfbo, this.zzfbg, new zzdqo(), this.zzfon, this.zzfbh, this.zzfbk, this.zzfbl);
    }

    @Override // com.google.android.gms.internal.ads.zzcbi
    public final /* synthetic */ zzcbi zzb(zzcyo zzcyoVar) {
        this.zzfon = (zzcyo) zzesg.checkNotNull(zzcyoVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcbi
    public final /* synthetic */ zzcbi zze(zzbsj zzbsjVar) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsjVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcbi
    public final /* synthetic */ zzcbi zze(zzbxr zzbxrVar) {
        this.zzfbo = (zzbxr) zzesg.checkNotNull(zzbxrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzcbj> zza(zzdlr zzdlrVar) {
        this.zzfbl = zzdlrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzcbj> zza(zzdmp zzdmpVar) {
        this.zzfbk = zzdmpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzcbj> zza(zzdpi zzdpiVar) {
        this.zzfbh = zzdpiVar;
        return this;
    }
}
