package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzda {
    private static boolean zznx = false;
    private static MessageDigest zzny;
    private static final Object zznz = new Object();
    private static final Object zzoa = new Object();
    static CountDownLatch zzob = new CountDownLatch(1);

    public static void zzbp() {
        synchronized (zzoa) {
            if (!zznx) {
                zznx = true;
                new Thread(new zzdc()).start();
            }
        }
    }

    private static MessageDigest zzbq() {
        boolean z;
        MessageDigest messageDigest;
        zzbp();
        try {
            z = zzob.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = zzny) != null) {
            return messageDigest;
        }
        return null;
    }

    public static String zzj(zzcf.zza zzaVar, String str) {
        byte[] zza;
        byte[] byteArray = zzaVar.toByteArray();
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcta)).booleanValue()) {
            if (zzff.zzzu == null) {
                throw new GeneralSecurityException();
            }
            zza = ((zzcf.zzf) ((zzena) zzcf.zzf.zzbm().zzi(zzelq.zzt(zzff.zzzu.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zza(zzcm.TINK_HYBRID).zzbjv())).toByteArray();
        } else {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                zza = zza(zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzcf.zzf.zza zzbm = zzcf.zzf.zzbm();
                Iterator<byte[]> it = zza2.iterator();
                while (it.hasNext()) {
                    zzbm.zzi(zzelq.zzt(zza(it.next(), str, false)));
                }
                zzbm.zzj(zzelq.zzt(zzb(byteArray)));
                zza = ((zzcf.zzf) ((zzena) zzbm.zzbjv())).toByteArray();
            }
        }
        return zzcy.zza(zza, true);
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static zzcf.zza zza(zzcf.zza.zzd zzdVar) {
        zzcf.zza.zzb zzap = zzcf.zza.zzap();
        zzap.zzau(zzdVar.zzv());
        return (zzcf.zza) ((zzena) zzap.zzbjv());
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) {
        byte[] array;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzdd zzddVar : new zzdb().zzvp) {
            zzddVar.zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeld(str.getBytes("UTF-8")).zzs(bArr3);
        }
        return bArr3;
    }

    public static byte[] zzb(byte[] bArr) {
        byte[] digest;
        synchronized (zznz) {
            MessageDigest zzbq = zzbq();
            if (zzbq == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzbq.reset();
            zzbq.update(bArr);
            digest = zzny.digest();
        }
        return digest;
    }
}
