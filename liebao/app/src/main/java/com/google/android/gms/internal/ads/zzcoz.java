package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcoz extends zzcpb {
    public zzcoz(Context context) {
        this.zzgrh = new zzatr(context, com.google.android.gms.ads.internal.zzr.zzlj().zzaai(), this, this);
    }

    public final zzebt<InputStream> zzi(zzauj zzaujVar) {
        synchronized (this.mLock) {
            if (this.zzgre) {
                return this.zzdml;
            }
            this.zzgre = true;
            this.zzgrg = zzaujVar;
            this.zzgrh.checkAvailabilityAndConnect();
            this.zzdml.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcoy
                private final zzcoz zzgrc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgrc = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgrc.zzasm();
                }
            }, zzbat.zzekj);
            return this.zzdml;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpb, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        com.google.android.gms.ads.internal.util.zzd.zzdz("Cannot connect to remote service, fallback to local instance.");
        this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgrf) {
                this.zzgrf = true;
                try {
                    this.zzgrh.zzwt().zza(this.zzgrg, new zzcpa(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                }
            }
        }
    }
}
