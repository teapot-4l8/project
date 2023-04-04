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
public final class zzafm extends zzgw implements zzafk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final IObjectWrapper zzts() {
        Parcel zza = zza(2, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getHeadline() {
        Parcel zza = zza(3, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final List getImages() {
        Parcel zza = zza(4, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getBody() {
        Parcel zza = zza(5, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final zzaes zztw() {
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

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getCallToAction() {
        Parcel zza = zza(7, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getAdvertiser() {
        Parcel zza = zza(8, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final Bundle getExtras() {
        Parcel zza = zza(9, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void destroy() {
        zzb(10, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final zzzd getVideoController() {
        Parcel zza = zza(11, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void performClick(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(12, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final boolean recordImpression(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        Parcel zza = zza(13, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void reportTouchEvent(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final zzaek zztu() {
        zzaek zzaemVar;
        Parcel zza = zza(15, zzdp());
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

    @Override // com.google.android.gms.internal.ads.zzafk
    public final IObjectWrapper zztv() {
        Parcel zza = zza(16, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(17, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
