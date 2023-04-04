package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajg implements zzu {
    private final Context context;
    private volatile zzaiz zzdjx;

    public zzajg(Context context) {
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final zzz zza(zzab<?> zzabVar) {
        zzaiy zzh = zzaiy.zzh(zzabVar);
        long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
        try {
            zzbbe zzbbeVar = new zzbbe();
            this.zzdjx = new zzaiz(this.context, com.google.android.gms.ads.internal.zzr.zzlj().zzaai(), new zzajk(this, zzbbeVar), new zzajn(this, zzbbeVar));
            this.zzdjx.checkAvailabilityAndConnect();
            zzebt zza = zzebh.zza(zzebh.zzb(zzbbeVar, new zzajj(this, zzh), zzbat.zzeke), ((Integer) zzww.zzra().zzd(zzabq.zzcvj)).intValue(), TimeUnit.MILLISECONDS, zzbat.zzekh);
            zza.addListener(new zzajl(this), zzbat.zzeke);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
            zzaja zzajaVar = (zzaja) new zzaue(parcelFileDescriptor).zza(zzaja.CREATOR);
            if (zzajaVar == null) {
                return null;
            }
            if (zzajaVar.zzdjw) {
                throw new zzap(zzajaVar.zzchs);
            }
            if (zzajaVar.zzdju.length != zzajaVar.zzdjv.length) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < zzajaVar.zzdju.length; i++) {
                hashMap.put(zzajaVar.zzdju[i], zzajaVar.zzdjv[i]);
            }
            return new zzz(zzajaVar.statusCode, zzajaVar.data, hashMap, zzajaVar.zzak, zzajaVar.zzal);
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            com.google.android.gms.ads.internal.util.zzd.zzed(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime3 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3);
            sb3.append("ms");
            com.google.android.gms.ads.internal.util.zzd.zzed(sb3.toString());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdjx == null) {
            return;
        }
        this.zzdjx.disconnect();
        Binder.flushPendingCommands();
    }
}
