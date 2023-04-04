package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzccd implements zzesa<zzccb> {
    private final zzccb zzgee;

    private zzccd(zzccb zzccbVar) {
        this.zzgee = zzccbVar;
    }

    public static zzccd zze(zzccb zzccbVar) {
        return new zzccd(zzccbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzccb zzccbVar = this.zzgee;
        if (zzccbVar != null) {
            return (zzccb) zzesg.zzbd(zzccbVar);
        }
        throw null;
    }
}
