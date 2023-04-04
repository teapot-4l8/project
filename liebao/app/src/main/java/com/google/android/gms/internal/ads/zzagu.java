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
public final class zzagu extends zzgw implements zzags {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getHeadline() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final List getImages() {
        Parcel zza = zza(3, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getBody() {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzaes zztt() {
        zzaes zzaeuVar;
        Parcel zza = zza(5, zzdp());
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

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getCallToAction() {
        Parcel zza = zza(6, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getAdvertiser() {
        Parcel zza = zza(7, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final double getStarRating() {
        Parcel zza = zza(8, zzdp());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getStore() {
        Parcel zza = zza(9, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getPrice() {
        Parcel zza = zza(10, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzzd getVideoController() {
        Parcel zza = zza(11, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(12, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void destroy() {
        zzb(13, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzaek zztu() {
        zzaek zzaemVar;
        Parcel zza = zza(14, zzdp());
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

    @Override // com.google.android.gms.internal.ads.zzags
    public final void performClick(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(15, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final boolean recordImpression(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        Parcel zza = zza(16, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void reportTouchEvent(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(17, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final IObjectWrapper zzts() {
        Parcel zza = zza(18, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final IObjectWrapper zztv() {
        Parcel zza = zza(19, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final Bundle getExtras() {
        Parcel zza = zza(20, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzagr zzagrVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzagrVar);
        zzb(21, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void cancelUnconfirmedClick() {
        zzb(22, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final List getMuteThisAdReasons() {
        Parcel zza = zza(23, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final boolean isCustomMuteThisAdEnabled() {
        Parcel zza = zza(24, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzys zzysVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzysVar);
        zzb(25, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzyo zzyoVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzyoVar);
        zzb(26, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zzud() {
        zzb(27, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void recordCustomClickGesture() {
        zzb(28, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzaer zzue() {
        zzaer zzaetVar;
        Parcel zza = zza(29, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaetVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            if (queryLocalInterface instanceof zzaer) {
                zzaetVar = (zzaer) queryLocalInterface;
            } else {
                zzaetVar = new zzaet(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaetVar;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final boolean isCustomClickGestureEnabled() {
        Parcel zza = zza(30, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzzc zzkm() {
        Parcel zza = zza(31, zzdp());
        zzzc zzj = zzzb.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzyx zzyxVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzyxVar);
        zzb(32, zzdp);
    }
}
