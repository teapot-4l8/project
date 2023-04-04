package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbkt implements zzbkn {
    private final zzdor zzfti;

    public zzbkt(zzdor zzdorVar) {
        this.zzfti = zzdorVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkn
    public final void zzm(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zzfti.zzbq(Boolean.parseBoolean(str));
        } catch (Exception unused) {
            throw new IllegalStateException("Invalid render_in_browser state");
        }
    }
}
