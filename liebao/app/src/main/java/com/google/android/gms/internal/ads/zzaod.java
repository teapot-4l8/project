package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaod extends zzgw implements zzaob {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaod(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getHeadline() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final List getImages() {
        Parcel zza = zza(3, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getBody() {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaes zztt() {
        Parcel zza = zza(5, zzdp());
        zzaes zzo = zzaev.zzo(zza.readStrongBinder());
        zza.recycle();
        return zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getCallToAction() {
        Parcel zza = zza(6, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final double getStarRating() {
        Parcel zza = zza(7, zzdp());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getStore() {
        Parcel zza = zza(8, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getPrice() {
        Parcel zza = zza(9, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void recordImpression() {
        zzb(10, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzv(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(11, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(12, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean getOverrideImpressionRecording() {
        Parcel zza = zza(13, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean getOverrideClickHandling() {
        Parcel zza = zza(14, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final Bundle getExtras() {
        Parcel zza = zza(15, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzx(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(16, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzzd getVideoController() {
        Parcel zza = zza(17, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper zzvr() {
        Parcel zza = zza(18, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaek zztu() {
        Parcel zza = zza(19, zzdp());
        zzaek zzm = zzaen.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper zzvs() {
        Parcel zza = zza(20, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper zztv() {
        Parcel zza = zza(21, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        zzgx.zza(zzdp, iObjectWrapper3);
        zzb(22, zzdp);
    }
}
