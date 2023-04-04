package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbas implements zzbaf {
    private final String zzbjd;

    public zzbas() {
        this(null);
    }

    public zzbas(String str) {
        this.zzbjd = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbaf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzen(String str) {
        try {
            try {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag(263);
                }
                String valueOf = String.valueOf(str);
                zzbao.zzdz(valueOf.length() != 0 ? "Pinging URL: ".concat(valueOf) : new String("Pinging URL: "));
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    zzww.zzqw();
                    zzbae.zza(true, httpURLConnection, this.zzbjd);
                    zzbai zzbaiVar = new zzbai();
                    zzbaiVar.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzbaiVar.zza(httpURLConnection, responseCode);
                    if (responseCode < 200 || responseCode >= 300) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                        sb.append("Received non-success response code ");
                        sb.append(responseCode);
                        sb.append(" from pinging URL: ");
                        sb.append(str);
                        zzbao.zzez(sb.toString());
                    }
                    if (ClientLibraryUtils.isPackageSide()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e2) {
                e = e2;
                String message = e.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
                sb2.append("Error while pinging URL: ");
                sb2.append(str);
                sb2.append(". ");
                sb2.append(message);
                zzbao.zzez(sb2.toString());
                if (ClientLibraryUtils.isPackageSide()) {
                    return;
                }
                TrafficStats.clearThreadStatsTag();
            } catch (IndexOutOfBoundsException e3) {
                String message2 = e3.getMessage();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length());
                sb3.append("Error while parsing ping URL: ");
                sb3.append(str);
                sb3.append(". ");
                sb3.append(message2);
                zzbao.zzez(sb3.toString());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (RuntimeException e4) {
                e = e4;
                String message3 = e.getMessage();
                StringBuilder sb22 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
                sb22.append("Error while pinging URL: ");
                sb22.append(str);
                sb22.append(". ");
                sb22.append(message3);
                zzbao.zzez(sb22.toString());
                if (ClientLibraryUtils.isPackageSide()) {
                }
            }
        } catch (Throwable th) {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th;
        }
    }
}
