package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzepf extends zzelq {
    static final int[] zziwx = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zziwy;
    private final zzelq zziwz;
    private final zzelq zzixa;
    private final int zzixb;
    private final int zzixc;

    private zzepf(zzelq zzelqVar, zzelq zzelqVar2) {
        this.zziwz = zzelqVar;
        this.zzixa = zzelqVar2;
        int size = zzelqVar.size();
        this.zzixb = size;
        this.zziwy = size + zzelqVar2.size();
        this.zzixc = Math.max(zzelqVar.zzbhl(), zzelqVar2.zzbhl()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelq zza(zzelq zzelqVar, zzelq zzelqVar2) {
        if (zzelqVar2.size() == 0) {
            return zzelqVar;
        }
        if (zzelqVar.size() == 0) {
            return zzelqVar2;
        }
        int size = zzelqVar.size() + zzelqVar2.size();
        if (size < 128) {
            return zzb(zzelqVar, zzelqVar2);
        }
        if (zzelqVar instanceof zzepf) {
            zzepf zzepfVar = (zzepf) zzelqVar;
            if (zzepfVar.zzixa.size() + zzelqVar2.size() < 128) {
                return new zzepf(zzepfVar.zziwz, zzb(zzepfVar.zzixa, zzelqVar2));
            } else if (zzepfVar.zziwz.zzbhl() > zzepfVar.zzixa.zzbhl() && zzepfVar.zzbhl() > zzelqVar2.zzbhl()) {
                return new zzepf(zzepfVar.zziwz, new zzepf(zzepfVar.zzixa, zzelqVar2));
            }
        }
        if (size >= zzhz(Math.max(zzelqVar.zzbhl(), zzelqVar2.zzbhl()) + 1)) {
            return new zzepf(zzelqVar, zzelqVar2);
        }
        return zzeph.zza(new zzeph(null), zzelqVar, zzelqVar2);
    }

    private static zzelq zzb(zzelq zzelqVar, zzelq zzelqVar2) {
        int size = zzelqVar.size();
        int size2 = zzelqVar2.size();
        byte[] bArr = new byte[size + size2];
        zzelqVar.zza(bArr, 0, 0, size);
        zzelqVar2.zza(bArr, 0, size, size2);
        return zzelq.zzu(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzhz(int i) {
        int[] iArr = zziwx;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final byte zzgh(int i) {
        zzad(i, this.zziwy);
        return zzgi(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final byte zzgi(int i) {
        int i2 = this.zzixb;
        if (i < i2) {
            return this.zziwz.zzgi(i);
        }
        return this.zzixa.zzgi(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final int size() {
        return this.zziwy;
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final zzelv zzbhg() {
        return new zzepe(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final int zzbhl() {
        return this.zzixc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final boolean zzbhm() {
        return this.zziwy >= zzhz(this.zzixc);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final zzelq zzac(int i, int i2) {
        int zzi = zzi(i, i2, this.zziwy);
        if (zzi == 0) {
            return zzelq.zzipc;
        }
        if (zzi == this.zziwy) {
            return this;
        }
        int i3 = this.zzixb;
        if (i2 <= i3) {
            return this.zziwz.zzac(i, i2);
        }
        if (i >= i3) {
            return this.zzixa.zzac(i - i3, i2 - i3);
        }
        zzelq zzelqVar = this.zziwz;
        return new zzepf(zzelqVar.zzac(i, zzelqVar.size()), this.zzixa.zzac(0, i2 - this.zzixb));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzixb;
        if (i4 <= i5) {
            this.zziwz.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zzixa.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zziwz.zzb(bArr, i, i2, i6);
            this.zzixa.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final void zza(zzeln zzelnVar) {
        this.zziwz.zza(zzelnVar);
        this.zzixa.zza(zzelnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    protected final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final boolean zzbhi() {
        int zzg = this.zziwz.zzg(0, 0, this.zzixb);
        zzelq zzelqVar = this.zzixa;
        return zzelqVar.zzg(zzg, 0, zzelqVar.size()) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzixb;
        if (i4 <= i5) {
            return this.zziwz.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzixa.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzixa.zzg(this.zziwz.zzg(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final boolean equals(Object obj) {
        boolean zza;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzelq)) {
            return false;
        }
        zzelq zzelqVar = (zzelq) obj;
        if (this.zziwy != zzelqVar.size()) {
            return false;
        }
        if (this.zziwy == 0) {
            return true;
        }
        int zzbhn = zzbhn();
        int zzbhn2 = zzelqVar.zzbhn();
        if (zzbhn != 0 && zzbhn2 != 0 && zzbhn != zzbhn2) {
            return false;
        }
        zzepg zzepgVar = new zzepg(this, null);
        zzelx next = zzepgVar.next();
        zzepg zzepgVar2 = new zzepg(zzelqVar, null);
        zzelx next2 = zzepgVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                zza = next.zza(next2, i2, min);
            } else {
                zza = next2.zza(next, i, min);
            }
            if (!zza) {
                return false;
            }
            i3 += min;
            int i4 = this.zziwy;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = zzepgVar.next();
                i = 0;
            } else {
                i += min;
            }
            if (min == size2) {
                next2 = zzepgVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzelq
    public final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzixb;
        if (i4 <= i5) {
            return this.zziwz.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzixa.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzixa.zzh(this.zziwz.zzh(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzelq
    public final zzemb zzbhj() {
        return new zzemg(new zzepj(this));
    }

    @Override // com.google.android.gms.internal.ads.zzelq, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzepf(zzelq zzelqVar, zzelq zzelqVar2, zzepe zzepeVar) {
        this(zzelqVar, zzelqVar2);
    }
}
