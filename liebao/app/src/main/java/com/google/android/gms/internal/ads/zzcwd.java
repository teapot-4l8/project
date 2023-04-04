package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwd extends zzcwf<zzbpi> {
    private final zzccb zzfbj;
    private final zzbxr zzfbo;
    private final zzbhh zzgxu;
    private final zzbsj.zza zzgxv;

    public zzcwd(zzbhh zzbhhVar, zzccb zzccbVar, zzbsj.zza zzaVar, zzbxr zzbxrVar) {
        this.zzgxu = zzbhhVar;
        this.zzfbj = zzccbVar;
        this.zzgxv = zzaVar;
        this.zzfbo = zzbxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwf
    protected final zzebt<zzbpi> zza(zzdpm zzdpmVar, Bundle bundle) {
        return this.zzgxu.zzagj().zza(this.zzgxv.zza(zzdpmVar).zze(bundle).zzami()).zza(this.zzfbo).zza(this.zzfbj).zza(new zzbnd(null)).zzahf().zzahd().zzalv();
    }
}
