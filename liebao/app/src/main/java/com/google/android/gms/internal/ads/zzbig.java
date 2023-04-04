package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbig implements zzcce {
    private zzbsj zzfbg;
    private zzdpi zzfbh;
    private zzbnd zzfbi;
    private zzccb zzfbj;
    private zzdmp zzfbk;
    private zzdlr zzfbl;
    private zzbxr zzfbo;
    private final /* synthetic */ zzbie zzfhy;

    private zzbig(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    /* renamed from: zzahf */
    public final zzccf zzahg() {
        zzesg.zza(this.zzfbo, zzbxr.class);
        zzesg.zza(this.zzfbg, zzbsj.class);
        zzesg.zza(this.zzfbj, zzccb.class);
        zzesg.zza(this.zzfbi, zzbnd.class);
        return new zzbif(this.zzfhy, this.zzfbi, this.zzfbj, new zzbqi(), new zzdqk(), new zzbrt(), new zzcmo(), this.zzfbo, this.zzfbg, new zzdqo(), this.zzfbh, this.zzfbk, this.zzfbl);
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* synthetic */ zzcce zza(zzbnd zzbndVar) {
        this.zzfbi = (zzbnd) zzesg.checkNotNull(zzbndVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* synthetic */ zzcce zza(zzccb zzccbVar) {
        this.zzfbj = (zzccb) zzesg.checkNotNull(zzccbVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* synthetic */ zzcce zza(zzbsj zzbsjVar) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsjVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* synthetic */ zzcce zza(zzbxr zzbxrVar) {
        this.zzfbo = (zzbxr) zzesg.checkNotNull(zzbxrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzccf> zza(zzdlr zzdlrVar) {
        this.zzfbl = zzdlrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzccf> zza(zzdmp zzdmpVar) {
        this.zzfbk = zzdmpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final /* synthetic */ zzbsg<zzccf> zza(zzdpi zzdpiVar) {
        this.zzfbh = zzdpiVar;
        return this;
    }
}
