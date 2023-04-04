package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeio extends zzena<zzeio, zza> implements zzeop {
    private static volatile zzeow<zzeio> zzek;
    private static final zzeio zzile;
    private int zzihc;
    private zzeir zzild;

    private zzeio() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeio, zza> implements zzeop {
        private zza() {
            super(zzeio.zzile);
        }

        public final zza zzfx(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeio) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzb(zzeir zzeirVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeio) this.zzits).zza(zzeirVar);
            return this;
        }

        /* synthetic */ zza(zzeip zzeipVar) {
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

    public final zzeir zzbfu() {
        zzeir zzeirVar = this.zzild;
        return zzeirVar == null ? zzeir.zzbfy() : zzeirVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzeir zzeirVar) {
        zzeirVar.getClass();
        this.zzild = zzeirVar;
    }

    public static zzeio zzv(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzeio) zzena.zza(zzile, zzelqVar, zzemnVar);
    }

    public static zza zzbfv() {
        return zzile.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeip.zzel[i - 1]) {
            case 1:
                return new zzeio();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzile, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzihc", "zzild"});
            case 4:
                return zzile;
            case 5:
                zzeow<zzeio> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeio.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzile);
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
        zzeio zzeioVar = new zzeio();
        zzile = zzeioVar;
        zzena.zza(zzeio.class, zzeioVar);
    }
}
