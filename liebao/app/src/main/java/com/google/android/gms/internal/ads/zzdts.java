package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdts implements zzdtt {
    private final Executor executor;
    private final zzbas zzeiw;

    public zzdts(Executor executor, zzbas zzbasVar) {
        this.executor = executor;
        this.zzeiw = zzbasVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtt
    public final void zzgw(String str) {
        this.executor.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzdtv
            private final String zzdkl;
            private final zzdts zzhuk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhuk = this;
                this.zzdkl = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhuk.zzgx(this.zzdkl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzgx(String str) {
        this.zzeiw.zzen(str);
    }
}
