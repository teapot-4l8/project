package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbfl implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzaxo zzetp;
    private final /* synthetic */ zzbfh zzetq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfl(zzbfh zzbfhVar, zzaxo zzaxoVar) {
        this.zzetq = zzbfhVar;
        this.zzetp = zzaxoVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzetq.zza(view, this.zzetp, 10);
    }
}
