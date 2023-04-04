package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavi extends zzgw implements zzavg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzavt zzavtVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzavtVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void show() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzavn zzavnVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzavnVar);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final boolean isLoaded() {
        Parcel zza = zza(5, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void pause() {
        zzb(6, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void resume() {
        zzb(7, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void destroy() {
        zzb(8, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzj(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(9, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzk(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzl(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(11, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final String getMediationAdapterClassName() {
        Parcel zza = zza(12, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setUserId(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(13, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzxt zzxtVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzxtVar);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final Bundle getAdMetadata() {
        Parcel zza = zza(15, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzave zzaveVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaveVar);
        zzb(16, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setAppPackageName(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(17, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzi(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(18, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setCustomData(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(19, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setImmersiveMode(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(34, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final boolean zzsc() {
        Parcel zza = zza(20, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final zzzc zzkm() {
        Parcel zza = zza(21, zzdp());
        zzzc zzj = zzzb.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }
}
