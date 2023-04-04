package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdeb implements zzdhb<Bundle> {
    @Nullable
    private final JSONObject zzgnb;
    @Nullable
    private final JSONObject zzhen;

    public zzdeb(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        this.zzhen = jSONObject;
        this.zzgnb = jSONObject2;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        JSONObject jSONObject = this.zzhen;
        if (jSONObject != null) {
            bundle2.putString("fwd_cld", jSONObject.toString());
        }
        JSONObject jSONObject2 = this.zzgnb;
        if (jSONObject2 != null) {
            bundle2.putString("fwd_common_cld", jSONObject2.toString());
        }
    }
}
