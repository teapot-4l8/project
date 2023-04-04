package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpn {
    public byte[] data;
    private int limit;
    private int position;

    public zzpn() {
    }

    public zzpn(int i) {
        this.data = new byte[i];
        this.limit = i;
    }

    public zzpn(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public final void reset(int i) {
        zzc(capacity() < i ? new byte[i] : this.data, i);
    }

    public final void zzc(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public final int zziz() {
        return this.limit - this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final void zzbk(int i) {
        zzpg.checkArgument(i >= 0 && i <= this.data.length);
        this.limit = i;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final void zzbl(int i) {
        zzpg.checkArgument(i >= 0 && i <= this.limit);
        this.position = i;
    }

    public final void zzbm(int i) {
        zzbl(this.position + i);
    }

    public final void zze(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i2 + 1;
        return (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
    }

    public final int zzja() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255);
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((bArr[i] & 255) << 8));
    }

    public final long zzjb() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        this.position = i4 + 1;
        return (bArr[i4] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
    }

    public final long zzjc() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        this.position = i4 + 1;
        return ((bArr[i4] & 255) << 24) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i5 = i3 + 1;
        this.position = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.position = i5 + 1;
        return (bArr[i5] & 255) | i6;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i5 + 1;
        this.position = i6;
        int i7 = i6 + 1;
        this.position = i7;
        int i8 = i7 + 1;
        this.position = i8;
        this.position = i8 + 1;
        return (bArr[i8] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i2] & 255) << 48) | ((bArr[i3] & 255) << 40) | ((bArr[i4] & 255) << 32) | ((bArr[i5] & 255) << 24) | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8);
    }

    public final int zzjd() {
        byte[] bArr = this.data;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = (bArr[i2] & 255) | ((bArr[i] & 255) << 8);
        this.position = i3 + 2;
        return i4;
    }

    public final int zzje() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readInt);
        throw new IllegalStateException(sb.toString());
    }

    public final long zzjf() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(readLong);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzbn(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.position + i) - 1;
        String str = new String(this.data, this.position, (i2 >= this.limit || this.data[i2] != 0) ? i : i - 1);
        this.position += i;
        return str;
    }

    public final String zzjg() {
        if (zziz() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != 0) {
            i++;
        }
        byte[] bArr = this.data;
        int i2 = this.position;
        String str = new String(bArr, i2, i - i2);
        this.position = i;
        if (i < this.limit) {
            this.position = i + 1;
        }
        return str;
    }
}
