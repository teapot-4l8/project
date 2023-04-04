package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaji extends zzajf {
    private final /* synthetic */ zzbbe zzbwi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaji(zzajj zzajjVar, zzbbe zzbbeVar) {
        this.zzbwi = zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajc
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbwi.set(parcelFileDescriptor);
    }
}
