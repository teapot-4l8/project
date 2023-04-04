package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzeij extends zzena<zzeij, zza> implements zzeop {
    private static volatile zzeow<zzeij> zzek;
    private static final zzeij zziks;
    private int zzikp;
    private boolean zzikq;
    private String zziko = "";
    private String zzijv = "";
    private String zzikr = "";

    private zzeij() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeij, zza> implements zzeop {
        private zza() {
            super(zzeij.zziks);
        }

        /* synthetic */ zza(zzeii zzeiiVar) {
            this();
        }
    }

    public final String zzbfd() {
        return this.zziko;
    }

    public final String zzbev() {
        return this.zzijv;
    }

    public final int zzbfe() {
        return this.zzikp;
    }

    public final boolean zzbff() {
        return this.zzikq;
    }

    public final String zzbfg() {
        return this.zzikr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeii.zzel[i - 1]) {
            case 1:
                return new zzeij();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziks, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zziko", "zzijv", "zzikp", "zzikq", "zzikr"});
            case 4:
                return zziks;
            case 5:
                zzeow<zzeij> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeij.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziks);
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
        zzeij zzeijVar = new zzeij();
        zziks = zzeijVar;
        zzena.zza(zzeij.class, zzeijVar);
    }
}
