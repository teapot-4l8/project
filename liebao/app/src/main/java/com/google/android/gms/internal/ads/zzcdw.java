package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdw implements zzesa<zzcdu> {
    private final zzesn<JSONObject> zzflg;
    private final zzesn<zzdot> zzfvi;

    public zzcdw(zzesn<zzdot> zzesnVar, zzesn<JSONObject> zzesnVar2) {
        this.zzfvi = zzesnVar;
        this.zzflg = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcdu(this.zzfvi.get(), this.zzflg.get());
    }
}
