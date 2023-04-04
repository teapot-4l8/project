package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.bz;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzemd extends zzemb {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzipt;
    private int zzipu;
    private int zzipv;
    private int zzipw;
    private int zzipx;

    private zzemd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzipx = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzipv = i;
        this.zzipt = z;
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
            if (this.limit - this.pos >= 10) {
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
        if (zzbij > 0 && zzbij <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzbij, zzenc.UTF_8);
            this.pos += zzbij;
            return str;
        } else if (zzbij == 0) {
            return "";
        } else {
            if (zzbij < 0) {
                throw zzenn.zzbka();
            }
            throw zzenn.zzbjz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final String zzbhy() {
        int zzbij = zzbij();
        if (zzbij > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzbij <= i - i2) {
                String zzo = zzeqj.zzo(this.buffer, i2, zzbij);
                this.pos += zzbij;
                return zzo;
            }
        }
        if (zzbij == 0) {
            return "";
        }
        if (zzbij <= 0) {
            throw zzenn.zzbka();
        }
        throw zzenn.zzbjz();
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final zzelq zzbhz() {
        byte[] bArr;
        int zzbij = zzbij();
        if (zzbij > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzbij <= i - i2) {
                zzelq zzi = zzelq.zzi(this.buffer, i2, zzbij);
                this.pos += zzbij;
                return zzi;
            }
        }
        if (zzbij == 0) {
            return zzelq.zzipc;
        }
        if (zzbij > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzbij <= i3 - i4) {
                int i5 = zzbij + i4;
                this.pos = i5;
                bArr = Arrays.copyOfRange(this.buffer, i4, i5);
                return zzelq.zzu(bArr);
            }
        }
        if (zzbij <= 0) {
            if (zzbij == 0) {
                bArr = zzenc.zzipi;
                return zzelq.zzu(bArr);
            }
            throw zzenn.zzbka();
        }
        throw zzenn.zzbjz();
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
        int i3 = this.limit;
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
        int i3 = this.limit;
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
        if (this.limit - i < 4) {
            throw zzenn.zzbjz();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzbim() {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzenn.zzbjz();
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
        int zzbii = i + zzbii();
        int i2 = this.zzipx;
        if (zzbii > i2) {
            throw zzenn.zzbjz();
        }
        this.zzipx = zzbii;
        zzbin();
        return i2;
    }

    private final void zzbin() {
        int i = this.limit + this.zzipu;
        this.limit = i;
        int i2 = i - this.zzipv;
        int i3 = this.zzipx;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzipu = i4;
            this.limit = i - i4;
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
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzemb
    public final int zzbii() {
        return this.pos - this.zzipv;
    }

    private final byte zzbio() {
        int i = this.pos;
        if (i == this.limit) {
            throw zzenn.zzbjz();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzgq(int i) {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzenn.zzbka();
        }
        throw zzenn.zzbjz();
    }
}
