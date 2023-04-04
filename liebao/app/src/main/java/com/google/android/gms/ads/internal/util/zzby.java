package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzby extends BroadcastReceiver {
    private final /* synthetic */ zzbv zzejh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzby(zzbv zzbvVar) {
        this.zzejh = zzbvVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzejh.zzc(context, intent);
    }
}
