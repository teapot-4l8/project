package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcov {
    private final Context context;
    private final Executor executor;
    private final zzdpm zzfzg;
    private final zzbar zzgra;

    public zzcov(Context context, zzbar zzbarVar, zzdpm zzdpmVar, Executor executor) {
        this.context = context;
        this.zzgra = zzbarVar;
        this.zzfzg = zzdpmVar;
        this.executor = executor;
    }

    public final zzebt<zzdpi> zzasl() {
        zzamg zza = com.google.android.gms.ads.internal.zzr.zzli().zzb(this.context, this.zzgra).zza("google.afma.response.normalize", zzamn.zzdma, zzamn.zzdma);
        zzvf zzvfVar = this.zzfzg.zzhnx.zzcip;
        if (!zza(zzvfVar)) {
            return zzebh.immediateFailedFuture(new zzcwo(zzdqj.REQUEST_ID_MISMATCH, "Mismatch request IDs."));
        }
        return zzebh.zzb(zzebh.zzb(zzebh.zzb(zzebh.zzag(""), new zzear(this, zzvfVar) { // from class: com.google.android.gms.internal.ads.zzcou
            private final zzcov zzgqy;
            private final zzvf zzgqz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqy = this;
                this.zzgqz = zzvfVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                zzvf zzvfVar2 = this.zzgqz;
                String str = (String) obj;
                String str2 = zzvfVar2.zzchp;
                String str3 = zzvfVar2.zzchq;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("headers", new JSONObject());
                jSONObject3.put("body", str2);
                jSONObject2.put("base_url", "");
                jSONObject2.put("signals", new JSONObject(str3));
                jSONObject.put("request", jSONObject2);
                jSONObject.put("response", jSONObject3);
                jSONObject.put("flags", new JSONObject());
                return zzebh.zzag(jSONObject);
            }
        }, this.executor), new zzear(zza) { // from class: com.google.android.gms.internal.ads.zzcox
            private final zzamg zzgrb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrb = zza;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgrb.zzh((JSONObject) obj);
            }
        }, this.executor), new zzear(this) { // from class: com.google.android.gms.internal.ads.zzcow
            private final zzcov zzgqy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqy = this;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgqy.zzp((JSONObject) obj);
            }
        }, this.executor);
    }

    private static boolean zza(zzvf zzvfVar) {
        String optString;
        String optString2;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczy)).booleanValue()) {
            if (zzvfVar == null) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(zzvfVar.zzchp);
                JSONObject jSONObject2 = new JSONObject(zzvfVar.zzchq);
                optString = jSONObject.optString("request_id", "");
                optString2 = jSONObject2.optString("request_id", "");
            } catch (JSONException unused) {
            }
            return !TextUtils.isEmpty(optString2) && optString.equals(optString2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzp(JSONObject jSONObject) {
        return zzebh.zzag(new zzdpi(new zzdpd(this.zzfzg), zzdpg.zza(new StringReader(jSONObject.toString()))));
    }
}
