package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpe extends zzcpb {
    private String zzgrj;
    private int zzgrk = zzcpj.zzgrm;

    public zzcpe(Context context) {
        this.zzgrh = new zzatr(context, com.google.android.gms.ads.internal.zzr.zzlj().zzaai(), this, this);
    }

    public final zzebt<InputStream> zzk(zzauj zzaujVar) {
        synchronized (this.mLock) {
            if (this.zzgrk != zzcpj.zzgrm && this.zzgrk != zzcpj.zzgrn) {
                return zzebh.immediateFailedFuture(new zzcpo(zzdqj.INVALID_REQUEST));
            } else if (this.zzgre) {
                return this.zzdml;
            } else {
                this.zzgrk = zzcpj.zzgrn;
                this.zzgre = true;
                this.zzgrg = zzaujVar;
                this.zzgrh.checkAvailabilityAndConnect();
                this.zzdml.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcph
                    private final zzcpe zzgrl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgrl = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgrl.zzasm();
                    }
                }, zzbat.zzekj);
                return this.zzdml;
            }
        }
    }

    public final zzebt<InputStream> zzgj(String str) {
        synchronized (this.mLock) {
            if (this.zzgrk != zzcpj.zzgrm && this.zzgrk != zzcpj.zzgro) {
                return zzebh.immediateFailedFuture(new zzcpo(zzdqj.INVALID_REQUEST));
            } else if (this.zzgre) {
                return this.zzdml;
            } else {
                this.zzgrk = zzcpj.zzgro;
                this.zzgre = true;
                this.zzgrj = str;
                this.zzgrh.checkAvailabilityAndConnect();
                this.zzdml.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcpg
                    private final zzcpe zzgrl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgrl = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgrl.zzasm();
                    }
                }, zzbat.zzekj);
                return this.zzdml;
            }
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
                    if (this.zzgrk == zzcpj.zzgrn) {
                        this.zzgrh.zzwt().zzc(this.zzgrg, new zzcpa(this));
                    } else if (this.zzgrk == zzcpj.zzgro) {
                        this.zzgrh.zzwt().zza(this.zzgrj, new zzcpa(this));
                    } else {
                        this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                }
            }
        }
    }
}
