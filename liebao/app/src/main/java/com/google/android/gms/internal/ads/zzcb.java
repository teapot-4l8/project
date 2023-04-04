package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcb {

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena<zza, C0103zza> implements zzeop {
        private static volatile zzeow<zza> zzek;
        private static final zza zzex;
        private int zzdv;
        private zzb zzev;
        private zzc zzew;

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzcb$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0103zza extends zzena.zzb<zza, C0103zza> implements zzeop {
            private C0103zza() {
                super(zza.zzex);
            }

            /* synthetic */ C0103zza(zzca zzcaVar) {
                this();
            }
        }

        public final boolean zzx() {
            return (this.zzdv & 1) != 0;
        }

        public final zzb zzy() {
            zzb zzbVar = this.zzev;
            return zzbVar == null ? zzb.zzad() : zzbVar;
        }

        public final boolean zzz() {
            return (this.zzdv & 2) != 0;
        }

        public final zzc zzaa() {
            zzc zzcVar = this.zzew;
            return zzcVar == null ? zzc.zzag() : zzcVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzca.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0103zza(null);
                case 3:
                    return zza(zzex, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzdv", "zzev", "zzew"});
                case 4:
                    return zzex;
                case 5:
                    zzeow<zza> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zza.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzex);
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
            zza zzaVar = new zza();
            zzex = zzaVar;
            zzena.zza(zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena<zzb, zza> implements zzeop {
        private static volatile zzeow<zzb> zzek;
        private static final zzb zzez;
        private int zzdv;
        private int zzey = 2;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zzb, zza> implements zzeop {
            private zza() {
                super(zzb.zzez);
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        public final zzcd zzac() {
            zzcd zzj = zzcd.zzj(this.zzey);
            return zzj == null ? zzcd.ENUM_SIGNAL_SOURCE_ADSHIELD : zzj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzca.zzel[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzez, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zzdv", "zzey", zzcd.zzw()});
                case 4:
                    return zzez;
                case 5:
                    zzeow<zzb> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzb.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzez);
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

        public static zzb zzad() {
            return zzez;
        }

        static {
            zzb zzbVar = new zzb();
            zzez = zzbVar;
            zzena.zza(zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzc extends zzena<zzc, zza> implements zzeop {
        private static volatile zzeow<zzc> zzek;
        private static final zzc zzfm;
        private int zzdv;
        private String zzfg = "";
        private String zzfh = "";
        private String zzfi = "";
        private String zzfj = "";
        private String zzfk = "";
        private String zzfl = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zzc, zza> implements zzeop {
            private zza() {
                super(zzc.zzfm);
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        public final String zzaf() {
            return this.zzfg;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzca.zzel[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzfm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzdv", "zzfg", "zzfh", "zzfi", "zzfj", "zzfk", "zzfl"});
                case 4:
                    return zzfm;
                case 5:
                    zzeow<zzc> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzc.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzfm);
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

        public static zzc zzag() {
            return zzfm;
        }

        static {
            zzc zzcVar = new zzc();
            zzfm = zzcVar;
            zzena.zza(zzc.class, zzcVar);
        }
    }
}
