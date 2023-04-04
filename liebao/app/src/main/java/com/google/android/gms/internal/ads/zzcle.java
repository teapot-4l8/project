package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzub;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcle implements zzesa<zzcln> {
    public static zzcle zzard() {
        zzcle zzcleVar;
        zzcleVar = zzclh.zzgnn;
        return zzcleVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzcln) zzesg.zzbd(new zzcln(zzub.zza.zzb.REQUEST_WILL_MAKE_NETWORK_REQUEST, zzub.zza.zzb.REQUEST_DID_RECEIVE_NETWORK_RESPONSE, zzub.zza.zzb.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST));
    }
}
