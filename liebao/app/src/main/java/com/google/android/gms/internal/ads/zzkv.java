package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzkv extends zzkw {
    public final long zzate;
    public final List<zzky> zzatf;
    public final List<zzkv> zzatg;

    public zzkv(int i, long j) {
        super(i);
        this.zzate = j;
        this.zzatf = new ArrayList();
        this.zzatg = new ArrayList();
    }

    public final void zza(zzky zzkyVar) {
        this.zzatf.add(zzkyVar);
    }

    public final void zza(zzkv zzkvVar) {
        this.zzatg.add(zzkvVar);
    }

    public final zzky zzas(int i) {
        int size = this.zzatf.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzky zzkyVar = this.zzatf.get(i2);
            if (zzkyVar.type == i) {
                return zzkyVar;
            }
        }
        return null;
    }

    public final zzkv zzat(int i) {
        int size = this.zzatg.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkv zzkvVar = this.zzatg.get(i2);
            if (zzkvVar.type == i) {
                return zzkvVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final String toString() {
        String zzaw = zzaw(this.type);
        String arrays = Arrays.toString(this.zzatf.toArray());
        String arrays2 = Arrays.toString(this.zzatg.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzaw).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzaw);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
