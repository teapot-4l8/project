package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzxk extends zzgw implements zzxi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzvq zzvqVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final boolean isLoading() {
        Parcel zza = zza(3, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final String zzkl() {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzvq zzvqVar, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeInt(i);
        zzb(5, zzdp);
    }
}
