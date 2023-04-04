package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbkp implements zzbkn {
    private com.google.android.gms.ads.internal.util.zzf zzecl;

    public zzbkp(com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzecl = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkn
    public final void zzm(Map<String, String> map) {
        this.zzecl.zzas(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
