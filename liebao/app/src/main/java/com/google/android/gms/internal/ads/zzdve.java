package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdve implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzeiq;
    private zzdwe zzhvt;
    private final String zzhvu;
    private final LinkedBlockingQueue<zzcf.zza> zzhvv;

    public zzdve(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhvu = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zzeiq = handlerThread;
        handlerThread.start();
        this.zzhvt = new zzdwe(context, this.zzeiq.getLooper(), this, this, 9200000);
        this.zzhvv = new LinkedBlockingQueue<>();
        this.zzhvt.checkAvailabilityAndConnect();
    }

    public final zzcf.zza zzen(int i) {
        zzcf.zza zzaVar;
        try {
            zzaVar = this.zzhvv.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzaVar = null;
        }
        return zzaVar == null ? zzays() : zzaVar;
    }

    private final zzdwl zzayr() {
        try {
            return this.zzhvt.zzazg();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzhvv.put(zzays());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdwl zzayr = zzayr();
        if (zzayr != null) {
            try {
                try {
                    this.zzhvv.put(zzayr.zza(new zzdwh(this.packageName, this.zzhvu)).zzazh());
                    zzasm();
                    this.zzeiq.quit();
                } catch (InterruptedException unused) {
                    zzasm();
                    this.zzeiq.quit();
                } catch (Throwable th) {
                    zzasm();
                    this.zzeiq.quit();
                    throw th;
                }
            } catch (Throwable unused2) {
                this.zzhvv.put(zzays());
                zzasm();
                this.zzeiq.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhvv.put(zzays());
        } catch (InterruptedException unused) {
        }
    }

    private final void zzasm() {
        zzdwe zzdweVar = this.zzhvt;
        if (zzdweVar != null) {
            if (zzdweVar.isConnected() || this.zzhvt.isConnecting()) {
                this.zzhvt.disconnect();
            }
        }
    }

    private static zzcf.zza zzays() {
        return (zzcf.zza) ((zzena) zzcf.zza.zzap().zzau(32768L).zzbjv());
    }
}
