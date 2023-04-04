package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeoj implements zzeog {
    @Override // com.google.android.gms.internal.ads.zzeog
    public final Map<?, ?> zzan(Object obj) {
        return (zzeoh) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzeog
    public final zzeoe<?, ?> zzas(Object obj) {
        zzeof zzeofVar = (zzeof) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzeog
    public final Map<?, ?> zzao(Object obj) {
        return (zzeoh) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzeog
    public final boolean zzap(Object obj) {
        return !((zzeoh) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzeog
    public final Object zzaq(Object obj) {
        ((zzeoh) obj).zzbhe();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzeog
    public final Object zzar(Object obj) {
        return zzeoh.zzbkr().zzbks();
    }

    @Override // com.google.android.gms.internal.ads.zzeog
    public final Object zzf(Object obj, Object obj2) {
        zzeoh zzeohVar = (zzeoh) obj;
        zzeoh zzeohVar2 = (zzeoh) obj2;
        if (!zzeohVar2.isEmpty()) {
            if (!zzeohVar.isMutable()) {
                zzeohVar = zzeohVar.zzbks();
            }
            zzeohVar.zza(zzeohVar2);
        }
        return zzeohVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeog
    public final int zzb(int i, Object obj, Object obj2) {
        zzeoh zzeohVar = (zzeoh) obj;
        zzeof zzeofVar = (zzeof) obj2;
        if (zzeohVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzeohVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw new NoSuchMethodError();
        }
        return 0;
    }
}
