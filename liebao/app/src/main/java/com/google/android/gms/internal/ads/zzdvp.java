package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdvp implements zzdvr {
    private static final zzcf.zza zzhwh = zzcf.zza.zzaq();

    @Override // com.google.android.gms.internal.ads.zzdvr
    public final zzcf.zza zzco(Context context) {
        zzcf.zza.zzb zzap = zzcf.zza.zzap();
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        advertisingIdClient.start();
        AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
        String id = info.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zzap.zzak(id);
            zzap.zzb(info.isLimitAdTrackingEnabled());
            zzap.zzb(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
        }
        return (zzcf.zza) ((zzena) zzap.zzbjv());
    }

    @Override // com.google.android.gms.internal.ads.zzdvr
    public final zzcf.zza zzayy() {
        return zzhwh;
    }
}
