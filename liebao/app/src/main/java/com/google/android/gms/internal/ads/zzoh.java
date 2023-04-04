package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzoh {
    private zzok zzbif;

    public abstract zzoj zza(zzib[] zzibVarArr, zznu zznuVar);

    public abstract void zzd(Object obj);

    public final void zza(zzok zzokVar) {
        this.zzbif = zzokVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invalidate() {
        zzok zzokVar = this.zzbif;
        if (zzokVar != null) {
            zzokVar.zzet();
        }
    }
}
