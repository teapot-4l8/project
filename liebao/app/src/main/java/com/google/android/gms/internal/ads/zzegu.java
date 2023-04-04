package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegu extends zzena<zzegu, zza> implements zzeop {
    private static volatile zzeow<zzegu> zzek;
    private static final zzegu zziia;
    private int zzihc;
    private int zzihg;

    private zzegu() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegu, zza> implements zzeop {
        private zza() {
            super(zzegu.zziia);
        }

        /* synthetic */ zza(zzegt zzegtVar) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegu zzl(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegu) zzena.zza(zziia, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegt.zzel[i - 1]) {
            case 1:
                return new zzegu();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziia, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzihg", "zzihc"});
            case 4:
                return zziia;
            case 5:
                zzeow<zzegu> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegu.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziia);
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
        zzegu zzeguVar = new zzegu();
        zziia = zzeguVar;
        zzena.zza(zzegu.class, zzeguVar);
    }
}
