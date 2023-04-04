package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedl;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzedn implements zzedl.zzb {
    private final /* synthetic */ zzecu zzifk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedn(zzecu zzecuVar) {
        this.zzifk = zzecuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Class<?> zzbbx() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final <Q> zzect<Q> zzc(Class<Q> cls) {
        try {
            return new zzecs(this.zzifk, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final zzect<?> zzbbv() {
        zzecu zzecuVar = this.zzifk;
        return new zzecs(zzecuVar, zzecuVar.zzbbm());
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Class<?> zzbbw() {
        return this.zzifk.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Set<Class<?>> zzbbl() {
        return this.zzifk.zzbbl();
    }
}
