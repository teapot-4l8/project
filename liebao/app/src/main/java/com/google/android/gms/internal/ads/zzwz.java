package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwz extends zzgw implements zzwx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdClicked() {
        zzb(1, zzdp());
    }
}
