package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzeb implements Runnable {
    private final /* synthetic */ Context zzxq;
    private final /* synthetic */ View zzxr;
    private final /* synthetic */ Activity zzxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeb(zzea zzeaVar, Context context, View view, Activity activity) {
        this.zzxq = context;
        this.zzxr = view;
        this.zzxs = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzduv zzduvVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxf;
            zzdsVar.zza(this.zzxq, this.zzxr, this.zzxs);
        } catch (Exception e2) {
            zzduvVar = zzea.zzxh;
            zzduvVar.zza(2020, -1L, e2);
        }
    }
}
