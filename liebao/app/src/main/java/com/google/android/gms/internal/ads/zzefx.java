package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzefx extends zzena<zzefx, zza> implements zzeop {
    private static volatile zzeow<zzefx> zzek;
    private static final zzefx zzihh;
    private zzega zzihe;
    private int zzihg;

    private zzefx() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzefx, zza> implements zzeop {
        private zza() {
            super(zzefx.zzihh);
        }

        /* synthetic */ zza(zzefy zzefyVar) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public final zzega zzbcd() {
        zzega zzegaVar = this.zzihe;
        return zzegaVar == null ? zzega.zzbci() : zzegaVar;
    }

    public static zzefx zzd(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzefx) zzena.zza(zzihh, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefy.zzel[i - 1]) {
            case 1:
                return new zzefx();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihh, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzihg", "zzihe"});
            case 4:
                return zzihh;
            case 5:
                zzeow<zzefx> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzefx.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihh);
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
        zzefx zzefxVar = new zzefx();
        zzihh = zzefxVar;
        zzena.zza(zzefx.class, zzefxVar);
    }
}
