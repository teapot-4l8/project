package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdye {
    private static final Logger logger = Logger.getLogger(zzdye.class.getName());
    private static final zzdyf zzhza = new zza();

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zza {
        private zza() {
        }
    }

    private zzdye() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzhn(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzhm(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String emptyToNull(@NullableDecl String str) {
        if (zzhm(str)) {
            return null;
        }
        return str;
    }
}
