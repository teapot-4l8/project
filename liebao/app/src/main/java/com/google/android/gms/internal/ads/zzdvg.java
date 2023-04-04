package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdvg implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final long startTime;
    private final HandlerThread zzeiq;
    private zzdwe zzhvt;
    private final LinkedBlockingQueue<zzdwt> zzhvv;
    private final String zzhvw;
    private final String zzhvx;
    private final int zzhvy = 1;
    private final zzduv zzvx;
    private final zzgp zzvz;

    public zzdvg(Context context, int i, zzgp zzgpVar, String str, String str2, String str3, zzduv zzduvVar) {
        this.zzhvw = str;
        this.zzvz = zzgpVar;
        this.zzhvx = str2;
        this.zzvx = zzduvVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzeiq = handlerThread;
        handlerThread.start();
        this.startTime = System.currentTimeMillis();
        this.zzhvt = new zzdwe(context, this.zzeiq.getLooper(), this, this, 19621000);
        this.zzhvv = new LinkedBlockingQueue<>();
        this.zzhvt.checkAvailabilityAndConnect();
    }

    public final zzdwt zzeo(int i) {
        zzdwt zzdwtVar;
        try {
            zzdwtVar = this.zzhvv.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            zzb(2009, this.startTime, e2);
            zzdwtVar = null;
        }
        zzb(3004, this.startTime, null);
        if (zzdwtVar != null) {
            if (zzdwtVar.status == 7) {
                zzduv.zza(zzbw.zza.zzc.DISABLED);
            } else {
                zzduv.zza(zzbw.zza.zzc.ENABLED);
            }
        }
        return zzdwtVar == null ? zzayt() : zzdwtVar;
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
            zzb(4011, this.startTime, null);
            this.zzhvv.put(zzayt());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdwl zzayr = zzayr();
        if (zzayr != null) {
            try {
                zzdwt zza = zzayr.zza(new zzdwr(this.zzhvy, this.zzvz, this.zzhvw, this.zzhvx));
                zzb(5011, this.startTime, null);
                this.zzhvv.put(zza);
            } catch (Throwable th) {
                try {
                    zzb(2010, this.startTime, new Exception(th));
                } finally {
                    zzasm();
                    this.zzeiq.quit();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzb(4012, this.startTime, null);
            this.zzhvv.put(zzayt());
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

    private static zzdwt zzayt() {
        return new zzdwt(null, 1);
    }

    private final void zzb(int i, long j, Exception exc) {
        zzduv zzduvVar = this.zzvx;
        if (zzduvVar != null) {
            zzduvVar.zza(i, System.currentTimeMillis() - j, exc);
        }
    }
}
