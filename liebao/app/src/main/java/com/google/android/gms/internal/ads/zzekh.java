package com.google.android.gms.internal.ads;

import java.security.KeyFactory;
import java.security.Provider;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzekh implements zzekc<KeyFactory> {
    @Override // com.google.android.gms.internal.ads.zzekc
    public final /* synthetic */ KeyFactory zza(String str, Provider provider) {
        if (provider == null) {
            return KeyFactory.getInstance(str);
        }
        return KeyFactory.getInstance(str, provider);
    }
}
