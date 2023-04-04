package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzub;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclc implements zzesa<zzcln> {
    public static zzclc zzarb() {
        zzclc zzclcVar;
        zzclcVar = zzclf.zzgnm;
        return zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzcln) zzesg.zzbd(new zzcln(zzub.zza.zzb.REQUEST_WILL_UPDATE_GMS_SIGNALS, zzub.zza.zzb.REQUEST_DID_UPDATE_GMS_SIGNALS, zzub.zza.zzb.REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS));
    }
}
