package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgc extends zzgn {
    private static final Object zzabf = new Object();
    private static volatile String zzabj;

    public zzgc(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        this.zzabg.zzac("E");
        if (zzabj == null) {
            synchronized (zzabf) {
                if (zzabj == null) {
                    zzabj = (String) this.zzabq.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabg) {
            this.zzabg.zzac(zzabj);
        }
    }
}
