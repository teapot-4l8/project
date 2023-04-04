package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public class zzema extends zzelx {
    protected final byte[] zzipn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzema(byte[] bArr) {
        if (bArr == null) {
            throw null;
        }
        this.zzipn = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzbho() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public byte zzgh(int i) {
        return this.zzipn[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzelq
    public byte zzgi(int i) {
        return this.zzipn[i];
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public int size() {
        return this.zzipn.length;
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final zzelq zzac(int i, int i2) {
        int zzi = zzi(i, i2, size());
        if (zzi == 0) {
            return zzelq.zzipc;
        }
        return new zzelt(this.zzipn, zzbho() + i, zzi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzipn, i, bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final void zza(zzeln zzelnVar) {
        zzelnVar.zzh(this.zzipn, zzbho(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    protected final String zza(Charset charset) {
        return new String(this.zzipn, zzbho(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final boolean zzbhi() {
        int zzbho = zzbho();
        return zzeqj.zzm(this.zzipn, zzbho, size() + zzbho);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final int zzg(int i, int i2, int i3) {
        int zzbho = zzbho() + i2;
        return zzeqj.zzb(i, this.zzipn, zzbho, i3 + zzbho);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzelq) && size() == ((zzelq) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof zzema) {
                zzema zzemaVar = (zzema) obj;
                int zzbhn = zzbhn();
                int zzbhn2 = zzemaVar.zzbhn();
                if (zzbhn == 0 || zzbhn2 == 0 || zzbhn == zzbhn2) {
                    return zza(zzemaVar, 0, size());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    final boolean zza(zzelq zzelqVar, int i, int i2) {
        if (i2 > zzelqVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 > zzelqVar.size()) {
            int size2 = zzelqVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (zzelqVar instanceof zzema) {
            zzema zzemaVar = (zzema) zzelqVar;
            byte[] bArr = this.zzipn;
            byte[] bArr2 = zzemaVar.zzipn;
            int zzbho = zzbho() + i2;
            int zzbho2 = zzbho();
            int zzbho3 = zzemaVar.zzbho() + i;
            while (zzbho2 < zzbho) {
                if (bArr[zzbho2] != bArr2[zzbho3]) {
                    return false;
                }
                zzbho2++;
                zzbho3++;
            }
            return true;
        } else {
            return zzelqVar.zzac(i, i3).equals(zzac(0, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final int zzh(int i, int i2, int i3) {
        return zzenc.zza(i, this.zzipn, zzbho() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final zzemb zzbhj() {
        return zzemb.zzb(this.zzipn, zzbho(), size(), true);
    }
}
