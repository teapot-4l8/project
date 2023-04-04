package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqa {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        com.google.android.gms.ads.internal.util.zzd.zzey(sb.toString());
        com.google.android.gms.ads.internal.util.zzd.zza(str, th);
        if (i == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkz().zzb(th, str);
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.util.zzd.zzey("This request is sent from a test device.");
            return;
        }
        zzww.zzqw();
        String zzbp = zzbae.zzbp(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzbp).length() + 102);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(zzbp);
        sb.append("\")) to get test ads on this device.");
        com.google.android.gms.ads.internal.util.zzd.zzey(sb.toString());
    }
}
