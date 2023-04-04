package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public class zzemn {
    private static volatile boolean zziqj = false;
    private static boolean zziqk = true;
    private static volatile zzemn zziql;
    private static volatile zzemn zziqm;
    private static final zzemn zziqn = new zzemn(true);
    private final Map<zza, zzena.zzf<?, ?>> zziqo;

    public static zzemn zzbiv() {
        zzemn zzemnVar = zziql;
        if (zzemnVar == null) {
            synchronized (zzemn.class) {
                zzemnVar = zziql;
                if (zzemnVar == null) {
                    zzemnVar = zziqn;
                    zziql = zzemnVar;
                }
            }
        }
        return zzemnVar;
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                return this.object == zzaVar.object && this.number == zzaVar.number;
            }
            return false;
        }
    }

    public static zzemn zzbiw() {
        zzemn zzemnVar = zziqm;
        if (zzemnVar != null) {
            return zzemnVar;
        }
        synchronized (zzemn.class) {
            zzemn zzemnVar2 = zziqm;
            if (zzemnVar2 != null) {
                return zzemnVar2;
            }
            zzemn zze = zzemy.zze(zzemn.class);
            zziqm = zze;
            return zze;
        }
    }

    public final <ContainingType extends zzeon> zzena.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzena.zzf<ContainingType, ?>) this.zziqo.get(new zza(containingtype, i));
    }

    zzemn() {
        this.zziqo = new HashMap();
    }

    private zzemn(boolean z) {
        this.zziqo = Collections.emptyMap();
    }
}
