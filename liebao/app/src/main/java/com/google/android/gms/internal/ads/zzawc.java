package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawc extends zzgw implements zzawa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzawa
    public final String getType() {
        Parcel zza = zza(1, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzawa
    public final int getAmount() {
        Parcel zza = zza(2, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
