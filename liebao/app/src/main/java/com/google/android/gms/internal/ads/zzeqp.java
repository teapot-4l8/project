package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeqp extends zzeqk {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0153, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zza(r23, r8) > (-65)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zza(r23, r8) > (-65)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00fa, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.ads.zzeqk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        byte b2;
        int zzj;
        int zzas;
        long j;
        int zzas2;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j2 = i2;
        long j3 = i3;
        if (i != 0) {
            if (j2 >= j3) {
                return i;
            }
            byte b3 = (byte) i;
            if (b3 < -32) {
                if (b3 >= -62) {
                    j = j2 + 1;
                }
                return -1;
            } else if (b3 < -16) {
                byte b4 = (byte) ((i >> 8) ^ (-1));
                if (b4 == 0) {
                    long j4 = j2 + 1;
                    b4 = zzeqg.zza(bArr, j2);
                    if (j4 >= j3) {
                        zzas2 = zzeqj.zzas(b3, b4);
                        return zzas2;
                    }
                    j2 = j4;
                }
                if (b4 <= -65 && ((b3 != -32 || b4 >= -96) && (b3 != -19 || b4 < -96))) {
                    j = j2 + 1;
                }
                return -1;
            } else {
                byte b5 = (byte) ((i >> 8) ^ (-1));
                if (b5 == 0) {
                    long j5 = j2 + 1;
                    b5 = zzeqg.zza(bArr, j2);
                    if (j5 >= j3) {
                        zzas = zzeqj.zzas(b3, b5);
                        return zzas;
                    }
                    j2 = j5;
                    b2 = 0;
                } else {
                    b2 = (byte) (i >> 16);
                }
                if (b2 == 0) {
                    long j6 = j2 + 1;
                    b2 = zzeqg.zza(bArr, j2);
                    if (j6 >= j3) {
                        zzj = zzeqj.zzj(b3, b5, b2);
                        return zzj;
                    }
                    j2 = j6;
                }
                if (b5 <= -65 && (((b3 << 28) + (b5 + 112)) >> 30) == 0 && b2 <= -65) {
                    long j7 = j2 + 1;
                    if (zzeqg.zza(bArr, j2) <= -65) {
                        j2 = j7;
                    }
                }
                return -1;
            }
            j2 = j;
        }
        int i5 = (int) (j3 - j2);
        if (i5 >= 16) {
            long j8 = j2;
            i4 = 0;
            while (true) {
                if (i4 >= i5) {
                    i4 = i5;
                    break;
                }
                long j9 = j8 + 1;
                if (zzeqg.zza(bArr, j8) < 0) {
                    break;
                }
                i4++;
                j8 = j9;
            }
        } else {
            i4 = 0;
        }
        int i6 = i5 - i4;
        long j10 = j2 + i4;
        while (true) {
            byte b6 = 0;
            while (true) {
                if (i6 <= 0) {
                    break;
                }
                long j11 = j10 + 1;
                byte zza = zzeqg.zza(bArr, j10);
                if (zza < 0) {
                    j10 = j11;
                    b6 = zza;
                    break;
                }
                i6--;
                j10 = j11;
                b6 = zza;
            }
            if (i6 != 0) {
                int i7 = i6 - 1;
                if (b6 >= -32) {
                    if (b6 >= -16) {
                        if (i7 < 3) {
                            return zza(bArr, b6, j10, i7);
                        }
                        i6 = i7 - 3;
                        long j12 = j10 + 1;
                        byte zza2 = zzeqg.zza(bArr, j10);
                        if (zza2 > -65 || (((b6 << 28) + (zza2 + 112)) >> 30) != 0) {
                            break;
                        }
                        long j13 = j12 + 1;
                        if (zzeqg.zza(bArr, j12) > -65) {
                            break;
                        }
                        long j14 = j13 + 1;
                        if (zzeqg.zza(bArr, j13) > -65) {
                            break;
                        }
                        j10 = j14;
                    } else if (i7 < 2) {
                        return zza(bArr, b6, j10, i7);
                    } else {
                        i6 = i7 - 2;
                        long j15 = j10 + 1;
                        byte zza3 = zzeqg.zza(bArr, j10);
                        if (zza3 > -65 || ((b6 == -32 && zza3 < -96) || (b6 == -19 && zza3 >= -96))) {
                            break;
                        }
                        j10 = j15 + 1;
                        if (zzeqg.zza(bArr, j15) > -65) {
                            break;
                        }
                    }
                } else if (i7 != 0) {
                    i6 = i7 - 1;
                    if (b6 < -62) {
                        break;
                    }
                    long j16 = j10 + 1;
                    if (zzeqg.zza(bArr, j10) > -65) {
                        break;
                    }
                    j10 = j16;
                } else {
                    return b6;
                }
            } else {
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqk
    public final String zzo(byte[] bArr, int i, int i2) {
        boolean zze;
        boolean zze2;
        boolean zzf;
        boolean zzg;
        boolean zze3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte zza = zzeqg.zza(bArr, i);
            zze3 = zzeql.zze(zza);
            if (!zze3) {
                break;
            }
            i++;
            zzeql.zza(zza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte zza2 = zzeqg.zza(bArr, i);
            zze = zzeql.zze(zza2);
            if (zze) {
                int i7 = i5 + 1;
                zzeql.zza(zza2, cArr, i5);
                while (i6 < i3) {
                    byte zza3 = zzeqg.zza(bArr, i6);
                    zze2 = zzeql.zze(zza3);
                    if (!zze2) {
                        break;
                    }
                    i6++;
                    zzeql.zza(zza3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                zzf = zzeql.zzf(zza2);
                if (!zzf) {
                    zzg = zzeql.zzg(zza2);
                    if (zzg) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            zzeql.zza(zza2, zzeqg.zza(bArr, i6), zzeqg.zza(bArr, i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw zzenn.zzbkh();
                        }
                    } else if (i6 < i3 - 2) {
                        int i9 = i6 + 1;
                        int i10 = i9 + 1;
                        zzeql.zza(zza2, zzeqg.zza(bArr, i6), zzeqg.zza(bArr, i9), zzeqg.zza(bArr, i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw zzenn.zzbkh();
                    }
                } else if (i6 < i3) {
                    zzeql.zza(zza2, zzeqg.zza(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                } else {
                    throw zzenn.zzbkh();
                }
            }
        }
        return new String(cArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqk
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
            zzeqg.zza(bArr, j4, (byte) charAt);
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
                    zzeqg.zza(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    zzeqg.zza(bArr, j6, (byte) ((charAt3 & '?') | 128));
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
                                zzeqg.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j8 = j7 + 1;
                                zzeqg.zza(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j9 = j8 + 1;
                                zzeqg.zza(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j9 + 1;
                                zzeqg.zza(bArr, j9, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzeqm(i4 - 1, length);
                    } else if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        throw new zzeqm(i4, length);
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
                    zzeqg.zza(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    zzeqg.zza(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                    zzeqg.zza(bArr, j11, (byte) ((charAt3 & '?') | 128));
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
                zzeqg.zza(bArr, j4, (byte) charAt3);
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
        int zzie;
        int zzas;
        int zzj;
        if (i2 == 0) {
            zzie = zzeqj.zzie(i);
            return zzie;
        } else if (i2 == 1) {
            zzas = zzeqj.zzas(i, zzeqg.zza(bArr, j));
            return zzas;
        } else if (i2 == 2) {
            zzj = zzeqj.zzj(i, zzeqg.zza(bArr, j), zzeqg.zza(bArr, j + 1));
            return zzj;
        } else {
            throw new AssertionError();
        }
    }
}
