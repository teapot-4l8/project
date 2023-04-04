package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzekj implements zzekc<Mac> {
    @Override // com.google.android.gms.internal.ads.zzekc
    public final /* synthetic */ Mac zza(String str, Provider provider) {
        if (provider == null) {
            return Mac.getInstance(str);
        }
        return Mac.getInstance(str, provider);
    }
}
