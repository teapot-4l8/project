package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehm extends zzena<zzehm, zza> implements zzeop {
    private static volatile zzeow<zzehm> zzek;
    private static final zzehm zziiu;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzehn zziit;

    private zzehm() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehm, zza> implements zzeop {
        private zza() {
            super(zzehm.zziiu);
        }

        public final zza zzfm(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehm) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzehn zzehnVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehm) this.zzits).zza(zzehnVar);
            return this;
        }

        public final zza zzab(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehm) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzehl zzehlVar) {
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

    public final zzehn zzbdz() {
        zzehn zzehnVar = this.zziit;
        return zzehnVar == null ? zzehn.zzbef() : zzehnVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzehn zzehnVar) {
        zzehnVar.getClass();
        this.zziit = zzehnVar;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zzihd = zzelqVar;
    }

    public static zzehm zzr(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzehm) zzena.zza(zziiu, zzelqVar, zzemnVar);
    }

    public static zza zzbea() {
        return zziiu.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehl.zzel[i - 1]) {
            case 1:
                return new zzehm();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziiu, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zziit", "zzihd"});
            case 4:
                return zziiu;
            case 5:
                zzeow<zzehm> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehm.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziiu);
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
        zzehm zzehmVar = new zzehm();
        zziiu = zzehmVar;
        zzena.zza(zzehm.class, zzehmVar);
    }
}
