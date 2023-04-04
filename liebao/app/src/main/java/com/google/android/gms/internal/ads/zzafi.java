package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzafi extends zzgw implements zzafg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final IObjectWrapper zzts() {
        Parcel zza = zza(2, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final String getHeadline() {
        Parcel zza = zza(3, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final List getImages() {
        Parcel zza = zza(4, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final String getBody() {
        Parcel zza = zza(5, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final zzaes zztt() {
        zzaes zzaeuVar;
        Parcel zza = zza(6, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaeuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaes) {
                zzaeuVar = (zzaes) queryLocalInterface;
            } else {
                zzaeuVar = new zzaeu(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final String getCallToAction() {
        Parcel zza = zza(7, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final double getStarRating() {
        Parcel zza = zza(8, zzdp());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final String getStore() {
        Parcel zza = zza(9, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final String getPrice() {
        Parcel zza = zza(10, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final Bundle getExtras() {
        Parcel zza = zza(11, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final void destroy() {
        zzb(12, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final zzzd getVideoController() {
        Parcel zza = zza(13, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final void performClick(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final boolean recordImpression(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        Parcel zza = zza(15, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final void reportTouchEvent(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(16, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final zzaek zztu() {
        zzaek zzaemVar;
        Parcel zza = zza(17, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaemVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (queryLocalInterface instanceof zzaek) {
                zzaemVar = (zzaek) queryLocalInterface;
            } else {
                zzaemVar = new zzaem(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final IObjectWrapper zztv() {
        Parcel zza = zza(18, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(19, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
