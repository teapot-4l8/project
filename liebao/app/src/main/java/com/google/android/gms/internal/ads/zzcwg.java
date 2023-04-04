package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwg extends zzcwf<zzcaj> {
    private final zzbxr zzfbo;
    private final zzcyo zzfon;
    private final zzbhh zzgxu;
    private final zzbsj.zza zzgxv;

    public zzcwg(zzbhh zzbhhVar, zzbsj.zza zzaVar, zzcyo zzcyoVar, zzbxr zzbxrVar) {
        this.zzgxu = zzbhhVar;
        this.zzgxv = zzaVar;
        this.zzfon = zzcyoVar;
        this.zzfbo = zzbxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwf
    protected final zzebt<zzcaj> zza(zzdpm zzdpmVar, Bundle bundle) {
        return this.zzgxu.zzagh().zze(this.zzgxv.zza(zzdpmVar).zze(bundle).zzami()).zze(this.zzfbo).zzb(this.zzfon).zzair().zzahd().zzalv();
    }
}
