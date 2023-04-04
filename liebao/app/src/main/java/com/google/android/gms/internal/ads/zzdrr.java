package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdrr<AdT extends zzbpc> {
    private final zzdqz zzhkm;
    private final zzdqs zzhrr;
    private zzdrx zzhrs;
    private zzecb<zzdrj<AdT>> zzhrt;
    private zzebt<zzdrj<AdT>> zzhru;
    private final zzdru<AdT> zzhrw;
    private int zzhrv = zzdrw.zzhsb;
    private final zzebi<zzdrj<AdT>> zzhry = new zzdrs(this);
    private final LinkedList<zzdrx> zzhrx = new LinkedList<>();

    public zzdrr(zzdqz zzdqzVar, zzdqs zzdqsVar, zzdru<AdT> zzdruVar) {
        this.zzhkm = zzdqzVar;
        this.zzhrr = zzdqsVar;
        this.zzhrw = zzdruVar;
        this.zzhrr.zza(new zzdqv(this) { // from class: com.google.android.gms.internal.ads.zzdrt
            private final zzdrr zzhrq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhrq = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdqv
            public final void execute() {
                this.zzhrq.zzaxk();
            }
        });
    }

    public final void zzb(zzdrx zzdrxVar) {
        this.zzhrx.add(zzdrxVar);
    }

    public final synchronized zzebt<zzdrv<AdT>> zzc(zzdrx zzdrxVar) {
        if (zzaxj()) {
            return null;
        }
        this.zzhrv = zzdrw.zzhsd;
        if (this.zzhrs.zzavp() != null && zzdrxVar.zzavp() != null && this.zzhrs.zzavp().equals(zzdrxVar.zzavp())) {
            this.zzhrv = zzdrw.zzhsc;
            return zzebh.zzb(this.zzhrt, new zzear(this) { // from class: com.google.android.gms.internal.ads.zzdrq
                private final zzdrr zzhrq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhrq = this;
                }

                @Override // com.google.android.gms.internal.ads.zzear
                public final zzebt zzf(Object obj) {
                    return this.zzhrq.zzc((zzdrj) obj);
                }
            }, zzdrxVar.getExecutor());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(zzdrx zzdrxVar) {
        while (zzaxj()) {
            if (zzdrxVar == null && this.zzhrx.isEmpty()) {
                return;
            }
            if (zzdrxVar == null) {
                zzdrxVar = this.zzhrx.remove();
            }
            if (zzdrxVar.zzavp() != null && this.zzhkm.zzb(zzdrxVar.zzavp())) {
                this.zzhrs = zzdrxVar.zzavq();
                this.zzhrt = zzecb.zzbbf();
                zzebt<zzdrj<AdT>> zza = this.zzhrw.zza(this.zzhrs);
                this.zzhru = zza;
                zzebh.zza(zza, this.zzhry, zzdrxVar.getExecutor());
                return;
            }
            zzdrxVar = null;
        }
        if (zzdrxVar != null) {
            this.zzhrx.add(zzdrxVar);
        }
    }

    private final boolean zzaxj() {
        zzebt<zzdrj<AdT>> zzebtVar = this.zzhru;
        return zzebtVar == null || zzebtVar.isDone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaxk() {
        synchronized (this) {
            zzd(this.zzhrs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzc(zzdrj zzdrjVar) {
        zzebt zzag;
        synchronized (this) {
            zzag = zzebh.zzag(new zzdrv(zzdrjVar, this.zzhrs));
        }
        return zzag;
    }
}
