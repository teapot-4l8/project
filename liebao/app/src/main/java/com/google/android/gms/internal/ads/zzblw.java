package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblw implements zzesa<JSONObject> {
    private final zzesn<zzdot> zzfvi;

    private zzblw(zzesn<zzdot> zzesnVar) {
        this.zzfvi = zzesnVar;
    }

    public static zzblw zzc(zzesn<zzdot> zzesnVar) {
        return new zzblw(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzblx.zza(this.zzfvi.get());
    }
}
