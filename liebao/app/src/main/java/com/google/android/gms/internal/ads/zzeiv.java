package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeiv extends zzena<zzeiv, zza> implements zzeop {
    private static volatile zzeow<zzeiv> zzek;
    private static final zzeiv zzill;
    private String zzilj = "";
    private zzeif zzilk;

    private zzeiv() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeiv, zza> implements zzeop {
        private zza() {
            super(zzeiv.zzill);
        }

        /* synthetic */ zza(zzeiu zzeiuVar) {
            this();
        }
    }

    public final String zzbgd() {
        return this.zzilj;
    }

    public final zzeif zzbge() {
        zzeif zzeifVar = this.zzilk;
        return zzeifVar == null ? zzeif.zzbfb() : zzeifVar;
    }

    public static zzeiv zzy(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzeiv) zzena.zza(zzill, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeiu.zzel[i - 1]) {
            case 1:
                return new zzeiv();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzill, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzilj", "zzilk"});
            case 4:
                return zzill;
            case 5:
                zzeow<zzeiv> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeiv.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzill);
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

    public static zzeiv zzbgf() {
        return zzill;
    }

    static {
        zzeiv zzeivVar = new zzeiv();
        zzill = zzeivVar;
        zzena.zza(zzeiv.class, zzeivVar);
    }
}
