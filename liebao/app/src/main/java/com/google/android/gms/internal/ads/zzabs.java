package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzabs {
    public static boolean zzcp(String str) {
        return zze((String) zzww.zzra().zzd(zzabq.zzcwy), str);
    }

    private static boolean zze(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
