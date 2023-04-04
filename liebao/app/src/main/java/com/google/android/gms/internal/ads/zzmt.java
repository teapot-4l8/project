package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzmt implements Runnable {
    private final /* synthetic */ zzms zzbdv;
    private final /* synthetic */ zzmy zzbew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmt(zzms zzmsVar, zzmy zzmyVar) {
        this.zzbdv = zzmsVar;
        this.zzbew = zzmyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        this.zzbew.release();
        sparseArray = this.zzbdv.zzbeh;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray2 = this.zzbdv.zzbeh;
            ((zznm) sparseArray2.valueAt(i)).disable();
        }
    }
}
