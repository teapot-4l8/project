package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzcmj {
    private final Executor executor;
    private final boolean zzdcl;
    protected final zzbas zzeiw;
    private final zzdug zzgoq;
    private final String zzdbu = zzadg.zzdec.get();
    protected final Map<String, String> zzgof = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcmj(Executor executor, zzbas zzbasVar, zzdug zzdugVar) {
        boolean z;
        this.executor = executor;
        this.zzeiw = zzbasVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue()) {
            z = ((Boolean) zzww.zzra().zzd(zzabq.zzcse)).booleanValue();
        } else {
            z = ((double) zzww.zzrd().nextFloat()) <= zzadg.zzdeb.get().doubleValue();
        }
        this.zzdcl = z;
        this.zzgoq = zzdugVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzarr();

    public final void zzo(Map<String, String> map) {
        final String zzp = zzp(map);
        if (this.zzdcl) {
            this.executor.execute(new Runnable(this, zzp) { // from class: com.google.android.gms.internal.ads.zzcmi
                private final String zzdkl;
                private final zzcmj zzgop;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgop = this;
                    this.zzdkl = zzp;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcmj zzcmjVar = this.zzgop;
                    zzcmjVar.zzeiw.zzen(this.zzdkl);
                }
            });
        }
        com.google.android.gms.ads.internal.util.zzd.zzed(zzp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzp(Map<String, String> map) {
        return this.zzgoq.zzr(map);
    }
}
