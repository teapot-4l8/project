package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajn implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbbe zzbwi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajn(zzajg zzajgVar, zzbbe zzbbeVar) {
        this.zzbwi = zzbbeVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbwi.setException(new RuntimeException("Connection failed."));
    }
}
