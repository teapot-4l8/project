package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzhn extends Handler {
    private final /* synthetic */ zzhk zzagr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhn(zzhk zzhkVar, Looper looper) {
        super(looper);
        this.zzagr = zzhkVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zzagr.zza(message);
    }
}
