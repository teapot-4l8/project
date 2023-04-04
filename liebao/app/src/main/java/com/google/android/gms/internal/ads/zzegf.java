package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegf extends zzena<zzegf, zza> implements zzeop {
    private static volatile zzeow<zzegf> zzek;
    private static final zzegf zzihr;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzegj zzihq;

    private zzegf() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegf, zza> implements zzeop {
        private zza() {
            super(zzegf.zzihr);
        }

        public final zza zzfg(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegf) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzc(zzegj zzegjVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegf) this.zzits).zzb(zzegjVar);
            return this;
        }

        public final zza zzu(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegf) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzegg zzeggVar) {
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

    public final zzegj zzbcr() {
        zzegj zzegjVar = this.zzihq;
        return zzegjVar == null ? zzegj.zzbcy() : zzegjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzegj zzegjVar) {
        zzegjVar.getClass();
        this.zzihq = zzegjVar;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zzihd = zzelqVar;
    }

    public static zzegf zzg(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegf) zzena.zza(zzihr, zzelqVar, zzemnVar);
    }

    public static zza zzbcs() {
        return zzihr.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegg.zzel[i - 1]) {
            case 1:
                return new zzegf();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zzihq", "zzihd"});
            case 4:
                return zzihr;
            case 5:
                zzeow<zzegf> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegf.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihr);
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

    public static zzegf zzbct() {
        return zzihr;
    }

    static {
        zzegf zzegfVar = new zzegf();
        zzihr = zzegfVar;
        zzena.zza(zzegf.class, zzegfVar);
    }
}
