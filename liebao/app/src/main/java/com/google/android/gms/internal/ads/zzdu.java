package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdu implements zzdwv {
    private final /* synthetic */ zzduu zzwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(zzds zzdsVar, zzduu zzduuVar) {
        this.zzwf = zzduuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwv
    public final boolean zzb(File file) {
        try {
            return this.zzwf.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
