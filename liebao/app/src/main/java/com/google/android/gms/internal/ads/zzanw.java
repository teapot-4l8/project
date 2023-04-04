package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzanw extends zzgw implements zzanu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final IObjectWrapper zzve() {
        Parcel zza = zza(1, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final boolean shouldDelegateInterscrollerEffect() {
        Parcel zza = zza(2, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }
}
