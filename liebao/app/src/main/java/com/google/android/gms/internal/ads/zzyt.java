package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzyt implements MuteThisAdReason {
    private final String description;
    private zzys zzckj;

    public zzyt(zzys zzysVar) {
        String str;
        this.zzckj = zzysVar;
        try {
            str = zzysVar.getDescription();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            str = null;
        }
        this.description = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.description;
    }

    public final zzys zzrl() {
        return this.zzckj;
    }

    public final String toString() {
        return this.description;
    }
}
