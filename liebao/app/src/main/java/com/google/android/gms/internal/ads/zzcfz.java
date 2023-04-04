package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfz implements zzdxw<zzz, Bitmap> {
    private final /* synthetic */ double zzgju;
    private final /* synthetic */ boolean zzgjv;
    private final /* synthetic */ zzcfw zzgjw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfz(zzcfw zzcfwVar, double d2, boolean z) {
        this.zzgjw = zzcfwVar;
        this.zzgju = d2;
        this.zzgjv = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdxw
    public final /* synthetic */ Bitmap apply(zzz zzzVar) {
        Bitmap zza;
        zza = this.zzgjw.zza(zzzVar.data, this.zzgju, this.zzgjv);
        return zza;
    }
}
