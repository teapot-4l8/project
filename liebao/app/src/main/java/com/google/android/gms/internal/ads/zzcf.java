package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcf {

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena<zza, zzb> implements zzeop {
        private static volatile zzeow<zza> zzek;
        private static final zza zzil;
        private int zzdv;
        private int zzfn;
        private int zzfo;
        private long zzfq;
        private long zzfr;
        private long zzfs;
        private long zzft;
        private long zzfu;
        private long zzfv;
        private long zzfw;
        private long zzfx;
        private long zzfy;
        private long zzfz;
        private long zzgb;
        private long zzgc;
        private long zzgd;
        private long zzge;
        private long zzgf;
        private long zzgg;
        private long zzgh;
        private long zzgi;
        private long zzgj;
        private long zzgm;
        private long zzgn;
        private long zzgo;
        private long zzgp;
        private zzb zzgs;
        private zzf zzhi;
        private zzg zzhk;
        private int zzhv;
        private int zzhw;
        private int zzhx;
        private zze zzhy;
        private long zzie;
        private boolean zzih;
        private long zzij;
        private zzd zzik;
        private String zzfp = "";
        private String zzef = "";
        private String zzga = "";
        private String zzfg = "";
        private String zzgk = "D";
        private String zzgl = "";
        private String zzfi = "";
        private long zzgq = -1;
        private long zzgr = -1;
        private long zzgt = -1;
        private long zzgu = -1;
        private long zzgv = -1;
        private long zzgw = -1;
        private long zzgx = -1;
        private long zzgy = -1;
        private String zzfj = "D";
        private String zzfk = "D";
        private long zzgz = -1;
        private int zzha = 1000;
        private int zzhb = 1000;
        private long zzhc = -1;
        private long zzhd = -1;
        private long zzhe = -1;
        private long zzhf = -1;
        private long zzhg = -1;
        private int zzhh = 1000;
        private zzenk<zzf> zzhj = zzbjm();
        private long zzhl = -1;
        private long zzhm = -1;
        private long zzhn = -1;
        private long zzho = -1;
        private long zzhp = -1;
        private long zzhq = -1;
        private long zzhr = -1;
        private long zzhs = -1;
        private String zzht = "D";
        private long zzhu = -1;
        private long zzhz = -1;
        private int zzia = 1000;
        private int zzib = 1000;
        private String zzic = "D";
        private zzenk<zze> zzid = zzbjm();
        private String zzif = "";
        private int zzig = 2;
        private String zzii = "";

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0104zza implements zzenf {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);
            
            private static final zzene<EnumC0104zza> zzes = new zzci();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzenf
            public final int zzv() {
                return this.value;
            }

            public static EnumC0104zza zzk(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            public static zzenh zzw() {
                return zzch.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            EnumC0104zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzenf {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6),
            DEVICE_IDENTIFIER_PER_APP_ID(7);
            
            private static final zzene<zzc> zzes = new zzcj();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzenf
            public final int zzv() {
                return this.value;
            }

            public static zzc zzl(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    case 7:
                        return DEVICE_IDENTIFIER_PER_APP_ID;
                    default:
                        return null;
                }
            }

            public static zzenh zzw() {
                return zzck.zzeu;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            zzc(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public enum zzd implements zzenf {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(AdRequest.MAX_CONTENT_URL_LENGTH),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(2048),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);
            
            private static final zzene<zzd> zzes = new zzcl();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzenf
            public final int zzv() {
                return this.value;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            zzd(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zze extends zzena<zze, C0105zza> implements zzeop {
            private static volatile zzeow<zze> zzek;
            private static final zze zzkf;
            private int zzdv;
            private int zzkd;
            private long zzke = -1;

            private zze() {
            }

            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zze$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0105zza extends zzena.zzb<zze, C0105zza> implements zzeop {
                private C0105zza() {
                    super(zze.zzkf);
                }

                /* synthetic */ C0105zza(zzcg zzcgVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzcg.zzel[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0105zza(null);
                    case 3:
                        return zza(zzkf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zzdv", "zzkd", zzc.zzw(), "zzke"});
                    case 4:
                        return zzkf;
                    case 5:
                        zzeow<zze> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zze.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzkf);
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
                zze zzeVar = new zze();
                zzkf = zzeVar;
                zzena.zza(zze.class, zzeVar);
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzf extends zzena<zzf, C0106zza> implements zzeop {
            private static volatile zzeow<zzf> zzek;
            private static final zzf zzkz;
            private int zzdv;
            private long zzkt;
            private long zzku;
            private long zzgb = -1;
            private long zzgc = -1;
            private long zzkg = -1;
            private long zzkh = -1;
            private long zzki = -1;
            private long zzkj = -1;
            private int zzkk = 1000;
            private long zzkl = -1;
            private long zzkm = -1;
            private long zzkn = -1;
            private int zzko = 1000;
            private long zzkp = -1;
            private long zzkq = -1;
            private long zzkr = -1;
            private long zzks = -1;
            private long zzkv = -1;
            private long zzkw = -1;
            private long zzkx = -1;
            private long zzky = -1;

            private zzf() {
            }

            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzf$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0106zza extends zzena.zzb<zzf, C0106zza> implements zzeop {
                private C0106zza() {
                    super(zzf.zzkz);
                }

                public final C0106zza zzcl(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzj(j);
                    return this;
                }

                public final C0106zza zzcm(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzk(j);
                    return this;
                }

                public final C0106zza zzcn(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbs(j);
                    return this;
                }

                public final C0106zza zzco(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbt(j);
                    return this;
                }

                public final C0106zza zzaz() {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzau();
                    return this;
                }

                public final C0106zza zzcp(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbu(j);
                    return this;
                }

                public final C0106zza zzcq(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbv(j);
                    return this;
                }

                public final C0106zza zzm(zzcq zzcqVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzk(zzcqVar);
                    return this;
                }

                public final C0106zza zzcr(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbw(j);
                    return this;
                }

                public final C0106zza zzcs(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbx(j);
                    return this;
                }

                public final C0106zza zzct(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzby(j);
                    return this;
                }

                public final C0106zza zzn(zzcq zzcqVar) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzl(zzcqVar);
                    return this;
                }

                public final C0106zza zzcu(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzbz(j);
                    return this;
                }

                public final C0106zza zzcv(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzca(j);
                    return this;
                }

                public final C0106zza zzcw(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcb(j);
                    return this;
                }

                public final C0106zza zzcx(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcc(j);
                    return this;
                }

                public final C0106zza zzcy(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcd(j);
                    return this;
                }

                public final C0106zza zzcz(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzce(j);
                    return this;
                }

                public final C0106zza zzda(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcf(j);
                    return this;
                }

                public final C0106zza zzdb(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzf) this.zzits).zzcg(j);
                    return this;
                }

                /* synthetic */ C0106zza(zzcg zzcgVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzj(long j) {
                this.zzdv |= 1;
                this.zzgb = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzk(long j) {
                this.zzdv |= 2;
                this.zzgc = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbs(long j) {
                this.zzdv |= 4;
                this.zzkg = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbt(long j) {
                this.zzdv |= 8;
                this.zzkh = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzau() {
                this.zzdv &= -9;
                this.zzkh = -1L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbu(long j) {
                this.zzdv |= 16;
                this.zzki = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbv(long j) {
                this.zzdv |= 32;
                this.zzkj = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzk(zzcq zzcqVar) {
                this.zzkk = zzcqVar.zzv();
                this.zzdv |= 64;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbw(long j) {
                this.zzdv |= 128;
                this.zzkl = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbx(long j) {
                this.zzdv |= 256;
                this.zzkm = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzby(long j) {
                this.zzdv |= AdRequest.MAX_CONTENT_URL_LENGTH;
                this.zzkn = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzl(zzcq zzcqVar) {
                this.zzko = zzcqVar.zzv();
                this.zzdv |= 1024;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbz(long j) {
                this.zzdv |= 2048;
                this.zzkp = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzca(long j) {
                this.zzdv |= 4096;
                this.zzkq = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcb(long j) {
                this.zzdv |= 8192;
                this.zzkr = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcc(long j) {
                this.zzdv |= 16384;
                this.zzks = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcd(long j) {
                this.zzdv |= 32768;
                this.zzkt = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzce(long j) {
                this.zzdv |= 65536;
                this.zzku = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcf(long j) {
                this.zzdv |= 131072;
                this.zzkv = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcg(long j) {
                this.zzdv |= 262144;
                this.zzkw = j;
            }

            public static C0106zza zzav() {
                return zzkz.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzcg.zzel[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0106zza(null);
                    case 3:
                        return zza(zzkz, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzdv", "zzgb", "zzgc", "zzkg", "zzkh", "zzki", "zzkj", "zzkk", zzcq.zzw(), "zzkl", "zzkm", "zzkn", "zzko", zzcq.zzw(), "zzkp", "zzkq", "zzkr", "zzks", "zzkt", "zzku", "zzkv", "zzkw", "zzkx", "zzky"});
                    case 4:
                        return zzkz;
                    case 5:
                        zzeow<zzf> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzf.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzkz);
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
                zzkz = zzfVar;
                zzena.zza(zzf.class, zzfVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzg extends zzena<zzg, C0107zza> implements zzeop {
            private static volatile zzeow<zzg> zzek;
            private static final zzg zzle;
            private int zzdv;
            private long zzhf = -1;
            private long zzhg = -1;
            private long zzla = -1;
            private long zzlb = -1;
            private long zzlc = -1;
            private long zzld = -1;

            private zzg() {
            }

            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzg$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0107zza extends zzena.zzb<zzg, C0107zza> implements zzeop {
                private C0107zza() {
                    super(zzg.zzle);
                }

                public final C0107zza zzdc(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzch(j);
                    return this;
                }

                public final C0107zza zzdd(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzci(j);
                    return this;
                }

                public final C0107zza zzde(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzcj(j);
                    return this;
                }

                public final C0107zza zzdf(long j) {
                    if (this.zzitt) {
                        zzbjr();
                        this.zzitt = false;
                    }
                    ((zzg) this.zzits).zzck(j);
                    return this;
                }

                /* synthetic */ C0107zza(zzcg zzcgVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzch(long j) {
                this.zzdv |= 4;
                this.zzla = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzci(long j) {
                this.zzdv |= 8;
                this.zzlb = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcj(long j) {
                this.zzdv |= 16;
                this.zzlc = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzck(long j) {
                this.zzdv |= 32;
                this.zzld = j;
            }

            public static C0107zza zzax() {
                return zzle.zzbjh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzcg.zzel[i - 1]) {
                    case 1:
                        return new zzg();
                    case 2:
                        return new C0107zza(null);
                    case 3:
                        return zza(zzle, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzdv", "zzhf", "zzhg", "zzla", "zzlb", "zzlc", "zzld"});
                    case 4:
                        return zzle;
                    case 5:
                        zzeow<zzg> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (zzg.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzle);
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
                zzg zzgVar = new zzg();
                zzle = zzgVar;
                zzena.zza(zzg.class, zzgVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzena.zzb<zza, zzb> implements zzeop {
            private zzb() {
                super(zza.zzil);
            }

            public final zzb zzac(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzt(str);
                return this;
            }

            public final zzb zzad(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzu(str);
                return this;
            }

            public final zzb zzal(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zze(j);
                return this;
            }

            public final zzb zzam(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzf(j);
                return this;
            }

            public final zzb zzan(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzg(j);
                return this;
            }

            public final zzb zzao(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzh(j);
                return this;
            }

            public final zzb zzap(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzi(j);
                return this;
            }

            public final zzb zzaq(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzj(j);
                return this;
            }

            public final zzb zzar(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzk(j);
                return this;
            }

            public final zzb zzas(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzl(j);
                return this;
            }

            public final zzb zzat(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzm(j);
                return this;
            }

            public final zzb zzau(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzn(j);
                return this;
            }

            public final zzb zzav(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzo(j);
                return this;
            }

            public final zzb zzaw(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzp(j);
                return this;
            }

            public final zzb zzae(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzv(str);
                return this;
            }

            public final zzb zzaf(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzw(str);
                return this;
            }

            public final zzb zzax(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzq(j);
                return this;
            }

            public final zzb zzay(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzr(j);
                return this;
            }

            public final zzb zzaz(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzs(j);
                return this;
            }

            public final zzb zzag(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzx(str);
                return this;
            }

            public final zzb zzba(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzt(j);
                return this;
            }

            @Deprecated
            public final zzb zzbb(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzu(j);
                return this;
            }

            public final zzb zzbc(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzv(j);
                return this;
            }

            public final zzb zzbd(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzw(j);
                return this;
            }

            public final zzb zzbe(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzx(j);
                return this;
            }

            public final zzb zzbf(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzy(j);
                return this;
            }

            public final zzb zzbg(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzz(j);
                return this;
            }

            public final zzb zzbh(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaa(j);
                return this;
            }

            public final zzb zzbi(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzab(j);
                return this;
            }

            public final zzb zzah(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzy(str);
                return this;
            }

            public final zzb zzai(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzz(str);
                return this;
            }

            public final zzb zzf(zzcq zzcqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzcqVar);
                return this;
            }

            public final zzb zzg(zzcq zzcqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzb(zzcqVar);
                return this;
            }

            public final zzb zzbj(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzac(j);
                return this;
            }

            public final zzb zzbk(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzad(j);
                return this;
            }

            public final zzb zzbl(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzae(j);
                return this;
            }

            public final zzb zzh(zzcq zzcqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzc(zzcqVar);
                return this;
            }

            public final zzb zzc(zzf zzfVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzfVar);
                return this;
            }

            public final zzb zzd(zzf zzfVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzb(zzfVar);
                return this;
            }

            public final zzb zzas() {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaj();
                return this;
            }

            public final zzb zzb(zzg zzgVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzgVar);
                return this;
            }

            public final zzb zzbm(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaf(j);
                return this;
            }

            public final zzb zzbn(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzag(j);
                return this;
            }

            public final zzb zzbo(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzah(j);
                return this;
            }

            public final zzb zzbp(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzai(j);
                return this;
            }

            public final zzb zzbq(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaj(j);
                return this;
            }

            public final zzb zzaj(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzaa(str);
                return this;
            }

            public final zzb zzi(zzcq zzcqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzd(zzcqVar);
                return this;
            }

            public final zzb zzj(zzcq zzcqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zze(zzcqVar);
                return this;
            }

            public final zzb zzak(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzab(str);
                return this;
            }

            public final zzb zzb(zzc zzcVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzcVar);
                return this;
            }

            public final zzb zzb(boolean z) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(z);
                return this;
            }

            public final zzb zzbr(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzak(j);
                return this;
            }

            /* synthetic */ zzb(zzcg zzcgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt(String str) {
            str.getClass();
            this.zzdv |= 1;
            this.zzfp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzu(String str) {
            str.getClass();
            this.zzdv |= 2;
            this.zzef = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j) {
            this.zzdv |= 4;
            this.zzfq = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzdv |= 16;
            this.zzfs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzdv |= 32;
            this.zzft = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzdv |= 1024;
            this.zzfy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzdv |= 2048;
            this.zzfz = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzdv |= 8192;
            this.zzgb = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzdv |= 16384;
            this.zzgc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzdv |= 32768;
            this.zzgd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(long j) {
            this.zzdv |= 65536;
            this.zzge = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(long j) {
            this.zzdv |= 524288;
            this.zzgh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(long j) {
            this.zzdv |= 1048576;
            this.zzgi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzdv |= 2097152;
            this.zzgj = j;
        }

        public final boolean zzai() {
            return (this.zzdv & 4194304) != 0;
        }

        public final String zzaf() {
            return this.zzfg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzv(String str) {
            str.getClass();
            this.zzdv |= 4194304;
            this.zzfg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzw(String str) {
            str.getClass();
            this.zzdv |= 16777216;
            this.zzgl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(long j) {
            this.zzdv |= 33554432;
            this.zzgm = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(long j) {
            this.zzdv |= 67108864;
            this.zzgn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(long j) {
            this.zzdv |= 134217728;
            this.zzgo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzx(String str) {
            str.getClass();
            this.zzdv |= 268435456;
            this.zzfi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt(long j) {
            this.zzdv |= 536870912;
            this.zzgp = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzu(long j) {
            this.zzdv |= 1073741824;
            this.zzgq = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzv(long j) {
            this.zzdv |= Integer.MIN_VALUE;
            this.zzgr = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzw(long j) {
            this.zzfn |= 2;
            this.zzgt = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzx(long j) {
            this.zzfn |= 4;
            this.zzgu = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzy(long j) {
            this.zzfn |= 8;
            this.zzgv = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzz(long j) {
            this.zzfn |= 16;
            this.zzgw = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaa(long j) {
            this.zzfn |= 32;
            this.zzgx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzab(long j) {
            this.zzfn |= 64;
            this.zzgy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzy(String str) {
            str.getClass();
            this.zzfn |= 128;
            this.zzfj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzz(String str) {
            str.getClass();
            this.zzfn |= 256;
            this.zzfk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzcq zzcqVar) {
            this.zzha = zzcqVar.zzv();
            this.zzfn |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzcq zzcqVar) {
            this.zzhb = zzcqVar.zzv();
            this.zzfn |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzac(long j) {
            this.zzfn |= 4096;
            this.zzhc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzad(long j) {
            this.zzfn |= 8192;
            this.zzhd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzae(long j) {
            this.zzfn |= 16384;
            this.zzhe = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzcq zzcqVar) {
            this.zzhh = zzcqVar.zzv();
            this.zzfn |= 131072;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            this.zzhi = zzfVar;
            this.zzfn |= 262144;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzf zzfVar) {
            zzfVar.getClass();
            zzenk<zzf> zzenkVar = this.zzhj;
            if (!zzenkVar.zzbhd()) {
                this.zzhj = zzena.zza(zzenkVar);
            }
            this.zzhj.add(zzfVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaj() {
            this.zzhj = zzbjm();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            this.zzhk = zzgVar;
            this.zzfn |= 524288;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaf(long j) {
            this.zzfn |= 2097152;
            this.zzhm = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzag(long j) {
            this.zzfn |= 4194304;
            this.zzhn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzah(long j) {
            this.zzfn |= 8388608;
            this.zzho = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzai(long j) {
            this.zzfn |= 67108864;
            this.zzhr = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaj(long j) {
            this.zzfn |= 134217728;
            this.zzhs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaa(String str) {
            str.getClass();
            this.zzfn |= 268435456;
            this.zzht = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zzcq zzcqVar) {
            this.zzia = zzcqVar.zzv();
            this.zzfo |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(zzcq zzcqVar) {
            this.zzib = zzcqVar.zzv();
            this.zzfo |= 16;
        }

        public final String zzak() {
            return this.zzif;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzab(String str) {
            str.getClass();
            this.zzfo |= 128;
            this.zzif = str;
        }

        public final zzc zzal() {
            zzc zzl = zzc.zzl(this.zzig);
            return zzl == null ? zzc.DEVICE_IDENTIFIER_GLOBAL_ID : zzl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzig = zzcVar.zzv();
            this.zzfo |= 256;
        }

        public final boolean zzam() {
            return this.zzih;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzfo |= AdRequest.MAX_CONTENT_URL_LENGTH;
            this.zzih = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzak(long j) {
            this.zzfo |= 2048;
            this.zzij = j;
        }

        public final boolean zzan() {
            return (this.zzfo & 4096) != 0;
        }

        public final zzd zzao() {
            zzd zzdVar = this.zzik;
            return zzdVar == null ? zzd.zzbj() : zzdVar;
        }

        public static zza zza(byte[] bArr, zzemn zzemnVar) {
            return (zza) zzena.zza(zzil, bArr, zzemnVar);
        }

        public static zzb zzap() {
            return zzil.zzbjh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzil, "\u0001O\u0000\u0003\u0001ÉO\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂF\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈG\u0019ဂK\u001aဌH\u001bဈ\u0016\u001cဇI\u001dဈ\u0018\u001eဈJ\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0ဌ*1ဌ+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08ဌ19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=Aဌ>Bဌ?Cဈ<Dဌ@EဉAFဂBGဂ8Hဂ9IဌCJဂ)Kဈ\u0017LဌDMဈEN\u001bÉဉL", new Object[]{"zzdv", "zzfn", "zzfo", "zzfp", "zzef", "zzfq", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzfz", "zzga", "zzgb", "zzgc", "zzgd", "zzge", "zzgf", "zzgg", "zzgh", "zzie", "zzgi", "zzgj", "zzif", "zzij", "zzig", zzc.zzw(), "zzfg", "zzih", "zzgl", "zzii", "zzgm", "zzgn", "zzgo", "zzfi", "zzgp", "zzgq", "zzgr", "zzgs", "zzgt", "zzgu", "zzgv", "zzgw", "zzhj", zzf.class, "zzgx", "zzgy", "zzfj", "zzfk", "zzha", zzcq.zzw(), "zzhb", zzcq.zzw(), "zzhi", "zzhc", "zzhd", "zzhe", "zzhf", "zzhg", "zzhh", zzcq.zzw(), "zzhk", "zzhl", "zzhm", "zzhn", "zzho", "zzhr", "zzhs", "zzhu", "zzhv", zzcm.zzw(), "zzhw", zzcr.zzw(), "zzht", "zzhx", EnumC0104zza.zzw(), "zzhy", "zzhz", "zzhp", "zzhq", "zzia", zzcq.zzw(), "zzgz", "zzgk", "zzib", zzcq.zzw(), "zzic", "zzid", zze.class, "zzik"});
                case 4:
                    return zzil;
                case 5:
                    zzeow<zza> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zza.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzil);
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

        public static zza zzaq() {
            return zzil;
        }

        static {
            zza zzaVar = new zza();
            zzil = zzaVar;
            zzena.zza(zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena<zzb, zza> implements zzeop {
        private static volatile zzeow<zzb> zzek;
        private static final zzb zzlk;
        private int zzdv;
        private long zzlf;
        private int zzlg;
        private boolean zzlh;
        private zzeng zzli = zzbjk();
        private long zzlj;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zzb, zza> implements zzeop {
            private zza() {
                super(zzb.zzlk);
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzlk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzdv", "zzlf", "zzlg", "zzlh", "zzli", "zzlj"});
                case 4:
                    return zzlk;
                case 5:
                    zzeow<zzb> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzb.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzlk);
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
            zzlk = zzbVar;
            zzena.zza(zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzd extends zzena<zzd, zza> implements zzeop {
        private static volatile zzeow<zzd> zzek;
        private static final zzd zzmj;
        private int zzdv;
        private long zzlf;
        private String zzmh = "";
        private zzelq zzmi = zzelq.zzipc;

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zzd, zza> implements zzeop {
            private zza() {
                super(zzd.zzmj);
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        public final boolean zzbh() {
            return (this.zzdv & 1) != 0;
        }

        public final long zzbi() {
            return this.zzlf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzmj, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzdv", "zzlf", "zzmh", "zzmi"});
                case 4:
                    return zzmj;
                case 5:
                    zzeow<zzd> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzd.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzmj);
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

        public static zzd zzbj() {
            return zzmj;
        }

        static {
            zzd zzdVar = new zzd();
            zzmj = zzdVar;
            zzena.zza(zzd.class, zzdVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zze extends zzena<zze, zza> implements zzeop {
        private static volatile zzeow<zze> zzek;
        private static final zze zzmk;
        private int zzdv;
        private String zzfl = "";

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zze, zza> implements zzeop {
            private zza() {
                super(zze.zzmk);
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzmk, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdv", "zzfl"});
                case 4:
                    return zzmk;
                case 5:
                    zzeow<zze> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zze.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzmk);
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
            zze zzeVar = new zze();
            zzmk = zzeVar;
            zzena.zza(zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzc extends zzena<zzc, zza> implements zzeop {
        private static volatile zzeow<zzc> zzek;
        private static final zzc zzlp;
        private int zzdv;
        private zzelq zzll = zzelq.zzipc;
        private zzelq zzlm = zzelq.zzipc;
        private zzelq zzln = zzelq.zzipc;
        private zzelq zzlo = zzelq.zzipc;

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zzc, zza> implements zzeop {
            private zza() {
                super(zzc.zzlp);
            }

            public final zza zze(zzelq zzelqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zza(zzelqVar);
                return this;
            }

            public final zza zzf(zzelq zzelqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zzb(zzelqVar);
                return this;
            }

            public final zza zzg(zzelq zzelqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zzc(zzelqVar);
                return this;
            }

            public final zza zzh(zzelq zzelqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzc) this.zzits).zzd(zzelqVar);
                return this;
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        public final zzelq zzbb() {
            return this.zzll;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzelq zzelqVar) {
            zzelqVar.getClass();
            this.zzdv |= 1;
            this.zzll = zzelqVar;
        }

        public final zzelq zzbc() {
            return this.zzlm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzelq zzelqVar) {
            zzelqVar.getClass();
            this.zzdv |= 2;
            this.zzlm = zzelqVar;
        }

        public final zzelq zzbd() {
            return this.zzln;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzelq zzelqVar) {
            zzelqVar.getClass();
            this.zzdv |= 4;
            this.zzln = zzelqVar;
        }

        public final zzelq zzbe() {
            return this.zzlo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zzelq zzelqVar) {
            zzelqVar.getClass();
            this.zzdv |= 8;
            this.zzlo = zzelqVar;
        }

        public static zzc zzb(byte[] bArr, zzemn zzemnVar) {
            return (zzc) zzena.zza(zzlp, bArr, zzemnVar);
        }

        public static zza zzbf() {
            return zzlp.zzbjh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzlp, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzdv", "zzll", "zzlm", "zzln", "zzlo"});
                case 4:
                    return zzlp;
                case 5:
                    zzeow<zzc> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzc.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzlp);
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
            zzc zzcVar = new zzc();
            zzlp = zzcVar;
            zzena.zza(zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzf extends zzena<zzf, zza> implements zzeop {
        private static volatile zzeow<zzf> zzek;
        private static final zzf zzmm;
        private int zzdv;
        private zzenk<zzelq> zzml = zzbjm();
        private zzelq zzlm = zzelq.zzipc;
        private int zzhw = 1;
        private int zzhv = 1;

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzena.zzb<zzf, zza> implements zzeop {
            private zza() {
                super(zzf.zzmm);
            }

            public final zza zzi(zzelq zzelqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzf) this.zzits).zzk(zzelqVar);
                return this;
            }

            public final zza zzj(zzelq zzelqVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzf) this.zzits).zzb(zzelqVar);
                return this;
            }

            public final zza zza(zzcm zzcmVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zzf) this.zzits).zzb(zzcmVar);
                return this;
            }

            /* synthetic */ zza(zzcg zzcgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(zzelq zzelqVar) {
            zzelqVar.getClass();
            zzenk<zzelq> zzenkVar = this.zzml;
            if (!zzenkVar.zzbhd()) {
                this.zzml = zzena.zza(zzenkVar);
            }
            this.zzml.add(zzelqVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzelq zzelqVar) {
            zzelqVar.getClass();
            this.zzdv |= 1;
            this.zzlm = zzelqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzcm zzcmVar) {
            this.zzhv = zzcmVar.zzv();
            this.zzdv |= 4;
        }

        public static zza zzbm() {
            return zzmm.zzbjh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcg.zzel[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzmm, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzdv", "zzml", "zzlm", "zzhw", zzcr.zzw(), "zzhv", zzcm.zzw()});
                case 4:
                    return zzmm;
                case 5:
                    zzeow<zzf> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zzf.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzmm);
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
            zzmm = zzfVar;
            zzena.zza(zzf.class, zzfVar);
        }
    }
}
