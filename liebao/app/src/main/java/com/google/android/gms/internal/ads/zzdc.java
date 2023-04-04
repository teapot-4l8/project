package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdc implements Runnable {
    private zzdc() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzda.zza(MessageDigest.getInstance("MD5"));
        } catch (NoSuchAlgorithmException unused) {
        } finally {
            zzda.zzob.countDown();
        }
    }
}
