package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegr extends zzena<zzegr, zza> implements zzeop {
    private static volatile zzeow<zzegr> zzek;
    private static final zzegr zzihz;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzegr() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegr, zza> implements zzeop {
        private zza() {
            super(zzegr.zzihz);
        }

        public final zza zzfi(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegr) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzw(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegr) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzegs zzegsVar) {
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

    public static zzegr zzk(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegr) zzena.zza(zzihz, zzelqVar, zzemnVar);
    }

    public static zza zzbdg() {
        return zzihz.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegs.zzel[i - 1]) {
            case 1:
                return new zzegr();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzihz, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zzihz;
            case 5:
                zzeow<zzegr> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegr.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzihz);
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
        zzegr zzegrVar = new zzegr();
        zzihz = zzegrVar;
        zzena.zza(zzegr.class, zzegrVar);
    }
}
