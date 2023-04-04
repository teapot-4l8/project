package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzvz extends zzxx {
    private final AppEventListener zzboo;

    public zzvz(AppEventListener appEventListener) {
        this.zzboo = appEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void onAppEvent(String str, String str2) {
        this.zzboo.onAppEvent(str, str2);
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboo;
    }
}
