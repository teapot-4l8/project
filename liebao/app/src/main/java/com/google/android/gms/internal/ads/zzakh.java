package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzakh extends zzgw implements zzakf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzakf
    public final void zzuo() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzakf
    public final void zzdd(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(2, zzdp);
    }
}
