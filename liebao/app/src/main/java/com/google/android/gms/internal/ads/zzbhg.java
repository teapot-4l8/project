package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbhg {
    private final Context zzaai;
    private final zzbar zzbpj;
    private final WeakReference<Context> zzeyg;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static class zza {
        private Context zzaai;
        private zzbar zzbpj;
        private WeakReference<Context> zzeyg;

        public final zza zza(zzbar zzbarVar) {
            this.zzbpj = zzbarVar;
            return this;
        }

        public final zza zzbz(Context context) {
            this.zzeyg = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaai = context;
            return this;
        }
    }

    private zzbhg(zza zzaVar) {
        this.zzbpj = zzaVar.zzbpj;
        this.zzaai = zzaVar.zzaai;
        this.zzeyg = zzaVar.zzeyg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context zzafp() {
        return this.zzaai;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WeakReference<Context> zzafq() {
        return this.zzeyg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbar zzafr() {
        return this.zzbpj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzafs() {
        return com.google.android.gms.ads.internal.zzr.zzkv().zzq(this.zzaai, this.zzbpj.zzbrz);
    }

    public final zzei zzaft() {
        return new zzei(new com.google.android.gms.ads.internal.zzf(this.zzaai, this.zzbpj));
    }
}
