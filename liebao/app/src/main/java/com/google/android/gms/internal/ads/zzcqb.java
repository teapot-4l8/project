package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqb extends zzatz {
    private final Context context;
    private final Executor zzfur;
    private final zzauw zzgrz;
    private final zzaux zzgsa;
    private final zzbki zzgsb;
    private final HashMap<String, zzcqm> zzgsc;

    public zzcqb(Context context, Executor executor, zzauw zzauwVar, zzbki zzbkiVar, zzaux zzauxVar, HashMap<String, zzcqm> hashMap) {
        zzabq.initialize(context);
        this.context = context;
        this.zzfur = executor;
        this.zzgrz = zzauwVar;
        this.zzgsa = zzauxVar;
        this.zzgsb = zzbkiVar;
        this.zzgsc = hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final zzats zza(zzatq zzatqVar) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(zzatq zzatqVar, zzaub zzaubVar) {
    }

    public final zzebt<InputStream> zzb(zzauj zzaujVar, int i) {
        zzamo zza = com.google.android.gms.ads.internal.zzr.zzli().zza(this.context, zzbar.zzaau());
        zzdhw zza2 = this.zzgsb.zza(zzaujVar, i);
        zzamg zza3 = zza.zza("google.afma.response.normalize", zzcqp.zzgsk, zzamn.zzdmb);
        zzcqq zzcqqVar = new zzcqq(this.context, zzaujVar.zzdvi.zzbrz, this.zzgrz, zzaujVar.zzdwh, i);
        zzdtg zzahw = zza2.zzahw();
        zzcqm zzcqmVar = null;
        if (!zzadr.zzdfo.get().booleanValue()) {
            if (zzaujVar.zzdyv != null && !zzaujVar.zzdyv.isEmpty()) {
                com.google.android.gms.ads.internal.util.zzd.zzed("Request contained a PoolKey but split request is disabled.");
            }
        } else if (zzaujVar.zzdyv != null && !zzaujVar.zzdyv.isEmpty() && (zzcqmVar = this.zzgsc.remove(zzaujVar.zzdyv)) == null) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Request contained a PoolKey but no matching parameters were found.");
        }
        if (zzcqmVar == null) {
            zzebt<JSONObject> zza4 = zza(zzaujVar, zzahw, zza2);
            zzebt<zzaup> zza5 = zza(zza4, zzahw, zza);
            zzdst zzayi = zzahw.zza((zzdtg) zzdth.HTTP, zza5, zza4).zzb(new Callable(zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcqa
                private final zzebt zzgbc;
                private final zzebt zzgkr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgkr = zza4;
                    this.zzgbc = zza5;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcqt((JSONObject) this.zzgkr.get(), (zzaup) this.zzgbc.get());
                }
            }).zzb(zzcqqVar).zzayi();
            return zzahw.zza((zzdtg) zzdth.PRE_PROCESS, zza4, zza5, zzayi).zzb(new Callable(zzayi, zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcqd
                private final zzebt zzfyy;
                private final zzebt zzgbc;
                private final zzebt zzgkr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgkr = zzayi;
                    this.zzgbc = zza4;
                    this.zzfyy = zza5;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcqp((zzcqs) this.zzgkr.get(), (JSONObject) this.zzgbc.get(), (zzaup) this.zzfyy.get());
                }
            }).zza(zza3).zzayi();
        }
        zzdst zzayi2 = zzahw.zza((zzdtg) zzdth.HTTP, zzebh.zzag(new zzcqt(zzcqmVar.zzgsh, zzcqmVar.zzgsg))).zzb(zzcqqVar).zzayi();
        zzebt<?> zzag = zzebh.zzag(zzcqmVar);
        return zzahw.zza((zzdtg) zzdth.PRE_PROCESS, zzayi2, zzag).zzb(new Callable(zzayi2, zzag) { // from class: com.google.android.gms.internal.ads.zzcqc
            private final zzebt zzgbc;
            private final zzebt zzgkr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkr = zzayi2;
                this.zzgbc = zzag;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzebt zzebtVar = this.zzgkr;
                zzebt zzebtVar2 = this.zzgbc;
                return new zzcqp((zzcqs) zzebtVar.get(), ((zzcqm) zzebtVar2.get()).zzgsh, ((zzcqm) zzebtVar2.get()).zzgsg);
            }
        }).zza(zza3).zzayi();
    }

    private static zzebt<JSONObject> zza(zzauj zzaujVar, zzdtg zzdtgVar, final zzdhw zzdhwVar) {
        zzear zzearVar = new zzear(zzdhwVar) { // from class: com.google.android.gms.internal.ads.zzcqf
            private final zzdhw zzgsd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgsd = zzdhwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgsd.zzahu().zzs(com.google.android.gms.ads.internal.zzr.zzkv().zzc((Bundle) obj));
            }
        };
        return zzdtgVar.zza((zzdtg) zzdth.GMS_SIGNALS, zzebh.zzag(zzaujVar.zzdys)).zza(zzearVar).zzb(zzcqe.zzgqm).zzayi();
    }

    private static zzebt<zzaup> zza(zzebt<JSONObject> zzebtVar, zzdtg zzdtgVar, zzamo zzamoVar) {
        return zzdtgVar.zza((zzdtg) zzdth.BUILD_URL, (zzebt) zzebtVar).zza(zzamoVar.zza("AFMA_getAdDictionary", zzamn.zzdma, zzcqh.zzdlz)).zzayi();
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(zzauj zzaujVar, zzaud zzaudVar) {
        zzebt<InputStream> zzb = zzb(zzaujVar, Binder.getCallingUid());
        zza(zzb, zzaudVar);
        zzb.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcqg
            private final zzcqb zzgse;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgse = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgse.zzasn();
            }
        }, this.zzfur);
    }

    public final zzebt<InputStream> zzc(zzauj zzaujVar, int i) {
        if (!zzadr.zzdfo.get().booleanValue()) {
            return zzebh.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        if (zzaujVar.zzdyu == null) {
            return zzebh.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzaujVar.zzdyu.zzhqp == 0 || zzaujVar.zzdyu.zzhqq == 0) {
            return zzebh.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzamo zza = com.google.android.gms.ads.internal.zzr.zzli().zza(this.context, zzbar.zzaau());
        zzdhw zza2 = this.zzgsb.zza(zzaujVar, i);
        zzdtg zzahw = zza2.zzahw();
        zzebt<JSONObject> zza3 = zza(zzaujVar, zzahw, zza2);
        zzebt<zzaup> zza4 = zza(zza3, zzahw, zza);
        return zzahw.zza((zzdtg) zzdth.GET_URL_AND_CACHE_KEY, zza3, zza4).zzb(new Callable(this, zza4, zza3) { // from class: com.google.android.gms.internal.ads.zzcqj
            private final zzebt zzfyy;
            private final zzebt zzgbc;
            private final zzcqb zzgse;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgse = this;
                this.zzgbc = zza4;
                this.zzfyy = zza3;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgse.zza(this.zzgbc, this.zzfyy);
            }
        }).zzayi();
    }

    public final zzebt<InputStream> zzgk(String str) {
        if (!zzadr.zzdfo.get().booleanValue()) {
            return zzebh.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcqk zzcqkVar = new zzcqk(this);
        if (this.zzgsc.remove(str) == null) {
            String valueOf = String.valueOf(str);
            return zzebh.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
        }
        return zzebh.zzag(zzcqkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zzc(zzauj zzaujVar, zzaud zzaudVar) {
        zza(zzc(zzaujVar, Binder.getCallingUid()), zzaudVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(String str, zzaud zzaudVar) {
        zza(zzgk(str), zzaudVar);
    }

    public final zzebt<InputStream> zzd(zzauj zzaujVar, int i) {
        zzamo zza = com.google.android.gms.ads.internal.zzr.zzli().zza(this.context, zzbar.zzaau());
        if (!zzadx.zzdgf.get().booleanValue()) {
            return zzebh.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdhw zza2 = this.zzgsb.zza(zzaujVar, i);
        final zzdhd<JSONObject> zzahv = zza2.zzahv();
        return zza2.zzahw().zza((zzdtg) zzdth.GET_SIGNALS, zzebh.zzag(zzaujVar.zzdys)).zza(new zzear(zzahv) { // from class: com.google.android.gms.internal.ads.zzcqi
            private final zzdhd zzgsf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgsf = zzahv;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgsf.zzs(com.google.android.gms.ads.internal.zzr.zzkv().zzc((Bundle) obj));
            }
        }).zzv(zzdth.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzamn.zzdma, zzamn.zzdmb)).zzayi();
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zzb(zzauj zzaujVar, zzaud zzaudVar) {
        zza(zzd(zzaujVar, Binder.getCallingUid()), zzaudVar);
    }

    private final void zza(zzebt<InputStream> zzebtVar, zzaud zzaudVar) {
        zzebh.zza(zzebh.zzb(zzebtVar, new zzear(this) { // from class: com.google.android.gms.internal.ads.zzcql
            private final zzcqb zzgse;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgse = this;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return zzebh.zzag(zzdqf.zze((InputStream) obj));
            }
        }, zzbat.zzeke), new zzcqn(this, zzaudVar), zzbat.zzekj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zza(zzebt zzebtVar, zzebt zzebtVar2) {
        String zzxc = ((zzaup) zzebtVar.get()).zzxc();
        this.zzgsc.put(zzxc, new zzcqm((zzaup) zzebtVar.get(), (JSONObject) zzebtVar2.get()));
        return new ByteArrayInputStream(zzxc.getBytes(zzdxu.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzasn() {
        zzbba.zza(this.zzgsa.zzxe(), "persistFlags");
    }
}
