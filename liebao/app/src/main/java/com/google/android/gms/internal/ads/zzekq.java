package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzekq implements zzeda {
    private final zzefu zzinz;
    private final int zzioa;

    public zzekq(zzefu zzefuVar, int i) {
        this.zzinz = zzefuVar;
        this.zzioa = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzefuVar.zzd(new byte[0], i);
    }

    @Override // com.google.android.gms.internal.ads.zzeda
    public final byte[] zzk(byte[] bArr) {
        return this.zzinz.zzd(bArr, this.zzioa);
    }
}
