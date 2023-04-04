package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbix {
    private zzbhg zzeys;
    private zzbjl zzfqi;
    private zzdtr zzfqj;
    private zzbjv zzfqk;
    private zzdqi zzfql;

    private zzbix() {
    }

    public final zzbix zzc(zzbhg zzbhgVar) {
        this.zzeys = (zzbhg) zzesg.checkNotNull(zzbhgVar);
        return this;
    }

    public final zzbix zza(zzbjl zzbjlVar) {
        this.zzfqi = (zzbjl) zzesg.checkNotNull(zzbjlVar);
        return this;
    }

    public final zzbhh zzaip() {
        zzesg.zza(this.zzeys, zzbhg.class);
        zzesg.zza(this.zzfqi, zzbjl.class);
        if (this.zzfqj == null) {
            this.zzfqj = new zzdtr();
        }
        if (this.zzfqk == null) {
            this.zzfqk = new zzbjv();
        }
        if (this.zzfql == null) {
            this.zzfql = new zzdqi();
        }
        return new zzbie(this.zzeys, this.zzfqi, this.zzfqj, this.zzfqk, this.zzfql);
    }
}
