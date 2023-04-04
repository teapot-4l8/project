package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazu extends com.google.android.gms.ads.internal.util.zza {
    private final /* synthetic */ zzazs zzeev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazu(zzazs zzazsVar) {
        this.zzeev = zzazsVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwp() {
        Context context;
        zzbar zzbarVar;
        Object obj;
        zzabx zzabxVar;
        context = this.zzeev.context;
        zzbarVar = this.zzeev.zzbpx;
        zzabu zzabuVar = new zzabu(context, zzbarVar.zzbrz);
        obj = this.zzeev.lock;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.zzr.zzle();
                zzabxVar = this.zzeev.zzeei;
                zzabz.zza(zzabxVar, zzabuVar);
            } catch (IllegalArgumentException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Cannot config CSI reporter.", e2);
            }
        }
    }
}
