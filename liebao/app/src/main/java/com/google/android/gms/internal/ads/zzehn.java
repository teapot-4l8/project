package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzehn extends zzena<zzehn, zza> implements zzeop {
    private static volatile zzeow<zzehn> zzek;
    private static final zzehn zziix;
    private int zzihc;
    private zzehj zziin;
    private zzelq zziiv = zzelq.zzipc;
    private zzelq zziiw = zzelq.zzipc;

    private zzehn() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzehn, zza> implements zzeop {
        private zza() {
            super(zzehn.zziix);
        }

        public final zza zzfn(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzc(zzehj zzehjVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).zzb(zzehjVar);
            return this;
        }

        public final zza zzac(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).zzz(zzelqVar);
            return this;
        }

        public final zza zzad(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzehn) this.zzits).zzaa(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzeho zzehoVar) {
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

    public final zzehj zzbds() {
        zzehj zzehjVar = this.zziin;
        return zzehjVar == null ? zzehj.zzbdx() : zzehjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzehj zzehjVar) {
        zzehjVar.getClass();
        this.zziin = zzehjVar;
    }

    public final zzelq zzbec() {
        return this.zziiv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzz(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zziiv = zzelqVar;
    }

    public final zzelq zzbed() {
        return this.zziiw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zziiw = zzelqVar;
    }

    public static zzehn zzs(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzehn) zzena.zza(zziix, zzelqVar, zzemnVar);
    }

    public static zza zzbee() {
        return zziix.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeho.zzel[i - 1]) {
            case 1:
                return new zzehn();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziix, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzihc", "zziin", "zziiv", "zziiw"});
            case 4:
                return zziix;
            case 5:
                zzeow<zzehn> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzehn.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziix);
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

    public static zzehn zzbef() {
        return zziix;
    }

    static {
        zzehn zzehnVar = new zzehn();
        zziix = zzehnVar;
        zzena.zza(zzehn.class, zzehnVar);
    }
}
