package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztf implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzta zzbvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztf(zzta zztaVar) {
        this.zzbvr = zztaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        Object obj2;
        zztj zztjVar;
        zztj zztjVar2;
        obj = this.zzbvr.lock;
        synchronized (obj) {
            try {
                zztjVar = this.zzbvr.zzbvm;
                if (zztjVar != null) {
                    zzta zztaVar = this.zzbvr;
                    zztjVar2 = this.zzbvr.zzbvm;
                    zztaVar.zzbvn = zztjVar2.zznj();
                }
            } catch (DeadObjectException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Unable to obtain a cache service instance.", e2);
                this.zzbvr.disconnect();
            }
            obj2 = this.zzbvr.lock;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Object obj;
        Object obj2;
        obj = this.zzbvr.lock;
        synchronized (obj) {
            this.zzbvr.zzbvn = null;
            obj2 = this.zzbvr.lock;
            obj2.notifyAll();
        }
    }
}
