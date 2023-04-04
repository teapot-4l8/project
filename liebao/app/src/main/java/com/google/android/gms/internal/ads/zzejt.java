package com.google.android.gms.internal.ads;

import java.security.interfaces.ECPrivateKey;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzejt implements zzecr {
    private static final byte[] zzige = new byte[0];
    private final String zzimm;
    private final byte[] zzimn;
    private final zzekb zzimo;
    private final zzejq zzimp;
    private final ECPrivateKey zzimq;
    private final zzejv zzimr;

    public zzejt(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzekb zzekbVar, zzejq zzejqVar) {
        this.zzimq = eCPrivateKey;
        this.zzimr = new zzejv(eCPrivateKey);
        this.zzimn = bArr;
        this.zzimm = str;
        this.zzimo = zzekbVar;
        this.zzimp = zzejqVar;
    }
}
