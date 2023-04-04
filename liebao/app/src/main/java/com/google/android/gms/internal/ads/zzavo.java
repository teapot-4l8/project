package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavo implements RewardItem {
    private final zzavd zzeao;

    public zzavo(zzavd zzavdVar) {
        this.zzeao = zzavdVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        zzavd zzavdVar = this.zzeao;
        if (zzavdVar == null) {
            return null;
        }
        try {
            return zzavdVar.getType();
        } catch (RemoteException e2) {
            zzbao.zzd("Could not forward getType to RewardItem", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        zzavd zzavdVar = this.zzeao;
        if (zzavdVar == null) {
            return 0;
        }
        try {
            return zzavdVar.getAmount();
        } catch (RemoteException e2) {
            zzbao.zzd("Could not forward getAmount to RewardItem", e2);
            return 0;
        }
    }
}
