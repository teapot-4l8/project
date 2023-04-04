package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyq implements zzesa<zzcyo> {
    private final zzcyo zzgzz;

    private zzcyq(zzcyo zzcyoVar) {
        this.zzgzz = zzcyoVar;
    }

    public static zzcyq zzc(zzcyo zzcyoVar) {
        return new zzcyq(zzcyoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzcyo zzcyoVar = this.zzgzz;
        if (zzcyoVar != null) {
            return (zzcyo) zzesg.zzbd(zzcyoVar);
        }
        throw null;
    }
}
