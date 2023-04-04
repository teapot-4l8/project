package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeir extends zzena<zzeir, zza> implements zzeop {
    private static volatile zzeow<zzeir> zzek;
    private static final zzeir zzilg;
    private String zzilf = "";

    private zzeir() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeir, zza> implements zzeop {
        private zza() {
            super(zzeir.zzilg);
        }

        /* synthetic */ zza(zzeiq zzeiqVar) {
            this();
        }
    }

    public final String zzbfx() {
        return this.zzilf;
    }

    public static zzeir zzw(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzeir) zzena.zza(zzilg, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeiq.zzel[i - 1]) {
            case 1:
                return new zzeir();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzilg, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzilf"});
            case 4:
                return zzilg;
            case 5:
                zzeow<zzeir> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeir.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzilg);
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

    public static zzeir zzbfy() {
        return zzilg;
    }

    static {
        zzeir zzeirVar = new zzeir();
        zzilg = zzeirVar;
        zzena.zza(zzeir.class, zzeirVar);
    }
}
