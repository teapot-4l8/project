package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzecw<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zziel;

    public zzecw(Class<PrimitiveT> cls) {
        this.zziel = cls;
    }

    public abstract PrimitiveT zzah(KeyT keyt);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<PrimitiveT> zzbbh() {
        return this.zziel;
    }
}
