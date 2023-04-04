package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfq implements zzdhb<Bundle> {
    private final String zzhfi;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    public zzdfq(String str) {
        this.zzhfi = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        zzdpw.zza(bundle, "omid_v", this.zzhfi);
    }
}
