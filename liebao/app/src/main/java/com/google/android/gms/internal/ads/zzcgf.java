package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcgf {
    private final Context context;
    private final Executor executor;
    private final zzbar zzbpx;
    private final zzaei zzdpr;
    private final zztz zzesy;
    private final zzei zzeus;
    private final ScheduledExecutorService zzftq;
    private final zzcfw zzgkm;
    private final com.google.android.gms.ads.internal.zzb zzgkn;
    private final zzcgs zzgko;

    public zzcgf(Context context, zzcfw zzcfwVar, zzei zzeiVar, zzbar zzbarVar, com.google.android.gms.ads.internal.zzb zzbVar, zztz zztzVar, Executor executor, zzdpm zzdpmVar, zzcgs zzcgsVar, ScheduledExecutorService scheduledExecutorService) {
        this.context = context;
        this.zzgkm = zzcfwVar;
        this.zzeus = zzeiVar;
        this.zzbpx = zzbarVar;
        this.zzgkn = zzbVar;
        this.zzesy = zztzVar;
        this.executor = executor;
        this.zzdpr = zzdpmVar.zzdpr;
        this.zzgko = zzcgsVar;
        this.zzftq = scheduledExecutorService;
    }

    public static List<zzzz> zzk(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzdza.zzbal();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzdza.zzbal();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzzz zzm = zzm(optJSONArray.optJSONObject(i));
            if (zzm != null) {
                arrayList.add(zzm);
            }
        }
        return zzdza.zzb(arrayList);
    }

    public static zzzz zzl(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzm(optJSONObject);
    }

    private static zzzz zzm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzzz(optString, optString2);
    }

    public final zzebt<zzaee> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdpr.zzdgx);
    }

    public final zzebt<List<zzaee>> zzd(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONArray(str), this.zzdpr.zzdgx, this.zzdpr.zzboe);
    }

    private final zzebt<List<zzaee>> zza(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzebh.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzebh.zzb(zzebh.zzi(arrayList), zzcge.zzebv, this.executor);
    }

    private final zzebt<zzaee> zza(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzebh.zzag(null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzebh.zzag(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzebh.zzag(new zzaee(null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzebh.zzb(this.zzgkm.zza(optString, optDouble, optBoolean), new zzdxw(optString, optDouble, optInt, optInt2) { // from class: com.google.android.gms.internal.ads.zzcgh
            private final String zzdmo;
            private final int zzehi;
            private final int zzehj;
            private final double zzgkq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = optString;
                this.zzgkq = optDouble;
                this.zzehi = optInt;
                this.zzehj = optInt2;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                String str = this.zzdmo;
                return new zzaee(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzgkq, this.zzehi, this.zzehj);
            }
        }, this.executor), (Object) null);
    }

    public final zzebt<zzaed> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzebh.zzag(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzebh.zzb(zza(optJSONArray, false, true), new zzdxw(this, optJSONObject) { // from class: com.google.android.gms.internal.ads.zzcgg
            private final JSONObject zzfvb;
            private final zzcgf zzgkp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkp = this;
                this.zzfvb = optJSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                return this.zzgkp.zza(this.zzfvb, (List) obj);
            }
        }, this.executor), (Object) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final zzebt<zzbfi> zzn(JSONObject jSONObject) {
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbh.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzebh.zzag(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Required field 'vast_xml' is missing");
                return zzebh.zzag(null);
            }
            return zza(zzebh.zza(this.zzgko.zzo(optJSONObject), ((Integer) zzww.zzra().zzd(zzabq.zzctt)).intValue(), TimeUnit.SECONDS, this.zzftq), (Object) null);
        }
        final zzebt<zzbfi> zzp = this.zzgko.zzp(zza.optString("base_url"), zza.optString("html"));
        return zzebh.zzb(zzp, new zzear(zzp) { // from class: com.google.android.gms.internal.ads.zzcgi
            private final zzebt zzgkr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkr = zzp;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                zzebt zzebtVar = this.zzgkr;
                zzbfi zzbfiVar = (zzbfi) obj;
                if (zzbfiVar == null || zzbfiVar.zzabv() == null) {
                    throw new zzcwo(zzdqj.INTERNAL_ERROR, "Retrieve video view in instream ad response failed.");
                }
                return zzebtVar;
            }
        }, zzbat.zzekj);
    }

    private static <T> zzebt<T> zza(zzebt<T> zzebtVar, T t) {
        return zzebh.zzb(zzebtVar, Exception.class, new zzear(null) { // from class: com.google.android.gms.internal.ads.zzcgl
            private final Object zzgks = null;

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                Object obj2 = this.zzgks;
                com.google.android.gms.ads.internal.util.zzd.zza("Error during loading assets.", (Exception) obj);
                return zzebh.zzag(obj2);
            }
        }, zzbat.zzekj);
    }

    private static <T> zzebt<T> zza(boolean z, zzebt<T> zzebtVar, T t) {
        if (z) {
            return zzebh.zzb(zzebtVar, new zzear(zzebtVar) { // from class: com.google.android.gms.internal.ads.zzcgk
                private final zzebt zzgkr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgkr = zzebtVar;
                }

                @Override // com.google.android.gms.internal.ads.zzear
                public final zzebt zzf(Object obj) {
                    return obj != null ? this.zzgkr : zzebh.immediateFailedFuture(new zzcwo(zzdqj.INTERNAL_ERROR, "Retrieve required value in native ad response failed."));
                }
            }, zzbat.zzekj);
        }
        return zza(zzebtVar, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, Object obj) {
        com.google.android.gms.ads.internal.zzr.zzkw();
        zzbfi zza = zzbfq.zza(this.context, zzbgx.zzafg(), "native-omid", false, false, this.zzeus, null, this.zzbpx, null, null, this.zzgkn, this.zzesy, null, null);
        zzbbb zzk = zzbbb.zzk(zza);
        zza.zzaef().zza(new zzbgt(zzk) { // from class: com.google.android.gms.internal.ads.zzcgn
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
        zza.loadData(str, "text/html", "UTF-8");
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzaed zza(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzaed(optString, list, zzf, zzf2, optInt > 0 ? Integer.valueOf(optInt) : null, jSONObject.optInt("presentation_ms", 4000) + optInt2, this.zzdpr.zzbof, optBoolean);
    }
}
