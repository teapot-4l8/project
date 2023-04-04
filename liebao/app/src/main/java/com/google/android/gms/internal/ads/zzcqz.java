package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqz implements zzbyw {
    private final zzdtw zzdjf;
    private final String zzgou;
    private boolean zzgos = false;
    private boolean zzgot = false;
    private final com.google.android.gms.ads.internal.util.zzf zzeci = com.google.android.gms.ads.internal.zzr.zzkz().zzyl();

    public zzcqz(String str, zzdtw zzdtwVar) {
        this.zzgou = str;
        this.zzdjf = zzdtwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzfu(String str) {
        this.zzdjf.zzb(zzgm("adapter_init_started").zzw("ancn", str));
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzfv(String str) {
        this.zzdjf.zzb(zzgm("adapter_init_finished").zzw("ancn", str));
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzn(String str, String str2) {
        this.zzdjf.zzb(zzgm("adapter_init_finished").zzw("ancn", str).zzw("rqe", str2));
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final synchronized void zzang() {
        if (!this.zzgos) {
            this.zzdjf.zzb(zzgm("init_started"));
            this.zzgos = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final synchronized void zzanh() {
        if (!this.zzgot) {
            this.zzdjf.zzb(zzgm("init_finished"));
            this.zzgot = true;
        }
    }

    private final zzdtx zzgm(String str) {
        return zzdtx.zzgy(str).zzw("tms", Long.toString(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime(), 10)).zzw("tid", this.zzeci.zzzn() ? "" : this.zzgou);
    }
}
