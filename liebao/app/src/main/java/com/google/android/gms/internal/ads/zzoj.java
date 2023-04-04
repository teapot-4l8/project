package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzoj {
    public final zznu zzbih;
    public final zzoi zzbii;
    public final Object zzbij;
    public final zzia[] zzbik;

    public zzoj(zznu zznuVar, zzoi zzoiVar, Object obj, zzia[] zziaVarArr) {
        this.zzbih = zznuVar;
        this.zzbii = zzoiVar;
        this.zzbij = obj;
        this.zzbik = zziaVarArr;
    }

    public final boolean zza(zzoj zzojVar, int i) {
        return zzojVar != null && zzpt.zza(this.zzbii.zzbh(i), zzojVar.zzbii.zzbh(i)) && zzpt.zza(this.zzbik[i], zzojVar.zzbik[i]);
    }
}
