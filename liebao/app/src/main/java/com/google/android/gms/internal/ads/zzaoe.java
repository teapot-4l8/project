package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaoe extends zzgw implements zzaoc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getHeadline() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final List getImages() {
        Parcel zza = zza(3, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getBody() {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final zzaes zztw() {
        Parcel zza = zza(5, zzdp());
        zzaes zzo = zzaev.zzo(zza.readStrongBinder());
        zza.recycle();
        return zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getCallToAction() {
        Parcel zza = zza(6, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getAdvertiser() {
        Parcel zza = zza(7, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void recordImpression() {
        zzb(8, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzv(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(9, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final boolean getOverrideImpressionRecording() {
        Parcel zza = zza(11, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final boolean getOverrideClickHandling() {
        Parcel zza = zza(12, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final Bundle getExtras() {
        Parcel zza = zza(13, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzx(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final IObjectWrapper zzvr() {
        Parcel zza = zza(15, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final zzzd getVideoController() {
        Parcel zza = zza(16, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final zzaek zztu() {
        Parcel zza = zza(19, zzdp());
        zzaek zzm = zzaen.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final IObjectWrapper zzvs() {
        Parcel zza = zza(20, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final IObjectWrapper zztv() {
        Parcel zza = zza(21, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        zzgx.zza(zzdp, iObjectWrapper3);
        zzb(22, zzdp);
    }
}
