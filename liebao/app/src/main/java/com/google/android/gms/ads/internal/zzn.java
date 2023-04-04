package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzei;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzn implements View.OnTouchListener {
    private final /* synthetic */ zzl zzbqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzl zzlVar) {
        this.zzbqf = zzlVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzei zzeiVar;
        zzei zzeiVar2;
        zzeiVar = this.zzbqf.zzbqd;
        if (zzeiVar != null) {
            zzeiVar2 = this.zzbqf.zzbqd;
            zzeiVar2.zza(motionEvent);
            return false;
        }
        return false;
    }
}
