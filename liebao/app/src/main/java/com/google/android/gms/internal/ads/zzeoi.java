package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeoi {
    private static final zzeog zzivr = zzbkw();
    private static final zzeog zzivs = new zzeoj();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeog zzbku() {
        return zzivr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeog zzbkv() {
        return zzivs;
    }

    private static zzeog zzbkw() {
        try {
            return (zzeog) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
