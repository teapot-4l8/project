package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdxo {
    private static int zza(char c2) {
        return (char) ((c2 | ' ') - 97);
    }

    public static boolean zza(CharSequence charSequence, CharSequence charSequence2) {
        int zza;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence2.charAt(i);
            if (charAt != charAt2 && ((zza = zza(charAt)) >= 26 || zza != zza(charAt2))) {
                return false;
            }
        }
        return true;
    }
}
