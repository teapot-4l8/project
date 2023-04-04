package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbq extends zzerk implements Closeable {
    private static zzers zzdc = zzers.zzp(zzbq.class);

    public zzbq(zzerm zzermVar, zzbn zzbnVar) {
        zza(zzermVar, zzermVar.size(), zzbnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzerk, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.zzjeg.close();
    }

    @Override // com.google.android.gms.internal.ads.zzerk
    public String toString() {
        String obj = this.zzjeg.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
