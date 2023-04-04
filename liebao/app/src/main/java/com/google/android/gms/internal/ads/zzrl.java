package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzrl extends zzxx {
    private final AppEventListener zzbtf;

    public zzrl(AppEventListener appEventListener) {
        this.zzbtf = appEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void onAppEvent(String str, String str2) {
        this.zzbtf.onAppEvent(str, str2);
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbtf;
    }
}
