package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaju implements AdapterStatus {
    private final String description;
    private final int zzdkc;
    private final AdapterStatus.State zzdkd;

    public zzaju(AdapterStatus.State state, String str, int i) {
        this.zzdkd = state;
        this.description = str;
        this.zzdkc = i;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State getInitializationState() {
        return this.zzdkd;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return this.zzdkc;
    }
}
