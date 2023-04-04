package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwn implements zzebi<T> {
    private final /* synthetic */ zzdoy zzglq;
    private final /* synthetic */ long zzgyb;
    private final /* synthetic */ String zzgyc;
    private final /* synthetic */ zzdot zzgyd;
    private final /* synthetic */ zzcwk zzgye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcwn(zzcwk zzcwkVar, long j, String str, zzdot zzdotVar, zzdoy zzdoyVar) {
        this.zzgye = zzcwkVar;
        this.zzgyb = j;
        this.zzgyc = str;
        this.zzgyd = zzdotVar;
        this.zzglq = zzdoyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void onSuccess(T t) {
        Clock clock;
        boolean z;
        zzctc zzctcVar;
        zzcwm zzcwmVar;
        clock = this.zzgye.zzbqq;
        long elapsedRealtime = clock.elapsedRealtime() - this.zzgyb;
        this.zzgye.zza(this.zzgyc, 0, elapsedRealtime, this.zzgyd.zzhmx);
        z = this.zzgye.zzgya;
        if (z) {
            zzcwmVar = this.zzgye.zzgxy;
            zzcwmVar.zza(this.zzglq, this.zzgyd, 0, null, elapsedRealtime);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            zzctcVar = this.zzgye.zzfzp;
            zzctcVar.zza(this.zzgyd, elapsedRealtime, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        Clock clock;
        int i;
        boolean z;
        zzctc zzctcVar;
        zzcwm zzcwmVar;
        clock = this.zzgye.zzbqq;
        long elapsedRealtime = clock.elapsedRealtime() - this.zzgyb;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzcwa) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzdpq) {
            i = 5;
        } else {
            i = ((th instanceof zzcnp) && zzdqh.zzh(th).errorCode == 3) ? 1 : 6;
        }
        this.zzgye.zza(this.zzgyc, i, elapsedRealtime, this.zzgyd.zzhmx);
        z = this.zzgye.zzgya;
        if (z) {
            zzcwmVar = this.zzgye.zzgxy;
            zzcwmVar.zza(this.zzglq, this.zzgyd, i, th instanceof zzctd ? (zzctd) th : null, elapsedRealtime);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            zzvh zzh = zzdqh.zzh(th);
            if ((zzh.errorCode == 3 || zzh.errorCode == 0) && zzh.zzchu != null && !zzh.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
                zzh = zzdqh.zzh(new zzctd(zzdqj.MEDIATION_NO_FILL, zzh.zzchu));
            }
            zzctcVar = this.zzgye.zzfzp;
            zzctcVar.zza(this.zzgyd, elapsedRealtime, zzh);
        }
    }
}
