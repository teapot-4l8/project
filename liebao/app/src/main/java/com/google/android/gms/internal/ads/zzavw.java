package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavw extends zzgw implements zzavu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzag(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeInt(i);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzah(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzai(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzak(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zza(IObjectWrapper iObjectWrapper, zzavy zzavyVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, zzavyVar);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzal(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(8, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeInt(i);
        zzb(9, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzam(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzan(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(11, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzb(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(12, zzdp);
    }
}
