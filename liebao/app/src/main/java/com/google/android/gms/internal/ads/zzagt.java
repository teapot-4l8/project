package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzagt extends zzgw implements zzagr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void onUnconfirmedClickReceived(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void onUnconfirmedClickCancelled() {
        zzb(2, zzdp());
    }
}
