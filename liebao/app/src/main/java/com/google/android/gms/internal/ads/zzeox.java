package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeox {
    private static final zzeov zziwl = zzblc();
    private static final zzeov zziwm = new zzeou();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeov zzbla() {
        return zziwl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeov zzblb() {
        return zziwm;
    }

    private static zzeov zzblc() {
        try {
            return (zzeov) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
