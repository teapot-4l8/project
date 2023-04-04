package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzefw extends zzena<zzefw, zza> implements zzeop {
    private static volatile zzeow<zzefw> zzek;
    private static final zzefw zzihf;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;
    private zzega zzihe;

    private zzefw() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzefw, zza> implements zzeop {
        private zza() {
            super(zzefw.zzihf);
        }

        public final zza zzfe(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzefw) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzt(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzefw) this.zzits).zzs(zzelqVar);
            return this;
        }

        public final zza zzd(zzega zzegaVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzefw) this.zzits).zzc(zzegaVar);
            return this;
        }

        /* synthetic */ zza(zzefv zzefvVar) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzihc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzihc = 0;
    }

    public final zzelq zzbcc() {
        return this.zzihd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zzihd = zzelqVar;
    }

    public final zzega zzbcd() {
        zzega zzegaVar = this.zzihe;
        return zzegaVar == null ? zzega.zzbci() : zzegaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzega zzegaVar) {
        zzegaVar.getClass();
        this.zzihe = zzegaVar;
    }

    public static zzefw zzc(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzefw) zzena.zza(zzihf, zzelqVar, zzemnVar);
    }

    public static zza zzbce() {
        return zzihf.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefv.zzel[i - 1]) {
            case 1:
                return new zzefw();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzihc", "zzihd", "zzihe"});
            case 4:
                return zzihf;
            case 5:
                zzeow<zzefw> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzefw.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihf);
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
        zzefw zzefwVar = new zzefw();
        zzihf = zzefwVar;
        zzena.zza(zzefw.class, zzefwVar);
    }
}
