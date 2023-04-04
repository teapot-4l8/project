package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehc extends zzena<zzehc, zza> implements zzeop {
    private static volatile zzeow<zzehc> zzek;
    private static final zzehc zziie;

    private zzehc() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehc, zza> implements zzeop {
        private zza() {
            super(zzehc.zziie);
        }

        /* synthetic */ zza(zzehb zzehbVar) {
            this();
        }
    }

    public static zzehc zzp(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzehc) zzena.zza(zziie, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehb.zzel[i - 1]) {
            case 1:
                return new zzehc();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziie, "\u0000\u0000", (Object[]) null);
            case 4:
                return zziie;
            case 5:
                zzeow<zzehc> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehc.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziie);
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
        zzehc zzehcVar = new zzehc();
        zziie = zzehcVar;
        zzena.zza(zzehc.class, zzehcVar);
    }
}
