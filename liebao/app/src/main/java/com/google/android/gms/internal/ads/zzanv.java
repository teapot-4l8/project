package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzanv extends zzgw implements zzant {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdClicked() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdClosed() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdFailedToLoad(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdLeftApplication() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdOpened() {
        zzb(5, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdLoaded() {
        zzb(6, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzanz zzanzVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzanzVar);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAdImpression() {
        zzb(8, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onAppEvent(String str, String str2) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(9, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzafo zzafoVar, String str) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzafoVar);
        zzdp.writeString(str);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoEnd() {
        zzb(11, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzdj(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(12, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzvp() {
        zzb(13, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(zzavy zzavyVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzavyVar);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoPause() {
        zzb(15, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzawa zzawaVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzawaVar);
        zzb(16, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzde(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(17, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzvq() {
        zzb(18, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(19, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void onVideoPlay() {
        zzb(20, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzdk(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(21, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc(int i, String str) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzdp.writeString(str);
        zzb(22, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(23, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzf(zzvh zzvhVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvhVar);
        zzb(24, zzdp);
    }
}
