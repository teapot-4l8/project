package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgu implements zzdhe<zzdhb<Bundle>> {
    private final boolean zzhgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgu(zzdmp zzdmpVar) {
        if (zzdmpVar != null) {
            this.zzhgf = true;
        } else {
            this.zzhgf = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhb<Bundle>> zzatu() {
        return zzebh.zzag(this.zzhgf ? zzdgt.zzhge : null);
    }
}
