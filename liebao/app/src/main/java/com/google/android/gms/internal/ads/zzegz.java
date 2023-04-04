package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzegz extends zzena<zzegz, zza> implements zzeop {
    private static volatile zzeow<zzegz> zzek;
    private static final zzegz zziid;
    private int zzihc;
    private zzelq zzihd = zzelq.zzipc;

    private zzegz() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzegz, zza> implements zzeop {
        private zza() {
            super(zzegz.zziid);
        }

        public final zza zzfk(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegz) this.zzits).setVersion(0);
            return this;
        }

        public final zza zzy(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzegz) this.zzits).zzs(zzelqVar);
            return this;
        }

        /* synthetic */ zza(zzeha zzehaVar) {
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

    public static zzegz zzo(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzegz) zzena.zza(zziid, zzelqVar, zzemnVar);
    }

    public static zza zzbdm() {
        return zziid.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeha.zzel[i - 1]) {
            case 1:
                return new zzegz();
            case 2:
                return new zza(null);
            case 3:
                return zza(zziid, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzihc", "zzihd"});
            case 4:
                return zziid;
            case 5:
                zzeow<zzegz> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzegz.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zziid);
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
        zzegz zzegzVar = new zzegz();
        zziid = zzegzVar;
        zzena.zza(zzegz.class, zzegzVar);
    }
}
