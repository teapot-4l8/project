package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.Provider;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeki implements zzekc<MessageDigest> {
    @Override // com.google.android.gms.internal.ads.zzekc
    public final /* synthetic */ MessageDigest zza(String str, Provider provider) {
        if (provider == null) {
            return MessageDigest.getInstance(str);
        }
        return MessageDigest.getInstance(str, provider);
    }
}
