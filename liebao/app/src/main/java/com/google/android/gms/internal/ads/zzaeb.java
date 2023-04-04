package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaeb {
    private static final AtomicReference<zzady> zzdgh = new AtomicReference<>();
    static final AtomicBoolean zzdgi = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzady zzti() {
        return zzdgh.get();
    }

    public static void zza(zzady zzadyVar) {
        zzdgh.set(zzadyVar);
    }
}
