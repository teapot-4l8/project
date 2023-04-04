package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdbr implements zzebi<ArrayList<Uri>> {
    private final /* synthetic */ zzasy zzhct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdbr(zzdbf zzdbfVar, zzasy zzasyVar) {
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
    public final /* synthetic */ void onSuccess(@Nonnull ArrayList<Uri> arrayList) {
        try {
            this.zzhct.onSuccess(arrayList);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
