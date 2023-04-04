package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfw extends zzgn {
    public zzfw(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 24);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final Void zzcz() {
        if (this.zzwh.isInitialized()) {
            return super.call();
        }
        if (this.zzwh.zzcl()) {
            zzda();
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        if (this.zzwh.zzcl()) {
            zzda();
            return;
        }
        synchronized (this.zzabg) {
            this.zzabg.zzak((String) this.zzabq.invoke(null, this.zzwh.getContext()));
        }
    }

    private final void zzda() {
        AdvertisingIdClient zzct = this.zzwh.zzct();
        if (zzct == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzct.getInfo();
            String zzaq = zzfh.zzaq(info.getId());
            if (zzaq != null) {
                synchronized (this.zzabg) {
                    this.zzabg.zzak(zzaq);
                    this.zzabg.zzb(info.isLimitAdTrackingEnabled());
                    this.zzabg.zzb(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgn, java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return call();
    }
}
