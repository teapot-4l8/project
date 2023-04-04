package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegb extends zzena<zzegb, zza> implements zzeop {
    private static volatile zzeow<zzegb> zzek;
    private static final zzegb zzihm;
    private int zzihc;
    private zzegf zzihk;
    private zzehu zzihl;

    private zzegb() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegb, zza> implements zzeop {
        private zza() {
            super(zzegb.zzihm);
        }

        public final zza zzff(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegb) this.zzits).setVersion(i);
            return this;
        }

        public final zza zzc(zzegf zzegfVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegb) this.zzits).zzb(zzegfVar);
            return this;
        }

        public final zza zzc(zzehu zzehuVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegb) this.zzits).zzb(zzehuVar);
            return this;
        }

        /* synthetic */ zza(zzegc zzegcVar) {
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

    public final zzegf zzbck() {
        zzegf zzegfVar = this.zzihk;
        return zzegfVar == null ? zzegf.zzbct() : zzegfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzegf zzegfVar) {
        zzegfVar.getClass();
        this.zzihk = zzegfVar;
    }

    public final zzehu zzbcl() {
        zzehu zzehuVar = this.zzihl;
        return zzehuVar == null ? zzehu.zzbeo() : zzehuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzehu zzehuVar) {
        zzehuVar.getClass();
        this.zzihl = zzehuVar;
    }

    public static zzegb zze(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegb) zzena.zza(zzihm, zzelqVar, zzemnVar);
    }

    public static zza zzbcm() {
        return zzihm.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegc.zzel[i - 1]) {
            case 1:
                return new zzegb();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihm, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzihc", "zzihk", "zzihl"});
            case 4:
                return zzihm;
            case 5:
                zzeow<zzegb> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegb.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihm);
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
        zzegb zzegbVar = new zzegb();
        zzihm = zzegbVar;
        zzena.zza(zzegb.class, zzegbVar);
    }
}
