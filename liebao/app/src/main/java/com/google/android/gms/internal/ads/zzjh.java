package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzjh implements zzij {
    private boolean zzamv;
    private int zzamq = -1;
    private int zzahy = -1;
    private int zzako = 0;
    private ByteBuffer zzamu = zzajm;
    private ByteBuffer zzalt = zzajm;

    @Override // com.google.android.gms.internal.ads.zzij
    public final int zzfo() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzb(int i, int i2, int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzii(i, i2, i3);
        }
        if (this.zzamq == i && this.zzahy == i2 && this.zzako == i3) {
            return false;
        }
        this.zzamq = i;
        this.zzahy = i2;
        this.zzako = i3;
        if (i3 == 2) {
            this.zzamu = zzajm;
            return true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean isActive() {
        int i = this.zzako;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final int zzfn() {
        return this.zzahy;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081 A[LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:16:0x0041, B:26:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzn(ByteBuffer byteBuffer) {
        int i;
        int i2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        int i4 = this.zzako;
        if (i4 == Integer.MIN_VALUE) {
            i3 /= 3;
        } else if (i4 != 3) {
            if (i4 == 1073741824) {
                i = i3 / 2;
                if (this.zzamu.capacity() >= i) {
                    this.zzamu = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                } else {
                    this.zzamu.clear();
                }
                i2 = this.zzako;
                if (i2 != Integer.MIN_VALUE) {
                    while (position < limit) {
                        this.zzamu.put(byteBuffer.get(position + 1));
                        this.zzamu.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else if (i2 == 3) {
                    while (position < limit) {
                        this.zzamu.put((byte) 0);
                        this.zzamu.put((byte) ((byteBuffer.get(position) & 255) - 128));
                        position++;
                    }
                } else if (i2 != 1073741824) {
                    throw new IllegalStateException();
                } else {
                    while (position < limit) {
                        this.zzamu.put(byteBuffer.get(position + 2));
                        this.zzamu.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                this.zzamu.flip();
                this.zzalt = this.zzamu;
            }
            throw new IllegalStateException();
        }
        i = i3 << 1;
        if (this.zzamu.capacity() >= i) {
        }
        i2 = this.zzako;
        if (i2 != Integer.MIN_VALUE) {
        }
        byteBuffer.position(byteBuffer.limit());
        this.zzamu.flip();
        this.zzalt = this.zzamu;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void zzfp() {
        this.zzamv = true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final ByteBuffer zzfq() {
        ByteBuffer byteBuffer = this.zzalt;
        this.zzalt = zzajm;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final boolean zzfi() {
        return this.zzamv && this.zzalt == zzajm;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void flush() {
        this.zzalt = zzajm;
        this.zzamv = false;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void reset() {
        flush();
        this.zzamu = zzajm;
        this.zzamq = -1;
        this.zzahy = -1;
        this.zzako = 0;
    }
}
