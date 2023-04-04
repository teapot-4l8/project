package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public enum zzcd implements zzenf {
    ENUM_SIGNAL_SOURCE_UNKNOWN(0),
    ENUM_SIGNAL_SOURCE_DISABLE(1),
    ENUM_SIGNAL_SOURCE_ADSHIELD(2),
    ENUM_SIGNAL_SOURCE_GASS(3),
    ENUM_SIGNAL_SOURCE_CALLER_PROVIDED(4);
    
    private static final zzene<zzcd> zzes = new zzene<zzcd>() { // from class: com.google.android.gms.internal.ads.zzcc
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzenf
    public final int zzv() {
        return this.value;
    }

    public static zzcd zzj(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                    }
                    return ENUM_SIGNAL_SOURCE_GASS;
                }
                return ENUM_SIGNAL_SOURCE_ADSHIELD;
            }
            return ENUM_SIGNAL_SOURCE_DISABLE;
        }
        return ENUM_SIGNAL_SOURCE_UNKNOWN;
    }

    public static zzenh zzw() {
        return zzce.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    zzcd(int i) {
        this.value = i;
    }
}
