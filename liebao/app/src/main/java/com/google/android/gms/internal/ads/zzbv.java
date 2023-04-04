package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbv extends zzerj {
    private ByteBuffer zzdr;

    public zzbv(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzerj
    public final void zzl(ByteBuffer byteBuffer) {
        this.zzdr = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
