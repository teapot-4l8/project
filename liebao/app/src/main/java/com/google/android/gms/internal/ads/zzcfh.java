package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcfh implements zzaig {
    static final zzaig zzdif = new zzcfh();

    private zzcfh() {
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zzd.zzdz("Show native ad policy validator overlay.");
        ((zzbfi) obj).getView().setVisibility(0);
    }
}
