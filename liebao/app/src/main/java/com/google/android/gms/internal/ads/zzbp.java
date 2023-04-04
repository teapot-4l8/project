package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.bz;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbp {
    public static int zza(byte b2) {
        return b2 < 0 ? b2 + bz.f6480a : b2;
    }

    public static long zzf(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int zzg(ByteBuffer byteBuffer) {
        return (zza(byteBuffer.get()) << 8) + 0 + zza(byteBuffer.get());
    }

    public static long zzh(ByteBuffer byteBuffer) {
        long zzf = (zzf(byteBuffer) << 32) + 0;
        if (zzf < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return zzf + zzf(byteBuffer);
    }

    public static double zzi(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d2 = 0 | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << bz.n) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255);
        Double.isNaN(d2);
        return d2 / 65536.0d;
    }

    public static double zzj(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d2 = 0 | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << bz.n) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255);
        Double.isNaN(d2);
        return d2 / 1.073741824E9d;
    }

    public static String zzk(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }
}
