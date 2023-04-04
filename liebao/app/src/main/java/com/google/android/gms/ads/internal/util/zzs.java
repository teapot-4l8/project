package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzs extends BroadcastReceiver {
    private final /* synthetic */ zzj zzegw;

    private zzs(zzj zzjVar) {
        this.zzegw = zzjVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            zzj.zza(this.zzegw, true);
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            zzj.zza(this.zzegw, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzs(zzj zzjVar, zzl zzlVar) {
        this(zzjVar);
    }
}
