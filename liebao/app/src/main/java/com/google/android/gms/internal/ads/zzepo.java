package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzepo extends zzepu {
    private final /* synthetic */ zzepn zzixv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzepo(zzepn zzepnVar) {
        super(zzepnVar, null);
        this.zzixv = zzepnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepu, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzepp(this.zzixv, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzepo(zzepn zzepnVar, zzepm zzepmVar) {
        this(zzepnVar);
    }
}
