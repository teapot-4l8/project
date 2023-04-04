package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwr<AdT> implements zzear<zzdpi, AdT> {
    private final Executor executor;
    private final zzdun zzftm;
    private final zzdup zzftn;
    private final ScheduledExecutorService zzfvp;
    private final zzdtg zzfzh;
    private final zzctc zzfzp;
    private final zzbsx zzgcz;
    private final zzbph<AdT> zzgyh;
    private final zzcwk zzgyi;

    public zzcwr(zzdtg zzdtgVar, zzcwk zzcwkVar, zzbsx zzbsxVar, zzdun zzdunVar, zzdup zzdupVar, zzbph<AdT> zzbphVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzctc zzctcVar) {
        this.zzfzh = zzdtgVar;
        this.zzgyi = zzcwkVar;
        this.zzgcz = zzbsxVar;
        this.zzftm = zzdunVar;
        this.zzftn = zzdupVar;
        this.zzgyh = zzbphVar;
        this.executor = executor;
        this.zzfvp = scheduledExecutorService;
        this.zzfzp = zzctcVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0115  */
    @Override // com.google.android.gms.internal.ads.zzear
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ zzebt zzf(zzdpi zzdpiVar) {
        String str;
        zzdov zzdovVar;
        boolean z;
        int i;
        zzdpi zzdpiVar2 = zzdpiVar;
        int i2 = zzdpiVar2.zzhnt.zzeuy.responseCode;
        if (i2 != 0) {
            if (i2 < 200 || i2 >= 300) {
                if (i2 < 300 || i2 >= 400) {
                    StringBuilder sb = new StringBuilder(46);
                    sb.append("Received error HTTP response code: ");
                    sb.append(i2);
                    str = sb.toString();
                } else {
                    str = "No location header to follow redirect or too many redirects.";
                }
            } else if (!((Boolean) zzww.zzra().zzd(zzabq.zzcxf)).booleanValue()) {
                str = "No fill.";
            }
            zzdovVar = zzdpiVar2.zzhnt.zzeuy.zzhni;
            if (zzdovVar != null) {
                str = zzdovVar.getDescription();
            }
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdba)).booleanValue() && ((i = zzdpiVar2.zzhnt.zzeuy.responseCode) < 200 || i >= 300)) {
                return zzebh.immediateFailedFuture(new zzcwo(zzdqj.NO_FILL, str));
            }
            zzdst zzayi = this.zzfzh.zzt(zzdth.RENDER_CONFIG_INIT).zze(zzebh.immediateFailedFuture(new zzcwo(zzdqj.NO_FILL, str))).zzayi();
            this.zzgcz.zza(new zzbkw(zzdpiVar2, this.zzftn, this.zzftm), this.executor);
            int i3 = 0;
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
                for (zzdot zzdotVar : zzdpiVar2.zzhnt.zzhnq) {
                    this.zzfzp.zzd(zzdotVar);
                    Iterator<String> it = zzdotVar.zzhly.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        zzcsz<AdT> zze = this.zzgyh.zze(zzdotVar.zzhlz, it.next());
                        if (zze != null && zze.zza(zzdpiVar2, zzdotVar)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.zzfzp.zza(zzdotVar, 0L, zzdqh.zza(zzdqj.INTERNAL_ERROR, null, null));
                    }
                }
            }
            for (zzdot zzdotVar2 : zzdpiVar2.zzhnt.zzhnq) {
                Iterator<String> it2 = zzdotVar2.zzhly.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String next = it2.next();
                    zzcsz<AdT> zze2 = this.zzgyh.zze(zzdotVar2.zzhlz, next);
                    if (zze2 != null && zze2.zza(zzdpiVar2, zzdotVar2)) {
                        zzdsy<I> zza = this.zzfzh.zza((zzdtg) zzdth.RENDER_CONFIG_WATERFALL, (zzebt) zzayi);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(next).length() + 26);
                        sb2.append("render-config-");
                        sb2.append(i3);
                        sb2.append("-");
                        sb2.append(next);
                        zzayi = zza.zzgv(sb2.toString()).zza(Throwable.class, new zzear(this, zzdpiVar2, zzdotVar2, zze2) { // from class: com.google.android.gms.internal.ads.zzcwq
                            private final zzdot zzfxi;
                            private final zzdpi zzgjy;
                            private final zzcwr zzgyf;
                            private final zzcsz zzgyg;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzgyf = this;
                                this.zzgjy = zzdpiVar2;
                                this.zzfxi = zzdotVar2;
                                this.zzgyg = zze2;
                            }

                            @Override // com.google.android.gms.internal.ads.zzear
                            public final zzebt zzf(Object obj) {
                                return this.zzgyf.zza(this.zzgjy, this.zzfxi, this.zzgyg, (Throwable) obj);
                            }
                        }).zzayi();
                        break;
                    }
                }
                i3++;
            }
            return zzayi;
        }
        str = "No ad config.";
        zzdovVar = zzdpiVar2.zzhnt.zzeuy.zzhni;
        if (zzdovVar != null) {
        }
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdba)).booleanValue()) {
        }
        zzdst zzayi2 = this.zzfzh.zzt(zzdth.RENDER_CONFIG_INIT).zze(zzebh.immediateFailedFuture(new zzcwo(zzdqj.NO_FILL, str))).zzayi();
        this.zzgcz.zza(new zzbkw(zzdpiVar2, this.zzftn, this.zzftm), this.executor);
        int i32 = 0;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
        }
        while (r1.hasNext()) {
        }
        return zzayi2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdpi zzdpiVar, zzdot zzdotVar, zzcsz zzcszVar, Throwable th) {
        return this.zzgyi.zza(zzdpiVar.zzhnt.zzeuy, zzdotVar, zzebh.zza(zzcszVar.zzb(zzdpiVar, zzdotVar), zzdotVar.zzhmr, TimeUnit.MILLISECONDS, this.zzfvp));
    }
}
