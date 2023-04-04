package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcig<T> implements zzaig<Object> {
    private final WeakReference<T> zzglu;
    private final String zzglv;
    private final zzaig<T> zzglw;
    private final /* synthetic */ zzchu zzglx;

    private zzcig(zzchu zzchuVar, WeakReference<T> weakReference, String str, zzaig<T> zzaigVar) {
        this.zzglx = zzchuVar;
        this.zzglu = weakReference;
        this.zzglv = str;
        this.zzglw = zzaigVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        T t = this.zzglu.get();
        if (t == null) {
            this.zzglx.zzb(this.zzglv, this);
        } else {
            this.zzglw.zza(t, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcig(zzchu zzchuVar, WeakReference weakReference, String str, zzaig zzaigVar, zzchz zzchzVar) {
        this(zzchuVar, weakReference, str, zzaigVar);
    }
}
