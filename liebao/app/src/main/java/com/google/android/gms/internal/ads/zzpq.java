package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpq {
    private byte[] data;
    private int zzbks;
    private int zzbkt = 0;
    private int zzbku;

    public zzpq(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbks = i;
        this.zzbku = i2;
        zzjl();
    }

    public final void zzbp(int i) {
        int i2 = this.zzbks;
        int i3 = (i / 8) + i2;
        this.zzbks = i3;
        int i4 = this.zzbkt + (i % 8);
        this.zzbkt = i4;
        if (i4 > 7) {
            this.zzbks = i3 + 1;
            this.zzbkt = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.zzbks) {
                if (zzbq(i2)) {
                    this.zzbks++;
                    i2 += 2;
                }
            } else {
                zzjl();
                return;
            }
        }
    }

    public final boolean zzjh() {
        return zzbo(1) == 1;
    }

    public final int zzbo(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = zzbq(this.zzbks + 1) ? this.zzbks + 2 : this.zzbks + 1;
            int i8 = this.zzbkt;
            if (i8 != 0) {
                byte[] bArr = this.data;
                i3 = ((bArr[i7] & 255) >>> (8 - i8)) | ((bArr[this.zzbks] & 255) << i8);
            } else {
                i3 = this.data[this.zzbks];
            }
            i -= 8;
            i5 |= (255 & i3) << i;
            this.zzbks = i7;
        }
        if (i > 0) {
            int i9 = this.zzbkt + i;
            byte b2 = (byte) (255 >> (8 - i));
            int i10 = zzbq(this.zzbks + 1) ? this.zzbks + 2 : this.zzbks + 1;
            if (i9 > 8) {
                byte[] bArr2 = this.data;
                i2 = (b2 & (((255 & bArr2[i10]) >> (16 - i9)) | ((bArr2[this.zzbks] & 255) << (i9 - 8)))) | i5;
                this.zzbks = i10;
            } else {
                i2 = (b2 & ((255 & this.data[this.zzbks]) >> (8 - i9))) | i5;
                if (i9 == 8) {
                    this.zzbks = i10;
                }
            }
            i5 = i2;
            this.zzbkt = i9 % 8;
        }
        zzjl();
        return i5;
    }

    public final int zzji() {
        return zzjk();
    }

    public final int zzjj() {
        int zzjk = zzjk();
        return (zzjk % 2 == 0 ? -1 : 1) * ((zzjk + 1) / 2);
    }

    private final int zzjk() {
        int i = 0;
        while (!zzjh()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? zzbo(i) : 0);
    }

    private final boolean zzbq(int i) {
        if (2 > i || i >= this.zzbku) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i - 1] == 0;
    }

    private final void zzjl() {
        int i;
        int i2;
        int i3 = this.zzbks;
        zzpg.checkState(i3 >= 0 && (i = this.zzbkt) >= 0 && i < 8 && (i3 < (i2 = this.zzbku) || (i3 == i2 && i == 0)));
    }
}
