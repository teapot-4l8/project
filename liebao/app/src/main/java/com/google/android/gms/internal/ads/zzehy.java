package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehy extends zzena<zzehy, zza> implements zzeop {
    private static volatile zzeow<zzehy> zzek;
    private static final zzehy zzijs;
    private int zzihc;
    private int zzihg;
    private zzehz zzijq;

    private zzehy() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehy, zza> implements zzeop {
        private zza() {
            super(zzehy.zzijs);
        }

        /* synthetic */ zza(zzehx zzehxVar) {
            this();
        }
    }

    public final zzehz zzbem() {
        zzehz zzehzVar = this.zzijq;
        return zzehzVar == null ? zzehz.zzbet() : zzehzVar;
    }

    public final int getKeySize() {
        return this.zzihg;
    }

    public static zzehy zzu(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzehy) zzena.zza(zzijs, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehx.zzel[i - 1]) {
            case 1:
                return new zzehy();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzijs, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzijq", "zzihg", "zzihc"});
            case 4:
                return zzijs;
            case 5:
                zzeow<zzehy> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehy.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzijs);
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

    public static zzehy zzbeq() {
        return zzijs;
    }

    static {
        zzehy zzehyVar = new zzehy();
        zzijs = zzehyVar;
        zzena.zza(zzehy.class, zzehyVar);
    }
}
