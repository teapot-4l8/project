package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
final class zzje {
    private static final zzjc zza = zzc();
    private static final zzjc zzb = new zzjf();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjc zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjc zzb() {
        return zzb;
    }

    private static zzjc zzc() {
        try {
            return (zzjc) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
