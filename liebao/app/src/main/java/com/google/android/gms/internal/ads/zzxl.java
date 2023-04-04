package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzxl extends zzgw implements zzxj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final zzxi zzrf() {
        zzxi zzxkVar;
        Parcel zza = zza(1, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzxkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzxi) {
                zzxkVar = (zzxi) queryLocalInterface;
            } else {
                zzxkVar = new zzxk(readStrongBinder);
            }
        }
        zza.recycle();
        return zzxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zzb(zzxc zzxcVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzxcVar);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzafs zzafsVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzafsVar);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzafx zzafxVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzafxVar);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(String str, zzagd zzagdVar, zzafy zzafyVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzagdVar);
        zzgx.zza(zzdp, zzafyVar);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzaei zzaeiVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaeiVar);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zzb(zzye zzyeVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzyeVar);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzagg zzaggVar, zzvt zzvtVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaggVar);
        zzgx.zza(zzdp, zzvtVar);
        zzb(8, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, publisherAdViewOptions);
        zzb(9, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzagl zzaglVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaglVar);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzajy zzajyVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzajyVar);
        zzb(13, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzakg zzakgVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzakgVar);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(AdManagerAdViewOptions adManagerAdViewOptions) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, adManagerAdViewOptions);
        zzb(15, zzdp);
    }
}
