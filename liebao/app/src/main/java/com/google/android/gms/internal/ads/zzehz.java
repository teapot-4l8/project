package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehz extends zzena<zzehz, zza> implements zzeop {
    private static volatile zzeow<zzehz> zzek;
    private static final zzehz zziju;
    private int zzihi;
    private int zzijt;

    private zzehz() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehz, zza> implements zzeop {
        private zza() {
            super(zzehz.zziju);
        }

        /* synthetic */ zza(zzeia zzeiaVar) {
            this();
        }
    }

    public final zzehs zzbes() {
        zzehs zzfp = zzehs.zzfp(this.zzijt);
        return zzfp == null ? zzehs.UNRECOGNIZED : zzfp;
    }

    public final int zzbch() {
        return this.zzihi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeia.zzel[i - 1]) {
            case 1:
                return new zzehz();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziju, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzijt", "zzihi"});
            case 4:
                return zziju;
            case 5:
                zzeow<zzehz> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehz.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziju);
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

    public static zzehz zzbet() {
        return zziju;
    }

    static {
        zzehz zzehzVar = new zzehz();
        zziju = zzehzVar;
        zzena.zza(zzehz.class, zzehzVar);
    }
}
