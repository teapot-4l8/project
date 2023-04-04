package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzenx {
    private static final zzenx zzivf = new zzenz();
    private static final zzenx zzivg = new zzeny();

    private zzenx() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenx zzbkn() {
        return zzivf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenx zzbko() {
        return zzivg;
    }
}
