package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.bz;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzemg extends zzemb {
    private final byte[] buffer;
    private int pos;
    private int zzakr;
    private int zzipu;
    private int zzipw;
    private int zzipx;
    private final InputStream zzipy;
    private int zzipz;
    private zzemf zziqa;

    private zzemg(InputStream inputStream, int i) {
        super();
        this.zzipx = Integer.MAX_VALUE;
        this.zziqa = null;
        zzenc.zza(inputStream, "input");
        this.zzipy = inputStream;
        this.buffer = new byte[4096];
        this.zzakr = 0;
        this.pos = 0;
        this.zzipz = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbhr() {
        if (zzbih()) {
            this.zzipw = 0;
            return 0;
        }
        int zzbij = zzbij();
        this.zzipw = zzbij;
        if ((zzbij >>> 3) != 0) {
            return zzbij;
        }
        throw zzenn.zzbkc();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final void zzgl(int i) {
        if (this.zzipw != i) {
            throw zzenn.zzbkd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final boolean zzgm(int i) {
        int zzbhr;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzakr - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzenn.zzbkb();
            }
            while (i3 < 10) {
                if (zzbio() < 0) {
                    i3++;
                }
            }
            throw zzenn.zzbkb();
            return true;
        } else if (i2 == 1) {
            zzgq(8);
            return true;
        } else if (i2 == 2) {
            zzgq(zzbij());
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    zzgq(4);
                    return true;
                }
                throw zzenn.zzbke();
            }
            return false;
        } else {
            do {
                zzbhr = zzbhr();
                if (zzbhr == 0) {
                    break;
                }
            } while (zzgm(zzbhr));
            zzgl(((i >>> 3) << 3) | 4);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final double readDouble() {
        return Double.longBitsToDouble(zzbim());
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final float readFloat() {
        return Float.intBitsToFloat(zzbil());
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final long zzbhs() {
        return zzbik();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final long zzbht() {
        return zzbik();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbhu() {
        return zzbij();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final long zzbhv() {
        return zzbim();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbhw() {
        return zzbil();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final boolean zzbhx() {
        return zzbik() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final String readString() {
        int zzbij = zzbij();
        if (zzbij > 0 && zzbij <= this.zzakr - this.pos) {
            String str = new String(this.buffer, this.pos, zzbij, zzenc.UTF_8);
            this.pos += zzbij;
            return str;
        } else if (zzbij == 0) {
            return "";
        } else {
            if (zzbij <= this.zzakr) {
                zzgr(zzbij);
                String str2 = new String(this.buffer, this.pos, zzbij, zzenc.UTF_8);
                this.pos += zzbij;
                return str2;
            }
            return new String(zzg(zzbij, false), zzenc.UTF_8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final String zzbhy() {
        byte[] zzg;
        int zzbij = zzbij();
        int i = this.pos;
        if (zzbij <= this.zzakr - i && zzbij > 0) {
            zzg = this.buffer;
            this.pos = i + zzbij;
        } else if (zzbij == 0) {
            return "";
        } else {
            if (zzbij <= this.zzakr) {
                zzgr(zzbij);
                zzg = this.buffer;
                this.pos = zzbij;
            } else {
                zzg = zzg(zzbij, false);
            }
            i = 0;
        }
        return zzeqj.zzo(zzg, i, zzbij);
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final zzelq zzbhz() {
        int zzbij = zzbij();
        int i = this.zzakr;
        int i2 = this.pos;
        if (zzbij <= i - i2 && zzbij > 0) {
            zzelq zzi = zzelq.zzi(this.buffer, i2, zzbij);
            this.pos += zzbij;
            return zzi;
        } else if (zzbij == 0) {
            return zzelq.zzipc;
        } else {
            byte[] zzgt = zzgt(zzbij);
            if (zzgt != null) {
                return zzelq.zzt(zzgt);
            }
            int i3 = this.pos;
            int i4 = this.zzakr;
            int i5 = i4 - i3;
            this.zzipz += i4;
            this.pos = 0;
            this.zzakr = 0;
            List<byte[]> zzgu = zzgu(zzbij - i5);
            byte[] bArr = new byte[zzbij];
            System.arraycopy(this.buffer, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzgu) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return zzelq.zzu(bArr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbia() {
        return zzbij();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbib() {
        return zzbij();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbic() {
        return zzbil();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final long zzbid() {
        return zzbim();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbie() {
        return zzgp(zzbij());
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final long zzbif() {
        return zzfh(zzbik());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zzbij() {
        int i;
        int i2 = this.pos;
        int i3 = this.zzakr;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.pos = i4;
                return b2;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b2 ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << bz.l);
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            byte b3 = bArr[i5];
                            i = (i9 ^ (b3 << 28)) ^ 266354560;
                            if (b3 < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i7 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i7;
                }
                this.pos = i5;
                return i;
            }
        }
        return (int) zzbig();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
        if (r2[r0] >= 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long zzbik() {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.pos;
        int i3 = this.zzakr;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.pos = i4;
                return b2;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b2 ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << bz.l);
                    if (i8 >= 0) {
                        i5 = i7;
                        j4 = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            long j5 = i9;
                            int i10 = i5 + 1;
                            long j6 = j5 ^ (bArr[i5] << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                i5 = i10 + 1;
                                long j7 = j6 ^ (bArr[i10] << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i10 = i5 + 1;
                                    j6 = j7 ^ (bArr[i5] << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i5 = i10 + 1;
                                        j7 = j6 ^ (bArr[i10] << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i11 = i5 + 1;
                                            j = (j7 ^ (bArr[i5] << 56)) ^ 71499008037633920L;
                                            i5 = j < 0 ? i11 + 1 : i11;
                                            j4 = j;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                j4 = j;
                            }
                            j4 = j3 ^ j6;
                            i5 = i10;
                        }
                    }
                    this.pos = i5;
                    return j4;
                }
                i = i6 ^ (-128);
                j4 = i;
                this.pos = i5;
                return j4;
            }
        }
        return zzbig();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzemb
    public final long zzbig() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzbio = zzbio();
            j |= (zzbio & Byte.MAX_VALUE) << i;
            if ((zzbio & 128) == 0) {
                return j;
            }
        }
        throw zzenn.zzbkb();
    }

    private final int zzbil() {
        int i = this.pos;
        if (this.zzakr - i < 4) {
            zzgr(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzbim() {
        int i = this.pos;
        if (this.zzakr - i < 8) {
            zzgr(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzgn(int i) {
        if (i < 0) {
            throw zzenn.zzbka();
        }
        int i2 = i + this.zzipz + this.pos;
        int i3 = this.zzipx;
        if (i2 > i3) {
            throw zzenn.zzbjz();
        }
        this.zzipx = i2;
        zzbin();
        return i3;
    }

    private final void zzbin() {
        int i = this.zzakr + this.zzipu;
        this.zzakr = i;
        int i2 = this.zzipz + i;
        int i3 = this.zzipx;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzipu = i4;
            this.zzakr = i - i4;
            return;
        }
        this.zzipu = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final void zzgo(int i) {
        this.zzipx = i;
        zzbin();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final boolean zzbih() {
        return this.pos == this.zzakr && !zzgs(1);
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbii() {
        return this.zzipz + this.pos;
    }

    private final void zzgr(int i) {
        if (zzgs(i)) {
            return;
        }
        if (i > (this.zzipq - this.zzipz) - this.pos) {
            throw zzenn.zzbkf();
        }
        throw zzenn.zzbjz();
    }

    private final boolean zzgs(int i) {
        while (this.pos + i > this.zzakr) {
            int i2 = this.zzipq;
            int i3 = this.zzipz;
            int i4 = this.pos;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.zzipx) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.zzakr;
                if (i5 > i4) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.zzipz += i4;
                this.zzakr -= i4;
                this.pos = 0;
            }
            InputStream inputStream = this.zzipy;
            byte[] bArr2 = this.buffer;
            int i6 = this.zzakr;
            int read = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.zzipq - this.zzipz) - this.zzakr));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zzipy.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzakr += read;
                zzbin();
                if (this.zzakr >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte zzbio() {
        if (this.pos == this.zzakr) {
            zzgr(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzg(int i, boolean z) {
        byte[] zzgt = zzgt(i);
        if (zzgt != null) {
            return zzgt;
        }
        int i2 = this.pos;
        int i3 = this.zzakr;
        int i4 = i3 - i2;
        this.zzipz += i3;
        this.pos = 0;
        this.zzakr = 0;
        List<byte[]> zzgu = zzgu(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzgu) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzgt(int i) {
        if (i == 0) {
            return zzenc.zzipi;
        }
        if (i < 0) {
            throw zzenn.zzbka();
        }
        int i2 = this.zzipz + this.pos + i;
        if (i2 - this.zzipq > 0) {
            throw zzenn.zzbkf();
        }
        int i3 = this.zzipx;
        if (i2 > i3) {
            zzgq((i3 - this.zzipz) - this.pos);
            throw zzenn.zzbjz();
        }
        int i4 = this.zzakr - this.pos;
        int i5 = i - i4;
        if (i5 < 4096 || i5 <= this.zzipy.available()) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
            this.zzipz += this.zzakr;
            this.pos = 0;
            this.zzakr = 0;
            while (i4 < i) {
                int read = this.zzipy.read(bArr, i4, i - i4);
                if (read == -1) {
                    throw zzenn.zzbjz();
                }
                this.zzipz += read;
                i4 += read;
            }
            return bArr;
        }
        return null;
    }

    private final List<byte[]> zzgu(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzipy.read(bArr, i2, min - i2);
                if (read == -1) {
                    throw zzenn.zzbjz();
                }
                this.zzipz += read;
                i2 += read;
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzgq(int i) {
        int i2 = this.zzakr;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i < 0) {
            throw zzenn.zzbka();
        } else {
            int i4 = this.zzipz;
            int i5 = this.pos;
            int i6 = i4 + i5 + i;
            int i7 = this.zzipx;
            if (i6 > i7) {
                zzgq((i7 - i4) - i5);
                throw zzenn.zzbjz();
            }
            this.zzipz = i4 + i5;
            int i8 = this.zzakr - i5;
            this.zzakr = 0;
            this.pos = 0;
            while (i8 < i) {
                try {
                    long j = i - i8;
                    long skip = this.zzipy.skip(j);
                    if (skip >= 0 && skip <= j) {
                        if (skip == 0) {
                            break;
                        }
                        i8 += (int) skip;
                    } else {
                        String valueOf = String.valueOf(this.zzipy.getClass());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                        sb.append(valueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(skip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                } finally {
                    this.zzipz += i8;
                    zzbin();
                }
            }
            if (i8 >= i) {
                return;
            }
            int i9 = this.zzakr;
            int i10 = i9 - this.pos;
            this.pos = i9;
            zzgr(1);
            while (true) {
                int i11 = i - i10;
                int i12 = this.zzakr;
                if (i11 > i12) {
                    i10 += i12;
                    this.pos = i12;
                    zzgr(1);
                } else {
                    this.pos = i11;
                    return;
                }
            }
        }
    }
}
