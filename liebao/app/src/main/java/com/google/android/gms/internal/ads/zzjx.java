package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzjx implements zzjz {
    private static final byte[] zzaoy = new byte[4096];
    private long position;
    private final zzon zzaoz;
    private final long zzapa;
    private byte[] zzapb = new byte[65536];
    private int zzapc;
    private int zzapd;

    public zzjx(zzon zzonVar, long j, long j2) {
        this.zzaoz = zzonVar;
        this.position = j;
        this.zzapa = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final int read(byte[] bArr, int i, int i2) {
        int zzb = zzb(bArr, i, i2);
        if (zzb == 0) {
            zzb = zza(bArr, i, i2, 0, true);
        }
        zzan(zzb);
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) {
        int zzb = zzb(bArr, i, i2);
        while (zzb < i2 && zzb != -1) {
            zzb = zza(bArr, i, i2, zzb, z);
        }
        zzan(zzb);
        return zzb != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void readFully(byte[] bArr, int i, int i2) {
        zza(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final int zzai(int i) {
        int zzal = zzal(i);
        if (zzal == 0) {
            byte[] bArr = zzaoy;
            zzal = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzan(zzal);
        return zzal;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zzaj(int i) {
        int zzal = zzal(i);
        while (zzal < i && zzal != -1) {
            byte[] bArr = zzaoy;
            zzal = zza(bArr, -zzal, Math.min(i, bArr.length + zzal), zzal, false);
        }
        zzan(zzal);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zza(byte[] bArr, int i, int i2) {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzapb, this.zzapc - i2, bArr, i, i2);
        }
    }

    private final boolean zzd(int i, boolean z) {
        int i2 = this.zzapc + i;
        byte[] bArr = this.zzapb;
        if (i2 > bArr.length) {
            this.zzapb = Arrays.copyOf(this.zzapb, zzpt.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzapd - this.zzapc, i);
        while (min < i) {
            min = zza(this.zzapb, this.zzapc, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i3 = this.zzapc + i;
        this.zzapc = i3;
        this.zzapd = Math.max(this.zzapd, i3);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zzak(int i) {
        zzd(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zzgu() {
        this.zzapc = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final long getPosition() {
        return this.position;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final long getLength() {
        return this.zzapa;
    }

    private final int zzal(int i) {
        int min = Math.min(this.zzapd, i);
        zzam(min);
        return min;
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzapd;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zzapb, 0, bArr, i, min);
        zzam(min);
        return min;
    }

    private final void zzam(int i) {
        int i2 = this.zzapd - i;
        this.zzapd = i2;
        this.zzapc = 0;
        byte[] bArr = this.zzapb;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        System.arraycopy(this.zzapb, i, bArr, 0, this.zzapd);
        this.zzapb = bArr;
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.zzaoz.read(bArr, i + i3, i2 - i3);
        if (read == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + read;
    }

    private final void zzan(int i) {
        if (i != -1) {
            this.position += i;
        }
    }
}
