package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzcn<T> implements zzcp<T> {
    private zzct<T> zza;

    @Override // com.google.android.gms.internal.consent_sdk.zzct
    public final T zza() {
        zzct<T> zzctVar = this.zza;
        if (zzctVar == null) {
            throw new IllegalStateException();
        }
        return zzctVar.zza();
    }

    public static <T> void zza(zzct<T> zzctVar, zzct<T> zzctVar2) {
        zzcu.zza(zzctVar2);
        zzcn zzcnVar = (zzcn) zzctVar;
        if (zzcnVar.zza != null) {
            throw new IllegalStateException();
        }
        zzcnVar.zza = zzctVar2;
    }
}
