package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegi extends zzena<zzegi, zza> implements zzeop {
    private static volatile zzeow<zzegi> zzek;
    private static final zzegi zzihs;
    private int zzihg;
    private zzegj zzihq;

    private zzegi() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegi, zza> implements zzeop {
        private zza() {
            super(zzegi.zzihs);
        }

        /* synthetic */ zza(zzegh zzeghVar) {
            this();
        }
    }

    public final zzegj zzbcr() {
        zzegj zzegjVar = this.zzihq;
        return zzegjVar == null ? zzegj.zzbcy() : zzegjVar;
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegi zzh(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegi) zzena.zza(zzihs, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegh.zzel[i - 1]) {
            case 1:
                return new zzegi();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzihq", "zzihg"});
            case 4:
                return zzihs;
            case 5:
                zzeow<zzegi> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegi.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihs);
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

    public static zzegi zzbcv() {
        return zzihs;
    }

    static {
        zzegi zzegiVar = new zzegi();
        zzihs = zzegiVar;
        zzena.zza(zzegi.class, zzegiVar);
    }
}
