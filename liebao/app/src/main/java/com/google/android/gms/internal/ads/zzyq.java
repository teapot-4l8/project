package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzyq extends zzgw implements zzyo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void onAdMuted() {
        zzb(1, zzdp());
    }
}
