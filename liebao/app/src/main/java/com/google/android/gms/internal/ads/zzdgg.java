package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgg implements zzdhe<zzdgd> {
    private final Context context;
    private final ScheduledExecutorService zzftq;
    private final zzdpm zzfzg;
    private final zzebs zzgka;
    private final zzcyz zzgyz;
    private String zzhcu;
    private final zzczb zzhfr;

    public zzdgg(zzebs zzebsVar, ScheduledExecutorService scheduledExecutorService, String str, zzczb zzczbVar, Context context, zzdpm zzdpmVar, zzcyz zzcyzVar) {
        this.zzgka = zzebsVar;
        this.zzftq = scheduledExecutorService;
        this.zzhcu = str;
        this.zzhfr = zzczbVar;
        this.context = context;
        this.zzfzg = zzdpmVar;
        this.zzgyz = zzcyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdgd> zzatu() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcro)).booleanValue()) {
            return zzebh.zza(new zzeas(this) { // from class: com.google.android.gms.internal.ads.zzdgf
                private final zzdgg zzhfq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhfq = this;
                }

                @Override // com.google.android.gms.internal.ads.zzeas
                public final zzebt zzauk() {
                    return this.zzhfq.zzaul();
                }
            }, this.zzgka);
        }
        return zzebh.zzag(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, List list, Bundle bundle) {
        zzbbe zzbbeVar = new zzbbe();
        this.zzgyz.zzgo(str);
        zzaqa zzgp = this.zzgyz.zzgp(str);
        if (zzgp == null) {
            throw null;
        }
        zzgp.zza(ObjectWrapper.wrap(this.context), this.zzhcu, bundle, (Bundle) list.get(0), this.zzfzg.zzbpy, new zzczh(str, zzgp, zzbbeVar));
        return zzbbeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzaul() {
        Map<String, List<Bundle>> zzu = this.zzhfr.zzu(this.zzhcu, this.zzfzg.zzhny);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<Bundle>> entry : zzu.entrySet()) {
            String key = entry.getKey();
            arrayList.add(zzebc.zzg(zzebh.zza(new zzeas(this, key, entry.getValue(), this.zzfzg.zzhnx.zzcih != null ? this.zzfzg.zzhnx.zzcih.getBundle(key) : null) { // from class: com.google.android.gms.internal.ads.zzdgi
                private final String zzdkl;
                private final zzdgg zzhfq;
                private final List zzhfs;
                private final Bundle zzhft;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhfq = this;
                    this.zzdkl = key;
                    this.zzhfs = r3;
                    this.zzhft = r4;
                }

                @Override // com.google.android.gms.internal.ads.zzeas
                public final zzebt zzauk() {
                    return this.zzhfq.zza(this.zzdkl, this.zzhfs, this.zzhft);
                }
            }, this.zzgka)).zza(((Long) zzww.zzra().zzd(zzabq.zzcrn)).longValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(Throwable.class, new zzdxw(key) { // from class: com.google.android.gms.internal.ads.zzdgh
                private final String zzdmo;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdmo = key;
                }

                @Override // com.google.android.gms.internal.ads.zzdxw
                public final Object apply(Object obj) {
                    Throwable th = (Throwable) obj;
                    String valueOf = String.valueOf(this.zzdmo);
                    com.google.android.gms.ads.internal.util.zzd.zzex(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
                    return null;
                }
            }, this.zzgka));
        }
        return zzebh.zzk(arrayList).zzb(new Callable(arrayList) { // from class: com.google.android.gms.internal.ads.zzdgk
            private final List zzhfu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfu = arrayList;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzebt> list = this.zzhfu;
                JSONArray jSONArray = new JSONArray();
                for (zzebt zzebtVar : list) {
                    if (((JSONObject) zzebtVar.get()) != null) {
                        jSONArray.put(zzebtVar.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzdgd(jSONArray.toString());
            }
        }, this.zzgka);
    }
}
