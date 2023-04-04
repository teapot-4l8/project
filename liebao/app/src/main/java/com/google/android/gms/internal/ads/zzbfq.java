package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbfq {
    public static zzebt<zzbfi> zza(final Context context, final zzbar zzbarVar, final String str, final zzei zzeiVar, final com.google.android.gms.ads.internal.zzb zzbVar) {
        return zzebh.zzb(zzebh.zzag(null), new zzear(context, zzeiVar, zzbarVar, zzbVar, str) { // from class: com.google.android.gms.internal.ads.zzbfp
            private final Context zzdbt;
            private final zzei zzdkw;
            private final zzbar zzetv;
            private final com.google.android.gms.ads.internal.zzb zzetw;
            private final String zzetx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbt = context;
                this.zzdkw = zzeiVar;
                this.zzetv = zzbarVar;
                this.zzetw = zzbVar;
                this.zzetx = str;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                Context context2 = this.zzdbt;
                zzei zzeiVar2 = this.zzdkw;
                zzbar zzbarVar2 = this.zzetv;
                com.google.android.gms.ads.internal.zzb zzbVar2 = this.zzetw;
                String str2 = this.zzetx;
                com.google.android.gms.ads.internal.zzr.zzkw();
                zzbfi zza = zzbfq.zza(context2, zzbgx.zzafg(), "", false, false, zzeiVar2, null, zzbarVar2, null, null, zzbVar2, zztz.zznl(), null, null);
                zzbbb zzk = zzbbb.zzk(zza);
                zza.zzaef().zza(new zzbgt(zzk) { // from class: com.google.android.gms.internal.ads.zzbfr
                    private final zzbbb zzety;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzety = zzk;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbgt
                    public final void zzam(boolean z) {
                        this.zzety.zzaav();
                    }
                });
                zza.loadUrl(str2);
                return zzk;
            }
        }, zzbat.zzeki);
    }

    public static zzbfi zza(final Context context, final zzbgx zzbgxVar, final String str, final boolean z, final boolean z2, final zzei zzeiVar, final zzacv zzacvVar, final zzbar zzbarVar, zzach zzachVar, final com.google.android.gms.ads.internal.zzm zzmVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zztz zztzVar, final zzdot zzdotVar, final zzdoy zzdoyVar) {
        zzabq.initialize(context);
        try {
            return (zzbfi) com.google.android.gms.ads.internal.util.zzbr.zza(new zzdyp(context, zzbgxVar, str, z, z2, zzeiVar, zzacvVar, zzbarVar, null, zzmVar, zzbVar, zztzVar, zzdotVar, zzdoyVar) { // from class: com.google.android.gms.internal.ads.zzbfs
                private final Context zzdbt;
                private final String zzdmx;
                private final zzbgx zzetz;
                private final boolean zzeua;
                private final boolean zzeub;
                private final zzei zzeuc;
                private final zzacv zzeud;
                private final zzbar zzeue;
                private final zzach zzeuf = null;
                private final com.google.android.gms.ads.internal.zzm zzeug;
                private final com.google.android.gms.ads.internal.zzb zzeuh;
                private final zztz zzeui;
                private final zzdot zzeuj;
                private final zzdoy zzeuk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdbt = context;
                    this.zzetz = zzbgxVar;
                    this.zzdmx = str;
                    this.zzeua = z;
                    this.zzeub = z2;
                    this.zzeuc = zzeiVar;
                    this.zzeud = zzacvVar;
                    this.zzeue = zzbarVar;
                    this.zzeug = zzmVar;
                    this.zzeuh = zzbVar;
                    this.zzeui = zztzVar;
                    this.zzeuj = zzdotVar;
                    this.zzeuk = zzdoyVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdyp
                public final Object get() {
                    return zzbfq.zzb(this.zzdbt, this.zzetz, this.zzdmx, this.zzeua, this.zzeub, this.zzeuc, this.zzeud, this.zzeue, null, this.zzeug, this.zzeuh, this.zzeui, this.zzeuj, this.zzeuk);
                }
            });
        } catch (Throwable th) {
            throw new zzbfu("Webview initialization failed.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzbfi zzb(Context context, zzbgx zzbgxVar, String str, boolean z, boolean z2, zzei zzeiVar, zzacv zzacvVar, zzbar zzbarVar, zzach zzachVar, com.google.android.gms.ads.internal.zzm zzmVar, com.google.android.gms.ads.internal.zzb zzbVar, zztz zztzVar, zzdot zzdotVar, zzdoy zzdoyVar) {
        try {
            TrafficStats.setThreadStatsTag(264);
            zzbft zzbftVar = new zzbft(zzbfy.zzc(context, zzbgxVar, str, z, z2, zzeiVar, zzacvVar, zzbarVar, zzachVar, zzmVar, zzbVar, zztzVar, zzdotVar, zzdoyVar));
            zzbftVar.setWebViewClient(com.google.android.gms.ads.internal.zzr.zzkx().zza(zzbftVar, zztzVar, z2));
            zzbftVar.setWebChromeClient(new zzbfa(zzbftVar));
            return zzbftVar;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
