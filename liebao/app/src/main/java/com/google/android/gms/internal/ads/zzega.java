package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzega extends zzena<zzega, zza> implements zzeop {
    private static volatile zzeow<zzega> zzek;
    private static final zzega zzihj;
    private int zzihi;

    private zzega() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzega, zza> implements zzeop {
        private zza() {
            super(zzega.zzihj);
        }

        /* synthetic */ zza(zzefz zzefzVar) {
            this();
        }
    }

    public final int zzbch() {
        return this.zzihi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefz.zzel[i - 1]) {
            case 1:
                return new zzega();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihj, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzihi"});
            case 4:
                return zzihj;
            case 5:
                zzeow<zzega> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzega.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihj);
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

    public static zzega zzbci() {
        return zzihj;
    }

    static {
        zzega zzegaVar = new zzega();
        zzihj = zzegaVar;
        zzena.zza(zzega.class, zzegaVar);
    }
}
