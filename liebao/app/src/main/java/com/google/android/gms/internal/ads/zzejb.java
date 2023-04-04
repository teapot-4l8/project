package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzejb extends zzena<zzejb, zza> implements zzeop {
    private static volatile zzeow<zzejb> zzek;
    private static final zzejb zzilw;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzejb() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzejb, zza> implements zzeop {
        private zza() {
            super(zzejb.zzilw);
        }

        public final zza zzga(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzejb) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzah(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzejb) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzeja zzejaVar) {
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

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zzihd = zzelqVar;
    }

    public static zzejb zzz(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzejb) zzena.zza(zzilw, zzelqVar, zzemnVar);
    }

    public static zza zzbgk() {
        return zzilw.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeja.zzel[i - 1]) {
            case 1:
                return new zzejb();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzilw, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zzilw;
            case 5:
                zzeow<zzejb> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzejb.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzilw);
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
        zzejb zzejbVar = new zzejb();
        zzilw = zzejbVar;
        zzena.zza(zzejb.class, zzejbVar);
    }
}
