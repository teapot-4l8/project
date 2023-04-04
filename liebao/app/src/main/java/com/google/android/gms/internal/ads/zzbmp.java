package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbmp extends zzbpc {
    private final View view;
    private final zzbfi zzdkm;
    private final zzdow zzfvv;
    private final int zzfvw;
    private final boolean zzfvx;
    private final boolean zzfvy;
    private zzsv zzfwk;
    private final zzbme zzfwl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmp(zzbpf zzbpfVar, View view, zzbfi zzbfiVar, zzdow zzdowVar, int i, boolean z, boolean z2, zzbme zzbmeVar) {
        super(zzbpfVar);
        this.view = view;
        this.zzdkm = zzbfiVar;
        this.zzfvv = zzdowVar;
        this.zzfvw = i;
        this.zzfvx = z;
        this.zzfvy = z2;
        this.zzfwl = zzbmeVar;
    }

    public final zzdow zzakk() {
        return zzdpr.zza(this.zzeux.zzhmg, this.zzfvv);
    }

    public final View zzakl() {
        return this.view;
    }

    public final int zzakb() {
        return this.zzfvw;
    }

    public final boolean zzakc() {
        return this.zzfvx;
    }

    public final boolean zzakd() {
        return this.zzfvy;
    }

    public final boolean zzadm() {
        zzbfi zzbfiVar = this.zzdkm;
        return (zzbfiVar == null || zzbfiVar.zzaef() == null || !this.zzdkm.zzaef().zzadm()) ? false : true;
    }

    public final boolean zzakm() {
        zzbfi zzbfiVar = this.zzdkm;
        return zzbfiVar != null && zzbfiVar.zzaeh();
    }

    public final void zza(zzsi zzsiVar) {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            zzbfiVar.zza(zzsiVar);
        }
    }

    public final void zza(zzsv zzsvVar) {
        this.zzfwk = zzsvVar;
    }

    public final zzsv zzakn() {
        return this.zzfwk;
    }

    public final void zzb(long j, int i) {
        this.zzfwl.zzb(j, i);
    }
}
