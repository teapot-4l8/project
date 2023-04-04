package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzein extends zzena<zzein, zzb> implements zzeop {
    private static volatile zzeow<zzein> zzek;
    private static final zzein zzilb;
    private int zzikt;
    private zzenk<zza> zzila = zzbjm();

    private zzein() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena<zza, C0108zza> implements zzeop {
        private static volatile zzeow<zza> zzek;
        private static final zza zzilc;
        private String zzijv = "";
        private int zzikm;
        private int zzikx;
        private int zziky;

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        /* renamed from: com.google.android.gms.internal.ads.zzein$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0108zza extends zzena.zzb<zza, C0108zza> implements zzeop {
            private C0108zza() {
                super(zza.zzilc);
            }

            public final C0108zza zzhw(String str) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzhu(str);
                return this;
            }

            public final C0108zza zzb(zzeid zzeidVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzeidVar);
                return this;
            }

            public final C0108zza zzfw(int i) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zzfu(i);
                return this;
            }

            public final C0108zza zzb(zzeiw zzeiwVar) {
                if (this.zzitt) {
                    zzbjr();
                    this.zzitt = false;
                }
                ((zza) this.zzits).zza(zzeiwVar);
                return this;
            }

            /* synthetic */ C0108zza(zzeim zzeimVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzhu(String str) {
            str.getClass();
            this.zzijv = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzeid zzeidVar) {
            this.zzikx = zzeidVar.zzv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzfu(int i) {
            this.zziky = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzeiw zzeiwVar) {
            this.zzikm = zzeiwVar.zzv();
        }

        public static C0108zza zzbfs() {
            return zzilc.zzbjh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzena
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzeim.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0108zza(null);
                case 3:
                    return zza(zzilc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzijv", "zzikx", "zziky", "zzikm"});
                case 4:
                    return zzilc;
                case 5:
                    zzeow<zza> zzeowVar = zzek;
                    if (zzeowVar == null) {
                        synchronized (zza.class) {
                            zzeowVar = zzek;
                            if (zzeowVar == null) {
                                zzeowVar = new zzena.zza<>(zzilc);
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
            zzilc = zzaVar;
            zzena.zza(zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzena.zzb<zzein, zzb> implements zzeop {
        private zzb() {
            super(zzein.zzilb);
        }

        public final zzb zzfv(int i) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzein) this.zzits).zzft(i);
            return this;
        }

        public final zzb zzb(zza zzaVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzein) this.zzits).zza(zzaVar);
            return this;
        }

        /* synthetic */ zzb(zzeim zzeimVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzft(int i) {
        this.zzikt = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzenk<zza> zzenkVar = this.zzila;
        if (!zzenkVar.zzbhd()) {
            this.zzila = zzena.zza(zzenkVar);
        }
        this.zzila.add(zzaVar);
    }

    public static zzb zzbfq() {
        return zzilb.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeim.zzel[i - 1]) {
            case 1:
                return new zzein();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzilb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzikt", "zzila", zza.class});
            case 4:
                return zzilb;
            case 5:
                zzeow<zzein> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzein.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzilb);
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
        zzein zzeinVar = new zzein();
        zzilb = zzeinVar;
        zzena.zza(zzein.class, zzeinVar);
    }
}
