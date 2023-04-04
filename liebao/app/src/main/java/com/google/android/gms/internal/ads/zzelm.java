package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.bz;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzelm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzell zzellVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 >= 0) {
            zzellVar.zziov = b2;
            return i2;
        }
        return zza(b2, bArr, i2, zzellVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, zzell zzellVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            zzellVar.zziov = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzellVar.zziov = i5 | (b3 << bz.l);
            return i6;
        }
        int i7 = i5 | ((b3 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzellVar.zziov = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzellVar.zziov = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzellVar.zziov = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i, zzell zzellVar) {
        byte b2;
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzellVar.zziow = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b3 = bArr[i2];
        long j2 = (j & 127) | ((b3 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b3 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (b2 & Byte.MAX_VALUE) << i4;
            b3 = bArr[i3];
            i3 = i5;
        }
        zzellVar.zziow = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzi(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzj(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzi(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzk(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzh(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzell zzellVar) {
        int zza = zza(bArr, i, zzellVar);
        int i2 = zzellVar.zziov;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzellVar.zziox = "";
                return zza;
            }
            zzellVar.zziox = new String(bArr, zza, i2, zzenc.UTF_8);
            return zza + i2;
        }
        throw zzenn.zzbka();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i, zzell zzellVar) {
        int zza = zza(bArr, i, zzellVar);
        int i2 = zzellVar.zziov;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzellVar.zziox = "";
                return zza;
            }
            zzellVar.zziox = zzeqj.zzo(bArr, zza, i2);
            return zza + i2;
        }
        throw zzenn.zzbka();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(byte[] bArr, int i, zzell zzellVar) {
        int zza = zza(bArr, i, zzellVar);
        int i2 = zzellVar.zziov;
        if (i2 < 0) {
            throw zzenn.zzbka();
        }
        if (i2 <= bArr.length - zza) {
            if (i2 == 0) {
                zzellVar.zziox = zzelq.zzipc;
                return zza;
            }
            zzellVar.zziox = zzelq.zzi(bArr, zza, i2);
            return zza + i2;
        }
        throw zzenn.zzbjz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzepi zzepiVar, byte[] bArr, int i, int i2, zzell zzellVar) {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zza(i4, bArr, i3, zzellVar);
            i4 = zzellVar.zziov;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzenn.zzbjz();
        }
        Object newInstance = zzepiVar.newInstance();
        int i6 = i4 + i5;
        zzepiVar.zza(newInstance, bArr, i5, i6, zzellVar);
        zzepiVar.zzak(newInstance);
        zzellVar.zziox = newInstance;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzepi zzepiVar, byte[] bArr, int i, int i2, int i3, zzell zzellVar) {
        zzeor zzeorVar = (zzeor) zzepiVar;
        Object newInstance = zzeorVar.newInstance();
        int zza = zzeorVar.zza((zzeor) newInstance, bArr, i, i2, i3, zzellVar);
        zzeorVar.zzak(newInstance);
        zzellVar.zziox = newInstance;
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzenk<?> zzenkVar, zzell zzellVar) {
        zzend zzendVar = (zzend) zzenkVar;
        int zza = zza(bArr, i2, zzellVar);
        zzendVar.zzhp(zzellVar.zziov);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzellVar);
            if (i != zzellVar.zziov) {
                break;
            }
            zza = zza(bArr, zza2, zzellVar);
            zzendVar.zzhp(zzellVar.zziov);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzenk<?> zzenkVar, zzell zzellVar) {
        zzend zzendVar = (zzend) zzenkVar;
        int zza = zza(bArr, i, zzellVar);
        int i2 = zzellVar.zziov + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzellVar);
            zzendVar.zzhp(zzellVar.zziov);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzenn.zzbjz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzepi<?> zzepiVar, int i, byte[] bArr, int i2, int i3, zzenk<?> zzenkVar, zzell zzellVar) {
        int zza = zza(zzepiVar, bArr, i2, i3, zzellVar);
        zzenkVar.add(zzellVar.zziox);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzellVar);
            if (i != zzellVar.zziov) {
                break;
            }
            zza = zza(zzepiVar, bArr, zza2, i3, zzellVar);
            zzenkVar.add(zzellVar.zziox);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzeqd zzeqdVar, zzell zzellVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzellVar);
                zzeqdVar.zzd(i, Long.valueOf(zzellVar.zziow));
                return zzb;
            } else if (i4 == 1) {
                zzeqdVar.zzd(i, Long.valueOf(zzi(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzellVar);
                int i5 = zzellVar.zziov;
                if (i5 < 0) {
                    throw zzenn.zzbka();
                }
                if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzeqdVar.zzd(i, zzelq.zzipc);
                    } else {
                        zzeqdVar.zzd(i, zzelq.zzi(bArr, zza, i5));
                    }
                    return zza + i5;
                }
                throw zzenn.zzbjz();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    zzeqdVar.zzd(i, Integer.valueOf(zzh(bArr, i2)));
                    return i2 + 4;
                }
                throw zzenn.zzbkc();
            } else {
                zzeqd zzblz = zzeqd.zzblz();
                int i6 = (i & (-8)) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzellVar);
                    int i8 = zzellVar.zziov;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzblz, zzellVar);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzenn.zzbkg();
                }
                zzeqdVar.zzd(i, zzblz);
                return i2;
            }
        }
        throw zzenn.zzbkc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzell zzellVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                return i2 + 4;
                            }
                            throw zzenn.zzbkc();
                        }
                        int i5 = (i & (-8)) | 4;
                        int i6 = 0;
                        while (i2 < i3) {
                            i2 = zza(bArr, i2, zzellVar);
                            i6 = zzellVar.zziov;
                            if (i6 == i5) {
                                break;
                            }
                            i2 = zza(i6, bArr, i2, i3, zzellVar);
                        }
                        if (i2 > i3 || i6 != i5) {
                            throw zzenn.zzbkg();
                        }
                        return i2;
                    }
                    return zza(bArr, i2, zzellVar) + zzellVar.zziov;
                }
                return i2 + 8;
            }
            return zzb(bArr, i2, zzellVar);
        }
        throw zzenn.zzbkc();
    }
}
