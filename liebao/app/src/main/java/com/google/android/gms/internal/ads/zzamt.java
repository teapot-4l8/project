package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzamt<I, O> implements zzamg<I, O> {
    private final zzale zzdme;
    private final zzami<O> zzdmh;
    private final zzaml<I> zzdmi;
    private final String zzdmj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamt(zzale zzaleVar, String str, zzaml<I> zzamlVar, zzami<O> zzamiVar) {
        this.zzdme = zzaleVar;
        this.zzdmj = str;
        this.zzdmi = zzamlVar;
        this.zzdmh = zzamiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final zzebt<O> zzh(I i) {
        zzbbe zzbbeVar = new zzbbe();
        zzalv zzb = this.zzdme.zzb((zzei) null);
        zzb.zza(new zzams(this, zzb, i, zzbbeVar), new zzamv(this, zzbbeVar, zzb));
        return zzbbeVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzalv zzalvVar, zzamc zzamcVar, I i, zzbbe<O> zzbbeVar) {
        try {
            com.google.android.gms.ads.internal.zzr.zzkv();
            String zzzr = com.google.android.gms.ads.internal.util.zzj.zzzr();
            zzahr.zzdiv.zza(zzzr, new zzamu(this, zzalvVar, zzbbeVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzzr);
            jSONObject.put("args", this.zzdmi.zzi(i));
            zzamcVar.zzb(this.zzdmj, jSONObject);
        } catch (Exception e2) {
            try {
                zzbbeVar.setException(e2);
                com.google.android.gms.ads.internal.util.zzd.zzc("Unable to invokeJavascript", e2);
            } finally {
                zzalvVar.release();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final zzebt<O> zzf(I i) {
        return zzh(i);
    }
}
