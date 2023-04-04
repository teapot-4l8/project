package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbeh implements Iterable<zzbef> {
    private final List<zzbef> zzerq = new ArrayList();

    public static boolean zzc(zzbcs zzbcsVar) {
        zzbef zzd = zzd(zzbcsVar);
        if (zzd != null) {
            zzd.zzerp.abort();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbef zzd(zzbcs zzbcsVar) {
        Iterator<zzbef> it = com.google.android.gms.ads.internal.zzr.zzlr().iterator();
        while (it.hasNext()) {
            zzbef next = it.next();
            if (next.zzekz == zzbcsVar) {
                return next;
            }
        }
        return null;
    }

    public final void zza(zzbef zzbefVar) {
        this.zzerq.add(zzbefVar);
    }

    public final void zzb(zzbef zzbefVar) {
        this.zzerq.remove(zzbefVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbef> iterator() {
        return this.zzerq.iterator();
    }
}
