package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeka implements zzecn {
    private final zzekn zzinb;
    private final zzeda zzinc;
    private final int zzind;

    public zzeka(zzekn zzeknVar, zzeda zzedaVar, int i) {
        this.zzinb = zzeknVar;
        this.zzinc = zzedaVar;
        this.zzind = i;
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] zzn = this.zzinb.zzn(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzejn.zza(zzn, this.zzinc.zzk(zzejn.zza(bArr2, zzn, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
