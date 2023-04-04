package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgr extends zzena<zzgr, zza> implements zzeop {
    private static final zzgr zzach;
    private static volatile zzeow<zzgr> zzek;
    private zzgv zzace;
    private zzelq zzacf = zzelq.zzipc;
    private zzelq zzacg = zzelq.zzipc;
    private int zzdv;

    private zzgr() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzgr, zza> implements zzeop {
        private zza() {
            super(zzgr.zzach);
        }

        /* synthetic */ zza(zzgt zzgtVar) {
            this();
        }
    }

    public final zzgv zzdd() {
        zzgv zzgvVar = this.zzace;
        return zzgvVar == null ? zzgv.zzdn() : zzgvVar;
    }

    public final zzelq zzde() {
        return this.zzacf;
    }

    public final zzelq zzdf() {
        return this.zzacg;
    }

    public static zzgr zza(zzelq zzelqVar, zzemn zzemnVar) {
        return (zzgr) zzena.zza(zzach, zzelqVar, zzemnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgt.zzel[i - 1]) {
            case 1:
                return new zzgr();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzach, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdv", "zzace", "zzacf", "zzacg"});
            case 4:
                return zzach;
            case 5:
                zzeow<zzgr> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzgr.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzach);
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
        zzgr zzgrVar = new zzgr();
        zzach = zzgrVar;
        zzena.zza(zzgr.class, zzgrVar);
    }
}
