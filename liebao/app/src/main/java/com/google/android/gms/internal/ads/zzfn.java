package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfn extends zzgn {
    public zzfn(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        this.zzabg.zzg(zzcq.ENUM_FAILURE);
        try {
            this.zzabg.zzg(((Boolean) this.zzabq.invoke(null, this.zzwh.getContext())).booleanValue() ? zzcq.ENUM_TRUE : zzcq.ENUM_FALSE);
        } catch (InvocationTargetException e2) {
            if (!(e2.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e2;
            }
        }
    }
}
