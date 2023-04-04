package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegj extends zzena<zzegj, zza> implements zzeop {
    private static volatile zzeow<zzegj> zzek;
    private static final zzegj zzihu;
    private int zziht;

    private zzegj() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegj, zza> implements zzeop {
        private zza() {
            super(zzegj.zzihu);
        }

        /* synthetic */ zza(zzegk zzegkVar) {
            this();
        }
    }

    public final int zzbcx() {
        return this.zziht;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegk.zzel[i - 1]) {
            case 1:
                return new zzegj();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihu, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zziht"});
            case 4:
                return zzihu;
            case 5:
                zzeow<zzegj> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegj.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihu);
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

    public static zzegj zzbcy() {
        return zzihu;
    }

    static {
        zzegj zzegjVar = new zzegj();
        zzihu = zzegjVar;
        zzena.zza(zzegj.class, zzegjVar);
    }
}
