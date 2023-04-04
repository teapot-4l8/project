package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdvi implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzgre = false;
    private boolean zzgrf = false;
    private final zzdwe zzhvz;
    private final zzdvx zzhwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdvi(Context context, Looper looper, zzdvx zzdvxVar) {
        this.zzhwa = zzdvxVar;
        this.zzhvz = new zzdwe(context, looper, this, this, 12800000);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzayu() {
        synchronized (this.lock) {
            if (!this.zzgre) {
                this.zzgre = true;
                this.zzhvz.checkAvailabilityAndConnect();
            }
        }
    }

    private final void zzasm() {
        synchronized (this.lock) {
            if (this.zzhvz.isConnected() || this.zzhvz.isConnecting()) {
                this.zzhvz.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.lock) {
            if (this.zzgrf) {
                return;
            }
            this.zzgrf = true;
            try {
                this.zzhvz.zzazg().zza(new zzdwc(this.zzhwa.toByteArray()));
                zzasm();
            } catch (Exception unused) {
                zzasm();
            } catch (Throwable th) {
                zzasm();
                throw th;
            }
        }
    }
}
