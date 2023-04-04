package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajq extends zzgw implements zzajo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void onInitializationSucceeded() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void onInitializationFailed(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(3, zzdp);
    }
}
