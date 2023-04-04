package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzelj {
    private static final Class<?> zziot = zzhy("libcore.io.Memory");
    private static final boolean zziou;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzbhb() {
        return (zziot == null || zziou) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> zzbhc() {
        return zziot;
    }

    private static <T> Class<T> zzhy(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        zziou = zzhy("org.robolectric.Robolectric") != null;
    }
}
