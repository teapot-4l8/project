package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdvo implements zzdvr {
    private static final zzcf.zza zzhwh = (zzcf.zza) ((zzena) zzcf.zza.zzap().zzae("E").zzbjv());

    @Override // com.google.android.gms.internal.ads.zzdvr
    public final zzcf.zza zzco(Context context) {
        return zzdvf.zzj(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    @Override // com.google.android.gms.internal.ads.zzdvr
    public final zzcf.zza zzayy() {
        return zzhwh;
    }
}
