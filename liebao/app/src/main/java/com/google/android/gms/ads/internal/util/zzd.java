package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.ads.zzadm;
import com.google.android.gms.internal.ads.zzbao;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzd extends zzbao {
    public static void zzed(String str) {
        if (zzyz()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzyz()) {
            Log.v(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzyz() {
        return isLoggable(2) && zzadm.zzdfe.get().booleanValue();
    }
}
