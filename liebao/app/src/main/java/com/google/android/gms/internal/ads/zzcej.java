package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcej implements zzesa<zzcdr> {
    private final zzced zzghs;

    private zzcej(zzced zzcedVar) {
        this.zzghs = zzcedVar;
    }

    public static zzcej zzb(zzced zzcedVar) {
        return new zzcej(zzcedVar);
    }

    public static zzcdr zzc(zzced zzcedVar) {
        return (zzcdr) zzesg.zzbd(zzcedVar.zzapm());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzc(this.zzghs);
    }
}
