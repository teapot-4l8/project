package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzedc<P> {
    private final Class<P> zziek;
    private final ConcurrentMap<zzedh, List<zzede<P>>> zzier = new ConcurrentHashMap();
    private zzede<P> zzies;

    public final zzede<P> zzbbp() {
        return this.zzies;
    }

    private zzedc(Class<P> cls) {
        this.zziek = cls;
    }

    public static <P> zzedc<P> zzb(Class<P> cls) {
        return new zzedc<>(cls);
    }

    public final void zza(zzede<P> zzedeVar) {
        if (zzedeVar == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (zzedeVar.zzbbr() != zzeid.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        List<zzede<P>> list = this.zzier.get(new zzedh(zzedeVar.zzbbt()));
        if (list == null) {
            list = Collections.emptyList();
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.zzies = zzedeVar;
    }

    public final zzede<P> zza(P p, zzeik.zzb zzbVar) {
        byte[] array;
        if (zzbVar.zzbbr() != zzeid.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        int i = zzeco.zzieh[zzbVar.zzbbs().ordinal()];
        if (i == 1 || i == 2) {
            array = ByteBuffer.allocate(5).put((byte) 0).putInt(zzbVar.zzbfo()).array();
        } else if (i == 3) {
            array = ByteBuffer.allocate(5).put((byte) 1).putInt(zzbVar.zzbfo()).array();
        } else if (i == 4) {
            array = zzecp.zziei;
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        zzede<P> zzedeVar = new zzede<>(p, array, zzbVar.zzbbr(), zzbVar.zzbbs(), zzbVar.zzbfo());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzedeVar);
        zzedh zzedhVar = new zzedh(zzedeVar.zzbbt());
        List<zzede<P>> put = this.zzier.put(zzedhVar, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(zzedeVar);
            this.zzier.put(zzedhVar, Collections.unmodifiableList(arrayList2));
        }
        return zzedeVar;
    }

    public final Class<P> zzbbh() {
        return this.zziek;
    }
}
