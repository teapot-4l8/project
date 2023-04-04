package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzsx extends zzgw implements zzsv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void onAppOpenAdClosed() {
        zzb(1, zzdp());
    }
}
