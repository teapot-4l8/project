package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdin implements zzdhe<zzdhb<JSONObject>> {
    private final JSONObject zzhhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdin(Context context) {
        this.zzhhm = zzauv.zzw(context);
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhb<JSONObject>> zzatu() {
        return zzebh.zzag(new zzdhb(this) { // from class: com.google.android.gms.internal.ads.zzdiq
            private final zzdin zzhhn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhhn = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdhb
            public final void zzr(Object obj) {
                this.zzhhn.zzr((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzhhm);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Failed putting version constants.");
        }
    }
}
