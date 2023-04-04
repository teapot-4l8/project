package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzedr {
    public static final String zzifm = new zzedu().getKeyType();
    public static final String zzifn = new zzeeb().getKeyType();
    private static final String zzifo = new zzeeg().getKeyType();
    private static final String zzifp = new zzeea().getKeyType();
    private static final String zzifq = new zzeem().getKeyType();
    private static final String zzifr = new zzeeq().getKeyType();
    private static final String zzifs = new zzeeh().getKeyType();
    private static final String zzift = new zzeer().getKeyType();
    @Deprecated
    private static final zzeix zzifu;
    @Deprecated
    private static final zzeix zzifv;
    @Deprecated
    private static final zzeix zzifw;

    public static void zzbby() {
        zzefq.zzbby();
        zzedl.zza((zzecu) new zzedu(), true);
        zzedl.zza((zzecu) new zzeea(), true);
        zzedl.zza((zzecu) new zzeeb(), true);
        zzeeg.zzbv(true);
        zzedl.zza((zzecu) new zzeeh(), true);
        zzedl.zza((zzecu) new zzeem(), true);
        zzedl.zza((zzecu) new zzeeq(), true);
        zzedl.zza((zzecu) new zzeer(), true);
        zzedl.zza(new zzedq());
    }

    static {
        zzeix zzbgi = zzeix.zzbgi();
        zzifu = zzbgi;
        zzifv = zzbgi;
        zzifw = zzbgi;
        try {
            zzbby();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
