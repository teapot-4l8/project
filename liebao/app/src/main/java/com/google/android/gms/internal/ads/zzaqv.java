package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaqv implements Runnable {
    private final /* synthetic */ zzaqt zzdqi;
    private final /* synthetic */ AdOverlayInfoParcel zzdqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqv(zzaqt zzaqtVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdqi = zzaqtVar;
        this.zzdqq = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        com.google.android.gms.ads.internal.zzr.zzku();
        activity = this.zzdqi.zzdqj;
        com.google.android.gms.ads.internal.overlay.zzo.zza(activity, this.zzdqq, true);
    }
}