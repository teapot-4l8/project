package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeqn extends zzeqk {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r13[r14] > (-65)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
        if (r13[r14] > (-65)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0082, code lost:
        if (r13[r14] > (-65)) goto L48;
     */
    @Override // com.google.android.gms.internal.ads.zzeqk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        int zzn;
        int zzn2;
        byte b2;
        int i4;
        int zzj;
        int zzas;
        int zzas2;
        if (i != 0) {
            if (i2 >= i3) {
                return i;
            }
            byte b3 = (byte) i;
            if (b3 < -32) {
                if (b3 >= -62) {
                    i4 = i2 + 1;
                }
                return -1;
            } else if (b3 < -16) {
                byte b4 = (byte) ((i >> 8) ^ (-1));
                if (b4 == 0) {
                    int i5 = i2 + 1;
                    byte b5 = bArr[i2];
                    if (i5 >= i3) {
                        zzas2 = zzeqj.zzas(b3, b5);
                        return zzas2;
                    }
                    i2 = i5;
                    b4 = b5;
                }
                if (b4 <= -65 && ((b3 != -32 || b4 >= -96) && (b3 != -19 || b4 < -96))) {
                    i4 = i2 + 1;
                }
                return -1;
            } else {
                byte b6 = (byte) ((i >> 8) ^ (-1));
                if (b6 == 0) {
                    int i6 = i2 + 1;
                    b6 = bArr[i2];
                    if (i6 >= i3) {
                        zzas = zzeqj.zzas(b3, b6);
                        return zzas;
                    }
                    i2 = i6;
                    b2 = 0;
                } else {
                    b2 = (byte) (i >> 16);
                }
                if (b2 == 0) {
                    int i7 = i2 + 1;
                    byte b7 = bArr[i2];
                    if (i7 >= i3) {
                        zzj = zzeqj.zzj(b3, b6, b7);
                        return zzj;
                    }
                    i2 = i7;
                    b2 = b7;
                }
                if (b6 <= -65 && (((b3 << 28) + (b6 + 112)) >> 30) == 0 && b2 <= -65) {
                    i4 = i2 + 1;
                }
                return -1;
            }
            i2 = i4;
        }
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i8 = i2 + 1;
            byte b8 = bArr[i2];
            if (b8 < 0) {
                if (b8 < -32) {
                    if (i8 >= i3) {
                        return b8;
                    }
                    if (b8 >= -62) {
                        i2 = i8 + 1;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                } else if (b8 >= -16) {
                    if (i8 >= i3 - 2) {
                        zzn2 = zzeqj.zzn(bArr, i8, i3);
                        return zzn2;
                    }
                    int i9 = i8 + 1;
                    byte b9 = bArr[i8];
                    if (b9 <= -65 && (((b8 << 28) + (b9 + 112)) >> 30) == 0) {
                        int i10 = i9 + 1;
                        if (bArr[i9] <= -65) {
                            i2 = i10 + 1;
                            if (bArr[i10] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i8 < i3 - 1) {
                    int i11 = i8 + 1;
                    byte b10 = bArr[i8];
                    if (b10 <= -65 && ((b8 != -32 || b10 >= -96) && (b8 != -19 || b10 < -96))) {
                        i8 = i11 + 1;
                        if (bArr[i11] > -65) {
                        }
                    }
                    return -1;
                } else {
                    zzn = zzeqj.zzn(bArr, i8, i3);
                    return zzn;
                }
            }
            i2 = i8;
        }
        return 0;
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
            byte b2 = bArr[i];
            zze3 = zzeql.zze(b2);
            if (!zze3) {
                break;
            }
            i++;
            zzeql.zza(b2, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b3 = bArr[i];
            zze = zzeql.zze(b3);
            if (zze) {
                int i7 = i5 + 1;
                zzeql.zza(b3, cArr, i5);
                while (i6 < i3) {
                    byte b4 = bArr[i6];
                    zze2 = zzeql.zze(b4);
                    if (!zze2) {
                        break;
                    }
                    i6++;
                    zzeql.zza(b4, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                zzf = zzeql.zzf(b3);
                if (!zzf) {
                    zzg = zzeql.zzg(b3);
                    if (zzg) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            zzeql.zza(b3, bArr[i6], bArr[i8], cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw zzenn.zzbkh();
                        }
                    } else if (i6 >= i3 - 2) {
                        throw zzenn.zzbkh();
                    } else {
                        int i9 = i6 + 1;
                        byte b5 = bArr[i6];
                        int i10 = i9 + 1;
                        zzeql.zza(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else if (i6 < i3) {
                    zzeql.zza(b3, bArr[i6], cArr, i5);
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
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.ads.zzeqk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char charAt;
        int length = charSequence.length();
        int i6 = i2 + i;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
            bArr[i5] = (byte) charAt;
            i7++;
        }
        int i8 = i + i7;
        while (i7 < length) {
            char charAt2 = charSequence.charAt(i7);
            if (charAt2 >= 128 || i8 >= i6) {
                if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                } else if ((charAt2 >= 55296 && 57343 >= charAt2) || i8 > i6 - 3) {
                    if (i8 <= i6 - 4) {
                        int i10 = i7 + 1;
                        if (i10 != charSequence.length()) {
                            char charAt3 = charSequence.charAt(i10);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i11 = i8 + 1;
                                bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                int i12 = i11 + 1;
                                bArr[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i13 = i12 + 1;
                                bArr[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i8 = i13 + 1;
                                bArr[i13] = (byte) ((codePoint & 63) | 128);
                                i7 = i10;
                            } else {
                                i7 = i10;
                            }
                        }
                        throw new zzeqm(i7 - 1, length);
                    } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                        throw new zzeqm(i7, length);
                    } else {
                        StringBuilder sb = new StringBuilder(37);
                        sb.append("Failed writing ");
                        sb.append(charAt2);
                        sb.append(" at index ");
                        sb.append(i8);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
                    }
                } else {
                    int i14 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> '\f') | 480);
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i3 = i15 + 1;
                    bArr[i15] = (byte) ((charAt2 & '?') | 128);
                }
                i7++;
            } else {
                i3 = i8 + 1;
                bArr[i8] = (byte) charAt2;
            }
            i8 = i3;
            i7++;
        }
        return i8;
    }
}
