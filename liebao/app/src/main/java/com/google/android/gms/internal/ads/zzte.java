package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzte implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzta zzbvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzte(zzta zztaVar) {
        this.zzbvr = zztaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        zztj zztjVar;
        Object obj2;
        obj = this.zzbvr.lock;
        synchronized (obj) {
            this.zzbvr.zzbvn = null;
            zztjVar = this.zzbvr.zzbvm;
            if (zztjVar != null) {
                this.zzbvr.zzbvm = null;
            }
            obj2 = this.zzbvr.lock;
            obj2.notifyAll();
        }
    }
}
