package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzta {
    private Context context;
    private zztj zzbvm;
    private zztn zzbvn;
    private final Runnable zzbvl = new zztd(this);
    private final Object lock = new Object();

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.lock) {
            if (this.context != null) {
                return;
            }
            this.context = context.getApplicationContext();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcuw)).booleanValue()) {
                connect();
            } else {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcuv)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzr.zzky().zza(new zztc(this));
                }
            }
        }
    }

    public final void zzna() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcux)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                com.google.android.gms.ads.internal.util.zzj.zzegq.removeCallbacks(this.zzbvl);
                com.google.android.gms.ads.internal.util.zzj.zzegq.postDelayed(this.zzbvl, ((Long) zzww.zzra().zzd(zzabq.zzcuy)).longValue());
            }
        }
    }

    public final zzth zza(zzti zztiVar) {
        synchronized (this.lock) {
            if (this.zzbvn == null) {
                return new zzth();
            }
            try {
                if (this.zzbvm.zznk()) {
                    return this.zzbvn.zzc(zztiVar);
                }
                return this.zzbvn.zza(zztiVar);
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Unable to call into cache service.", e2);
                return new zzth();
            }
        }
    }

    public final long zzb(zzti zztiVar) {
        synchronized (this.lock) {
            if (this.zzbvn == null) {
                return -2L;
            }
            if (this.zzbvm.zznk()) {
                try {
                    return this.zzbvn.zzb(zztiVar);
                } catch (RemoteException e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzc("Unable to call into cache service.", e2);
                }
            }
            return -2L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect() {
        synchronized (this.lock) {
            if (this.context != null && this.zzbvm == null) {
                zztj zza = zza(new zztf(this), new zzte(this));
                this.zzbvm = zza;
                zza.checkAvailabilityAndConnect();
            }
        }
    }

    private final synchronized zztj zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zztj(this.context, com.google.android.gms.ads.internal.zzr.zzlj().zzaai(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbvm == null) {
                return;
            }
            if (this.zzbvm.isConnected() || this.zzbvm.isConnecting()) {
                this.zzbvm.disconnect();
            }
            this.zzbvm = null;
            this.zzbvn = null;
            Binder.flushPendingCommands();
        }
    }
}
