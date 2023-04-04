package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrf implements zzesa<zzcrd> {
    private final zzesn<Set<zzcrc>> zzgoo;
    private final zzesn<zzdtx> zzgst;

    private zzcrf(zzesn<Set<zzcrc>> zzesnVar, zzesn<zzdtx> zzesnVar2) {
        this.zzgoo = zzesnVar;
        this.zzgst = zzesnVar2;
    }

    public static zzcrf zzan(zzesn<Set<zzcrc>> zzesnVar, zzesn<zzdtx> zzesnVar2) {
        return new zzcrf(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcrd(this.zzgoo.get(), this.zzgst.get());
    }
}
