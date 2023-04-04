package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztu implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbbe zzbwi;
    private final /* synthetic */ zzto zzbwj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztu(zzto zztoVar, zzbbe zzbbeVar) {
        this.zzbwj = zztoVar;
        this.zzbwi = zzbbeVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        obj = this.zzbwj.lock;
        synchronized (obj) {
            this.zzbwi.setException(new RuntimeException("Connection failed."));
        }
    }
}
