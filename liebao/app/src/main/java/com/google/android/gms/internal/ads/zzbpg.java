package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpg<AdT> implements zzbph<AdT> {
    private final Map<String, zzcsz<AdT>> zzfyr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpg(Map<String, zzcsz<AdT>> map) {
        this.zzfyr = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final zzcsz<AdT> zze(int i, String str) {
        return this.zzfyr.get(str);
    }
}
