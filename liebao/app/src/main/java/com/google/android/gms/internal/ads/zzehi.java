package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehi extends zzena<zzehi, zza> implements zzeop {
    private static volatile zzeow<zzehi> zzek;
    private static final zzehi zziio;
    private zzehj zziin;

    private zzehi() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehi, zza> implements zzeop {
        private zza() {
            super(zzehi.zziio);
        }

        /* synthetic */ zza(zzehh zzehhVar) {
            this();
        }
    }

    public final zzehj zzbds() {
        zzehj zzehjVar = this.zziin;
        return zzehjVar == null ? zzehj.zzbdx() : zzehjVar;
    }

    public static zzehi zzq(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzehi) zzena.zza(zziio, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehh.zzel[i - 1]) {
            case 1:
                return new zzehi();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziio, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zziin"});
            case 4:
                return zziio;
            case 5:
                zzeow<zzehi> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehi.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziio);
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
        zzehi zzehiVar = new zzehi();
        zziio = zzehiVar;
        zzena.zza(zzehi.class, zzehiVar);
    }
}
