package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehq extends zzena<zzehq, zza> implements zzeop {
    private static volatile zzeow<zzehq> zzek;
    private static final zzehq zzijb;
    private int zziiy;
    private int zziiz;
    private zzelq zzija = zzelq.zzipc;

    private zzehq() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehq, zza> implements zzeop {
        private zza() {
            super(zzehq.zzijb);
        }

        /* synthetic */ zza(zzehp zzehpVar) {
            this();
        }
    }

    public final zzehr zzbeh() {
        zzehr zzfo = zzehr.zzfo(this.zziiy);
        return zzfo == null ? zzehr.UNRECOGNIZED : zzfo;
    }

    public final zzehs zzbei() {
        zzehs zzfp = zzehs.zzfp(this.zziiz);
        return zzfp == null ? zzehs.UNRECOGNIZED : zzfp;
    }

    public final zzelq zzbej() {
        return this.zzija;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehp.zzel[i - 1]) {
            case 1:
                return new zzehq();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzijb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zziiy", "zziiz", "zzija"});
            case 4:
                return zzijb;
            case 5:
                zzeow<zzehq> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehq.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzijb);
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

    public static zzehq zzbek() {
        return zzijb;
    }

    static {
        zzehq zzehqVar = new zzehq();
        zzijb = zzehqVar;
        zzena.zza(zzehq.class, zzehqVar);
    }
}
