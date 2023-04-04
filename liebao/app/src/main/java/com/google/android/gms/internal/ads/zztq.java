package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztq implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzti zzbwh;
    private final /* synthetic */ zzbbe zzbwi;
    final /* synthetic */ zzto zzbwj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztq(zzto zztoVar, zzti zztiVar, zzbbe zzbbeVar) {
        this.zzbwj = zztoVar;
        this.zzbwh = zztiVar;
        this.zzbwi = zzbbeVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        boolean z;
        final zztj zztjVar;
        obj = this.zzbwj.lock;
        synchronized (obj) {
            z = this.zzbwj.zzbwg;
            if (z) {
                return;
            }
            this.zzbwj.zzbwg = true;
            zztjVar = this.zzbwj.zzbvm;
            if (zztjVar == null) {
                return;
            }
            zzebs zzebsVar = zzbat.zzeke;
            final zzti zztiVar = this.zzbwh;
            final zzbbe zzbbeVar = this.zzbwi;
            this.zzbwi.addListener(new Runnable(this.zzbwi, zzebsVar.zzg(new Runnable(this, zztjVar, zztiVar, zzbbeVar) { // from class: com.google.android.gms.internal.ads.zztt
                private final zztq zzbwm;
                private final zztj zzbwn;
                private final zzti zzbwo;
                private final zzbbe zzbwp;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbwm = this;
                    this.zzbwn = zztjVar;
                    this.zzbwo = zztiVar;
                    this.zzbwp = zzbbeVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzth zza;
                    zztq zztqVar = this.zzbwm;
                    zztj zztjVar2 = this.zzbwn;
                    zzti zztiVar2 = this.zzbwo;
                    zzbbe zzbbeVar2 = this.zzbwp;
                    try {
                        zztn zznj = zztjVar2.zznj();
                        if (zztjVar2.zznk()) {
                            zza = zznj.zzc(zztiVar2);
                        } else {
                            zza = zznj.zza(zztiVar2);
                        }
                        if (!zza.zznc()) {
                            zzbbeVar2.setException(new RuntimeException("No entry contents."));
                            zztqVar.zzbwj.disconnect();
                            return;
                        }
                        zztv zztvVar = new zztv(zztqVar, zza.zznd(), 1);
                        int read = zztvVar.read();
                        if (read == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zztvVar.unread(read);
                        zzbbeVar2.set(zztw.zza(zztvVar, zza.zznf(), zza.zzni(), zza.zznh(), zza.zzng()));
                    } catch (RemoteException | IOException e2) {
                        com.google.android.gms.ads.internal.util.zzd.zzc("Unable to obtain a cache service instance.", e2);
                        zzbbeVar2.setException(e2);
                        zztqVar.zzbwj.disconnect();
                    }
                }
            })) { // from class: com.google.android.gms.internal.ads.zzts
                private final zzbbe zzbwk;
                private final Future zzbwl;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbwk = r1;
                    this.zzbwl = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbbe zzbbeVar2 = this.zzbwk;
                    Future future = this.zzbwl;
                    if (zzbbeVar2.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzbat.zzekj);
        }
    }
}
