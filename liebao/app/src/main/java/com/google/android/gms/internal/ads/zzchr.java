package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzchr implements zzaeg {
    private final /* synthetic */ zzcho zzglf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchr(zzcho zzchoVar) {
        this.zzglf = zzchoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final JSONObject zztq() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zztp() {
        zzcdf zzcdfVar;
        zzcdf zzcdfVar2;
        zzcdfVar = this.zzglf.zzghx;
        if (zzcdfVar != null) {
            zzcdfVar2 = this.zzglf.zzghx;
            zzcdfVar2.zzfx("_videoMediaView");
        }
    }
}
