package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzedi<KeyProtoT extends zzeon, PublicKeyProtoT extends zzeon> extends zzecu<KeyProtoT> {
    private final Class<PublicKeyProtoT> zziez;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzedi(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzecw<?, KeyProtoT>... zzecwVarArr) {
        super(cls, zzecwVarArr);
        this.zziez = cls2;
    }
}
