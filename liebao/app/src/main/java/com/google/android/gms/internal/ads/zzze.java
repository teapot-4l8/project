package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzze extends zzgw implements zzzc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(1, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String getResponseId() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final List<zzvx> getAdapterResponses() {
        Parcel zza = zza(3, zzdp());
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzvx.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }
}
