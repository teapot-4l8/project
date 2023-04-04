package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqc extends zzgw implements zzaqa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvt zzvtVar, zzaqf zzaqfVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzgx.zza(zzdp, bundle);
        zzgx.zza(zzdp, bundle2);
        zzgx.zza(zzdp, zzvtVar);
        zzgx.zza(zzdp, zzaqfVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzaqr zzvm() {
        Parcel zza = zza(2, zzdp());
        zzaqr zzaqrVar = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzaqr zzvn() {
        Parcel zza = zza(3, zzdp());
        zzaqr zzaqrVar = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzzd getVideoController() {
        Parcel zza = zza(5, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzz(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String[] strArr, Bundle[] bundleArr) {
        Parcel zzdp = zzdp();
        zzdp.writeStringArray(strArr);
        zzdp.writeTypedArray(bundleArr, 0);
        zzb(11, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapo zzapoVar, zzant zzantVar, zzvt zzvtVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzapoVar);
        zzgx.zza(zzdp, zzantVar);
        zzgx.zza(zzdp, zzvtVar);
        zzb(13, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapt zzaptVar, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzaptVar);
        zzgx.zza(zzdp, zzantVar);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final boolean zzaa(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(15, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapz zzapzVar, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzapzVar);
        zzgx.zza(zzdp, zzantVar);
        zzb(16, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final boolean zzab(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(17, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapu zzapuVar, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzapuVar);
        zzgx.zza(zzdp, zzantVar);
        zzb(18, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzdn(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(19, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzb(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapz zzapzVar, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzapzVar);
        zzgx.zza(zzdp, zzantVar);
        zzb(20, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzb(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapo zzapoVar, zzant zzantVar, zzvt zzvtVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzapoVar);
        zzgx.zza(zzdp, zzantVar);
        zzgx.zza(zzdp, zzvtVar);
        zzb(21, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapu zzapuVar, zzant zzantVar, zzaei zzaeiVar) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzvqVar);
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzapuVar);
        zzgx.zza(zzdp, zzantVar);
        zzgx.zza(zzdp, zzaeiVar);
        zzb(22, zzdp);
    }
}
