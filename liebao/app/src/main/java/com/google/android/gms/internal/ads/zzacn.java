package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzacn extends zzgw implements zzacl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final String zzsy() {
        Parcel zza = zza(1, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final String getContent() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzn(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void recordClick() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void recordImpression() {
        zzb(5, zzdp());
    }
}
