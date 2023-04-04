package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbai;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zze extends zza {
    private Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(Context context) {
        this.context = context;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwp() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.context);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzd.zzc("Fail to get isAdIdFakeForDebugLogging", e2);
            z = false;
        }
        zzbai.zzav(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzd.zzez(sb.toString());
    }
}
