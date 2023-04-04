package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaoj extends zzgw implements zzaoh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getHeadline() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final List getImages() {
        Parcel zza = zza(3, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getBody() {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final zzaes zztt() {
        Parcel zza = zza(5, zzdp());
        zzaes zzo = zzaev.zzo(zza.readStrongBinder());
        zza.recycle();
        return zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getCallToAction() {
        Parcel zza = zza(6, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getAdvertiser() {
        Parcel zza = zza(7, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final double getStarRating() {
        Parcel zza = zza(8, zzdp());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getStore() {
        Parcel zza = zza(9, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getPrice() {
        Parcel zza = zza(10, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final zzzd getVideoController() {
        Parcel zza = zza(11, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final zzaek zztu() {
        Parcel zza = zza(12, zzdp());
        zzaek zzm = zzaen.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final IObjectWrapper zzvr() {
        Parcel zza = zza(13, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final IObjectWrapper zzvs() {
        Parcel zza = zza(14, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final IObjectWrapper zztv() {
        Parcel zza = zza(15, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final Bundle getExtras() {
        Parcel zza = zza(16, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final boolean getOverrideImpressionRecording() {
        Parcel zza = zza(17, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final boolean getOverrideClickHandling() {
        Parcel zza = zza(18, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void recordImpression() {
        zzb(19, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void zzv(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(20, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        zzgx.zza(zzdp, iObjectWrapper3);
        zzb(21, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void zzx(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(22, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final float getMediaContentAspectRatio() {
        Parcel zza = zza(23, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final float getVideoDuration() {
        Parcel zza = zza(24, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final float getVideoCurrentTime() {
        Parcel zza = zza(25, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }
}
