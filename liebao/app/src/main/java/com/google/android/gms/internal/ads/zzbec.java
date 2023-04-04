package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbec {
    private long zzdg;

    public final long zzq(ByteBuffer byteBuffer) {
        zzbt zzbtVar;
        zzbu zzbuVar;
        long j = this.zzdg;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbs> it = new zzbq(new zzbdz(duplicate), zzbee.zzero).zzbnj().iterator();
            while (true) {
                zzbtVar = null;
                if (!it.hasNext()) {
                    zzbuVar = null;
                    break;
                }
                zzbs next = it.next();
                if (next instanceof zzbu) {
                    zzbuVar = (zzbu) next;
                    break;
                }
            }
            Iterator<zzbs> it2 = zzbuVar.zzbnj().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbs next2 = it2.next();
                if (next2 instanceof zzbt) {
                    zzbtVar = (zzbt) next2;
                    break;
                }
            }
            long duration = (zzbtVar.getDuration() * 1000) / zzbtVar.zzr();
            this.zzdg = duration;
            return duration;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
