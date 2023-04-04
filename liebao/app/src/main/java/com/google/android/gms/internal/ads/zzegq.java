package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegq extends zzena<zzegq, zza> implements zzeop {
    private static volatile zzeow<zzegq> zzek;
    private static final zzegq zzihy;
    private int zziht;

    private zzegq() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegq, zza> implements zzeop {
        private zza() {
            super(zzegq.zzihy);
        }

        /* synthetic */ zza(zzegp zzegpVar) {
            this();
        }
    }

    public final int zzbcx() {
        return this.zziht;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegp.zzel[i - 1]) {
            case 1:
                return new zzegq();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihy, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zziht"});
            case 4:
                return zzihy;
            case 5:
                zzeow<zzegq> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegq.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihy);
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

    public static zzegq zzbde() {
        return zzihy;
    }

    static {
        zzegq zzegqVar = new zzegq();
        zzihy = zzegqVar;
        zzena.zza(zzegq.class, zzegqVar);
    }
}
