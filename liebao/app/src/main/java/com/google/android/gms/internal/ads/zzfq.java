package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfq extends zzgn {
    private static zzgq<String> zzabc = new zzgq<>();
    private final Context zzaba;

    public zzfq(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2, Context context) {
        super(zzfcVar, str, str2, zzbVar, i, 29);
        this.zzaba = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        this.zzabg.zzaf("E");
        AtomicReference<String> zzas = zzabc.zzas(this.zzaba.getPackageName());
        if (zzas.get() == null) {
            synchronized (zzas) {
                if (zzas.get() == null) {
                    zzas.set((String) this.zzabq.invoke(null, this.zzaba));
                }
            }
        }
        String str = zzas.get();
        synchronized (this.zzabg) {
            this.zzabg.zzaf(zzcy.zza(str.getBytes(), true));
        }
    }
}
