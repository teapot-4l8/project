package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegm extends zzena<zzegm, zza> implements zzeop {
    private static volatile zzeow<zzegm> zzek;
    private static final zzegm zzihw;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzegq zzihv;

    private zzegm() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegm, zza> implements zzeop {
        private zza() {
            super(zzegm.zzihw);
        }

        public final zza zzfh(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegm) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzegq zzegqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegm) this.zzits).zza(zzegqVar);
            return this;
        }

        public final zza zzv(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegm) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzegl zzeglVar) {
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

    public final zzegq zzbda() {
        zzegq zzegqVar = this.zzihv;
        return zzegqVar == null ? zzegq.zzbde() : zzegqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzegq zzegqVar) {
        zzegqVar.getClass();
        this.zzihv = zzegqVar;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zzihd = zzelqVar;
    }

    public static zzegm zzi(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegm) zzena.zza(zzihw, zzelqVar, zzemnVar);
    }

    public static zza zzbdb() {
        return zzihw.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegl.zzel[i - 1]) {
            case 1:
                return new zzegm();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzihc", "zzihv", "zzihd"});
            case 4:
                return zzihw;
            case 5:
                zzeow<zzegm> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegm.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihw);
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
        zzegm zzegmVar = new zzegm();
        zzihw = zzegmVar;
        zzena.zza(zzegm.class, zzegmVar);
    }
}
