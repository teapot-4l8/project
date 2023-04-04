package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwk {
    private final Clock zzbqq;
    private final zzctc zzfzp;
    private final zzcwm zzgxy;
    private final List<String> zzgxz = Collections.synchronizedList(new ArrayList());
    private final boolean zzgya = ((Boolean) zzww.zzra().zzd(zzabq.zzczv)).booleanValue();

    public zzcwk(Clock clock, zzcwm zzcwmVar, zzctc zzctcVar) {
        this.zzbqq = clock;
        this.zzgxy = zzcwmVar;
        this.zzfzp = zzctcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> zzebt<T> zza(zzdoy zzdoyVar, zzdot zzdotVar, zzebt<T> zzebtVar) {
        long elapsedRealtime = this.zzbqq.elapsedRealtime();
        String str = zzdotVar.zzdnw;
        if (str != null) {
            zzebh.zza(zzebtVar, new zzcwn(this, elapsedRealtime, str, zzdotVar, zzdoyVar), zzbat.zzekj);
        }
        return zzebtVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.zzgxz.add(sb2);
    }

    public final String zzasy() {
        return TextUtils.join("_", this.zzgxz);
    }
}
