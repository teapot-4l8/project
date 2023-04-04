package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaet extends zzgw implements zzaer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final float getAspectRatio() {
        Parcel zza = zza(2, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzo(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final IObjectWrapper zztr() {
        Parcel zza = zza(4, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final float getDuration() {
        Parcel zza = zza(5, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final float getCurrentTime() {
        Parcel zza = zza(6, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final zzzd getVideoController() {
        Parcel zza = zza(7, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final boolean hasVideoContent() {
        Parcel zza = zza(8, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zza(zzage zzageVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzageVar);
        zzb(9, zzdp);
    }
}
