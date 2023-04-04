package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbaf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzq implements zzbaf {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzegy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzj zzjVar, Context context, String str) {
        this.val$context = context;
        this.zzegy = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbaf
    public final void zzen(String str) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        zzj.zzb(this.val$context, this.zzegy, str);
    }
}
