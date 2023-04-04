package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpi {
    public final List<? extends zzebt<? extends zzbpc>> zzfys;

    public zzbpi(List<? extends zzebt<? extends zzbpc>> list) {
        this.zzfys = list;
    }

    public zzbpi(zzbpc zzbpcVar) {
        this.zzfys = Collections.singletonList(zzebh.zzag(zzbpcVar));
    }

    public static zzcsz<zzbpi> zza(zzcvm<? extends zzbpc> zzcvmVar) {
        return new zzcsy(zzcvmVar, zzbpl.zzebv);
    }

    public static zzcsz<zzbpi> zza(zzcsz<? extends zzbpc> zzcszVar) {
        return new zzcsy(zzcszVar, zzbpk.zzebv);
    }
}
