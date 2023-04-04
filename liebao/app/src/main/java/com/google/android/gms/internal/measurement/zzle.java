package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
final class zzle extends zzld {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.measurement.zzld
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zza(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        if ((i2 | i3 | (bArr.length - i3)) >= 0) {
            long j2 = i2;
            int i5 = (int) (i3 - j2);
            if (i5 >= 16) {
                long j3 = j2;
                i4 = 0;
                while (true) {
                    if (i4 >= i5) {
                        i4 = i5;
                        break;
                    }
                    long j4 = j3 + 1;
                    if (zzkz.zza(bArr, j3) < 0) {
                        break;
                    }
                    i4++;
                    j3 = j4;
                }
            } else {
                i4 = 0;
            }
            int i6 = i5 - i4;
            long j5 = j2 + i4;
            while (true) {
                byte b2 = 0;
                while (true) {
                    if (i6 <= 0) {
                        break;
                    }
                    long j6 = j5 + 1;
                    b2 = zzkz.zza(bArr, j5);
                    if (b2 < 0) {
                        j5 = j6;
                        break;
                    }
                    i6--;
                    j5 = j6;
                }
                if (i6 == 0) {
                    return 0;
                }
                int i7 = i6 - 1;
                if (b2 >= -32) {
                    if (b2 >= -16) {
                        if (i7 < 3) {
                            return zza(bArr, b2, j5, i7);
                        }
                        i6 = i7 - 3;
                        long j7 = j5 + 1;
                        byte zza = zzkz.zza(bArr, j5);
                        if (zza > -65 || (((b2 << 28) + (zza + 112)) >> 30) != 0) {
                            break;
                        }
                        long j8 = j7 + 1;
                        if (zzkz.zza(bArr, j7) > -65) {
                            break;
                        }
                        j = j8 + 1;
                        if (zzkz.zza(bArr, j8) > -65) {
                            break;
                        }
                    } else if (i7 < 2) {
                        return zza(bArr, b2, j5, i7);
                    } else {
                        i6 = i7 - 2;
                        long j9 = j5 + 1;
                        byte zza2 = zzkz.zza(bArr, j5);
                        if (zza2 > -65 || ((b2 == -32 && zza2 < -96) || (b2 == -19 && zza2 >= -96))) {
                            break;
                        }
                        j5 = j9 + 1;
                        if (zzkz.zza(bArr, j9) > -65) {
                            break;
                        }
                    }
                } else if (i7 != 0) {
                    i6 = i7 - 1;
                    if (b2 < -62) {
                        break;
                    }
                    j = j5 + 1;
                    if (zzkz.zza(bArr, j5) > -65) {
                        break;
                    }
                } else {
                    return b2;
                }
                j5 = j;
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzld
    public final String zza(byte[] bArr, int i, int i2) {
        boolean zzd;
        boolean zzd2;
        boolean zze;
        boolean zzf;
        boolean zzd3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte zza = zzkz.zza(bArr, i);
            zzd3 = zzla.zzd(zza);
            if (!zzd3) {
                break;
            }
            i++;
            zzla.zzb(zza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte zza2 = zzkz.zza(bArr, i);
            zzd = zzla.zzd(zza2);
            if (zzd) {
                int i7 = i5 + 1;
                zzla.zzb(zza2, cArr, i5);
                while (i6 < i3) {
                    byte zza3 = zzkz.zza(bArr, i6);
                    zzd2 = zzla.zzd(zza3);
                    if (!zzd2) {
                        break;
                    }
                    i6++;
                    zzla.zzb(zza3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                zze = zzla.zze(zza2);
                if (!zze) {
                    zzf = zzla.zzf(zza2);
                    if (zzf) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            zzla.zzb(zza2, zzkz.zza(bArr, i6), zzkz.zza(bArr, i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw zzij.zzh();
                        }
                    } else if (i6 < i3 - 2) {
                        int i9 = i6 + 1;
                        int i10 = i9 + 1;
                        zzla.zzb(zza2, zzkz.zza(bArr, i6), zzkz.zza(bArr, i9), zzkz.zza(bArr, i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw zzij.zzh();
                    }
                } else if (i6 < i3) {
                    zzla.zzb(zza2, zzkz.zza(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzij.zzh();
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzld
    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c2;
        long j;
        long j2;
        long j3;
        int i3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c2 = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzkz.zza(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 >= c2 || j4 >= j5) {
                if (charAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    zzkz.zza(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    zzkz.zza(bArr, j6, (byte) ((charAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else if ((charAt3 >= 55296 && 57343 >= charAt3) || j4 > j5 - 3) {
                    if (j4 <= j5 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j7 = j4 + 1;
                                zzkz.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j8 = j7 + 1;
                                zzkz.zza(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j9 = j8 + 1;
                                zzkz.zza(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j9 + 1;
                                zzkz.zza(bArr, j9, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzlf(i4 - 1, length);
                    } else if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        throw new zzlf(i4, length);
                    } else {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                } else {
                    long j10 = j4 + j;
                    zzkz.zza(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    zzkz.zza(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                    zzkz.zza(bArr, j11, (byte) ((charAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c2 = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                zzkz.zza(bArr, j4, (byte) charAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c2 = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzb;
        int zzb2;
        int zzb3;
        if (i2 == 0) {
            zzb = zzlb.zzb(i);
            return zzb;
        } else if (i2 == 1) {
            zzb2 = zzlb.zzb(i, zzkz.zza(bArr, j));
            return zzb2;
        } else if (i2 == 2) {
            zzb3 = zzlb.zzb(i, zzkz.zza(bArr, j), zzkz.zza(bArr, j + 1));
            return zzb3;
        } else {
            throw new AssertionError();
        }
    }
}
