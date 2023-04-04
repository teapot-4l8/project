package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzejs implements zzecq {
    private static final byte[] zzige = new byte[0];
    private final zzeju zziml;
    private final String zzimm;
    private final byte[] zzimn;
    private final zzekb zzimo;
    private final zzejq zzimp;

    public zzejs(ECPublicKey eCPublicKey, byte[] bArr, String str, zzekb zzekbVar, zzejq zzejqVar) {
        zzejw.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zziml = new zzeju(eCPublicKey);
        this.zzimn = bArr;
        this.zzimm = str;
        this.zzimo = zzekbVar;
        this.zzimp = zzejqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecq
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        zzejx zza = this.zziml.zza(this.zzimm, this.zzimn, bArr2, this.zzimp.zzbcb(), this.zzimo);
        byte[] zzc = this.zzimp.zzm(zza.zzbgp()).zzc(bArr, zzige);
        byte[] zzbgo = zza.zzbgo();
        return ByteBuffer.allocate(zzbgo.length + zzc.length).put(zzbgo).put(zzc).array();
    }
}
