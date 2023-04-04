package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgm extends zzgn {
    private final View zzaay;

    public zzgm(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2, View view) {
        super(zzfcVar, str, str2, zzbVar, i, 57);
        this.zzaay = view;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        if (this.zzaay != null) {
            Boolean bool = (Boolean) zzww.zzra().zzd(zzabq.zzctg);
            zzfk zzfkVar = new zzfk((String) this.zzabq.invoke(null, this.zzaay, this.zzwh.getContext().getResources().getDisplayMetrics(), bool));
            zzcf.zza.zzg.C0107zza zzax = zzcf.zza.zzg.zzax();
            zzax.zzdc(zzfkVar.zzaas.longValue()).zzdd(zzfkVar.zzaat.longValue()).zzde(zzfkVar.zzaau.longValue());
            if (bool.booleanValue()) {
                zzax.zzdf(zzfkVar.zzaav.longValue());
            }
            this.zzabg.zzb((zzcf.zza.zzg) ((zzena) zzax.zzbjv()));
        }
    }
}
