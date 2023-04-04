package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqu extends BroadcastReceiver {
    private final /* synthetic */ zzqs zzbsc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqu(zzqs zzqsVar) {
        this.zzbsc = zzqsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzbsc.zzbu(3);
    }
}
