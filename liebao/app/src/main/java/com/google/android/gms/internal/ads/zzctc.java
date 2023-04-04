package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzctc {
    private zzdot zzeux = null;
    private final Map<String, zzvx> zzgvl = Collections.synchronizedMap(new HashMap());
    private final List<zzvx> zzaed = Collections.synchronizedList(new ArrayList());

    public final void zzd(zzdot zzdotVar) {
        String str = zzdotVar.zzdnw;
        if (this.zzgvl.containsKey(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = zzdotVar.zzhmk.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                bundle.putString(next, zzdotVar.zzhmk.getString(next));
            } catch (JSONException unused) {
            }
        }
        zzvx zzvxVar = new zzvx(zzdotVar.zzhmo, 0L, null, bundle);
        this.zzaed.add(zzvxVar);
        this.zzgvl.put(str, zzvxVar);
    }

    public final void zza(zzdot zzdotVar, long j, zzvh zzvhVar) {
        String str = zzdotVar.zzdnw;
        if (this.zzgvl.containsKey(str)) {
            if (this.zzeux == null) {
                this.zzeux = zzdotVar;
            }
            zzvx zzvxVar = this.zzgvl.get(str);
            zzvxVar.zzcjb = j;
            zzvxVar.zzcjc = zzvhVar;
        }
    }

    public final zzbsp zzasu() {
        return new zzbsp(this.zzeux, "", this);
    }

    public final List<zzvx> getAdapterResponses() {
        return this.zzaed;
    }
}
