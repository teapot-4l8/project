package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzna implements zznd, zzne {
    private final Uri uri;
    private final Handler zzafa;
    private zzid zzafl;
    private final int zzbdw;
    private final zzmz zzbdx;
    private zznd zzbdy;
    private final zzoq zzbfe;
    private final zzkb zzbff;
    private final int zzbfg;
    private boolean zzbfh;
    private final String zzbea = null;
    private final zzif zzafe = new zzif();

    public zzna(Uri uri, zzoq zzoqVar, zzkb zzkbVar, int i, Handler handler, zzmz zzmzVar, String str, int i2) {
        this.uri = uri;
        this.zzbfe = zzoqVar;
        this.zzbff = zzkbVar;
        this.zzbdw = i;
        this.zzafa = handler;
        this.zzbdx = zzmzVar;
        this.zzbfg = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzid() {
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zza(zzhh zzhhVar, boolean z, zznd zzndVar) {
        this.zzbdy = zzndVar;
        zzns zznsVar = new zzns(-9223372036854775807L, false);
        this.zzafl = zznsVar;
        zzndVar.zzb(zznsVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final zznc zza(int i, zzol zzolVar) {
        zzpg.checkArgument(i == 0);
        return new zzms(this.uri, this.zzbfe.zzit(), this.zzbff.zzgv(), this.zzbdw, this.zzafa, this.zzbdx, this, zzolVar, null, this.zzbfg);
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzb(zznc zzncVar) {
        ((zzms) zzncVar).release();
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzie() {
        this.zzbdy = null;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final void zzb(zzid zzidVar, Object obj) {
        boolean z = zzidVar.zza(0, this.zzafe, false).zzaiz != -9223372036854775807L;
        if (!this.zzbfh || z) {
            this.zzafl = zzidVar;
            this.zzbfh = z;
            this.zzbdy.zzb(zzidVar, null);
        }
    }
}
