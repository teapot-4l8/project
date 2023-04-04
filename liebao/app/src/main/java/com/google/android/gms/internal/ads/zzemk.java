package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzemk extends zzeln {
    private static final Logger logger = Logger.getLogger(zzemk.class.getName());
    private static final boolean zziqf = zzeqg.zzbmb();
    zzemm zziqg;

    public static int zzbx(boolean z) {
        return 1;
    }

    public static int zzd(double d2) {
        return 8;
    }

    public static int zzfm(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzfo(long j) {
        return 8;
    }

    public static int zzfp(long j) {
        return 8;
    }

    private static long zzfq(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzhf(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzhh(int i) {
        return 4;
    }

    public static int zzhi(int i) {
        return 4;
    }

    private static int zzhk(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static zzemk zzv(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public abstract void writeTag(int i, int i2);

    public abstract void zza(int i, zzelq zzelqVar);

    public abstract void zza(int i, zzeon zzeonVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(int i, zzeon zzeonVar, zzepi zzepiVar);

    public abstract void zzae(int i, int i2);

    public abstract void zzaf(int i, int i2);

    public abstract void zzah(int i, int i2);

    public abstract void zzai(zzelq zzelqVar);

    public abstract void zzb(int i, zzelq zzelqVar);

    public abstract int zzbir();

    public abstract void zzd(byte b2);

    public abstract void zzfi(long j);

    public abstract void zzfk(long j);

    public abstract void zzg(zzeon zzeonVar);

    public abstract void zzgz(int i);

    public abstract void zzh(int i, boolean z);

    public abstract void zzha(int i);

    public abstract void zzhc(int i);

    public abstract void zzi(int i, long j);

    public abstract void zzi(int i, String str);

    public abstract void zzia(String str);

    public abstract void zzk(int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i, int i2);

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        zza(String str, Throwable th) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
            String valueOf = String.valueOf(str);
        }
    }

    private zzemk() {
    }

    public final void zzag(int i, int i2) {
        zzaf(i, zzhk(i2));
    }

    public final void zzj(int i, long j) {
        zzi(i, zzfq(j));
    }

    public final void zza(int i, float f) {
        zzah(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(int i, double d2) {
        zzk(i, Double.doubleToRawLongBits(d2));
    }

    public final void zzhb(int i) {
        zzha(zzhk(i));
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    private static class zzb extends zzemk {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i2 | 0 | (bArr.length - i2)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = 0;
            this.position = 0;
            this.limit = i2;
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void writeTag(int i, int i2) {
            zzha((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzae(int i, int i2) {
            writeTag(i, 0);
            zzgz(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzaf(int i, int i2) {
            writeTag(i, 0);
            zzha(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzah(int i, int i2) {
            writeTag(i, 5);
            zzhc(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzi(int i, long j) {
            writeTag(i, 0);
            zzfi(j);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzk(int i, long j) {
            writeTag(i, 1);
            zzfk(j);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzh(int i, boolean z) {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzi(int i, String str) {
            writeTag(i, 2);
            zzia(str);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zza(int i, zzelq zzelqVar) {
            writeTag(i, 2);
            zzai(zzelqVar);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzai(zzelq zzelqVar) {
            zzha(zzelqVar.size());
            zzelqVar.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzk(byte[] bArr, int i, int i2) {
            zzha(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        final void zza(int i, zzeon zzeonVar, zzepi zzepiVar) {
            writeTag(i, 2);
            zzelg zzelgVar = (zzelg) zzeonVar;
            int zzbgz = zzelgVar.zzbgz();
            if (zzbgz == -1) {
                zzbgz = zzepiVar.zzau(zzelgVar);
                zzelgVar.zzgd(zzbgz);
            }
            zzha(zzbgz);
            zzepiVar.zza(zzeonVar, this.zziqg);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zza(int i, zzeon zzeonVar) {
            writeTag(1, 3);
            zzaf(2, i);
            writeTag(3, 2);
            zzg(zzeonVar);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzb(int i, zzelq zzelqVar) {
            writeTag(1, 3);
            zzaf(2, i);
            zza(3, zzelqVar);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzg(zzeon zzeonVar) {
            zzha(zzeonVar.zzbjj());
            zzeonVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzd(byte b2) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzgz(int i) {
            if (i >= 0) {
                zzha(i);
            } else {
                zzfi(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzha(int i) {
            if (!zzemk.zziqf || zzelj.zzbhb() || zzbir() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
            } else if ((i & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzeqg.zza(bArr3, i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzeqg.zza(bArr4, i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & (-128)) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzeqg.zza(bArr5, i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzeqg.zza(bArr6, i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & (-128)) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzeqg.zza(bArr7, i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzeqg.zza(bArr8, i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & (-128)) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzeqg.zza(bArr9, i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzeqg.zza(bArr10, i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzeqg.zza(bArr11, i15, (byte) (i12 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzhc(int i) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzfi(long j) {
            if (zzemk.zziqf && zzbir() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzeqg.zza(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzeqg.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzfk(long j) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.buffer;
                int i3 = i2 + 1;
                this.position = i3;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.buffer;
                int i8 = i7 + 1;
                this.position = i8;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.buffer;
                this.position = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        private final void write(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeln
        public final void zzh(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final void zzia(String str) {
            int i = this.position;
            try {
                int zzhf = zzhf(str.length() * 3);
                int zzhf2 = zzhf(str.length());
                if (zzhf2 == zzhf) {
                    int i2 = i + zzhf2;
                    this.position = i2;
                    int zza = zzeqj.zza(str, this.buffer, i2, zzbir());
                    this.position = i;
                    zzha((zza - i) - zzhf2);
                    this.position = zza;
                    return;
                }
                zzha(zzeqj.zzd(str));
                this.position = zzeqj.zza(str, this.buffer, this.position, zzbir());
            } catch (zzeqm e2) {
                this.position = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zza(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzemk
        public final int zzbir() {
            return this.limit - this.position;
        }
    }

    public final void zzfj(long j) {
        zzfi(zzfq(j));
    }

    public final void zzf(float f) {
        zzhc(Float.floatToRawIntBits(f));
    }

    public final void zzc(double d2) {
        zzfk(Double.doubleToRawLongBits(d2));
    }

    public final void zzbw(boolean z) {
        zzd(z ? (byte) 1 : (byte) 0);
    }

    public static int zzai(int i, int i2) {
        return zzhf(i << 3) + zzhe(i2);
    }

    public static int zzaj(int i, int i2) {
        return zzhf(i << 3) + zzhf(i2);
    }

    public static int zzak(int i, int i2) {
        return zzhf(i << 3) + zzhf(zzhk(i2));
    }

    public static int zzal(int i, int i2) {
        return zzhf(i << 3) + 4;
    }

    public static int zzam(int i, int i2) {
        return zzhf(i << 3) + 4;
    }

    public static int zzl(int i, long j) {
        return zzhf(i << 3) + zzfm(j);
    }

    public static int zzm(int i, long j) {
        return zzhf(i << 3) + zzfm(j);
    }

    public static int zzn(int i, long j) {
        return zzhf(i << 3) + zzfm(zzfq(j));
    }

    public static int zzo(int i, long j) {
        return zzhf(i << 3) + 8;
    }

    public static int zzp(int i, long j) {
        return zzhf(i << 3) + 8;
    }

    public static int zzb(int i, float f) {
        return zzhf(i << 3) + 4;
    }

    public static int zzc(int i, double d2) {
        return zzhf(i << 3) + 8;
    }

    public static int zzi(int i, boolean z) {
        return zzhf(i << 3) + 1;
    }

    public static int zzan(int i, int i2) {
        return zzhf(i << 3) + zzhe(i2);
    }

    public static int zzj(int i, String str) {
        return zzhf(i << 3) + zzib(str);
    }

    public static int zzc(int i, zzelq zzelqVar) {
        int zzhf = zzhf(i << 3);
        int size = zzelqVar.size();
        return zzhf + zzhf(size) + size;
    }

    public static int zza(int i, zzens zzensVar) {
        int zzhf = zzhf(i << 3);
        int zzbjj = zzensVar.zzbjj();
        return zzhf + zzhf(zzbjj) + zzbjj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, zzeon zzeonVar, zzepi zzepiVar) {
        return zzhf(i << 3) + zza(zzeonVar, zzepiVar);
    }

    public static int zzb(int i, zzeon zzeonVar) {
        return (zzhf(8) << 1) + zzaj(2, i) + zzhf(24) + zzh(zzeonVar);
    }

    public static int zzd(int i, zzelq zzelqVar) {
        return (zzhf(8) << 1) + zzaj(2, i) + zzc(3, zzelqVar);
    }

    public static int zzb(int i, zzens zzensVar) {
        return (zzhf(8) << 1) + zzaj(2, i) + zza(3, zzensVar);
    }

    public static int zzhd(int i) {
        return zzhf(i << 3);
    }

    public static int zzhe(int i) {
        if (i >= 0) {
            return zzhf(i);
        }
        return 10;
    }

    public static int zzhg(int i) {
        return zzhf(zzhk(i));
    }

    public static int zzfl(long j) {
        return zzfm(j);
    }

    public static int zzfn(long j) {
        return zzfm(zzfq(j));
    }

    public static int zzhj(int i) {
        return zzhe(i);
    }

    public static int zzib(String str) {
        int length;
        try {
            length = zzeqj.zzd(str);
        } catch (zzeqm unused) {
            length = str.getBytes(zzenc.UTF_8).length;
        }
        return zzhf(length) + length;
    }

    public static int zza(zzens zzensVar) {
        int zzbjj = zzensVar.zzbjj();
        return zzhf(zzbjj) + zzbjj;
    }

    public static int zzaj(zzelq zzelqVar) {
        int size = zzelqVar.size();
        return zzhf(size) + size;
    }

    public static int zzw(byte[] bArr) {
        int length = bArr.length;
        return zzhf(length) + length;
    }

    public static int zzh(zzeon zzeonVar) {
        int zzbjj = zzeonVar.zzbjj();
        return zzhf(zzbjj) + zzbjj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzeon zzeonVar, zzepi zzepiVar) {
        zzelg zzelgVar = (zzelg) zzeonVar;
        int zzbgz = zzelgVar.zzbgz();
        if (zzbgz == -1) {
            zzbgz = zzepiVar.zzau(zzelgVar);
            zzelgVar.zzgd(zzbgz);
        }
        return zzhf(zzbgz) + zzbgz;
    }

    public final void zzbis() {
        if (zzbir() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zza(String str, zzeqm zzeqmVar) {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzeqmVar);
        byte[] bytes = str.getBytes(zzenc.UTF_8);
        try {
            zzha(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (zza e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zza(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzc(int i, zzeon zzeonVar, zzepi zzepiVar) {
        int zzhf = zzhf(i << 3) << 1;
        zzelg zzelgVar = (zzelg) zzeonVar;
        int zzbgz = zzelgVar.zzbgz();
        if (zzbgz == -1) {
            zzbgz = zzepiVar.zzau(zzelgVar);
            zzelgVar.zzgd(zzbgz);
        }
        return zzhf + zzbgz;
    }

    @Deprecated
    public static int zzi(zzeon zzeonVar) {
        return zzeonVar.zzbjj();
    }

    @Deprecated
    public static int zzhl(int i) {
        return zzhf(i);
    }
}
