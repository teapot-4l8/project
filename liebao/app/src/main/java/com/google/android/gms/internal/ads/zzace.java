package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes.dex */
public final class zzace {
    private final Map<String, zzacf> zzdcf = new HashMap();
    private final zzach zzdcg;

    public zzace(zzach zzachVar) {
        this.zzdcg = zzachVar;
    }

    public final void zza(String str, zzacf zzacfVar) {
        this.zzdcf.put(str, zzacfVar);
    }

    public final void zzb(String str, String str2, long j) {
        zzach zzachVar = this.zzdcg;
        zzacf zzacfVar = this.zzdcf.get(str2);
        String[] strArr = {str};
        if (zzachVar != null && zzacfVar != null) {
            zzachVar.zza(zzacfVar, j, strArr);
        }
        Map<String, zzacf> map = this.zzdcf;
        zzach zzachVar2 = this.zzdcg;
        map.put(str, zzachVar2 == null ? null : zzachVar2.zzex(j));
    }

    public final zzach zzsr() {
        return this.zzdcg;
    }
}
