package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeif extends zzena<zzeif, zza> implements zzeop {
    private static volatile zzeow<zzeif> zzek;
    private static final zzeif zzikn;
    private String zzijv = "";
    private zzelq zzijw = zzelq.zzipc;
    private int zzikm;

    private zzeif() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeif, zza> implements zzeop {
        private zza() {
            super(zzeif.zzikn);
        }

        /* synthetic */ zza(zzeih zzeihVar) {
            this();
        }
    }

    public final String zzbev() {
        return this.zzijv;
    }

    public final zzelq zzbew() {
        return this.zzijw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeih.zzel[i - 1]) {
            case 1:
                return new zzeif();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzikn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzijv", "zzijw", "zzikm"});
            case 4:
                return zzikn;
            case 5:
                zzeow<zzeif> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeif.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzikn);
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

    public static zzeif zzbfb() {
        return zzikn;
    }

    static {
        zzeif zzeifVar = new zzeif();
        zzikn = zzeifVar;
        zzena.zza(zzeif.class, zzeifVar);
    }
}
