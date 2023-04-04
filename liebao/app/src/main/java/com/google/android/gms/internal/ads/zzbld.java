package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbld {
    private final Executor executor;
    private final String zzbry;
    private final zzamx zzfug;
    private zzbli zzfuh;
    private final zzaig<Object> zzfui = new zzblc(this);
    private final zzaig<Object> zzfuj = new zzble(this);

    public zzbld(String str, zzamx zzamxVar, Executor executor) {
        this.zzbry = str;
        this.zzfug = zzamxVar;
        this.executor = executor;
    }

    public final void zza(zzbli zzbliVar) {
        this.zzfug.zzc("/updateActiveView", this.zzfui);
        this.zzfug.zzc("/untrackActiveViewUnit", this.zzfuj);
        this.zzfuh = zzbliVar;
    }

    public final void zza(zzbfi zzbfiVar) {
        zzbfiVar.zza("/updateActiveView", this.zzfui);
        zzbfiVar.zza("/untrackActiveViewUnit", this.zzfuj);
    }

    public final void zzb(zzbfi zzbfiVar) {
        zzbfiVar.zzb("/updateActiveView", this.zzfui);
        zzbfiVar.zzb("/untrackActiveViewUnit", this.zzfuj);
    }

    public final void zzajr() {
        this.zzfug.zzd("/updateActiveView", this.zzfui);
        this.zzfug.zzd("/untrackActiveViewUnit", this.zzfuj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzn(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzbry);
    }
}
