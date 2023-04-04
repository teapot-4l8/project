package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpo {
    private byte[] data;
    private int zzbks;
    private int zzbkt;
    private int zzbku;

    public zzpo() {
    }

    public zzpo(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpo(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbku = i;
    }

    public final int zzbo(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i6 = i / 8;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = this.zzbkt;
            if (i9 != 0) {
                byte[] bArr = this.data;
                int i10 = this.zzbks;
                i5 = ((bArr[i10 + 1] & 255) >>> (8 - i9)) | ((bArr[i10] & 255) << i9);
            } else {
                i5 = this.data[this.zzbks];
            }
            i -= 8;
            i7 |= (255 & i5) << i;
            this.zzbks++;
        }
        if (i > 0) {
            int i11 = this.zzbkt + i;
            byte b2 = (byte) (255 >> (8 - i));
            if (i11 > 8) {
                byte[] bArr2 = this.data;
                int i12 = this.zzbks;
                i4 = (b2 & (((bArr2[i12 + 1] & 255) >> (16 - i11)) | ((bArr2[i12] & 255) << (i11 - 8)))) | i7;
                this.zzbks = i12 + 1;
            } else {
                byte[] bArr3 = this.data;
                int i13 = this.zzbks;
                i4 = (b2 & ((bArr3[i13] & 255) >> (8 - i11))) | i7;
                if (i11 == 8) {
                    this.zzbks = i13 + 1;
                }
            }
            i7 = i4;
            this.zzbkt = i11 % 8;
        }
        int i14 = this.zzbks;
        if (i14 >= 0 && (i2 = this.zzbkt) >= 0 && i2 < 8 && (i14 < (i3 = this.zzbku) || (i14 == i3 && i2 == 0))) {
            z = true;
        }
        zzpg.checkState(z);
        return i7;
    }
}
