package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzccc implements zzesa<zzcdy> {
    private final zzccb zzgee;

    private zzccc(zzccb zzccbVar) {
        this.zzgee = zzccbVar;
    }

    public static zzccc zzc(zzccb zzccbVar) {
        return new zzccc(zzccbVar);
    }

    public static zzcdy zzd(zzccb zzccbVar) {
        return (zzcdy) zzesg.zzbd(zzccbVar.zzanv());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzd(this.zzgee);
    }
}
