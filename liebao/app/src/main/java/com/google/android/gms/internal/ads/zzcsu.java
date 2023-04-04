package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcsu extends TimerTask {
    private final /* synthetic */ AlertDialog zzgvb;
    private final /* synthetic */ Timer zzgvc;
    private final /* synthetic */ com.google.android.gms.ads.internal.overlay.zze zzgvd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsu(AlertDialog alertDialog, Timer timer, com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzgvb = alertDialog;
        this.zzgvc = timer;
        this.zzgvd = zzeVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzgvb.dismiss();
        this.zzgvc.cancel();
        com.google.android.gms.ads.internal.overlay.zze zzeVar = this.zzgvd;
        if (zzeVar != null) {
            zzeVar.close();
        }
    }
}
