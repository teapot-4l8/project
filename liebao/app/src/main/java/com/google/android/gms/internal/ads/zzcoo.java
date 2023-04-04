package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcoo implements zzcpp {
    private static final Pattern zzgqv = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzftq;
    private final zzdpm zzfzg;
    private final zzebs zzgka;
    private final zzcno zzgqt;
    private final zzcrr zzgqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcoo(zzdpm zzdpmVar, zzcno zzcnoVar, zzebs zzebsVar, ScheduledExecutorService scheduledExecutorService, zzcrr zzcrrVar) {
        this.zzfzg = zzdpmVar;
        this.zzgqt = zzcnoVar;
        this.zzgka = zzebsVar;
        this.zzftq = scheduledExecutorService;
        this.zzgqu = zzcrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpp
    public final zzebt<zzdpi> zzh(zzauj zzaujVar) {
        zzebt<zzdpi> zzb = zzebh.zzb(this.zzgqt.zze(zzaujVar), new zzear(this) { // from class: com.google.android.gms.internal.ads.zzcor
            private final zzcoo zzgqw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgqw.zzd((InputStream) obj);
            }
        }, this.zzgka);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxh)).booleanValue()) {
            zzb = zzebh.zzb(zzebh.zza(zzb, ((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS, this.zzftq), TimeoutException.class, zzcoq.zzbpa, zzbat.zzekj);
        }
        zzebh.zza(zzb, new zzcot(this), zzbat.zzekj);
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzd(InputStream inputStream) {
        return zzebh.zzag(new zzdpi(new zzdpd(this.zzfzg), zzdpg.zza(new InputStreamReader(inputStream))));
    }
}
