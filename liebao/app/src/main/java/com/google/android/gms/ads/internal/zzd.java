package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzear;
import com.google.android.gms.internal.ads.zzebh;
import com.google.android.gms.internal.ads.zzebt;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzd implements zzear {
    static final zzear zzbpa = new zzd();

    private zzd() {
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final zzebt zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzr.zzkz().zzyl().zzeg(jSONObject.getString("appSettingsJson"));
        }
        return zzebh.zzag(null);
    }
}
