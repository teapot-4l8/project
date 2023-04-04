package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvp implements zzcvm<zzcdf> {
    private final zzebs zzgka;
    private final zzccf zzgxk;
    private final zzcgb zzgxl;
    private final zzdqc<zzchu> zzgxm;

    public zzcvp(zzccf zzccfVar, zzebs zzebsVar, zzcgb zzcgbVar, zzdqc<zzchu> zzdqcVar) {
        this.zzgxk = zzccfVar;
        this.zzgka = zzebsVar;
        this.zzgxl = zzcgbVar;
        this.zzgxm = zzdqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (zzdotVar.zzhmh == null || zzdotVar.zzhmh.zzgem == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<List<zzebt<zzcdf>>> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        return zzebh.zzb(zzebh.zzb(this.zzgxm.zzawl(), new zzear(this, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcvo
            private final zzdot zzgvt;
            private final zzcvp zzgxj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxj = this;
                this.zzgvt = zzdotVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgxj.zza(this.zzgvt, (zzchu) obj);
            }
        }, this.zzgka), new zzear(this, zzdpiVar, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcvr
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzcvp zzgxj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxj = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgxj.zza(this.zzgjy, this.zzfxi, (JSONArray) obj);
            }
        }, this.zzgka);
    }

    private final zzebt<zzcdf> zzb(zzdpi zzdpiVar, zzdot zzdotVar, JSONObject jSONObject) {
        zzebt<zzchu> zzawl = this.zzgxm.zzawl();
        zzebt<zzcdr> zza = this.zzgxl.zza(zzdpiVar, zzdotVar, jSONObject);
        return zzebh.zzb(zzawl, zza).zzb(new Callable(this, zza, zzawl, zzdpiVar, zzdotVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcvs
            private final zzebt zzfyy;
            private final zzebt zzgbc;
            private final zzcvp zzgxj;
            private final zzdpi zzgxo;
            private final zzdot zzgxp;
            private final JSONObject zzgxq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxj = this;
                this.zzgbc = zza;
                this.zzfyy = zzawl;
                this.zzgxo = zzdpiVar;
                this.zzgxp = zzdotVar;
                this.zzgxq = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgxj.zza(this.zzgbc, this.zzfyy, this.zzgxo, this.zzgxp, this.zzgxq);
            }
        }, this.zzgka);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcdf zza(zzebt zzebtVar, zzebt zzebtVar2, zzdpi zzdpiVar, zzdot zzdotVar, JSONObject jSONObject) {
        zzcdr zzcdrVar = (zzcdr) zzebtVar.get();
        zzchu zzchuVar = (zzchu) zzebtVar2.get();
        zzcdt zza = this.zzgxk.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzced(zzcdrVar), new zzcct(jSONObject, zzchuVar));
        zza.zzahp().zzaqi();
        zza.zzahq().zzb(zzchuVar);
        zza.zzahr().zzi(zzcdrVar.zzaot());
        return zza.zzaho();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzchu zzchuVar, JSONObject jSONObject) {
        this.zzgxm.zzd(zzebh.zzag(zzchuVar));
        if (!jSONObject.optBoolean("success")) {
            throw new zzamh("process json failed");
        }
        return zzebh.zzag(jSONObject.getJSONObject("json").getJSONArray("ads"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdpi zzdpiVar, zzdot zzdotVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzebh.immediateFailedFuture(new zzcnp(zzdqj.NO_FILL));
        }
        if (zzdpiVar.zzhns.zzfzg.zzhby > 1) {
            int length = jSONArray.length();
            this.zzgxm.ensureSize(Math.min(length, zzdpiVar.zzhns.zzfzg.zzhby));
            ArrayList arrayList = new ArrayList(zzdpiVar.zzhns.zzfzg.zzhby);
            for (int i = 0; i < zzdpiVar.zzhns.zzfzg.zzhby; i++) {
                if (i < length) {
                    arrayList.add(zzb(zzdpiVar, zzdotVar, jSONArray.getJSONObject(i)));
                } else {
                    arrayList.add(zzebh.immediateFailedFuture(new zzcnp(zzdqj.NO_FILL)));
                }
            }
            return zzebh.zzag(arrayList);
        }
        return zzebh.zzb(zzb(zzdpiVar, zzdotVar, jSONArray.getJSONObject(0)), zzcvt.zzebv, this.zzgka);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdot zzdotVar, zzchu zzchuVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbi)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzdotVar.zzhmh.zzgem);
        jSONObject2.put("sdk_params", jSONObject);
        return zzebh.zzb(zzchuVar.zzc("google.afma.nativeAds.preProcessJson", jSONObject2), new zzear(this, zzchuVar) { // from class: com.google.android.gms.internal.ads.zzcvq
            private final zzcvp zzgxj;
            private final zzchu zzgxn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxj = this;
                this.zzgxn = zzchuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgxj.zza(this.zzgxn, (JSONObject) obj);
            }
        }, this.zzgka);
    }
}
