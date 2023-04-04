package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzhe extends Exception {
    private final int type;
    private final int zzaeq;

    public static zzhe zza(Exception exc, int i) {
        return new zzhe(1, null, exc, i);
    }

    public static zzhe zza(IOException iOException) {
        return new zzhe(0, null, iOException, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhe zza(RuntimeException runtimeException) {
        return new zzhe(2, null, runtimeException, -1);
    }

    private zzhe(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.zzaeq = i2;
    }
}
