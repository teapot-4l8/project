package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzto {
    private final Context context;
    private final Object lock = new Object();
    private zztj zzbvm;
    private boolean zzbwg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzto(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<zztw> zzd(zzti zztiVar) {
        zztr zztrVar = new zztr(this);
        zztq zztqVar = new zztq(this, zztiVar, zztrVar);
        zztu zztuVar = new zztu(this, zztrVar);
        synchronized (this.lock) {
            zztj zztjVar = new zztj(this.context, com.google.android.gms.ads.internal.zzr.zzlj().zzaai(), zztqVar, zztuVar);
            this.zzbvm = zztjVar;
            zztjVar.checkAvailabilityAndConnect();
        }
        return zztrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbvm == null) {
                return;
            }
            this.zzbvm.disconnect();
            this.zzbvm = null;
            Binder.flushPendingCommands();
        }
    }
}
