package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public enum zzgp implements zzenf {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(999);
    
    private static final zzene<zzgp> zzes = new zzene<zzgp>() { // from class: com.google.android.gms.internal.ads.zzgs
    };
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzenf
    public final int zzv() {
        return this.value;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    zzgp(int i) {
        this.value = i;
    }
}
