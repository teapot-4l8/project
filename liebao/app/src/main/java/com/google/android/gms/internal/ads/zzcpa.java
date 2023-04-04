package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpa extends zzauc {
    private final /* synthetic */ zzcpb zzgrd;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcpa(zzcpb zzcpbVar) {
        this.zzgrd = zzcpbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgrd.zzdml.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void zza(com.google.android.gms.ads.internal.util.zzaq zzaqVar) {
        this.zzgrd.zzdml.setException(new com.google.android.gms.ads.internal.util.zzap(zzaqVar.zzacu, zzaqVar.errorCode));
    }
}
