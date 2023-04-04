package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzefq {
    @Deprecated
    private static final zzeix zzifu;
    @Deprecated
    private static final zzeix zzifv;
    @Deprecated
    private static final zzeix zzifw;
    private static final String zziha = new zzefm().getKeyType();

    public static void zzbby() {
        zzedl.zza((zzecu) new zzefm(), true);
        zzedl.zza((zzecu) new zzefl(), true);
        zzedl.zza(new zzeft());
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
