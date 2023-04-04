package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzrw {
    private static MessageDigest zzbum;
    protected Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzbp(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final MessageDigest zzmt() {
        synchronized (this.mLock) {
            if (zzbum != null) {
                return zzbum;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbum = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzbum;
        }
    }
}
