package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzdxr {
    public static zzdxr zzb(char c2) {
        return new zzdxt(c2);
    }

    public abstract boolean zzc(char c2);

    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzdyi.zzb(i, length, "index");
        while (i < length) {
            if (zzc(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzd(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
