package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeqj {
    private static final zzeqk zzizd;

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzas(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzie(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzj(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean zzx(byte[] bArr) {
        return zzizd.zzm(bArr, 0, bArr.length);
    }

    public static boolean zzm(byte[] bArr, int i, int i2) {
        return zzizd.zzm(bArr, i, i2);
    }

    public static int zzb(int i, byte[] bArr, int i2, int i3) {
        return zzizd.zzb(i, bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzn(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return zzj(b2, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return zzas(b2, bArr[i]);
        }
        return zzie(b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new zzeqm(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(i3 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzizd.zzb(charSequence, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzo(byte[] bArr, int i, int i2) {
        return zzizd.zzo(bArr, i, i2);
    }

    static {
        zzeqk zzeqnVar;
        if ((zzeqg.zzbmb() && zzeqg.zzbmc()) && !zzelj.zzbhb()) {
            zzeqnVar = new zzeqp();
        } else {
            zzeqnVar = new zzeqn();
        }
        zzizd = zzeqnVar;
    }
}
