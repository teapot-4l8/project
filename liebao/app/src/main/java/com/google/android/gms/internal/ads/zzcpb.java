package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzcpb implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected zzauj zzgrg;
    protected zzatr zzgrh;
    protected final zzbbe<InputStream> zzdml = new zzbbe<>();
    protected final Object mLock = new Object();
    protected boolean zzgre = false;
    protected boolean zzgrf = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzasm() {
        synchronized (this.mLock) {
            this.zzgrf = true;
            if (this.zzgrh.isConnected() || this.zzgrh.isConnecting()) {
                this.zzgrh.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        com.google.android.gms.ads.internal.util.zzd.zzdz("Cannot connect to remote service, fallback to local instance.");
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        com.google.android.gms.ads.internal.util.zzd.zzdz("Disconnected from remote ad request service.");
        this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
    }
}
