package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaty extends zzgw implements zzatw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final zzats zza(zzatq zzatqVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzatqVar);
        Parcel zza = zza(1, zzdp);
        zzats zzatsVar = (zzats) zzgx.zza(zza, zzats.CREATOR);
        zza.recycle();
        return zzatsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(zzatq zzatqVar, zzaub zzaubVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzatqVar);
        zzgx.zza(zzdp, zzaubVar);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(zzauj zzaujVar, zzaud zzaudVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaujVar);
        zzgx.zza(zzdp, zzaudVar);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zzb(zzauj zzaujVar, zzaud zzaudVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaujVar);
        zzgx.zza(zzdp, zzaudVar);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zzc(zzauj zzaujVar, zzaud zzaudVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaujVar);
        zzgx.zza(zzdp, zzaudVar);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(String str, zzaud zzaudVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzaudVar);
        zzb(7, zzdp);
    }
}
