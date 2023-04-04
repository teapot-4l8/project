package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdvq extends zzena<zzdvq, zzb> implements zzeop {
    private static volatile zzeow<zzdvq> zzek;
    private static final zzeni<Integer, zza> zzhwj = new zzdvt();
    private static final zzdvq zzhwn;
    private int zzdv;
    private zzeng zzhwi = zzbjk();
    private String zzhwk = "";
    private String zzhwl = "";
    private String zzhwm = "";

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public enum zza implements zzenf {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzene<zza> zzes = new zzdvu();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzenf
        public final int zzv() {
            return this.value;
        }

        public static zza zzep(int i) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return BLOCKED_REASON_BACKGROUND;
            }
            return BLOCKED_REASON_UNKNOWN;
        }

        public static zzenh zzw() {
            return zzdvv.zzeu;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        zza(int i) {
            this.value = i;
        }
    }

    private zzdvq() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena.zzb<zzdvq, zzb> implements zzeop {
        private zzb() {
            super(zzdvq.zzhwn);
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvq) this.zzits).zza(zzaVar);
            return this;
        }

        public final zzb zzhi(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzdvq) this.zzits).zzhh(str);
            return this;
        }

        /* synthetic */ zzb(zzdvt zzdvtVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzeng zzengVar = this.zzhwi;
        if (!zzengVar.zzbhd()) {
            this.zzhwi = zzena.zza(zzengVar);
        }
        this.zzhwi.zzhp(zzaVar.zzv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzhh(String str) {
        str.getClass();
        this.zzdv |= 1;
        this.zzhwk = str;
    }

    public static zzb zzayz() {
        return zzhwn.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdvs.zzel[i - 1]) {
            case 1:
                return new zzdvq();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzhwn, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdv", "zzhwi", zza.zzw(), "zzhwk", "zzhwl", "zzhwm"});
            case 4:
                return zzhwn;
            case 5:
                zzeow<zzdvq> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzdvq.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzhwn);
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
        zzdvq zzdvqVar = new zzdvq();
        zzhwn = zzdvqVar;
        zzena.zza(zzdvq.class, zzdvqVar);
    }
}
