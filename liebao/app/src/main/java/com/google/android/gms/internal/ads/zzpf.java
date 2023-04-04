package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.just.agentweb.WebIndicator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpf {
    private static final byte[] zzbkd = {0, 0, 0, 1};
    private static final int[] zzbke = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, WebIndicator.MAX_UNIFORM_SPEED_DURATION, 7350};
    private static final int[] zzbkf = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzpo zzpoVar = new zzpo(bArr);
        int zza = zza(zzpoVar);
        int zzb = zzb(zzpoVar);
        int zzbo = zzpoVar.zzbo(4);
        if (zza == 5 || zza == 29) {
            zzb = zzb(zzpoVar);
            if (zza(zzpoVar) == 22) {
                zzbo = zzpoVar.zzbo(4);
            }
        }
        int i = zzbkf[zzbo];
        zzpg.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(zzb), Integer.valueOf(i));
    }

    public static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = zzbkd;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, zzbkd.length, i2);
        return bArr3;
    }

    private static int zza(zzpo zzpoVar) {
        int zzbo = zzpoVar.zzbo(5);
        return zzbo == 31 ? zzpoVar.zzbo(6) + 32 : zzbo;
    }

    private static int zzb(zzpo zzpoVar) {
        int zzbo = zzpoVar.zzbo(4);
        if (zzbo == 15) {
            return zzpoVar.zzbo(24);
        }
        zzpg.checkArgument(zzbo < 13);
        return zzbke[zzbo];
    }
}
