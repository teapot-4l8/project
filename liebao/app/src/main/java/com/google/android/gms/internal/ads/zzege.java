package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzege extends zzena<zzege, zza> implements zzeop {
    private static volatile zzeow<zzege> zzek;
    private static final zzege zzihp;
    private zzegi zzihn;
    private zzehy zziho;

    private zzege() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzege, zza> implements zzeop {
        private zza() {
            super(zzege.zzihp);
        }

        /* synthetic */ zza(zzegd zzegdVar) {
            this();
        }
    }

    public final zzegi zzbco() {
        zzegi zzegiVar = this.zzihn;
        return zzegiVar == null ? zzegi.zzbcv() : zzegiVar;
    }

    public final zzehy zzbcp() {
        zzehy zzehyVar = this.zziho;
        return zzehyVar == null ? zzehy.zzbeq() : zzehyVar;
    }

    public static zzege zzf(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzege) zzena.zza(zzihp, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegd.zzel[i - 1]) {
            case 1:
                return new zzege();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzihn", "zziho"});
            case 4:
                return zzihp;
            case 5:
                zzeow<zzege> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzege.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihp);
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
        zzege zzegeVar = new zzege();
        zzihp = zzegeVar;
        zzena.zza(zzege.class, zzegeVar);
    }
}
