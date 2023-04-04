package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.Collections;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdbq implements zzebi<Uri> {
    private final /* synthetic */ zzasy zzhct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdbq(zzdbf zzdbfVar, zzasy zzasyVar) {
        this.zzhct = zzasyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        try {
            zzasy zzasyVar = this.zzhct;
            String valueOf = String.valueOf(th.getMessage());
            zzasyVar.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(@Nonnull Uri uri) {
        try {
            this.zzhct.onSuccess(Collections.singletonList(uri));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
