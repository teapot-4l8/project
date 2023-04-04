package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcgb {
    private final zzebs zzgka;
    private final zzcgf zzgkb;
    private final zzcgp zzgkc;

    public zzcgb(zzebs zzebsVar, zzcgf zzcgfVar, zzcgp zzcgpVar) {
        this.zzgka = zzebsVar;
        this.zzgkb = zzcgfVar;
        this.zzgkc = zzcgpVar;
    }

    public final zzebt<zzcdr> zza(final zzdpi zzdpiVar, final zzdot zzdotVar, final JSONObject jSONObject) {
        zzebt zzb;
        final zzebt zze = this.zzgka.zze(new Callable(this, zzdpiVar, zzdotVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcga
            private final zzdot zzfxi;
            private final zzcgb zzgjx;
            private final zzdpi zzgjy;
            private final JSONObject zzgjz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjx = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
                this.zzgjz = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdpi zzdpiVar2 = this.zzgjy;
                zzdot zzdotVar2 = this.zzfxi;
                JSONObject jSONObject2 = this.zzgjz;
                zzcdr zzcdrVar = new zzcdr();
                zzcdrVar.zzeh(jSONObject2.optInt("template_id", -1));
                zzcdrVar.zzfy(jSONObject2.optString("custom_template_id"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
                zzcdrVar.zzfz(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
                zzdpm zzdpmVar = zzdpiVar2.zzhns.zzfzg;
                if (!zzdpmVar.zzhnz.contains(Integer.toString(zzcdrVar.zzaoo()))) {
                    zzdqj zzdqjVar = zzdqj.INTERNAL_ERROR;
                    int zzaoo = zzcdrVar.zzaoo();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Invalid template ID: ");
                    sb.append(zzaoo);
                    throw new zzcwo(zzdqjVar, sb.toString());
                }
                if (zzcdrVar.zzaoo() == 3) {
                    if (zzcdrVar.getCustomTemplateId() == null) {
                        throw new zzcwo(zzdqj.INTERNAL_ERROR, "No custom template id for custom template ad response.");
                    }
                    if (!zzdpmVar.zzhoa.contains(zzcdrVar.getCustomTemplateId())) {
                        throw new zzcwo(zzdqj.INTERNAL_ERROR, "Unexpected custom template id in the response.");
                    }
                }
                zzcdrVar.setStarRating(jSONObject2.optDouble("rating", -1.0d));
                String optString = jSONObject2.optString("headline", null);
                if (zzdotVar2.zzead) {
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    String zzzu = com.google.android.gms.ads.internal.util.zzj.zzzu();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(zzzu).length() + 3 + String.valueOf(optString).length());
                    sb2.append(zzzu);
                    sb2.append(" : ");
                    sb2.append(optString);
                    optString = sb2.toString();
                }
                zzcdrVar.zzo("headline", optString);
                zzcdrVar.zzo("body", jSONObject2.optString("body", null));
                zzcdrVar.zzo("call_to_action", jSONObject2.optString("call_to_action", null));
                zzcdrVar.zzo("store", jSONObject2.optString("store", null));
                zzcdrVar.zzo("price", jSONObject2.optString("price", null));
                zzcdrVar.zzo("advertiser", jSONObject2.optString("advertiser", null));
                return zzcdrVar;
            }
        });
        final zzebt<List<zzaee>> zzd = this.zzgkb.zzd(jSONObject, "images");
        final zzebt<zzaee> zzc = this.zzgkb.zzc(jSONObject, "secondary_image");
        final zzebt<zzaee> zzc2 = this.zzgkb.zzc(jSONObject, "app_icon");
        final zzebt<zzaed> zze2 = this.zzgkb.zze(jSONObject, "attribution");
        final zzebt<zzbfi> zzn = this.zzgkb.zzn(jSONObject);
        zzcgf zzcgfVar = this.zzgkb;
        if (!jSONObject.optBoolean("enable_omid")) {
            zzb = zzebh.zzag(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzb = zzebh.zzag(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzb = zzebh.zzag(null);
                } else {
                    zzb = zzebh.zzb(zzebh.zzag(null), new zzear(zzcgfVar, optString) { // from class: com.google.android.gms.internal.ads.zzcgj
                        private final String zzdkl;
                        private final zzcgf zzgkp;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgkp = zzcgfVar;
                            this.zzdkl = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzear
                        public final zzebt zzf(Object obj) {
                            return this.zzgkp.zza(this.zzdkl, obj);
                        }
                    }, zzbat.zzeki);
                }
            }
        }
        final zzebt zzebtVar = zzb;
        final zzebt<List<zzcgq>> zzg = this.zzgkc.zzg(jSONObject, "custom_assets");
        return zzebh.zza(zze, zzd, zzc, zzc2, zze2, zzn, zzebtVar, zzg).zzb(new Callable(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzn, zzebtVar, zzg) { // from class: com.google.android.gms.internal.ads.zzcgd
            private final zzebt zzfyy;
            private final zzebt zzgbc;
            private final zzcgb zzgjx;
            private final zzebt zzgkf;
            private final zzebt zzgkg;
            private final zzebt zzgkh;
            private final JSONObject zzgki;
            private final zzebt zzgkj;
            private final zzebt zzgkk;
            private final zzebt zzgkl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjx = this;
                this.zzgbc = zze;
                this.zzfyy = zzd;
                this.zzgkf = zzc2;
                this.zzgkg = zzc;
                this.zzgkh = zze2;
                this.zzgki = jSONObject;
                this.zzgkj = zzn;
                this.zzgkk = zzebtVar;
                this.zzgkl = zzg;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzebt zzebtVar2 = this.zzgbc;
                zzebt zzebtVar3 = this.zzfyy;
                zzebt zzebtVar4 = this.zzgkf;
                zzebt zzebtVar5 = this.zzgkg;
                zzebt zzebtVar6 = this.zzgkh;
                JSONObject jSONObject2 = this.zzgki;
                zzebt zzebtVar7 = this.zzgkj;
                zzebt zzebtVar8 = this.zzgkk;
                zzebt zzebtVar9 = this.zzgkl;
                zzcdr zzcdrVar = (zzcdr) zzebtVar2.get();
                zzcdrVar.setImages((List) zzebtVar3.get());
                zzcdrVar.zza((zzaes) zzebtVar4.get());
                zzcdrVar.zzb((zzaes) zzebtVar5.get());
                zzcdrVar.zza((zzaek) zzebtVar6.get());
                zzcdrVar.zzh(zzcgf.zzk(jSONObject2));
                zzcdrVar.zza(zzcgf.zzl(jSONObject2));
                zzbfi zzbfiVar = (zzbfi) zzebtVar7.get();
                if (zzbfiVar != null) {
                    zzcdrVar.zzf(zzbfiVar);
                    zzcdrVar.zzac(zzbfiVar.getView());
                    zzcdrVar.zzb(zzbfiVar.zzabv());
                }
                zzbfi zzbfiVar2 = (zzbfi) zzebtVar8.get();
                if (zzbfiVar2 != null) {
                    zzcdrVar.zzg(zzbfiVar2);
                }
                for (zzcgq zzcgqVar : (List) zzebtVar9.get()) {
                    int i = zzcgqVar.type;
                    if (i == 1) {
                        zzcdrVar.zzo(zzcgqVar.zzcm, zzcgqVar.zzdsn);
                    } else if (i == 2) {
                        zzcdrVar.zza(zzcgqVar.zzcm, zzcgqVar.zzgkv);
                    }
                }
                return zzcdrVar;
            }
        }, this.zzgka);
    }
}
