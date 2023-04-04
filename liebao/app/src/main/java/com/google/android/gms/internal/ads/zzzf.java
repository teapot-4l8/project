package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzzf extends zzgw implements zzzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void play() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void pause() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void mute(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isMuted() {
        Parcel zza = zza(4, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final int getPlaybackState() {
        Parcel zza = zza(5, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getDuration() {
        Parcel zza = zza(6, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getCurrentTime() {
        Parcel zza = zza(7, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zza(zzzi zzziVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzziVar);
        zzb(8, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getAspectRatio() {
        Parcel zza = zza(9, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isCustomControlsEnabled() {
        Parcel zza = zza(10, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzzi zzrm() {
        zzzi zzzkVar;
        Parcel zza = zza(11, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzzkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            if (queryLocalInterface instanceof zzzi) {
                zzzkVar = (zzzi) queryLocalInterface;
            } else {
                zzzkVar = new zzzk(readStrongBinder);
            }
        }
        zza.recycle();
        return zzzkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isClickToExpandEnabled() {
        Parcel zza = zza(12, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void stop() {
        zzb(13, zzdp());
    }
}
