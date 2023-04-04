package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzgw;
import com.google.android.gms.internal.ads.zzgx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbi extends zzgw implements zzbg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final boolean zzd(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        Parcel zza = zza(1, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final void zzaq(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(2, zzdp);
    }
}
