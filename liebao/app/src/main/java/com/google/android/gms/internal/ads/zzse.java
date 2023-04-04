package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzse {
    final long value;
    final int zzbuo;
    final String zzbuv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzse(long j, String str, int i) {
        this.value = j;
        this.zzbuv = str;
        this.zzbuo = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzse)) {
            zzse zzseVar = (zzse) obj;
            if (zzseVar.value == this.value && zzseVar.zzbuo == this.zzbuo) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
