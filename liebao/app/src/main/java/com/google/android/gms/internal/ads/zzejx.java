package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzejx {
    private final zzekk zzimt;
    private final zzekk zzimu;

    public zzejx(byte[] bArr, byte[] bArr2) {
        this.zzimt = zzekk.zzr(bArr);
        this.zzimu = zzekk.zzr(bArr2);
    }

    public final byte[] zzbgo() {
        zzekk zzekkVar = this.zzimt;
        if (zzekkVar == null) {
            return null;
        }
        return zzekkVar.getBytes();
    }

    public final byte[] zzbgp() {
        zzekk zzekkVar = this.zzimu;
        if (zzekkVar == null) {
            return null;
        }
        return zzekkVar.getBytes();
    }
}
