package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnp implements zzesa<View> {
    private final zzbnl zzfxk;

    public zzbnp(zzbnl zzbnlVar) {
        this.zzfxk = zzbnlVar;
    }

    public static View zzb(zzbnl zzbnlVar) {
        return (View) zzesg.zzbd(zzbnlVar.zzakl());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzb(this.zzfxk);
    }
}
