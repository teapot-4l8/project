package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehu extends zzena<zzehu, zza> implements zzeop {
    private static volatile zzeow<zzehu> zzek;
    private static final zzehu zzijr;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzehz zzijq;

    private zzehu() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehu, zza> implements zzeop {
        private zza() {
            super(zzehu.zzijr);
        }

        public final zza zzfq(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehu) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzd(zzehz zzehzVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehu) this.zzits).zzc(zzehzVar);
            return this;
        }

        public final zza zzae(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehu) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzehw zzehwVar) {
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

    public final zzehz zzbem() {
        zzehz zzehzVar = this.zzijq;
        return zzehzVar == null ? zzehz.zzbet() : zzehzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzehz zzehzVar) {
        zzehzVar.getClass();
        this.zzijq = zzehzVar;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zzihd = zzelqVar;
    }

    public static zzehu zzt(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzehu) zzena.zza(zzijr, zzelqVar, zzemnVar);
    }

    public static zza zzben() {
        return zzijr.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzehw.zzel[i - 1]) {
            case 1:
                return new zzehu();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzijr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zzijq", "zzihd"});
            case 4:
                return zzijr;
            case 5:
                zzeow<zzehu> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehu.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzijr);
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

    public static zzehu zzbeo() {
        return zzijr;
    }

    static {
        zzehu zzehuVar = new zzehu();
        zzijr = zzehuVar;
        zzena.zza(zzehu.class, zzehuVar);
    }
}
