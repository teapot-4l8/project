package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzekf implements zzekc<Cipher> {
    @Override // com.google.android.gms.internal.ads.zzekc
    public final /* synthetic */ Cipher zza(String str, Provider provider) {
        if (provider == null) {
            return Cipher.getInstance(str);
        }
        return Cipher.getInstance(str, provider);
    }
}
