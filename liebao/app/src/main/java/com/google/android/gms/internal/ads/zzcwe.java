package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwe extends zzcwf<zzbne> {
    private final zzccb zzfbj;
    private final zzbxr zzfbo;
    private final zzcyo zzfon;
    private final ViewGroup zzfwu;
    private final zzbve zzfyj;
    private final zzbhh zzgxu;
    private final zzbsj.zza zzgxv;

    public zzcwe(zzbhh zzbhhVar, zzbsj.zza zzaVar, zzcyo zzcyoVar, zzbxr zzbxrVar, zzccb zzccbVar, zzbve zzbveVar, ViewGroup viewGroup) {
        this.zzgxu = zzbhhVar;
        this.zzgxv = zzaVar;
        this.zzfon = zzcyoVar;
        this.zzfbo = zzbxrVar;
        this.zzfbj = zzccbVar;
        this.zzfyj = zzbveVar;
        this.zzfwu = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzcwf
    protected final zzebt<zzbne> zza(zzdpm zzdpmVar, Bundle bundle) {
        return this.zzgxu.zzagc().zzd(this.zzgxv.zza(zzdpmVar).zze(bundle).zzami()).zzd(this.zzfbo).zza(this.zzfon).zzb(this.zzfbj).zza(new zzboz(this.zzfyj)).zzd(new zzbnd(this.zzfwu)).zzaie().zzahd().zzalv();
    }
}
