package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzrt implements Runnable {
    private final /* synthetic */ zzrq zzbuh;
    private final /* synthetic */ View zzbui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrt(zzrq zzrqVar, View view) {
        this.zzbuh = zzrqVar;
        this.zzbui = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbuh.zzj(this.zzbui);
    }
}
