package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdvl {
    private final Context context;
    private final Executor executor;
    private final zzdvr zzhwd;
    private final zzdvr zzhwe;
    private Task<zzcf.zza> zzhwf;
    private Task<zzcf.zza> zzhwg;
    private final zzduv zzvx;
    private final zzduz zzys;

    private zzdvl(Context context, Executor executor, zzduv zzduvVar, zzduz zzduzVar, zzdvp zzdvpVar, zzdvo zzdvoVar) {
        this.context = context;
        this.executor = executor;
        this.zzvx = zzduvVar;
        this.zzys = zzduzVar;
        this.zzhwd = zzdvpVar;
        this.zzhwe = zzdvoVar;
    }

    public static zzdvl zza(Context context, Executor executor, zzduv zzduvVar, zzduz zzduzVar) {
        zzdvl zzdvlVar = new zzdvl(context, executor, zzduvVar, zzduzVar, new zzdvp(), new zzdvo());
        if (zzdvlVar.zzys.zzayp()) {
            zzdvlVar.zzhwf = zzdvlVar.zzd(new Callable(zzdvlVar) { // from class: com.google.android.gms.internal.ads.zzdvk
                private final zzdvl zzhwc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhwc = zzdvlVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzhwc.zzayx();
                }
            });
        } else {
            zzdvlVar.zzhwf = Tasks.forResult(zzdvlVar.zzhwd.zzayy());
        }
        zzdvlVar.zzhwg = zzdvlVar.zzd(new Callable(zzdvlVar) { // from class: com.google.android.gms.internal.ads.zzdvn
            private final zzdvl zzhwc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhwc = zzdvlVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhwc.zzayw();
            }
        });
        return zzdvlVar;
    }

    public final zzcf.zza zzayv() {
        return zza(this.zzhwf, this.zzhwd.zzayy());
    }

    public final zzcf.zza zzcp() {
        return zza(this.zzhwg, this.zzhwe.zzayy());
    }

    private final Task<zzcf.zza> zzd(Callable<zzcf.zza> callable) {
        return Tasks.call(this.executor, callable).addOnFailureListener(this.executor, new OnFailureListener(this) { // from class: com.google.android.gms.internal.ads.zzdvm
            private final zzdvl zzhwc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhwc = this;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zzhwc.zzc(exc);
            }
        });
    }

    private static zzcf.zza zza(Task<zzcf.zza> task, zzcf.zza zzaVar) {
        return !task.isSuccessful() ? zzaVar : task.getResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvx.zza(2025, -1L, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzayw() {
        return this.zzhwe.zzco(this.context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzayx() {
        return this.zzhwd.zzco(this.context);
    }
}
