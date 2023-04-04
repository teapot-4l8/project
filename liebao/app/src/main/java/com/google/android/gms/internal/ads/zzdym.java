package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdym implements Iterable<String> {
    private final /* synthetic */ CharSequence zzhzh;
    private final /* synthetic */ zzdyh zzhzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdym(zzdyh zzdyhVar, CharSequence charSequence) {
        this.zzhzi = zzdyhVar;
        this.zzhzh = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        Iterator<String> zzb;
        zzb = this.zzhzi.zzb(this.zzhzh);
        return zzb;
    }

    public final String toString() {
        StringBuilder zza = zzdxz.zzhl(", ").zza(new StringBuilder("["), iterator());
        zza.append(']');
        return zza.toString();
    }
}
