package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcvf implements zzcbr {
    private zzbtl zzgah = null;
    private final zzdot zzgai;
    private final zzaqa zzgxf;
    private final boolean zzgxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcvf(zzdot zzdotVar, zzaqa zzaqaVar, boolean z) {
        this.zzgai = zzdotVar;
        this.zzgxf = zzaqaVar;
        this.zzgxg = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zza(boolean z, Context context) {
        boolean zzaa;
        try {
            if (this.zzgxg) {
                zzaa = this.zzgxf.zzab(ObjectWrapper.wrap(context));
            } else {
                zzaa = this.zzgxf.zzaa(ObjectWrapper.wrap(context));
            }
            if (!zzaa) {
                throw new zzcbq("Adapter failed to show.");
            }
            if (this.zzgah == null) {
                return;
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcrt)).booleanValue() || this.zzgai.zzhmt != 2) {
                return;
            }
            this.zzgah.onAdImpression();
        } catch (Throwable th) {
            throw new zzcbq(th);
        }
    }

    public final void zza(zzbtl zzbtlVar) {
        this.zzgah = zzbtlVar;
    }
}
