package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeis extends zzena<zzeis, zza> implements zzeop {
    private static volatile zzeow<zzeis> zzek;
    private static final zzeis zzili;
    private int zzihc;
    private zzeiv zzilh;

    private zzeis() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeis, zza> implements zzeop {
        private zza() {
            super(zzeis.zzili);
        }

        public final zza zzfy(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeis) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzeiv zzeivVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeis) this.zzits).zza(zzeivVar);
            return this;
        }

        /* synthetic */ zza(zzeit zzeitVar) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzihc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzihc = i;
    }

    public final zzeiv zzbga() {
        zzeiv zzeivVar = this.zzilh;
        return zzeivVar == null ? zzeiv.zzbgf() : zzeivVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzeiv zzeivVar) {
        zzeivVar.getClass();
        this.zzilh = zzeivVar;
    }

    public static zzeis zzx(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzeis) zzena.zza(zzili, zzelqVar, zzemnVar);
    }

    public static zza zzbgb() {
        return zzili.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeit.zzel[i - 1]) {
            case 1:
                return new zzeis();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzili, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzihc", "zzilh"});
            case 4:
                return zzili;
            case 5:
                zzeow<zzeis> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeis.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzili);
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
        zzeis zzeisVar = new zzeis();
        zzili = zzeisVar;
        zzena.zza(zzeis.class, zzeisVar);
    }
}
