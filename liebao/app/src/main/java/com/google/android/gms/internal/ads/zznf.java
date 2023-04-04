package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zznf implements zzne {
    private final zzne[] zzbfi;
    private final ArrayList<zzne> zzbfj;
    private zznd zzbfk;
    private zzid zzbfl;
    private Object zzbfm;
    private zznh zzbfo;
    private final zzie zzafd = new zzie();
    private int zzbfn = -1;

    public zznf(zzne... zzneVarArr) {
        this.zzbfi = zzneVarArr;
        this.zzbfj = new ArrayList<>(Arrays.asList(zzneVarArr));
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zza(zzhh zzhhVar, boolean z, zznd zzndVar) {
        this.zzbfk = zzndVar;
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzbfi;
            if (i >= zzneVarArr.length) {
                return;
            }
            zzneVarArr[i].zza(zzhhVar, false, new zzni(this, i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzid() {
        zznh zznhVar = this.zzbfo;
        if (zznhVar != null) {
            throw zznhVar;
        }
        for (zzne zzneVar : this.zzbfi) {
            zzneVar.zzid();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final zznc zza(int i, zzol zzolVar) {
        int length = this.zzbfi.length;
        zznc[] zzncVarArr = new zznc[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzncVarArr[i2] = this.zzbfi[i2].zza(i, zzolVar);
        }
        return new zzng(zzncVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzb(zznc zzncVar) {
        zzng zzngVar = (zzng) zzncVar;
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzbfi;
            if (i >= zzneVarArr.length) {
                return;
            }
            zzneVarArr[i].zzb(zzngVar.zzbfp[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzie() {
        for (zzne zzneVar : this.zzbfi) {
            zzneVar.zzie();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i, zzid zzidVar, Object obj) {
        zznh zznhVar;
        if (this.zzbfo == null) {
            int zzfj = zzidVar.zzfj();
            for (int i2 = 0; i2 < zzfj; i2++) {
                zzidVar.zza(i2, this.zzafd, false);
            }
            if (this.zzbfn == -1) {
                this.zzbfn = zzidVar.zzfk();
            } else if (zzidVar.zzfk() != this.zzbfn) {
                zznhVar = new zznh(1);
                this.zzbfo = zznhVar;
            }
            zznhVar = null;
            this.zzbfo = zznhVar;
        }
        if (this.zzbfo != null) {
            return;
        }
        this.zzbfj.remove(this.zzbfi[i]);
        if (i == 0) {
            this.zzbfl = zzidVar;
            this.zzbfm = obj;
        }
        if (this.zzbfj.isEmpty()) {
            this.zzbfk.zzb(this.zzbfl, this.zzbfm);
        }
    }
}
