package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdok extends AdMetadataListener {
    private final /* synthetic */ zzdoh zzhlt;
    private final /* synthetic */ zzyw zzhlu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdok(zzdoh zzdohVar, zzyw zzywVar) {
        this.zzhlt = zzdohVar;
        this.zzhlu = zzywVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzcip zzcipVar;
        zzcipVar = this.zzhlt.zzhls;
        if (zzcipVar != null) {
            try {
                this.zzhlu.onAdMetadataChanged();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
