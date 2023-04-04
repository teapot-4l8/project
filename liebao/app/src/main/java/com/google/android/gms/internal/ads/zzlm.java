package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzlm {
    public final zzkh zzasz;
    public final zzlu zzbab = new zzlu();
    public zzls zzbac;
    public zzlg zzbad;
    public int zzbae;
    public int zzbaf;
    public int zzbag;
    public zzkk zzbah;
    public zzlr zzbai;

    public zzlm(zzkh zzkhVar) {
        this.zzasz = zzkhVar;
    }

    public final void zza(zzls zzlsVar, zzlg zzlgVar) {
        this.zzbac = (zzls) zzpg.checkNotNull(zzlsVar);
        this.zzbad = (zzlg) zzpg.checkNotNull(zzlgVar);
        this.zzasz.zze(zzlsVar.zzaij);
        reset();
    }

    public final void reset() {
        zzlu zzluVar = this.zzbab;
        zzluVar.zzbbc = 0;
        zzluVar.zzbbp = 0L;
        zzluVar.zzbbj = false;
        zzluVar.zzbbo = false;
        zzluVar.zzbbl = null;
        this.zzbae = 0;
        this.zzbag = 0;
        this.zzbaf = 0;
        this.zzbah = null;
        this.zzbai = null;
    }
}
