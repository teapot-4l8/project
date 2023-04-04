package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzyy extends zzgw implements zzyw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final void onAdMetadataChanged() {
        zzb(1, zzdp());
    }
}
