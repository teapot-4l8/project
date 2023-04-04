package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbok extends zzbne {
    private final Executor zzfur;
    private final zzagm zzfxu;
    private final Runnable zzfxv;

    public zzbok(zzbpf zzbpfVar, zzagm zzagmVar, Runnable runnable, Executor executor) {
        super(zzbpfVar);
        this.zzfxu = zzagmVar;
        this.zzfxv = runnable;
        this.zzfur = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final zzzd getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final void zza(ViewGroup viewGroup, zzvt zzvtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final zzdow zzakk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final View zzakl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final zzdow zzakt() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final int zzaku() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final void zzkj() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void zzakv() {
        this.zzfur.execute(new Runnable(this, new Runnable(new AtomicReference(this.zzfxv)) { // from class: com.google.android.gms.internal.ads.zzbon
            private final AtomicReference zzfxx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfxx = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable = (Runnable) this.zzfxx.getAndSet(null);
                if (runnable != null) {
                    runnable.run();
                }
            }
        }) { // from class: com.google.android.gms.internal.ads.zzbom
            private final Runnable zzfsq;
            private final zzbok zzfxw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfxw = this;
                this.zzfsq = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfxw.zze(this.zzfsq);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Runnable runnable) {
        try {
            if (this.zzfxu.zzm(ObjectWrapper.wrap(runnable))) {
                return;
            }
            runnable.run();
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
