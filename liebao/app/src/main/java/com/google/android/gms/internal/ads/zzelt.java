package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzelt extends zzema {
    private final int zzipf;
    private final int zzipg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzelt(byte[] bArr, int i, int i2) {
        super(bArr);
        zzi(i, i + i2, bArr.length);
        this.zzipf = i;
        this.zzipg = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzema, com.google.android.gms.internal.ads.zzelq
    public final byte zzgh(int i) {
        zzad(i, size());
        return this.zzipn[this.zzipf + i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzema, com.google.android.gms.internal.ads.zzelq
    public final byte zzgi(int i) {
        return this.zzipn[this.zzipf + i];
    }

    @Override // com.google.android.gms.internal.ads.zzema, com.google.android.gms.internal.ads.zzelq
    public final int size() {
        return this.zzipg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzema
    public final int zzbho() {
        return this.zzipf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzema, com.google.android.gms.internal.ads.zzelq
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzipn, zzbho() + i, bArr, i2, i3);
    }
}
