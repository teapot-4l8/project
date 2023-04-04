package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzge extends zzgn {
    public zzge(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        try {
            this.zzabg.zzi(((Boolean) this.zzabq.invoke(null, this.zzwh.getContext())).booleanValue() ? zzcq.ENUM_TRUE : zzcq.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zzabg.zzi(zzcq.ENUM_FAILURE);
        }
    }
}
