package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public enum zzcq implements zzenf {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    
    private static final zzene<zzcq> zzes = new zzene<zzcq>() { // from class: com.google.android.gms.internal.ads.zzcp
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzenf
    public final int zzv() {
        return this.value;
    }

    public static zzcq zzn(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 1000) {
                        return null;
                    }
                    return ENUM_UNKNOWN;
                }
                return ENUM_FAILURE;
            }
            return ENUM_TRUE;
        }
        return ENUM_FALSE;
    }

    public static zzenh zzw() {
        return zzcs.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    zzcq(int i) {
        this.value = i;
    }
}
