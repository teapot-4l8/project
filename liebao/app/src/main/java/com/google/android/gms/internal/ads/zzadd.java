package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzadd<T> extends zzacy<T> {
    public static zzacy<Boolean> zzg(String str, boolean z) {
        return new zzadd(str, true, zzada.zzddl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    public zzadd(String str, Object obj, int i) {
        super(str, obj, i);
    }

    @Override // com.google.android.gms.internal.ads.zzacy
    public final T get() {
        if (!zzaeb.zzdgi.get()) {
            throw new IllegalStateException("Striped code is accessed: 54c42518-856a-44fb-aae0-cd6676d514e5");
        }
        return (T) super.get();
    }
}
