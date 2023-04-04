package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Signature;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzekl implements zzekc<Signature> {
    @Override // com.google.android.gms.internal.ads.zzekc
    public final /* synthetic */ Signature zza(String str, Provider provider) {
        if (provider == null) {
            return Signature.getInstance(str);
        }
        return Signature.getInstance(str, provider);
    }
}
