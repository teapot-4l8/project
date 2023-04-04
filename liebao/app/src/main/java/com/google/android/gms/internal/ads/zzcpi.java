package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcpi implements zzbvm {
    private final Context context;
    private final zzayd zzbrf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcpi(Context context, zzayd zzaydVar) {
        this.context = context;
        this.zzbrf = zzaydVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
        if (TextUtils.isEmpty(zzdpiVar.zzhnt.zzeuy.zzdyi)) {
            return;
        }
        this.zzbrf.zza(this.context, zzdpiVar.zzhns.zzfzg.zzhnx);
        this.zzbrf.zzi(this.context, zzdpiVar.zzhnt.zzeuy.zzdyi);
    }
}
