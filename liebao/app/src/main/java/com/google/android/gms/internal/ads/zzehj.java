package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehj extends zzena<zzehj, zza> implements zzeop {
    private static volatile zzeow<zzehj> zzek;
    private static final zzehj zziis;
    private zzehq zziip;
    private zzehe zziiq;
    private int zziir;

    private zzehj() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehj, zza> implements zzeop {
        private zza() {
            super(zzehj.zziis);
        }

        /* synthetic */ zza(zzehk zzehkVar) {
            this();
        }
    }

    public final zzehq zzbdu() {
        zzehq zzehqVar = this.zziip;
        return zzehqVar == null ? zzehq.zzbek() : zzehqVar;
    }

    public final zzehe zzbdv() {
        zzehe zzeheVar = this.zziiq;
        return zzeheVar == null ? zzehe.zzbdq() : zzeheVar;
    }

    public final zzehd zzbdw() {
        zzehd zzfl = zzehd.zzfl(this.zziir);
        return zzfl == null ? zzehd.UNRECOGNIZED : zzfl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehk.zzel[i - 1]) {
            case 1:
                return new zzehj();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziis, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zziip", "zziiq", "zziir"});
            case 4:
                return zziis;
            case 5:
                zzeow<zzehj> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehj.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziis);
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

    public static zzehj zzbdx() {
        return zziis;
    }

    static {
        zzehj zzehjVar = new zzehj();
        zziis = zzehjVar;
        zzena.zza(zzehj.class, zzehjVar);
    }
}
