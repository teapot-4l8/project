package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwi extends zzcwf<zzcip> {
    private final zzbxr zzfbo;
    private final zzbhh zzgxu;
    private final zzbsj.zza zzgxv;

    public zzcwi(zzbhh zzbhhVar, zzbsj.zza zzaVar, zzbxr zzbxrVar) {
        this.zzgxu = zzbhhVar;
        this.zzgxv = zzaVar;
        this.zzfbo = zzbxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwf
    protected final zzebt<zzcip> zza(zzdpm zzdpmVar, Bundle bundle) {
        return this.zzgxu.zzagk().zzf(this.zzgxv.zza(zzdpmVar).zze(bundle).zzami()).zzf(this.zzfbo).zzaix().zzahd().zzalv();
    }
}
