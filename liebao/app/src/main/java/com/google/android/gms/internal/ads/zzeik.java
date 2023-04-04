package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeik extends zzena<zzeik, zza> implements zzeop {
    private static volatile zzeow<zzeik> zzek;
    private static final zzeik zzikv;
    private int zzikt;
    private zzenk<zzb> zziku = zzbjm();

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena<zzb, zza> implements zzeop {
        private static volatile zzeow<zzb> zzek;
        private static final zzb zzikz;
        private int zzikm;
        private zzeic zzikw;
        private int zzikx;
        private int zziky;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zzb, zza> implements zzeop {
            private zza() {
                super(zzb.zzikz);
            }

            /* synthetic */ zza(zzeil zzeilVar) {
                this();
            }
        }

        public final boolean zzbfm() {
            return this.zzikw != null;
        }

        public final zzeic zzbfn() {
            zzeic zzeicVar = this.zzikw;
            return zzeicVar == null ? zzeic.zzbez() : zzeicVar;
        }

        public final zzeid zzbbr() {
            zzeid zzfs = zzeid.zzfs(this.zzikx);
            return zzfs == null ? zzeid.UNRECOGNIZED : zzfs;
        }

        public final int zzbfo() {
            return this.zziky;
        }

        public final zzeiw zzbbs() {
            zzeiw zzfz = zzeiw.zzfz(this.zzikm);
            return zzfz == null ? zzeiw.UNRECOGNIZED : zzfz;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzeil.zzel[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzikz, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzikw", "zzikx", "zziky", "zzikm"});
                case 4:
                    return zzikz;
                case 5:
                    zzeow<zzb> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzb.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzikz);
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
            zzb zzbVar = new zzb();
            zzikz = zzbVar;
            zzena.zza(zzb.class, zzbVar);
        }
    }

    private zzeik() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeik, zza> implements zzeop {
        private zza() {
            super(zzeik.zzikv);
        }

        /* synthetic */ zza(zzeil zzeilVar) {
            this();
        }
    }

    public final int zzbfi() {
        return this.zzikt;
    }

    public final List<zzb> zzbfj() {
        return this.zziku;
    }

    public final int zzbfk() {
        return this.zziku.size();
    }

    public static zzeik zzc(byte[] bArr, zzemn zzemnVar) {
        return (zzeik) zzena.zza(zzikv, bArr, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeil.zzel[i - 1]) {
            case 1:
                return new zzeik();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzikv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzikt", "zziku", zzb.class});
            case 4:
                return zzikv;
            case 5:
                zzeow<zzeik> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeik.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzikv);
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
        zzeik zzeikVar = new zzeik();
        zzikv = zzeikVar;
        zzena.zza(zzeik.class, zzeikVar);
    }
}
