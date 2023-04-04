package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeqz {

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena<zza, C0109zza> implements zzeop {
        private static volatile zzeow<zza> zzek;
        private static final zza zzjau;
        private int zzdv;
        private int zzjan;
        private zzb zzjao;
        private boolean zzjar;
        private boolean zzjas;
        private byte zzjat = 2;
        private zzelq zzjap = zzelq.zzipc;
        private zzelq zzjaq = zzelq.zzipc;

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzena<zzb, C0110zza> implements zzeop {
            private static volatile zzeow<zzb> zzek;
            private static final zzb zzjaz;
            private int zzdv;
            private String zzjav = "";
            private String zzjaw = "";
            private String zzjax = "";
            private int zzjay;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zza$zzb$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0110zza extends zzena.zzb<zzb, C0110zza> implements zzeop {
                private C0110zza() {
                    super(zzb.zzjaz);
                }

                /* synthetic */ C0110zza(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0110zza(null);
                    case 3:
                        return zza(zzjaz, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdv", "zzjav", "zzjaw", "zzjax", "zzjay"});
                    case 4:
                        return zzjaz;
                    case 5:
                        zzeow<zzb> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzb.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjaz);
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
                zzjaz = zzbVar;
                zzena.zza(zzb.class, zzbVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzenf {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzene<zzc> zzes = new zzera();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzenf
            public final int zzv() {
                return this.value;
            }

            public static zzc zzig(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    return null;
                                }
                                return DANGEROUS_HOST;
                            }
                            return POTENTIALLY_UNWANTED;
                        }
                        return UNKNOWN;
                    }
                    return DANGEROUS;
                }
                return SAFE;
            }

            public static zzenh zzw() {
                return zzerb.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            zzc(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzeqz$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0109zza extends zzena.zzb<zza, C0109zza> implements zzeop {
            private C0109zza() {
                super(zza.zzjau);
            }

            /* synthetic */ C0109zza(zzeqy zzeqyVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzeqy.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0109zza(null);
                case 3:
                    return zza(zzjau, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdv", "zzjan", zzc.zzw(), "zzjao", "zzjap", "zzjaq", "zzjar", "zzjas"});
                case 4:
                    return zzjau;
                case 5:
                    zzeow<zza> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zza.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzjau);
                                zzek = zzeowVar;
                            }
                        }
                    }
                    return zzeowVar;
                case 6:
                    return Byte.valueOf(this.zzjat);
                case 7:
                    this.zzjat = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zzaVar = new zza();
            zzjau = zzaVar;
            zzena.zza(zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena<zzb, C0112zzb> implements zzeop {
        private static volatile zzeow<zzb> zzek;
        private static final zzb zzjbv;
        private int zzcan;
        private int zzdv;
        private int zzjbg;
        private zza zzjbj;
        private zzf zzjbm;
        private boolean zzjbn;
        private boolean zzjbq;
        private boolean zzjbr;
        private zzi zzjbs;
        private byte zzjat = 2;
        private String zzjaw = "";
        private String zzjbh = "";
        private String zzjbi = "";
        private zzenk<zzh> zzjbk = zzbjm();
        private String zzjbl = "";
        private zzenk<String> zzjbo = zzena.zzbjm();
        private String zzjbp = "";
        private zzelq zzjap = zzelq.zzipc;
        private zzenk<String> zzjbt = zzena.zzbjm();
        private zzenk<String> zzjbu = zzena.zzbjm();

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zze extends zzena<zze, C0116zzb> implements zzeop {
            private static volatile zzeow<zze> zzek;
            private static final zze zzjcm;
            private int zzdv;
            private int zzjce;
            private zza zzjck;
            private byte zzjat = 2;
            private zzenk<zzc> zzjcb = zzbjm();
            private zzelq zzjcc = zzelq.zzipc;
            private zzelq zzjcd = zzelq.zzipc;
            private zzelq zzjcl = zzelq.zzipc;

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzena<zza, C0115zza> implements zzeop {
                private static volatile zzeow<zza> zzek;
                private static final zza zzjcp;
                private int zzdv;
                private int zzjcn;
                private zzelq zzjco = zzelq.zzipc;
                private zzelq zzjci = zzelq.zzipc;

                private zza() {
                }

                /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
                /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zze$zza$zza  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C0115zza extends zzena.zzb<zza, C0115zza> implements zzeop {
                    private C0115zza() {
                        super(zza.zzjcp);
                    }

                    /* synthetic */ C0115zza(zzeqy zzeqyVar) {
                        this();
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzena
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzeqy.zzel[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C0115zza(null);
                        case 3:
                            return zza(zzjcp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzjcn", "zzjco", "zzjci"});
                        case 4:
                            return zzjcp;
                        case 5:
                            zzeow<zza> zzeowVar = zzek;
                            if (zzeowVar == null) {
                                synchronized (zza.class) {
                                    zzeowVar = zzek;
                                    if (zzeowVar == null) {
                                        zzeowVar = new zzena.zza<>(zzjcp);
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
                    zzjcp = zzaVar;
                    zzena.zza(zza.class, zzaVar);
                }
            }

            private zze() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zze$zzb  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0116zzb extends zzena.zzb<zze, C0116zzb> implements zzeop {
                private C0116zzb() {
                    super(zze.zzjcm);
                }

                /* synthetic */ C0116zzb(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0116zzb(null);
                    case 3:
                        return zza(zzjcm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdv", "zzjck", "zzjcb", zzc.class, "zzjcc", "zzjcd", "zzjce", "zzjcl"});
                    case 4:
                        return zzjcm;
                    case 5:
                        zzeow<zze> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zze.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjcm);
                                    zzek = zzeowVar;
                                }
                            }
                        }
                        return zzeowVar;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        this.zzjat = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zze zzeVar = new zze();
                zzjcm = zzeVar;
                zzena.zza(zze.class, zzeVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public enum zzg implements zzenf {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzene<zzg> zzes = new zzere();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzenf
            public final int zzv() {
                return this.value;
            }

            public static zzg zzii(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzenh zzw() {
                return zzerf.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            zzg(int i) {
                this.value = i;
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena<zza, C0111zza> implements zzeop {
            private static volatile zzeow<zza> zzek;
            private static final zza zzjbx;
            private int zzdv;
            private String zzjbw = "";

            private zza() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0111zza extends zzena.zzb<zza, C0111zza> implements zzeop {
                private C0111zza() {
                    super(zza.zzjbx);
                }

                public final C0111zza zzii(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zza) this.zzits).zzie(str);
                    return this;
                }

                /* synthetic */ C0111zza(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzie(String str) {
                str.getClass();
                this.zzdv |= 1;
                this.zzjbw = str;
            }

            public static C0111zza zzbmq() {
                return zzjbx.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0111zza(null);
                    case 3:
                        return zza(zzjbx, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdv", "zzjbw"});
                    case 4:
                        return zzjbx;
                    case 5:
                        zzeow<zza> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zza.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjbx);
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
                zzjbx = zzaVar;
                zzena.zza(zza.class, zzaVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzena<zzc, zza> implements zzeop {
            private static volatile zzeow<zzc> zzek;
            private static final zzc zzjbz;
            private int zzdv;
            private byte zzjat = 2;
            private zzelq zzjby = zzelq.zzipc;
            private zzelq zzijw = zzelq.zzipc;

            private zzc() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzena.zzb<zzc, zza> implements zzeop {
                private zza() {
                    super(zzc.zzjbz);
                }

                public final zza zzap(zzelq zzelqVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzc) this.zzits).zzao(zzelqVar);
                    return this;
                }

                public final zza zzaq(zzelq zzelqVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzc) this.zzits).zzaf(zzelqVar);
                    return this;
                }

                /* synthetic */ zza(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzao(zzelq zzelqVar) {
                zzelqVar.getClass();
                this.zzdv |= 1;
                this.zzjby = zzelqVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzaf(zzelq zzelqVar) {
                zzelqVar.getClass();
                this.zzdv |= 2;
                this.zzijw = zzelqVar;
            }

            public static zza zzbmt() {
                return zzjbz.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzjbz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdv", "zzjby", "zzijw"});
                    case 4:
                        return zzjbz;
                    case 5:
                        zzeow<zzc> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzc.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjbz);
                                    zzek = zzeowVar;
                                }
                            }
                        }
                        return zzeowVar;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        this.zzjat = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zzjbz = zzcVar;
                zzena.zza(zzc.class, zzcVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzd extends zzena<zzd, C0114zzb> implements zzeop {
            private static volatile zzeow<zzd> zzek;
            private static final zzd zzjcf;
            private int zzdv;
            private zza zzjca;
            private int zzjce;
            private byte zzjat = 2;
            private zzenk<zzc> zzjcb = zzbjm();
            private zzelq zzjcc = zzelq.zzipc;
            private zzelq zzjcd = zzelq.zzipc;

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzena<zza, C0113zza> implements zzeop {
                private static volatile zzeow<zza> zzek;
                private static final zza zzjcj;
                private int zzdv;
                private zzelq zzjcg = zzelq.zzipc;
                private zzelq zzjch = zzelq.zzipc;
                private zzelq zzjci = zzelq.zzipc;

                private zza() {
                }

                /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
                /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzd$zza$zza  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C0113zza extends zzena.zzb<zza, C0113zza> implements zzeop {
                    private C0113zza() {
                        super(zza.zzjcj);
                    }

                    /* synthetic */ C0113zza(zzeqy zzeqyVar) {
                        this();
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzena
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzeqy.zzel[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C0113zza(null);
                        case 3:
                            return zza(zzjcj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzjcg", "zzjch", "zzjci"});
                        case 4:
                            return zzjcj;
                        case 5:
                            zzeow<zza> zzeowVar = zzek;
                            if (zzeowVar == null) {
                                synchronized (zza.class) {
                                    zzeowVar = zzek;
                                    if (zzeowVar == null) {
                                        zzeowVar = new zzena.zza<>(zzjcj);
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
                    zzjcj = zzaVar;
                    zzena.zza(zza.class, zzaVar);
                }
            }

            private zzd() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzd$zzb  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0114zzb extends zzena.zzb<zzd, C0114zzb> implements zzeop {
                private C0114zzb() {
                    super(zzd.zzjcf);
                }

                public final C0114zzb zzb(zzc zzcVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzd) this.zzits).zza(zzcVar);
                    return this;
                }

                /* synthetic */ C0114zzb(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzc zzcVar) {
                zzcVar.getClass();
                zzenk<zzc> zzenkVar = this.zzjcb;
                if (!zzenkVar.zzbhd()) {
                    this.zzjcb = zzena.zza(zzenkVar);
                }
                this.zzjcb.add(zzcVar);
            }

            public static C0114zzb zzbmv() {
                return zzjcf.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C0114zzb(null);
                    case 3:
                        return zza(zzjcf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdv", "zzjca", "zzjcb", zzc.class, "zzjcc", "zzjcd", "zzjce"});
                    case 4:
                        return zzjcf;
                    case 5:
                        zzeow<zzd> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzd.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjcf);
                                    zzek = zzeowVar;
                                }
                            }
                        }
                        return zzeowVar;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        this.zzjat = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzd zzdVar = new zzd();
                zzjcf = zzdVar;
                zzena.zza(zzd.class, zzdVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzf extends zzena<zzf, C0117zzb> implements zzeop {
            private static volatile zzeow<zzf> zzek;
            private static final zzf zzjcs;
            private int zzcan;
            private int zzdv;
            private String zzjcq = "";
            private zzelq zzjcr = zzelq.zzipc;

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* loaded from: classes.dex */
            public enum zza implements zzenf {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzene<zza> zzes = new zzerd();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzenf
                public final int zzv() {
                    return this.value;
                }

                public static zza zzih(int i) {
                    if (i != 0) {
                        if (i != 1) {
                            return null;
                        }
                        return TYPE_CREATIVE;
                    }
                    return TYPE_UNKNOWN;
                }

                public static zzenh zzw() {
                    return zzerc.zzeu;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                zza(int i) {
                    this.value = i;
                }
            }

            private zzf() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzf$zzb  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0117zzb extends zzena.zzb<zzf, C0117zzb> implements zzeop {
                private C0117zzb() {
                    super(zzf.zzjcs);
                }

                public final C0117zzb zzb(zza zzaVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zza(zzaVar);
                    return this;
                }

                public final C0117zzb zzij(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).setMimeType(str);
                    return this;
                }

                public final C0117zzb zzas(zzelq zzelqVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzar(zzelqVar);
                    return this;
                }

                /* synthetic */ C0117zzb(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zza zzaVar) {
                this.zzcan = zzaVar.zzv();
                this.zzdv |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setMimeType(String str) {
                str.getClass();
                this.zzdv |= 2;
                this.zzjcq = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzar(zzelq zzelqVar) {
                zzelqVar.getClass();
                this.zzdv |= 4;
                this.zzjcr = zzelqVar;
            }

            public static C0117zzb zzbna() {
                return zzjcs.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0117zzb(null);
                    case 3:
                        return zza(zzjcs, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzcan", zza.zzw(), "zzjcq", "zzjcr"});
                    case 4:
                        return zzjcs;
                    case 5:
                        zzeow<zzf> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzf.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjcs);
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
                zzf zzfVar = new zzf();
                zzjcs = zzfVar;
                zzena.zza(zzf.class, zzfVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzh extends zzena<zzh, C0118zzb> implements zzeop {
            private static volatile zzeow<zzh> zzek;
            private static final zzh zzjdp;
            private int zzdv;
            private int zzjdh;
            private zzd zzjdi;
            private zze zzjdj;
            private int zzjdk;
            private int zzjdn;
            private byte zzjat = 2;
            private String zzjaw = "";
            private zzeng zzjdl = zzbjk();
            private String zzjdm = "";
            private zzenk<String> zzjdo = zzena.zzbjm();

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* loaded from: classes.dex */
            public enum zza implements zzenf {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzene<zza> zzes = new zzerg();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzenf
                public final int zzv() {
                    return this.value;
                }

                public static zza zzij(int i) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return null;
                                }
                                return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                            }
                            return AD_RESOURCE_POST_CLICK;
                        }
                        return AD_RESOURCE_CREATIVE;
                    }
                    return AD_RESOURCE_UNKNOWN;
                }

                public static zzenh zzw() {
                    return zzerh.zzeu;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                zza(int i) {
                    this.value = i;
                }
            }

            private zzh() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0118zzb extends zzena.zzb<zzh, C0118zzb> implements zzeop {
                private C0118zzb() {
                    super(zzh.zzjdp);
                }

                public final C0118zzb zzik(int i) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).setId(i);
                    return this;
                }

                public final C0118zzb zzil(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).setUrl(str);
                    return this;
                }

                public final C0118zzb zzb(zzd zzdVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).zza(zzdVar);
                    return this;
                }

                public final C0118zzb zzb(zza zzaVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).zza(zzaVar);
                    return this;
                }

                public final C0118zzb zzim(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzh) this.zzits).zzik(str);
                    return this;
                }

                /* synthetic */ C0118zzb(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setId(int i) {
                this.zzdv |= 1;
                this.zzjdh = i;
            }

            public final String getUrl() {
                return this.zzjaw;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setUrl(String str) {
                str.getClass();
                this.zzdv |= 2;
                this.zzjaw = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzd zzdVar) {
                zzdVar.getClass();
                this.zzjdi = zzdVar;
                this.zzdv |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zza zzaVar) {
                this.zzjdn = zzaVar.zzv();
                this.zzdv |= 64;
            }

            public final int zzbnc() {
                return this.zzjdo.size();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzik(String str) {
                str.getClass();
                zzenk<String> zzenkVar = this.zzjdo;
                if (!zzenkVar.zzbhd()) {
                    this.zzjdo = zzena.zza(zzenkVar);
                }
                this.zzjdo.add(str);
            }

            public static C0118zzb zzbnd() {
                return zzjdp.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0118zzb(null);
                    case 3:
                        return zza(zzjdp, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdv", "zzjdh", "zzjaw", "zzjdi", "zzjdj", "zzjdk", "zzjdl", "zzjdm", "zzjdn", zza.zzw(), "zzjdo"});
                    case 4:
                        return zzjdp;
                    case 5:
                        zzeow<zzh> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzh.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjdp);
                                    zzek = zzeowVar;
                                }
                            }
                        }
                        return zzeowVar;
                    case 6:
                        return Byte.valueOf(this.zzjat);
                    case 7:
                        this.zzjat = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzh zzhVar = new zzh();
                zzjdp = zzhVar;
                zzena.zza(zzh.class, zzhVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzi extends zzena<zzi, zza> implements zzeop {
            private static volatile zzeow<zzi> zzek;
            private static final zzi zzjdy;
            private int zzdv;
            private String zzjdv = "";
            private long zzjdw;
            private boolean zzjdx;

            private zzi() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzena.zzb<zzi, zza> implements zzeop {
                private zza() {
                    super(zzi.zzjdy);
                }

                public final zza zzin(String str) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzi) this.zzits).zzio(str);
                    return this;
                }

                public final zza zzft(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzi) this.zzits).zzfu(j);
                    return this;
                }

                public final zza zzca(boolean z) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzi) this.zzits).zzcb(z);
                    return this;
                }

                /* synthetic */ zza(zzeqy zzeqyVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzio(String str) {
                str.getClass();
                this.zzdv |= 1;
                this.zzjdv = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzfu(long j) {
                this.zzdv |= 2;
                this.zzjdw = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcb(boolean z) {
                this.zzdv |= 4;
                this.zzjdx = z;
            }

            public static zza zzbnf() {
                return zzjdy.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeqy.zzel[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzjdy, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdv", "zzjdv", "zzjdw", "zzjdx"});
                    case 4:
                        return zzjdy;
                    case 5:
                        zzeow<zzi> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzi.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzjdy);
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
                zzi zziVar = new zzi();
                zzjdy = zziVar;
                zzena.zza(zzi.class, zziVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzeqz$zzb$zzb  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0112zzb extends zzena.zzb<zzb, C0112zzb> implements zzeop {
            private C0112zzb() {
                super(zzb.zzjbv);
            }

            public final C0112zzb zzb(zzg zzgVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzgVar);
                return this;
            }

            public final String getUrl() {
                return ((zzb) this.zzits).getUrl();
            }

            public final C0112zzb zzif(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).setUrl(str);
                return this;
            }

            public final C0112zzb zzig(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzid(str);
                return this;
            }

            public final C0112zzb zzb(zza zzaVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzaVar);
                return this;
            }

            public final List<zzh> zzbml() {
                return Collections.unmodifiableList(((zzb) this.zzits).zzbml());
            }

            public final C0112zzb zzb(zzh zzhVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzhVar);
                return this;
            }

            public final String zzbmm() {
                return ((zzb) this.zzits).zzbmm();
            }

            public final C0112zzb zzih(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzdw(str);
                return this;
            }

            public final C0112zzb zzbms() {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzbmn();
                return this;
            }

            public final C0112zzb zzb(zzf zzfVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zzfVar);
                return this;
            }

            public final C0112zzb zzb(zzi zziVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zza(zziVar);
                return this;
            }

            public final C0112zzb zzo(Iterable<String> iterable) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzm(iterable);
                return this;
            }

            public final C0112zzb zzp(Iterable<String> iterable) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzb) this.zzits).zzn(iterable);
                return this;
            }

            /* synthetic */ C0112zzb(zzeqy zzeqyVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            this.zzcan = zzgVar.zzv();
            this.zzdv |= 1;
        }

        public final String getUrl() {
            return this.zzjaw;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setUrl(String str) {
            str.getClass();
            this.zzdv |= 4;
            this.zzjaw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzid(String str) {
            str.getClass();
            this.zzdv |= 8;
            this.zzjbh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            zzaVar.getClass();
            this.zzjbj = zzaVar;
            this.zzdv |= 32;
        }

        public final List<zzh> zzbml() {
            return this.zzjbk;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzh zzhVar) {
            zzhVar.getClass();
            zzenk<zzh> zzenkVar = this.zzjbk;
            if (!zzenkVar.zzbhd()) {
                this.zzjbk = zzena.zza(zzenkVar);
            }
            this.zzjbk.add(zzhVar);
        }

        public final String zzbmm() {
            return this.zzjbl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzdw(String str) {
            str.getClass();
            this.zzdv |= 64;
            this.zzjbl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbmn() {
            this.zzdv &= -65;
            this.zzjbl = zzjbv.zzjbl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            this.zzjbm = zzfVar;
            this.zzdv |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzi zziVar) {
            zziVar.getClass();
            this.zzjbs = zziVar;
            this.zzdv |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(Iterable<String> iterable) {
            zzenk<String> zzenkVar = this.zzjbt;
            if (!zzenkVar.zzbhd()) {
                this.zzjbt = zzena.zza(zzenkVar);
            }
            zzelg.zza(iterable, this.zzjbt);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(Iterable<String> iterable) {
            zzenk<String> zzenkVar = this.zzjbu;
            if (!zzenkVar.zzbhd()) {
                this.zzjbu = zzena.zza(zzenkVar);
            }
            zzelg.zza(iterable, this.zzjbu);
        }

        public static C0112zzb zzbmo() {
            return zzjbv.zzbjh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzeqy.zzel[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0112zzb(null);
                case 3:
                    return zza(zzjbv, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdv", "zzjaw", "zzjbh", "zzjbi", "zzjbk", zzh.class, "zzjbn", "zzjbo", "zzjbp", "zzjbq", "zzjbr", "zzcan", zzg.zzw(), "zzjbg", zza.zzc.zzw(), "zzjbj", "zzjbl", "zzjbm", "zzjap", "zzjbs", "zzjbt", "zzjbu"});
                case 4:
                    return zzjbv;
                case 5:
                    zzeow<zzb> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzb.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzjbv);
                                zzek = zzeowVar;
                            }
                        }
                    }
                    return zzeowVar;
                case 6:
                    return Byte.valueOf(this.zzjat);
                case 7:
                    this.zzjat = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzjbv = zzbVar;
            zzena.zza(zzb.class, zzbVar);
        }
    }
}
