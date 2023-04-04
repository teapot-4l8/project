package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaut implements Callable<zzauo> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzauq zzeai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaut(zzauq zzauqVar, Context context) {
        this.zzeai = zzauqVar;
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzauo call() {
        WeakHashMap weakHashMap;
        zzauo zzxd;
        WeakHashMap weakHashMap2;
        weakHashMap = this.zzeai.zzeaf;
        zzaus zzausVar = (zzaus) weakHashMap.get(this.val$context);
        if (zzausVar != null) {
            if (!(zzausVar.zzeag + zzadf.zzdea.get().longValue() < com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis())) {
                zzxd = new zzaur(this.val$context, zzausVar.zzeah).zzxd();
                weakHashMap2 = this.zzeai.zzeaf;
                weakHashMap2.put(this.val$context, new zzaus(this.zzeai, zzxd));
                return zzxd;
            }
        }
        zzxd = new zzaur(this.val$context).zzxd();
        weakHashMap2 = this.zzeai.zzeaf;
        weakHashMap2.put(this.val$context, new zzaus(this.zzeai, zzxd));
        return zzxd;
    }
}
