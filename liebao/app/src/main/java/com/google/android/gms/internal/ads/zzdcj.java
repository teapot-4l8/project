package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcj implements zzesa<zzdck> {
    private final zzesn<zzdpm> zzfxn;

    private zzdcj(zzesn<zzdpm> zzesnVar) {
        this.zzfxn = zzesnVar;
    }

    public static zzdcj zzak(zzesn<zzdpm> zzesnVar) {
        return new zzdcj(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdck(this.zzfxn.get());
    }
}