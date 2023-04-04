package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbfm implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzaxo zzetp;
    private final /* synthetic */ zzbfh zzetq;
    private final /* synthetic */ int zzetr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfm(zzbfh zzbfhVar, View view, zzaxo zzaxoVar, int i) {
        this.zzetq = zzbfhVar;
        this.val$view = view;
        this.zzetp = zzaxoVar;
        this.zzetr = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzetq.zza(this.val$view, this.zzetp, this.zzetr - 1);
    }
}
