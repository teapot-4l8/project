package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaiv implements zzaiu {
    private final /* synthetic */ zzbbe zzdjs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaiv(zzais zzaisVar, zzbbe zzbbeVar) {
        this.zzdjs = zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaiu
    public final void zzc(JSONObject jSONObject) {
        this.zzdjs.set(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaiu
    public final void onFailure(String str) {
        this.zzdjs.setException(new zzamh(str));
    }
}
