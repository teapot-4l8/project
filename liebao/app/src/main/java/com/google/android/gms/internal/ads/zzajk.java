package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajk implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbbe zzbwi;
    private final /* synthetic */ zzajg zzdjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajk(zzajg zzajgVar, zzbbe zzbbeVar) {
        this.zzdjz = zzajgVar;
        this.zzbwi = zzbbeVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzaiz zzaizVar;
        try {
            zzbbe zzbbeVar = this.zzbwi;
            zzaizVar = this.zzdjz.zzdjx;
            zzbbeVar.set(zzaizVar.zzun());
        } catch (DeadObjectException e2) {
            this.zzbwi.setException(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbbe zzbbeVar = this.zzbwi;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbbeVar.setException(new RuntimeException(sb.toString()));
    }
}
