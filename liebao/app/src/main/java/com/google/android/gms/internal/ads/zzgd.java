package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgd extends zzgn {
    private List<Long> zzabk;

    public zzgd(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 31);
        this.zzabk = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        this.zzabg.zzax(-1L);
        this.zzabg.zzay(-1L);
        if (this.zzabk == null) {
            this.zzabk = (List) this.zzabq.invoke(null, this.zzwh.getContext());
        }
        List<Long> list = this.zzabk;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.zzabg) {
            this.zzabg.zzax(this.zzabk.get(0).longValue());
            this.zzabg.zzay(this.zzabk.get(1).longValue());
        }
    }
}
