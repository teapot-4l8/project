package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzenb implements zzeok {
    private static final zzenb zzitq = new zzenb();

    private zzenb() {
    }

    public static zzenb zzbjq() {
        return zzitq;
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final boolean zzg(Class<?> cls) {
        return zzena.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final zzeol zzh(Class<?> cls) {
        if (!zzena.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzeol) zzena.zzf(cls.asSubclass(zzena.class)).zza(zzena.zze.zzitx, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }
}
