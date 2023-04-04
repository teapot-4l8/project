package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegn extends zzena<zzegn, zza> implements zzeop {
    private static volatile zzeow<zzegn> zzek;
    private static final zzegn zzihx;
    private int zzihg;
    private zzegq zzihv;

    private zzegn() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegn, zza> implements zzeop {
        private zza() {
            super(zzegn.zzihx);
        }

        /* synthetic */ zza(zzego zzegoVar) {
            this();
        }
    }

    public final zzegq zzbda() {
        zzegq zzegqVar = this.zzihv;
        return zzegqVar == null ? zzegq.zzbde() : zzegqVar;
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegn zzj(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegn) zzena.zza(zzihx, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzego.zzel[i - 1]) {
            case 1:
                return new zzegn();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihx, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzihv", "zzihg"});
            case 4:
                return zzihx;
            case 5:
                zzeow<zzegn> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegn.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihx);
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
        zzegn zzegnVar = new zzegn();
        zzihx = zzegnVar;
        zzena.zza(zzegn.class, zzegnVar);
    }
}
