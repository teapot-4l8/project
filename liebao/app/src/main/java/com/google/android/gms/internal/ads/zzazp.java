package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzazp implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbbe zzedv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazp(zzazm zzazmVar, Context context, zzbbe zzbbeVar) {
        this.val$context = context;
        this.zzedv = zzbbeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzedv.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            this.zzedv.setException(e2);
            zzbao.zzc("Exception while getting advertising Id info", e2);
        }
    }
}
