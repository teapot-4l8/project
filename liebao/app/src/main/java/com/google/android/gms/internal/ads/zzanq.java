package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzanq extends zzgw implements zzano {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzantVar);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final IObjectWrapper zzve() {
        Parcel zza = zza(2, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzantVar);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void showInterstitial() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void destroy() {
        zzb(5, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzantVar);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzantVar);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void pause() {
        zzb(8, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void resume() {
        zzb(9, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzavu zzavuVar, String str2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzavuVar);
        zzdp.writeString(str2);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(zzvq zzvqVar, String str) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzb(11, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void showVideo() {
        zzb(12, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean isInitialized() {
        Parcel zza = zza(13, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar, zzaei zzaeiVar, List<String> list) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzantVar);
        zzgx.zza(zzdp, zzaeiVar);
        zzdp.writeStringList(list);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaob zzvf() {
        zzaob zzaodVar;
        Parcel zza = zza(15, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaodVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (queryLocalInterface instanceof zzaob) {
                zzaodVar = (zzaob) queryLocalInterface;
            } else {
                zzaodVar = new zzaod(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaoc zzvg() {
        zzaoc zzaoeVar;
        Parcel zza = zza(16, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaoeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (queryLocalInterface instanceof zzaoc) {
                zzaoeVar = (zzaoc) queryLocalInterface;
            } else {
                zzaoeVar = new zzaoe(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaoeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle zzvh() {
        Parcel zza = zza(17, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle getInterstitialAdapterInfo() {
        Parcel zza = zza(18, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle zzvi() {
        Parcel zza = zza(19, zzdp());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(zzvq zzvqVar, String str, String str2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(20, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzs(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(21, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean zzvj() {
        Parcel zza = zza(22, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzavu zzavuVar, List<String> list) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzavuVar);
        zzdp.writeStringList(list);
        zzb(23, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzafo zzvk() {
        Parcel zza = zza(24, zzdp());
        zzafo zzr = zzafr.zzr(zza.readStrongBinder());
        zza.recycle();
        return zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void setImmersiveMode(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(25, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzzd getVideoController() {
        Parcel zza = zza(26, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaoh zzvl() {
        zzaoh zzaojVar;
        Parcel zza = zza(27, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaojVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (queryLocalInterface instanceof zzaoh) {
                zzaojVar = (zzaoh) queryLocalInterface;
            } else {
                zzaojVar = new zzaoj(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaojVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzb(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzantVar);
        zzb(28, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzt(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(30, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajoVar, List<zzajw> list) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzajoVar);
        zzdp.writeTypedList(list);
        zzb(31, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzc(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzgx.zza(zzdp, zzantVar);
        zzb(32, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaqr zzvm() {
        Parcel zza = zza(33, zzdp());
        zzaqr zzaqrVar = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaqr zzvn() {
        Parcel zza = zza(34, zzdp());
        zzaqr zzaqrVar = (zzaqr) zzgx.zza(zza, zzaqr.CREATOR);
        zza.recycle();
        return zzaqrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzb(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzvtVar);
        zzgx.zza(zzdp, zzvqVar);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, zzantVar);
        zzb(35, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzanu zzvo() {
        zzanu zzanwVar;
        Parcel zza = zza(36, zzdp());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzanwVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            if (queryLocalInterface instanceof zzanu) {
                zzanwVar = (zzanu) queryLocalInterface;
            } else {
                zzanwVar = new zzanw(readStrongBinder);
            }
        }
        zza.recycle();
        return zzanwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(37, zzdp);
    }
}
