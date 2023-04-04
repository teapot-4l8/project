package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeen implements zzecn {
    private static final byte[] zzige = new byte[0];
    private final zzeif zzigf;
    private final zzecn zzigg;

    public zzeen(zzeif zzeifVar, zzecn zzecnVar) {
        this.zzigf = zzeifVar;
        this.zzigg = zzecnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] byteArray = zzedl.zzb(this.zzigf).toByteArray();
        byte[] zzc = this.zzigg.zzc(byteArray, zzige);
        byte[] zzc2 = ((zzecn) zzedl.zza(this.zzigf.zzbev(), byteArray, zzecn.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
