package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbc implements zzesa<View> {
    private final zzcak zzgdr;

    private zzcbc(zzcak zzcakVar) {
        this.zzgdr = zzcakVar;
    }

    public static zzcbc zzc(zzcak zzcakVar) {
        return new zzcbc(zzcakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return this.zzgdr.zzano();
    }
}
