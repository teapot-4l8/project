package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzeg implements Runnable {
    private final /* synthetic */ int zzxv;
    private final /* synthetic */ int zzxw;
    private final /* synthetic */ int zzxx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeg(zzea zzeaVar, int i, int i2, int i3) {
        this.zzxv = i;
        this.zzxw = i2;
        this.zzxx = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzduv zzduvVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxf;
            zzdsVar.zza(MotionEvent.obtain(0L, this.zzxv, 0, this.zzxw, this.zzxx, 0));
        } catch (Exception e2) {
            zzduvVar = zzea.zzxh;
            zzduvVar.zza(2022, -1L, e2);
        }
    }
}
