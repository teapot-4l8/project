package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import com.google.android.gms.internal.ads.zzeon;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzecu<KeyProtoT extends zzeon> {
    private final Class<KeyProtoT> zziel;
    private final Map<Class<?>, zzecw<?, KeyProtoT>> zziem;
    private final Class<?> zzien;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzecu(Class<KeyProtoT> cls, zzecw<?, KeyProtoT>... zzecwVarArr) {
        this.zziel = cls;
        HashMap hashMap = new HashMap();
        for (zzecw<?, KeyProtoT> zzecwVar : zzecwVarArr) {
            if (hashMap.containsKey(zzecwVar.zzbbh())) {
                String valueOf = String.valueOf(zzecwVar.zzbbh().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            }
            hashMap.put(zzecwVar.zzbbh(), zzecwVar);
        }
        if (zzecwVarArr.length > 0) {
            this.zzien = zzecwVarArr[0].zzbbh();
        } else {
            this.zzien = Void.class;
        }
        this.zziem = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public abstract zzeic.zza zzbbk();

    public abstract void zzc(KeyProtoT keyprotot);

    public abstract KeyProtoT zzp(zzelq zzelqVar);

    public final Class<KeyProtoT> zzbbj() {
        return this.zziel;
    }

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) {
        zzecw<?, KeyProtoT> zzecwVar = this.zziem.get(cls);
        if (zzecwVar == null) {
            String canonicalName = cls.getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
            sb.append("Requested primitive class ");
            sb.append(canonicalName);
            sb.append(" not supported.");
            throw new IllegalArgumentException(sb.toString());
        }
        return (P) zzecwVar.zzah(keyprotot);
    }

    public final Set<Class<?>> zzbbl() {
        return this.zziem.keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<?> zzbbm() {
        return this.zzien;
    }

    public zzecx<?, KeyProtoT> zzbbn() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
