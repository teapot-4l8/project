package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcna {
    private final Executor executor;
    private final zzbar zzbpj;
    private final Context zzcmo;
    private final Executor zzfur;
    private final ScheduledExecutorService zzfvp;
    private final WeakReference<Context> zzgpg;
    private final zzckb zzgph;
    private final zzcmk zzgpi;
    private final zzbyr zzgpk;
    private boolean zzgpb = false;
    private boolean zzgpc = false;
    private boolean zzgpd = false;
    private final zzbbe<Boolean> zzgpf = new zzbbe<>();
    private Map<String, zzajm> zzgpj = new ConcurrentHashMap();
    private boolean enabled = true;
    private final long zzgpe = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();

    public zzcna(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzckb zzckbVar, ScheduledExecutorService scheduledExecutorService, zzcmk zzcmkVar, zzbar zzbarVar, zzbyr zzbyrVar) {
        this.zzgph = zzckbVar;
        this.zzcmo = context;
        this.zzgpg = weakReference;
        this.executor = executor2;
        this.zzfvp = scheduledExecutorService;
        this.zzfur = executor;
        this.zzgpi = zzcmkVar;
        this.zzbpj = zzbarVar;
        this.zzgpk = zzbyrVar;
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public final void disable() {
        this.enabled = false;
    }

    public final void zzb(zzajt zzajtVar) {
        this.zzgpf.addListener(new Runnable(this, zzajtVar) { // from class: com.google.android.gms.internal.ads.zzcnd
            private final zzcna zzgpl;
            private final zzajt zzgpm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgpl = this;
                this.zzgpm = zzajtVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgpl.zzc(this.zzgpm);
            }
        }, this.zzfur);
    }

    public final void zzarv() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrz)).booleanValue() && !zzado.zzdfh.get().booleanValue()) {
            if (this.zzbpj.zzekb >= ((Integer) zzww.zzra().zzd(zzabq.zzcsa)).intValue() && this.enabled) {
                if (this.zzgpb) {
                    return;
                }
                synchronized (this) {
                    if (this.zzgpb) {
                        return;
                    }
                    this.zzgpi.zzars();
                    this.zzgpk.zzang();
                    this.zzgpf.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcnc
                        private final zzcna zzgpl;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgpl = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzgpl.zzasb();
                        }
                    }, this.executor);
                    this.zzgpb = true;
                    zzebt<String> zzarx = zzarx();
                    this.zzfvp.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcne
                        private final zzcna zzgpl;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgpl = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzgpl.zzasa();
                        }
                    }, ((Long) zzww.zzra().zzd(zzabq.zzcsc)).longValue(), TimeUnit.SECONDS);
                    zzebh.zza(zzarx, new zzcnl(this), this.executor);
                    return;
                }
            }
        }
        if (this.zzgpb) {
            return;
        }
        zza("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zzgpf.set(false);
        this.zzgpb = true;
        this.zzgpc = true;
    }

    public final List<zzajm> zzarw() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzgpj.keySet()) {
            zzajm zzajmVar = this.zzgpj.get(str);
            arrayList.add(new zzajm(str, zzajmVar.zzdkb, zzajmVar.zzdkc, zzajmVar.description));
        }
        return arrayList;
    }

    private final synchronized zzebt<String> zzarx() {
        String zzyr = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzg().zzyr();
        if (!TextUtils.isEmpty(zzyr)) {
            return zzebh.zzag(zzyr);
        }
        zzbbe zzbbeVar = new zzbbe();
        com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzb(new Runnable(this, zzbbeVar) { // from class: com.google.android.gms.internal.ads.zzcnf
            private final zzcna zzgpl;
            private final zzbbe zzgpn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgpl = this;
                this.zzgpn = zzbbeVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgpl.zza(this.zzgpn);
            }
        });
        return zzbbeVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzgi(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzbbe zzbbeVar = new zzbbe();
                zzebt zza = zzebh.zza(zzbbeVar, ((Long) zzww.zzra().zzd(zzabq.zzcsb)).longValue(), TimeUnit.SECONDS, this.zzfvp);
                this.zzgpi.zzgg(next);
                this.zzgpk.zzfu(next);
                long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
                Iterator<String> it = keys;
                zza.addListener(new Runnable(this, obj, zzbbeVar, next, elapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzcnh
                    private final Object zzdms;
                    private final String zzgng;
                    private final zzcna zzgpl;
                    private final zzbbe zzgpo;
                    private final long zzgpp;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgpl = this;
                        this.zzdms = obj;
                        this.zzgpo = zzbbeVar;
                        this.zzgng = next;
                        this.zzgpp = elapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgpl.zza(this.zzdms, this.zzgpo, this.zzgng, this.zzgpp);
                    }
                }, this.executor);
                arrayList.add(zza);
                zzcnn zzcnnVar = new zzcnn(this, obj, next, elapsedRealtime, zzbbeVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray(JThirdPlatFormInterface.KEY_DATA);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject(JThirdPlatFormInterface.KEY_DATA);
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzajw(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    try {
                        this.zzfur.execute(new Runnable(this, this.zzgph.zzd(next, new JSONObject()), zzcnnVar, arrayList2, next) { // from class: com.google.android.gms.internal.ads.zzcnj
                            private final String zzetx;
                            private final zzcna zzgpl;
                            private final zzdqd zzgpq;
                            private final zzajo zzgpr;
                            private final List zzgps;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzgpl = this;
                                this.zzgpq = r2;
                                this.zzgpr = zzcnnVar;
                                this.zzgps = arrayList2;
                                this.zzetx = next;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzgpl.zza(this.zzgpq, this.zzgpr, this.zzgps, this.zzetx);
                            }
                        });
                    } catch (zzdpq unused2) {
                        zzcnnVar.onInitializationFailed("Failed to create Adapter.");
                    }
                } catch (RemoteException e2) {
                    zzbao.zzc("", e2);
                }
                keys = it;
            }
            zzebh.zzj(arrayList).zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcng
                private final zzcna zzgpl;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgpl = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgpl.zzarz();
                }
            }, this.executor);
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zzd.zza("Malformed CLD response", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzgpj.put(str, new zzajm(str, z, i, str2));
    }

    public final boolean zzary() {
        return this.zzgpc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdqd zzdqdVar, zzajo zzajoVar, List list, String str) {
        try {
            try {
                Context context = this.zzgpg.get();
                if (context == null) {
                    context = this.zzcmo;
                }
                zzdqdVar.zza(context, zzajoVar, list);
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
            }
        } catch (zzdpq unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Failed to initialize adapter. ");
            sb.append(str);
            sb.append(" does not implement the initialize() method.");
            zzajoVar.onInitializationFailed(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzarz() {
        this.zzgpf.set(true);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzbbe zzbbeVar, String str, long j) {
        synchronized (obj) {
            if (!zzbbeVar.isDone()) {
                zza(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - j));
                this.zzgpi.zzt(str, "timeout");
                this.zzgpk.zzn(str, "timeout");
                zzbbeVar.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzasa() {
        synchronized (this) {
            if (this.zzgpd) {
                return;
            }
            zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzgpe));
            this.zzgpf.setException(new Exception());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(final zzbbe zzbbeVar) {
        this.executor.execute(new Runnable(this, zzbbeVar) { // from class: com.google.android.gms.internal.ads.zzcni
            private final zzcna zzgpl;
            private final zzbbe zzgpn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgpl = this;
                this.zzgpn = zzbbeVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbe zzbbeVar2 = this.zzgpn;
                String zzyr = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzg().zzyr();
                if (!TextUtils.isEmpty(zzyr)) {
                    zzbbeVar2.set(zzyr);
                } else {
                    zzbbeVar2.setException(new Exception());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzasb() {
        this.zzgpi.zzart();
        this.zzgpk.zzanh();
        this.zzgpc = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzajt zzajtVar) {
        try {
            zzajtVar.zze(zzarw());
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
