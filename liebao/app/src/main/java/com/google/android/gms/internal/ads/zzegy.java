package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegy extends zzena<zzegy, zza> implements zzeop {
    private static volatile zzeow<zzegy> zzek;
    private static final zzegy zziic;
    private int zzihc;
    private int zzihg;

    private zzegy() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegy, zza> implements zzeop {
        private zza() {
            super(zzegy.zziic);
        }

        /* synthetic */ zza(zzegx zzegxVar) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzegy zzn(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegy) zzena.zza(zziic, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegx.zzel[i - 1]) {
            case 1:
                return new zzegy();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziic, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzihc", "zzihg"});
            case 4:
                return zziic;
            case 5:
                zzeow<zzegy> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegy.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziic);
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
        zzegy zzegyVar = new zzegy();
        zziic = zzegyVar;
        zzena.zza(zzegy.class, zzegyVar);
    }
}
