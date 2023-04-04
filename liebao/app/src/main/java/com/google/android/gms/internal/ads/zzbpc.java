package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbpc {
    protected final zzdot zzeux;
    protected final zzdpi zzftl;
    private final zzbts zzfym;
    private final zzbui zzfyn;
    private final zzdmi zzfyo;
    private final zzbsp zzfyp;
    private final zzbvl zzfyq;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbpc(zzbpf zzbpfVar) {
        this.zzftl = zzbpf.zza(zzbpfVar);
        this.zzeux = zzbpf.zzb(zzbpfVar);
        this.zzfym = zzbpf.zzc(zzbpfVar);
        this.zzfyn = zzbpf.zzd(zzbpfVar);
        this.zzfyo = zzbpf.zze(zzbpfVar);
        this.zzfyp = zzbpf.zzf(zzbpfVar);
        this.zzfyq = zzbpf.zzg(zzbpfVar);
    }

    public final zzbts zzalk() {
        return this.zzfym;
    }

    public void zzakv() {
        this.zzfyn.onAdLoaded();
    }

    public final zzbsp zzall() {
        return this.zzfyp;
    }

    public void destroy() {
        this.zzfym.zzcg(null);
    }

    public final zzdmi zzalm() {
        return this.zzfyo;
    }

    public final zzbwp zzaln() {
        return this.zzfyq.zzaln();
    }
}
