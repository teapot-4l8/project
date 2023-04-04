package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeal;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeav<V> extends zzeal<Object, V> {
    private zzeax<?> zzidh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeav(zzdyv<? extends zzebt<?>> zzdyvVar, boolean z, Executor executor, Callable<V> callable) {
        super(zzdyvVar, z, false);
        this.zzidh = new zzeay(this, callable, executor);
        zzbav();
    }

    @Override // com.google.android.gms.internal.ads.zzeal
    final void zzb(int i, @NullableDecl Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeal
    final void zzbaw() {
        zzeax<?> zzeaxVar = this.zzidh;
        if (zzeaxVar != null) {
            zzeaxVar.execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeal
    public final void zza(zzeal.zza zzaVar) {
        super.zza(zzaVar);
        if (zzaVar == zzeal.zza.OUTPUT_FUTURE_DONE) {
            this.zzidh = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeah
    protected final void interruptTask() {
        zzeax<?> zzeaxVar = this.zzidh;
        if (zzeaxVar != null) {
            zzeaxVar.interruptTask();
        }
    }
}
