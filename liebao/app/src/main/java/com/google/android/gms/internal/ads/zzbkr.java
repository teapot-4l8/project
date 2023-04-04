package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbkr implements zzbkn {
    private com.google.android.gms.ads.internal.util.zzf zzecl;

    public zzbkr(com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzecl = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkn
    public final void zzm(Map<String, String> map) {
        this.zzecl.zzat(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
