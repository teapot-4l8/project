package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzejc extends zzena<zzejc, zza> implements zzeop {
    private static volatile zzeow<zzejc> zzek;
    private static final zzejc zzilx;

    private zzejc() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzejc, zza> implements zzeop {
        private zza() {
            super(zzejc.zzilx);
        }

        /* synthetic */ zza(zzejd zzejdVar) {
            this();
        }
    }

    public static zzejc zzaa(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzejc) zzena.zza(zzilx, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzejd.zzel[i - 1]) {
            case 1:
                return new zzejc();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzilx, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzilx;
            case 5:
                zzeow<zzejc> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzejc.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzilx);
                            zzek = zzeowVar;
                        }
                    }
                }
                return zzeowVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzejc zzejcVar = new zzejc();
        zzilx = zzejcVar;
        zzena.zza(zzejc.class, zzejcVar);
    }
}
