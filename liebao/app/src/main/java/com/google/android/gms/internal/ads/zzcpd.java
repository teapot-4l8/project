package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpd extends zzcpb {
    public zzcpd(Context context) {
        this.zzgrh = new zzatr(context, com.google.android.gms.ads.internal.zzr.zzlj().zzaai(), this, this);
    }

    public final zzebt<InputStream> zzj(zzauj zzaujVar) {
        synchronized (this.mLock) {
            if (this.zzgre) {
                return this.zzdml;
            }
            this.zzgre = true;
            this.zzgrg = zzaujVar;
            this.zzgrh.checkAvailabilityAndConnect();
            this.zzdml.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcpc
                private final zzcpd zzgri;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgri = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgri.zzasm();
                }
            }, zzbat.zzekj);
            return this.zzdml;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgrf) {
                this.zzgrf = true;
                try {
                    this.zzgrh.zzwt().zzb(this.zzgrg, new zzcpa(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                }
            }
        }
    }
}
