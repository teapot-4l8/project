package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzemq {
    private static final zzemp<?> zziqp = new zzemr();
    private static final zzemp<?> zziqq = zzbix();

    private static zzemp<?> zzbix() {
        try {
            return (zzemp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzemp<?> zzbiy() {
        return zziqp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzemp<?> zzbiz() {
        zzemp<?> zzempVar = zziqq;
        if (zzempVar != null) {
            return zzempVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
