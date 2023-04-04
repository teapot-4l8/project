package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdop extends AdMetadataListener {
    private final /* synthetic */ zzxt zzhlv;
    private final /* synthetic */ zzdon zzhlw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdop(zzdon zzdonVar, zzxt zzxtVar) {
        this.zzhlw = zzdonVar;
        this.zzhlv = zzxtVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzcip zzcipVar;
        zzcipVar = this.zzhlw.zzhls;
        if (zzcipVar != null) {
            try {
                this.zzhlv.onAdMetadataChanged();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
