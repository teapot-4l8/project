package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzery<T> implements zzesa<T> {
    private zzesn<T> zzjfa;

    @Override // com.google.android.gms.internal.ads.zzesn
    public final T get() {
        zzesn<T> zzesnVar = this.zzjfa;
        if (zzesnVar == null) {
            throw new IllegalStateException();
        }
        return zzesnVar.get();
    }

    public static <T> void zzbf(zzesn<T> zzesnVar, zzesn<T> zzesnVar2) {
        zzesg.checkNotNull(zzesnVar2);
        zzery zzeryVar = (zzery) zzesnVar;
        if (zzeryVar.zzjfa != null) {
            throw new IllegalStateException();
        }
        zzeryVar.zzjfa = zzesnVar2;
    }
}
