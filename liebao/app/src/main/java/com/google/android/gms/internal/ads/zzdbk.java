package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzdbk implements zzdxw {
    static final zzdxw zzebv = new zzdbk();

    private zzdbk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxw
    public final Object apply(Object obj) {
        String optString;
        optString = ((JSONObject) obj).optString("nas");
        return optString;
    }
}
