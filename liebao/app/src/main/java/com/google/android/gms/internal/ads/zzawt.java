package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawt implements RewardItem {
    private final zzawa zzeaz;

    public zzawt(zzawa zzawaVar) {
        this.zzeaz = zzawaVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzawa zzawaVar = this.zzeaz;
        if (zzawaVar == null) {
            return null;
        }
        try {
            return zzawaVar.getType();
        } catch (RemoteException e2) {
            zzbao.zzd("Could not forward getType to RewardItem", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzawa zzawaVar = this.zzeaz;
        if (zzawaVar == null) {
            return 0;
        }
        try {
            return zzawaVar.getAmount();
        } catch (RemoteException e2) {
            zzbao.zzd("Could not forward getAmount to RewardItem", e2);
            return 0;
        }
    }
}
