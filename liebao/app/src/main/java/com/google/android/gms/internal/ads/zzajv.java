package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajv extends zzgw implements zzajt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajt
    public final void zze(List<zzajm> list) {
        Parcel zzdp = zzdp();
        zzdp.writeTypedList(list);
        zzb(1, zzdp);
    }
}
