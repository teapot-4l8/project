package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvq;
import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdvx extends zzena<zzdvx, zzb> implements zzeop {
    private static volatile zzeow<zzdvx> zzek;
    private static final zzdvx zzhwu;
    private int zzdv;
    private int zzhwr;
    private zzdvq zzhwt;
    private String zzdw = "";
    private String zzhws = "";

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public enum zza implements zzenf {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzene<zza> zzes = new zzdvz();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzenf
        public final int zzv() {
            return this.value;
        }

        public static zza zzeq(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return BLOCKED_IMPRESSION;
            }
            return EVENT_TYPE_UNKNOWN;
        }

        public static zzenh zzw() {
            return zzdvy.zzeu;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        zza(int i) {
            this.value = i;
        }
    }

    private zzdvx() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena.zzb<zzdvx, zzb> implements zzeop {
        private zzb() {
            super(zzdvx.zzhwu);
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvx) this.zzits).zza(zzaVar);
            return this;
        }

        public final zzb zzhj(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvx) this.zzits).zzj(str);
            return this;
        }

        public final zzb zza(zzdvq.zzb zzbVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvx) this.zzits).zza((zzdvq) ((zzena) zzbVar.zzbjv()));
            return this;
        }

        /* synthetic */ zzb(zzdvw zzdvwVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        this.zzhwr = zzaVar.zzv();
        this.zzdv |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(String str) {
        str.getClass();
        this.zzdv |= 2;
        this.zzdw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdvq zzdvqVar) {
        zzdvqVar.getClass();
        this.zzhwt = zzdvqVar;
        this.zzdv |= 8;
    }

    public static zzb zzazb() {
        return zzhwu.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdvw.zzel[i - 1]) {
            case 1:
                return new zzdvx();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzhwu, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdv", "zzhwr", zza.zzw(), "zzdw", "zzhws", "zzhwt"});
            case 4:
                return zzhwu;
            case 5:
                zzeow<zzdvx> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzdvx.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzhwu);
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
        zzdvx zzdvxVar = new zzdvx();
        zzhwu = zzdvxVar;
        zzena.zza(zzdvx.class, zzdvxVar);
    }
}
