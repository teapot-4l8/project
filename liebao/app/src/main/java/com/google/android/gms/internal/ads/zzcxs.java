package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxs implements zzcta<zzaqa, zzcuv> {
    private final zzcyz zzgyz;

    public zzcxs(zzcyz zzcyzVar) {
        this.zzgyz = zzcyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzctb<zzaqa, zzcuv> zzf(String str, JSONObject jSONObject) {
        zzaqa zzgp = this.zzgyz.zzgp(str);
        if (zzgp == null) {
            return null;
        }
        return new zzctb<>(zzgp, new zzcuv(), str);
    }
}
