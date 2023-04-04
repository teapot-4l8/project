package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzerl extends zzerj implements zzbs {
    private int flags;
    private int version;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzerl(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzjeb) {
            zzbni();
        }
        return this.version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzr(ByteBuffer byteBuffer) {
        this.version = zzbp.zza(byteBuffer.get());
        this.flags = (zzbp.zzg(byteBuffer) << 8) + 0 + zzbp.zza(byteBuffer.get());
        return 4L;
    }
}
