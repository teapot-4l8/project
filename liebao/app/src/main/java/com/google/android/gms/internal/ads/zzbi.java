package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zza(InputStream inputStream, int i, zzat zzatVar) {
        byte[] bArr;
        zzbh zzbhVar = new zzbh(zzatVar, i);
        try {
            bArr = zzatVar.zzf(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zzbhVar.write(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            zzao.v("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    zzatVar.zza(bArr);
                    zzbhVar.close();
                    throw th;
                }
            }
            byte[] byteArray = zzbhVar.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    zzao.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            zzatVar.zza(bArr);
            zzbhVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArr = null;
        }
    }

    private static void zza(String str, zzab<?> zzabVar, zzap zzapVar) {
        zzak zzj = zzabVar.zzj();
        int zzi = zzabVar.zzi();
        try {
            zzj.zza(zzapVar);
            zzabVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzi)));
        } catch (zzap e2) {
            zzabVar.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzi)));
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzab<?> zzabVar, IOException iOException, long j, zzbb zzbbVar, byte[] bArr) {
        if (iOException instanceof SocketTimeoutException) {
            zza("socket", zzabVar, new zzam());
        } else if (iOException instanceof MalformedURLException) {
            String valueOf = String.valueOf(zzabVar.getUrl());
            throw new RuntimeException(valueOf.length() != 0 ? "Bad URL ".concat(valueOf) : new String("Bad URL "), iOException);
        } else if (zzbbVar != null) {
            int statusCode = zzbbVar.getStatusCode();
            zzao.e("Unexpected response code %d for %s", Integer.valueOf(statusCode), zzabVar.getUrl());
            if (bArr != null) {
                zzz zzzVar = new zzz(statusCode, bArr, false, SystemClock.elapsedRealtime() - j, zzbbVar.zzq());
                if (statusCode == 401 || statusCode == 403) {
                    zza("auth", zzabVar, new zzl(zzzVar));
                    return;
                } else if (statusCode >= 400 && statusCode <= 499) {
                    throw new zzo(zzzVar);
                } else {
                    if (statusCode >= 500 && statusCode <= 599) {
                        throw new zzan(zzzVar);
                    }
                    throw new zzan(zzzVar);
                }
            }
            zza("network", zzabVar, new zzw());
        } else {
            throw new zzy(iOException);
        }
    }
}
