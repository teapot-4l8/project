package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzur;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzz extends zzaa {
    @Override // com.google.android.gms.ads.internal.util.zzr
    public final zzur zza(Context context, TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (zzj.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzur.ENUM_TRUE : zzur.ENUM_FALSE;
        }
        return zzur.ENUM_FALSE;
    }
}
