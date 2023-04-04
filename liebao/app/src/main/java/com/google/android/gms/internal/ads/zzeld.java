package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeld {
    private final byte[] zziom = new byte[256];
    private int zzion;
    private int zzioo;

    public zzeld(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zziom[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zziom;
            i2 = (i2 + bArr2[i3] + bArr[i3 % bArr.length]) & 255;
            byte b2 = bArr2[i3];
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b2;
        }
        this.zzion = 0;
        this.zzioo = 0;
    }

    public final void zzs(byte[] bArr) {
        int i = this.zzion;
        int i2 = this.zzioo;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.zziom;
            i2 = (i2 + bArr2[i]) & 255;
            byte b2 = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b2;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.zzion = i;
        this.zzioo = i2;
    }
}
