package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzee implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzxq;
    private final /* synthetic */ View zzxr;
    private final /* synthetic */ String zzxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzee(zzea zzeaVar, Context context, String str, View view, Activity activity) {
        this.zzxq = context;
        this.zzxu = str;
        this.zzxr = view;
        this.val$activity = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzduv zzduvVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxf;
            zzdsVar.zza(this.zzxq, this.zzxu, this.zzxr, this.val$activity);
        } catch (Exception e2) {
            zzduvVar = zzea.zzxh;
            zzduvVar.zza(2021, -1L, e2);
        }
    }
}
