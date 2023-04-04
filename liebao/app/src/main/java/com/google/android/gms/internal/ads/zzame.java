package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzame implements zzakq, zzamf {
    private final zzamc zzdlt;
    private final HashSet<AbstractMap.SimpleEntry<String, zzaig<? super zzamc>>> zzdlu = new HashSet<>();

    public zzame(zzamc zzamcVar) {
        this.zzdlt = zzamcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, Map map) {
        zzakt.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakq, com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, JSONObject jSONObject) {
        zzakt.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, JSONObject jSONObject) {
        zzakt.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakq
    public final void zzi(String str, String str2) {
        zzakt.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakq, com.google.android.gms.internal.ads.zzalf
    public final void zzcv(String str) {
        this.zzdlt.zzcv(str);
    }

    @Override // com.google.android.gms.internal.ads.zzamc
    public final void zza(String str, zzaig<? super zzamc> zzaigVar) {
        this.zzdlt.zza(str, zzaigVar);
        this.zzdlu.add(new AbstractMap.SimpleEntry<>(str, zzaigVar));
    }

    @Override // com.google.android.gms.internal.ads.zzamc
    public final void zzb(String str, zzaig<? super zzamc> zzaigVar) {
        this.zzdlt.zzb(str, zzaigVar);
        this.zzdlu.remove(new AbstractMap.SimpleEntry(str, zzaigVar));
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzva() {
        Iterator<AbstractMap.SimpleEntry<String, zzaig<? super zzamc>>> it = this.zzdlu.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzaig<? super zzamc>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdlt.zzb(next.getKey(), next.getValue());
        }
        this.zzdlu.clear();
    }
}
