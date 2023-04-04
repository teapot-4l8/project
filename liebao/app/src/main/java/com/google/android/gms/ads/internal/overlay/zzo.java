package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzo {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzduk == 4 && adOverlayInfoParcel.zzduf == null) {
            if (adOverlayInfoParcel.zzchr != null) {
                adOverlayInfoParcel.zzchr.onAdClicked();
            }
            com.google.android.gms.ads.internal.zzr.zzkt();
            if (adOverlayInfoParcel.zzdue.zzdsy) {
                context = adOverlayInfoParcel.zzdkm.zzabx();
            }
            zza.zza(context, adOverlayInfoParcel.zzdue, adOverlayInfoParcel.zzduj, adOverlayInfoParcel.zzdue.zzdjj);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzbpx.zzekc);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.google.android.gms.ads.internal.zzr.zzkv();
        com.google.android.gms.ads.internal.util.zzj.zza(context, intent);
    }
}
