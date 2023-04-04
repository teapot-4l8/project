package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzmy {
    private final zzkc zzaru;
    private final zzka[] zzbfc;
    private zzka zzbfd;

    public zzmy(zzka[] zzkaVarArr, zzkc zzkcVar) {
        this.zzbfc = zzkaVarArr;
        this.zzaru = zzkcVar;
    }

    public final zzka zza(zzjz zzjzVar, Uri uri) {
        zzka zzkaVar = this.zzbfd;
        if (zzkaVar != null) {
            return zzkaVar;
        }
        zzka[] zzkaVarArr = this.zzbfc;
        int length = zzkaVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzka zzkaVar2 = zzkaVarArr[i];
            try {
            } catch (EOFException unused) {
            } finally {
                zzjzVar.zzgu();
            }
            if (zzkaVar2.zza(zzjzVar)) {
                this.zzbfd = zzkaVar2;
                break;
            }
            i++;
        }
        zzka zzkaVar3 = this.zzbfd;
        if (zzkaVar3 == null) {
            String zza = zzpt.zza(this.zzbfc);
            StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
            sb.append("None of the available extractors (");
            sb.append(zza);
            sb.append(") could read the stream.");
            throw new zznt(sb.toString(), uri);
        }
        zzkaVar3.zza(this.zzaru);
        return this.zzbfd;
    }

    public final void release() {
        zzka zzkaVar = this.zzbfd;
        if (zzkaVar != null) {
            zzkaVar.release();
            this.zzbfd = null;
        }
    }
}
