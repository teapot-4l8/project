package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqn implements zzebi<ParcelFileDescriptor> {
    private final /* synthetic */ zzaud zzgsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcqn(zzcqb zzcqbVar, zzaud zzaudVar) {
        this.zzgsi = zzaudVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        try {
            this.zzgsi.zza(com.google.android.gms.ads.internal.util.zzaq.zzc(th));
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Service can't call client", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.zzgsi.zzb(parcelFileDescriptor);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Service can't call client", e2);
        }
    }
}
