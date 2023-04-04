package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvn implements zzcta<zzdqd, zzcuv> {
    private final zzckb zzgph;

    public zzcvn(zzckb zzckbVar) {
        this.zzgph = zzckbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzctb<zzdqd, zzcuv> zzf(String str, JSONObject jSONObject) {
        zzdqd zzd = this.zzgph.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzctb<>(zzd, new zzcuv(), str);
    }
}
