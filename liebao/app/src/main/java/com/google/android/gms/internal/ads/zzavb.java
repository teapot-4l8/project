package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavb extends zzavc {
    private final String type;
    private final int zzean;

    public zzavb(String str, int i) {
        this.type = str;
        this.zzean = i;
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final int getAmount() {
        return this.zzean;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzavb)) {
            zzavb zzavbVar = (zzavb) obj;
            if (Objects.equal(this.type, zzavbVar.type) && Objects.equal(Integer.valueOf(this.zzean), Integer.valueOf(zzavbVar.zzean))) {
                return true;
            }
        }
        return false;
    }
}
