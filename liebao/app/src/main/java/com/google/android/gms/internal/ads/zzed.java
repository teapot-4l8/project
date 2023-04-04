package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzed implements Runnable {
    private final /* synthetic */ MotionEvent zzxt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzed(zzea zzeaVar, MotionEvent motionEvent) {
        this.zzxt = motionEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzduv zzduvVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxf;
            zzdsVar.zza(this.zzxt);
        } catch (Exception e2) {
            zzduvVar = zzea.zzxh;
            zzduvVar.zza(2022, -1L, e2);
        }
    }
}
