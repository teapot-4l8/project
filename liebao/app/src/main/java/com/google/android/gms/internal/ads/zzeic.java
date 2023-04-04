package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeic extends zzena<zzeic, zzb> implements zzeop {
    private static volatile zzeow<zzeic> zzek;
    private static final zzeic zzijy;
    private String zzijv = "";
    private zzelq zzijw = zzelq.zzipc;
    private int zzijx;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public enum zza implements zzenf {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzene<zza> zzes = new zzeie();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzenf
        public final int zzv() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        public static zza zzfr(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return REMOTE;
                        }
                        return ASYMMETRIC_PUBLIC;
                    }
                    return ASYMMETRIC_PRIVATE;
                }
                return SYMMETRIC;
            }
            return UNKNOWN_KEYMATERIAL;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzv());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        zza(int i) {
            this.value = i;
        }
    }

    private zzeic() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena.zzb<zzeic, zzb> implements zzeop {
        private zzb() {
            super(zzeic.zzijy);
        }

        public final zzb zzhv(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeic) this.zzits).zzhu(str);
            return this;
        }

        public final zzb zzag(zzelq zzelqVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeic) this.zzits).zzaf(zzelqVar);
            return this;
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzeic) this.zzits).zza(zzaVar);
            return this;
        }

        /* synthetic */ zzb(zzeib zzeibVar) {
            this();
        }
    }

    public final String zzbev() {
        return this.zzijv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzhu(String str) {
        str.getClass();
        this.zzijv = str;
    }

    public final zzelq zzbew() {
        return this.zzijw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(zzelq zzelqVar) {
        zzelqVar.getClass();
        this.zzijw = zzelqVar;
    }

    public final zza zzbex() {
        zza zzfr = zza.zzfr(this.zzijx);
        return zzfr == null ? zza.UNRECOGNIZED : zzfr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        this.zzijx = zzaVar.zzv();
    }

    public static zzb zzbey() {
        return zzijy.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeib.zzel[i - 1]) {
            case 1:
                return new zzeic();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzijy, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzijv", "zzijw", "zzijx"});
            case 4:
                return zzijy;
            case 5:
                zzeow<zzeic> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeic.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzijy);
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

    public static zzeic zzbez() {
        return zzijy;
    }

    static {
        zzeic zzeicVar = new zzeic();
        zzijy = zzeicVar;
        zzena.zza(zzeic.class, zzeicVar);
    }
}
