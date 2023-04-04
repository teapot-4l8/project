package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgv extends zzena<zzgv, zza> implements zzeop {
    private static final zzgv zzacn;
    private static volatile zzeow<zzgv> zzek;
    private String zzaci = "";
    private String zzacj = "";
    private long zzack;
    private long zzacl;
    private long zzacm;
    private int zzdv;

    private zzgv() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzgv, zza> implements zzeop {
        private zza() {
            super(zzgv.zzacn);
        }

        public final zza zzav(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzgv) this.zzits).zzat(str);
            return this;
        }

        public final zza zzaw(String str) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzgv) this.zzits).zzau(str);
            return this;
        }

        public final zza zzdj(long j) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzgv) this.zzits).zzdg(j);
            return this;
        }

        public final zza zzdk(long j) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzgv) this.zzits).zzdh(j);
            return this;
        }

        public final zza zzdl(long j) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            ((zzgv) this.zzits).zzdi(j);
            return this;
        }

        /* synthetic */ zza(zzgu zzguVar) {
            this();
        }
    }

    public final String zzdh() {
        return this.zzaci;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzat(String str) {
        str.getClass();
        this.zzdv |= 1;
        this.zzaci = str;
    }

    public final String zzdi() {
        return this.zzacj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzau(String str) {
        str.getClass();
        this.zzdv |= 2;
        this.zzacj = str;
    }

    public final long zzdj() {
        return this.zzack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdg(long j) {
        this.zzdv |= 4;
        this.zzack = j;
    }

    public final long zzdk() {
        return this.zzacl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdh(long j) {
        this.zzdv |= 8;
        this.zzacl = j;
    }

    public final long zzdl() {
        return this.zzacm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdi(long j) {
        this.zzdv |= 16;
        this.zzacm = j;
    }

    public static zzgv zzl(zzelq zzelqVar) {
        return (zzgv) zzena.zza(zzacn, zzelqVar);
    }

    public static zzgv zzb(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzgv) zzena.zza(zzacn, zzelqVar, zzemnVar);
    }

    public static zza zzdm() {
        return zzacn.zzbjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgu.zzel[i - 1]) {
            case 1:
                return new zzgv();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzacn, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzdv", "zzaci", "zzacj", "zzack", "zzacl", "zzacm"});
            case 4:
                return zzacn;
            case 5:
                zzeow<zzgv> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzgv.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzacn);
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

    public static zzgv zzdn() {
        return zzacn;
    }

    static {
        zzgv zzgvVar = new zzgv();
        zzacn = zzgvVar;
        zzena.zza(zzgv.class, zzgvVar);
    }
}
