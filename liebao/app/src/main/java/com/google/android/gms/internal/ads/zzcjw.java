package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjw {
    private final Map<String, zzcjx> zzgmt = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzdqd zzdqdVar) {
        if (this.zzgmt.containsKey(str)) {
            return;
        }
        try {
            this.zzgmt.put(str, new zzcjx(str, zzdqdVar.zzvm(), zzdqdVar.zzvn()));
        } catch (zzdpq unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzaqa zzaqaVar) {
        if (this.zzgmt.containsKey(str)) {
            return;
        }
        try {
            this.zzgmt.put(str, new zzcjx(str, zzaqaVar.zzvm(), zzaqaVar.zzvn()));
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private final synchronized zzcjx zzge(String str) {
        return this.zzgmt.get(str);
    }

    @Nullable
    public final zzcjx zzi(List<String> list) {
        for (String str : list) {
            zzcjx zzge = zzge(str);
            if (zzge != null) {
                return zzge;
            }
        }
        return null;
    }
}
