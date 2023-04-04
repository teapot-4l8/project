package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegv extends zzena<zzegv, zza> implements zzeop {
    private static volatile zzeow<zzegv> zzek;
    private static final zzegv zziib;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzegv() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegv, zza> implements zzeop {
        private zza() {
            super(zzegv.zziib);
        }

        public final zza zzfj(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegv) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzx(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegv) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzegw zzegwVar) {
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

    public static zzegv zzm(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegv) zzena.zza(zziib, zzelqVar, zzemnVar);
    }

    public static zza zzbdj() {
        return zziib.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegw.zzel[i - 1]) {
            case 1:
                return new zzegv();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziib, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zziib;
            case 5:
                zzeow<zzegv> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegv.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziib);
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
        zzegv zzegvVar = new zzegv();
        zziib = zzegvVar;
        zzena.zza(zzegv.class, zzegvVar);
    }
}
