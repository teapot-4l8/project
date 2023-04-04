package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzlp {
    private static final int[] zzbam = {zzpt.zzbh("isom"), zzpt.zzbh("iso2"), zzpt.zzbh("iso3"), zzpt.zzbh("iso4"), zzpt.zzbh("iso5"), zzpt.zzbh("iso6"), zzpt.zzbh("avc1"), zzpt.zzbh("hvc1"), zzpt.zzbh("hev1"), zzpt.zzbh("mp41"), zzpt.zzbh("mp42"), zzpt.zzbh("3g2a"), zzpt.zzbh("3g2b"), zzpt.zzbh("3gr6"), zzpt.zzbh("3gs6"), zzpt.zzbh("3ge6"), zzpt.zzbh("3gg6"), zzpt.zzbh("M4V "), zzpt.zzbh("M4A "), zzpt.zzbh("f4v "), zzpt.zzbh("kddi"), zzpt.zzbh("M4VP"), zzpt.zzbh("qt  "), zzpt.zzbh("MSNV")};

    public static boolean zzd(zzjz zzjzVar) {
        return zza(zzjzVar, true);
    }

    public static boolean zze(zzjz zzjzVar) {
        return zza(zzjzVar, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean zza(zzjz zzjzVar, boolean z) {
        boolean z2;
        boolean z3;
        long length = zzjzVar.getLength();
        int i = (int) ((length == -1 || length > 4096) ? 4096L : 4096L);
        zzpn zzpnVar = new zzpn(64);
        int i2 = 0;
        boolean z4 = false;
        while (i2 < i) {
            zzpnVar.reset(8);
            zzjzVar.zza(zzpnVar.data, 0, 8);
            long zzjb = zzpnVar.zzjb();
            int readInt = zzpnVar.readInt();
            int i3 = 16;
            if (zzjb == 1) {
                zzjzVar.zza(zzpnVar.data, 8, 8);
                zzpnVar.zzbk(16);
                zzjb = zzpnVar.zzjf();
            } else {
                i3 = 8;
            }
            long j = i3;
            if (zzjb < j) {
                return false;
            }
            i2 += i3;
            if (readInt != zzkw.zzaui) {
                if (readInt == zzkw.zzaur || readInt == zzkw.zzaut) {
                    z2 = true;
                    break;
                }
                if ((i2 + zzjb) - j >= i) {
                    break;
                }
                int i4 = (int) (zzjb - j);
                i2 += i4;
                if (readInt == zzkw.zzath) {
                    if (i4 < 8) {
                        return false;
                    }
                    zzpnVar.reset(i4);
                    zzjzVar.zza(zzpnVar.data, 0, i4);
                    int i5 = i4 / 4;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i5) {
                            break;
                        }
                        if (i6 == 1) {
                            zzpnVar.zzbm(4);
                        } else {
                            int readInt2 = zzpnVar.readInt();
                            if ((readInt2 >>> 8) != zzpt.zzbh("3gp")) {
                                for (int i7 : zzbam) {
                                    if (i7 != readInt2) {
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                    z4 = true;
                                    break;
                                }
                            }
                            z3 = true;
                            if (!z3) {
                            }
                        }
                        i6++;
                    }
                    if (!z4) {
                        return false;
                    }
                } else if (i4 != 0) {
                    zzjzVar.zzak(i4);
                }
            }
        }
        z2 = false;
        return z4 && z == z2;
    }
}
