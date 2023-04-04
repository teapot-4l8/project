package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbw {

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena<zza, zzb> implements zzeop {
        private static final zza zzej;
        private static volatile zzeow<zza> zzek;
        private int zzdv;
        private long zzdx;
        private long zzeb;
        private long zzec;
        private long zzee;
        private int zzei;
        private String zzdw = "";
        private String zzdy = "";
        private String zzdz = "";
        private String zzea = "";
        private String zzed = "";
        private String zzef = "";
        private String zzeg = "";
        private zzenk<C0101zza> zzeh = zzbjm();

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0101zza extends zzena<C0101zza, C0102zza> implements zzeop {
            private static volatile zzeow<C0101zza> zzek;
            private static final C0101zza zzeo;
            private int zzdv;
            private String zzem = "";
            private String zzen = "";

            private C0101zza() {
            }

            /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
            /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0102zza extends zzena.zzb<C0101zza, C0102zza> implements zzeop {
                private C0102zza() {
                    super(C0101zza.zzeo);
                }

                /* synthetic */ C0102zza(zzbx zzbxVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzena
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbx.zzel[i - 1]) {
                    case 1:
                        return new C0101zza();
                    case 2:
                        return new C0102zza(null);
                    case 3:
                        return zza(zzeo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdv", "zzem", "zzen"});
                    case 4:
                        return zzeo;
                    case 5:
                        zzeow<C0101zza> zzeowVar = zzek;
                        if (zzeowVar == null) {
                            synchronized (C0101zza.class) {
                                zzeowVar = zzek;
                                if (zzeowVar == null) {
                                    zzeowVar = new zzena.zza<>(zzeo);
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
                C0101zza c0101zza = new C0101zza();
                zzeo = c0101zza;
                zzena.zza(C0101zza.class, c0101zza);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzenf {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);
            
            private static final zzene<zzc> zzes = new zzbz();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzenf
            public final int zzv() {
                return this.value;
            }

            public static zzc zzh(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return DISABLED;
                    }
                    return ENABLED;
                }
                return UNKNOWN;
            }

            public static zzenh zzw() {
                return zzby.zzeu;
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

        /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzena.zzb<zza, zzb> implements zzeop {
            private zzb() {
                super(zza.zzej);
            }

            public final zzb zzo(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzj(str);
                return this;
            }

            public final zzb zzd(long j) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzc(j);
                return this;
            }

            public final zzb zzp(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzk(str);
                return this;
            }

            public final zzb zzq(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzl(str);
                return this;
            }

            public final zzb zzr(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzm(str);
                return this;
            }

            public final zzb zzs(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzn(str);
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

            /* synthetic */ zzb(zzbx zzbxVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzdv |= 1;
            this.zzdw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzdv |= 2;
            this.zzdx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzdv |= 4;
            this.zzdy = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzdv |= 8;
            this.zzdz = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzdv |= 16;
            this.zzea = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzdv |= 1024;
            this.zzeg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzei = zzcVar.zzv();
            this.zzdv |= 2048;
        }

        public static zzb zzs() {
            return zzej.zzbjh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbx.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzej, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdv", "zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzeh", C0101zza.class, "zzei", zzc.zzw()});
                case 4:
                    return zzej;
                case 5:
                    zzeow<zza> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zza.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzej);
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
            zzej = zzaVar;
            zzena.zza(zza.class, zzaVar);
        }
    }
}
