package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaxi implements zzebi<Void> {
    private final /* synthetic */ zzebt zzebu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxi(zzaxf zzaxfVar, zzebt zzebtVar) {
        this.zzebu = zzebtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        List list;
        list = zzaxf.zzebi;
        list.remove(this.zzebu);
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(Void r2) {
        List list;
        list = zzaxf.zzebi;
        list.remove(this.zzebu);
    }
}
