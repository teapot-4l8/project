package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajj implements zzear<zzaje, ParcelFileDescriptor> {
    private final /* synthetic */ zzaiy zzdjy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajj(zzajg zzajgVar, zzaiy zzaiyVar) {
        this.zzdjy = zzaiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final /* synthetic */ zzebt<ParcelFileDescriptor> zzf(zzaje zzajeVar) {
        zzbbe zzbbeVar = new zzbbe();
        zzajeVar.zza(this.zzdjy, new zzaji(this, zzbbeVar));
        return zzbbeVar;
    }
}
