package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdaj implements zzve {
    private zzwx zzhbg;

    public final synchronized void zzb(zzwx zzwxVar) {
        this.zzhbg = zzwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final synchronized void onAdClicked() {
        if (this.zzhbg != null) {
            try {
                this.zzhbg.onAdClicked();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Remote Exception at onAdClicked.", e2);
            }
        }
    }
}
