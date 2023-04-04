package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfl extends BroadcastReceiver {
    private final /* synthetic */ zzfj zzaaw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfl(zzfj zzfjVar) {
        this.zzaaw = zzfjVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzaaw.zzcw();
    }
}
