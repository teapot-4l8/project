package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeal;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzeau<V, C> extends zzeal<V, C> {
    private List<zzeaw<V>> zzidg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeau(zzdyv<? extends zzebt<? extends V>> zzdyvVar, boolean z) {
        super(zzdyvVar, true, true);
        List<zzeaw<V>> zzfb;
        if (zzdyvVar.isEmpty()) {
            zzfb = zzdza.zzbal();
        } else {
            zzfb = zzdzi.zzfb(zzdyvVar.size());
        }
        for (int i = 0; i < zzdyvVar.size(); i++) {
            zzfb.add(null);
        }
        this.zzidg = zzfb;
    }

    abstract C zzl(List<zzeaw<V>> list);

    @Override // com.google.android.gms.internal.ads.zzeal
    final void zzb(int i, @NullableDecl V v) {
        List<zzeaw<V>> list = this.zzidg;
        if (list != null) {
            list.set(i, new zzeaw<>(v));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeal
    final void zzbaw() {
        List<zzeaw<V>> list = this.zzidg;
        if (list != null) {
            set(zzl(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeal
    public final void zza(zzeal.zza zzaVar) {
        super.zza(zzaVar);
        this.zzidg = null;
    }
}
