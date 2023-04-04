package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzadc;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzdgv;
import com.google.android.gms.internal.ads.zzvq;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzs {
    private final Context context;
    private final String zzbrj;
    private final Map<String, String> zzbrk = new TreeMap();
    private String zzbrl;
    private String zzbrm;

    public zzs(Context context, String str) {
        this.context = context.getApplicationContext();
        this.zzbrj = str;
    }

    public final String zzlu() {
        return this.zzbrm;
    }

    public final String getQuery() {
        return this.zzbrl;
    }

    public final String zzlv() {
        return this.zzbrj;
    }

    public final Map<String, String> zzlw() {
        return this.zzbrk;
    }

    public final void zza(zzvq zzvqVar, zzbar zzbarVar) {
        this.zzbrl = zzvqVar.zzcif.zzbrl;
        Bundle bundle = zzvqVar.zzcih != null ? zzvqVar.zzcih.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle == null) {
            return;
        }
        String str = zzadc.zzddt.get();
        for (String str2 : bundle.keySet()) {
            if (str.equals(str2)) {
                this.zzbrm = bundle.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.zzbrk.put(str2.substring(4), bundle.getString(str2));
            }
        }
        this.zzbrk.put("SDKVersion", zzbarVar.zzbrz);
        if (zzadc.zzddr.get().booleanValue()) {
            try {
                Bundle zza = zzdgv.zza(this.context, new JSONArray(zzadc.zzdds.get()));
                for (String str3 : zza.keySet()) {
                    this.zzbrk.put(str3, zza.get(str3).toString());
                }
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e2);
            }
        }
    }
}
