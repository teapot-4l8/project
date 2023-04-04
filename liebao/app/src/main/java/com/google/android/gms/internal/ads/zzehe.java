package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehe extends zzena<zzehe, zza> implements zzeop {
    private static volatile zzeow<zzehe> zzek;
    private static final zzehe zziim;
    private zzeif zziil;

    private zzehe() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehe, zza> implements zzeop {
        private zza() {
            super(zzehe.zziim);
        }

        /* synthetic */ zza(zzehg zzehgVar) {
            this();
        }
    }

    public final zzeif zzbdp() {
        zzeif zzeifVar = this.zziil;
        return zzeifVar == null ? zzeif.zzbfb() : zzeifVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehg.zzel[i - 1]) {
            case 1:
                return new zzehe();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziim, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zziil"});
            case 4:
                return zziim;
            case 5:
                zzeow<zzehe> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehe.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziim);
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

    public static zzehe zzbdq() {
        return zziim;
    }

    static {
        zzehe zzeheVar = new zzehe();
        zziim = zzeheVar;
        zzena.zza(zzehe.class, zzeheVar);
    }
}
