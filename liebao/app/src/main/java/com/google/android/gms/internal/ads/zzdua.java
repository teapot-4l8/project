package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdua {
    private final Clock zzbqq;
    private final Map<String, List<String>> zzhus = new HashMap();
    private final Map<String, Long> zzhut = new HashMap();

    public zzdua(Clock clock) {
        this.zzbqq = clock;
    }

    public final void zzhb(String str) {
        if (this.zzhut.containsKey(str)) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.zzbqq.elapsedRealtime() - this.zzhut.remove(str).longValue());
            zzz(str, sb.toString());
            return;
        }
        this.zzhut.put(str, Long.valueOf(this.zzbqq.elapsedRealtime()));
    }

    public final void zzy(String str, String str2) {
        if (this.zzhut.containsKey(str)) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime() - this.zzhut.remove(str).longValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 20);
            sb.append(str2);
            sb.append(elapsedRealtime);
            zzz(str, sb.toString());
            return;
        }
        this.zzhut.put(str, Long.valueOf(this.zzbqq.elapsedRealtime()));
    }

    public final List<zzdud> zzayk() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.zzhus.entrySet()) {
            int i = 0;
            if (entry.getValue().size() > 1) {
                for (String str : entry.getValue()) {
                    String key = entry.getKey();
                    i++;
                    StringBuilder sb = new StringBuilder(String.valueOf(key).length() + 12);
                    sb.append(key);
                    sb.append(".");
                    sb.append(i);
                    arrayList.add(new zzdud(sb.toString(), str));
                }
            } else {
                arrayList.add(new zzdud(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return arrayList;
    }

    private final void zzz(String str, String str2) {
        if (!this.zzhus.containsKey(str)) {
            this.zzhus.put(str, new ArrayList());
        }
        this.zzhus.get(str).add(str2);
    }
}
