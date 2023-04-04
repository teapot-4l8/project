package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqs {
    private zzdqv zzhpo = null;
    private zzdqv zzhpp = null;
    private zzdqv zzhpq = null;
    private zzdqv zzhpr = null;
    private zzdqv zzhps = null;
    private zzdqv zzhpt = null;
    private zzdqv zzhpu = null;
    private zzdqv zzhpv = null;

    public final void zza(zzdqv zzdqvVar) {
        this.zzhpr = zzdqvVar;
    }

    public final void onAdClosed() {
        zzdqv zzdqvVar = this.zzhpr;
        if (zzdqvVar != null) {
            zzdqvVar.execute();
        }
    }
}
