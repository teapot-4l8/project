package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyl implements zzesa<zzbxr> {
    private final zzbxr zzgdc;

    private zzbyl(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyl zzz(zzbxr zzbxrVar) {
        return new zzbyl(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzbxr zzbxrVar = this.zzgdc;
        if (zzbxrVar != null) {
            return (zzbxr) zzesg.zzbd(zzbxrVar);
        }
        throw null;
    }
}
