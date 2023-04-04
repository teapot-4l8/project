package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedl;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzedm implements zzedl.zzb {
    private final /* synthetic */ zzedi zzifi;
    private final /* synthetic */ zzecu zzifj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedm(zzedi zzediVar, zzecu zzecuVar) {
        this.zzifi = zzediVar;
        this.zzifj = zzecuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final <Q> zzect<Q> zzc(Class<Q> cls) {
        try {
            return new zzedj(this.zzifi, this.zzifj, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final zzect<?> zzbbv() {
        zzedi zzediVar = this.zzifi;
        return new zzedj(zzediVar, this.zzifj, zzediVar.zzbbm());
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Class<?> zzbbw() {
        return this.zzifi.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Set<Class<?>> zzbbl() {
        return this.zzifi.zzbbl();
    }

    @Override // com.google.android.gms.internal.ads.zzedl.zzb
    public final Class<?> zzbbx() {
        return this.zzifj.getClass();
    }
}
