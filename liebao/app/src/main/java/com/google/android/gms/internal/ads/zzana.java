package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzana<I, O> implements zzear<I, O> {
    private final zzami<O> zzdmh;
    private final zzaml<I> zzdmi;
    private final String zzdmj;
    private final zzebt<zzamc> zzdmn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzana(zzebt<zzamc> zzebtVar, String str, zzaml<I> zzamlVar, zzami<O> zzamiVar) {
        this.zzdmn = zzebtVar;
        this.zzdmj = str;
        this.zzdmi = zzamlVar;
        this.zzdmh = zzamiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final zzebt<O> zzf(I i) {
        return zzebh.zzb(this.zzdmn, new zzear(this, i) { // from class: com.google.android.gms.internal.ads.zzand
            private final zzana zzdmr;
            private final Object zzdms;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmr = this;
                this.zzdms = i;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzdmr.zza(this.zzdms, (zzamc) obj);
            }
        }, zzbat.zzekj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(Object obj, zzamc zzamcVar) {
        zzbbe zzbbeVar = new zzbbe();
        com.google.android.gms.ads.internal.zzr.zzkv();
        String zzzr = com.google.android.gms.ads.internal.util.zzj.zzzr();
        zzahr.zzdiv.zza(zzzr, new zzanc(this, zzbbeVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzzr);
        jSONObject.put("args", this.zzdmi.zzi(obj));
        zzamcVar.zzb(this.zzdmj, jSONObject);
        return zzbbeVar;
    }
}
