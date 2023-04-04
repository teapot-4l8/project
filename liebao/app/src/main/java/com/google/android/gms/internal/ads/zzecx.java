package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzecx<KeyFormatProtoT extends zzeon, KeyT> {
    private final Class<KeyFormatProtoT> zziel;

    public zzecx(Class<KeyFormatProtoT> cls) {
        this.zziel = cls;
    }

    public abstract void zzd(KeyFormatProtoT keyformatprotot);

    public abstract KeyT zze(KeyFormatProtoT keyformatprotot);

    public abstract KeyFormatProtoT zzr(zzelq zzelqVar);

    public final Class<KeyFormatProtoT> zzbbo() {
        return this.zziel;
    }
}
