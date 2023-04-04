package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbng extends zzbne {
    private final Context context;
    private final View view;
    private final zzbfi zzdkm;
    private final Executor zzfur;
    private final zzdow zzfvv;
    private final zzbpd zzfww;
    private final zzcdy zzfwx;
    private final zzbzp zzfwy;
    private final zzeru<zzczg> zzfwz;
    private zzvt zzfxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbng(zzbpf zzbpfVar, Context context, zzdow zzdowVar, View view, zzbfi zzbfiVar, zzbpd zzbpdVar, zzcdy zzcdyVar, zzbzp zzbzpVar, zzeru<zzczg> zzeruVar, Executor executor) {
        super(zzbpfVar);
        this.context = context;
        this.view = view;
        this.zzdkm = zzbfiVar;
        this.zzfvv = zzdowVar;
        this.zzfww = zzbpdVar;
        this.zzfwx = zzcdyVar;
        this.zzfwy = zzbzpVar;
        this.zzfwz = zzeruVar;
        this.zzfur = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final View zzakl() {
        return this.view;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final void zza(ViewGroup viewGroup, zzvt zzvtVar) {
        zzbfi zzbfiVar;
        if (viewGroup == null || (zzbfiVar = this.zzdkm) == null) {
            return;
        }
        zzbfiVar.zza(zzbgx.zzb(zzvtVar));
        viewGroup.setMinimumHeight(zzvtVar.heightPixels);
        viewGroup.setMinimumWidth(zzvtVar.widthPixels);
        this.zzfxa = zzvtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final zzzd getVideoController() {
        try {
            return this.zzfww.getVideoController();
        } catch (zzdpq unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final zzdow zzakk() {
        boolean z;
        zzvt zzvtVar = this.zzfxa;
        if (zzvtVar != null) {
            return zzdpr.zzh(zzvtVar);
        }
        if (this.zzeux.zzhmu) {
            Iterator<String> it = this.zzeux.zzhly.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdow(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzdpr.zza(this.zzeux.zzhmg, this.zzfvv);
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final zzdow zzakt() {
        return this.zzfvv;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final int zzaku() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && this.zzeux.zzadh) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdag)).booleanValue()) {
                return 0;
            }
        }
        return this.zzftl.zzhnt.zzeuy.zzhnh;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final void zzkj() {
        this.zzfwy.zzanl();
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void zzakv() {
        this.zzfur.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbnj
            private final zzbng zzfxg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfxg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfxg.zzakw();
            }
        });
        super.zzakv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzakw() {
        if (this.zzfwx.zzapg() != null) {
            try {
                this.zzfwx.zzapg().zza(this.zzfwz.get(), ObjectWrapper.wrap(this.context));
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("RemoteException when notifyAdLoad is called", e2);
            }
        }
    }
}
