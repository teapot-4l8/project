package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes.dex */
public final class zzach {
    private zzach zzdco;
    private final List<zzacf> zzdcm = new LinkedList();
    private final Map<String, String> zzdcn = new LinkedHashMap();
    private final Object lock = new Object();
    final boolean zzdcl = true;

    public zzach(boolean z, String str, String str2) {
        this.zzdcn.put("action", str);
        this.zzdcn.put("ad_format", str2);
    }

    public final void zzc(zzach zzachVar) {
        synchronized (this.lock) {
            this.zzdco = zzachVar;
        }
    }

    public final zzacf zzex(long j) {
        if (this.zzdcl) {
            return new zzacf(j, null, null);
        }
        return null;
    }

    public final boolean zza(zzacf zzacfVar, long j, String... strArr) {
        synchronized (this.lock) {
            for (String str : strArr) {
                this.zzdcm.add(new zzacf(j, str, zzacfVar));
            }
        }
        return true;
    }

    public final zzacg zzsw() {
        zzacg zzacgVar;
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.lock) {
            for (zzacf zzacfVar : this.zzdcm) {
                long time = zzacfVar.getTime();
                String zzss = zzacfVar.zzss();
                zzacf zzst = zzacfVar.zzst();
                if (zzst != null && time > 0) {
                    sb.append(zzss);
                    sb.append('.');
                    sb.append(time - zzst.getTime());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzst.getTime()))) {
                            hashMap.put(Long.valueOf(zzst.getTime()), new StringBuilder(zzss));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzst.getTime()));
                            sb2.append('+');
                            sb2.append(zzss);
                        }
                    }
                }
            }
            this.zzdcm.clear();
            String str = null;
            if (!TextUtils.isEmpty(null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis() + (((Long) entry.getKey()).longValue() - com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzacgVar = new zzacg(sb.toString(), str);
        }
        return zzacgVar;
    }

    public final void zzg(String str, String str2) {
        zzabx zzyf;
        if (!this.zzdcl || TextUtils.isEmpty(str2) || (zzyf = com.google.android.gms.ads.internal.zzr.zzkz().zzyf()) == null) {
            return;
        }
        synchronized (this.lock) {
            zzacb zzcq = zzyf.zzcq(str);
            Map<String, String> map = this.zzdcn;
            map.put(str, zzcq.zzf(map.get(str), str2));
        }
    }

    public final Map<String, String> zzsx() {
        synchronized (this.lock) {
            zzabx zzyf = com.google.android.gms.ads.internal.zzr.zzkz().zzyf();
            if (zzyf != null && this.zzdco != null) {
                return zzyf.zza(this.zzdcn, this.zzdco.zzsx());
            }
            return this.zzdcn;
        }
    }
}
