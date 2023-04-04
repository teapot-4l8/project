package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzcak {
    private final zzbfi zzdkm;
    private final zzcbr zzgdq;

    public zzcak(zzcbr zzcbrVar) {
        this(zzcbrVar, null);
    }

    public zzcak(zzcbr zzcbrVar, zzbfi zzbfiVar) {
        this.zzgdq = zzcbrVar;
        this.zzdkm = zzbfiVar;
    }

    public final zzcbr zzann() {
        return this.zzgdq;
    }

    public final zzbfi zzajy() {
        return this.zzdkm;
    }

    public final View zzano() {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            return zzbfiVar.getWebView();
        }
        return null;
    }

    public final View zzanp() {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar == null) {
            return null;
        }
        return zzbfiVar.getWebView();
    }

    public Set<zzbzl<zzbsy>> zzb(zzbrx zzbrxVar) {
        return Collections.singleton(zzbzl.zzb(zzbrxVar, zzbat.zzekj));
    }

    public Set<zzbzl<zzbza>> zzc(zzbrx zzbrxVar) {
        return Collections.singleton(zzbzl.zzb(zzbrxVar, zzbat.zzekj));
    }

    public final zzbzl<zzbwy> zzb(Executor executor) {
        final zzbfi zzbfiVar = this.zzdkm;
        return new zzbzl<>(new zzbwy(zzbfiVar) { // from class: com.google.android.gms.internal.ads.zzcam
            private final zzbfi zzewn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzewn = zzbfiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwy
            public final void zzakz() {
                zzbfi zzbfiVar2 = this.zzewn;
                if (zzbfiVar2.zzaeb() != null) {
                    zzbfiVar2.zzaeb().close();
                }
            }
        }, executor);
    }
}
