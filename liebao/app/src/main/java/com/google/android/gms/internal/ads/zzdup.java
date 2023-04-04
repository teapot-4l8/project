package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdup {
    private final Executor executor;
    private final zzbas zzhuz;

    public zzdup(Executor executor, zzbas zzbasVar) {
        this.executor = executor;
        this.zzhuz = zzbasVar;
    }

    public final void zzk(List<String> list) {
        for (String str : list) {
            zzen(str);
        }
    }

    public final void zzen(String str) {
        this.executor.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzduo
            private final String zzdkl;
            private final zzdup zzhol;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhol = this;
                this.zzdkl = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhol.zzhd(this.zzdkl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzhd(String str) {
        this.zzhuz.zzen(str);
    }
}
