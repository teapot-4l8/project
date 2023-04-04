package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsm implements zzesa<Bundle> {
    private final zzbsj zzgbg;

    private zzbsm(zzbsj zzbsjVar) {
        this.zzgbg = zzbsjVar;
    }

    public static zzbsm zzh(zzbsj zzbsjVar) {
        return new zzbsm(zzbsjVar);
    }

    public static Bundle zzi(zzbsj zzbsjVar) {
        return zzbsjVar.zzamh();
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return this.zzgbg.zzamh();
    }
}
