package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedl;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzedk implements zzedl.zzb {
    private final /* synthetic */ zzect zzifc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedk(zzect zzectVar) {
        this.zzifc = zzectVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Class<?> zzbbx() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final <Q> zzect<Q> zzc(Class<Q> cls) {
        if (!this.zzifc.zzbbh().equals(cls)) {
            throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
        }
        return this.zzifc;
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final zzect<?> zzbbv() {
        return this.zzifc;
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Class<?> zzbbw() {
        return this.zzifc.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Set<Class<?>> zzbbl() {
        return Collections.singleton(this.zzifc.zzbbh());
    }
}
