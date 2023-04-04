package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxb extends zzawd {
    private final String type;
    private final int zzean;

    public zzaxb(zzavy zzavyVar) {
        this(zzavyVar != null ? zzavyVar.type : "", zzavyVar != null ? zzavyVar.zzean : 1);
    }

    public zzaxb(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzaxb(String str, int i) {
        this.type = str;
        this.zzean = i;
    }

    @Override // com.google.android.gms.internal.ads.zzawa
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzawa
    public final int getAmount() {
        return this.zzean;
    }
}
