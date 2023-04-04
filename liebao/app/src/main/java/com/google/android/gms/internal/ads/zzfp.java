package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfp extends zzgn {
    private static final zzgq<zzcx> zzaaz = new zzgq<>();
    private final Context zzaba;
    private zzcb.zza zzabb;

    public zzfp(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2, Context context, zzcb.zza zzaVar) {
        super(zzfcVar, str, str2, zzbVar, i, 27);
        this.zzabb = null;
        this.zzaba = context;
        this.zzabb = zzaVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[Catch: all -> 0x0113, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001f, B:10:0x0029, B:16:0x0039, B:18:0x0045, B:34:0x0082, B:38:0x0089, B:40:0x00ac, B:50:0x00dc, B:42:0x00b6, B:46:0x00c3, B:48:0x00cd, B:49:0x00d0, B:19:0x0048, B:22:0x0056, B:24:0x005c, B:28:0x006b, B:30:0x0075, B:32:0x007d, B:33:0x0080, B:51:0x00df, B:52:0x00e5), top: B:67:0x000d }] */
    @Override // com.google.android.gms.internal.ads.zzgn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzcx() {
        boolean z;
        zzcx zzcxVar;
        zzcd zzcdVar;
        AtomicReference<zzcx> zzas = zzaaz.zzas(this.zzaba.getPackageName());
        synchronized (zzas) {
            zzcx zzcxVar2 = zzas.get();
            if (zzcxVar2 != null && !zzfh.zzar(zzcxVar2.zzns) && !zzcxVar2.zzns.equals("E") && !zzcxVar2.zzns.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                z = false;
                if (z) {
                    if (!zzfh.zzar(zza(this.zzabb))) {
                        zzcdVar = zzcd.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                    } else {
                        zzcb.zza zzaVar = this.zzabb;
                        if (Boolean.valueOf(zzfh.zzar(zza(zzaVar)) && zzaVar != null && zzaVar.zzx() && zzaVar.zzy().zzac() == zzcd.ENUM_SIGNAL_SOURCE_GASS).booleanValue() && this.zzwh.zzcn()) {
                            zzcdVar = zzcd.ENUM_SIGNAL_SOURCE_GASS;
                        } else {
                            zzcdVar = zzcd.ENUM_SIGNAL_SOURCE_ADSHIELD;
                        }
                    }
                    zzcx zzcxVar3 = new zzcx((String) this.zzabq.invoke(null, this.zzaba, Boolean.valueOf(zzcdVar == zzcd.ENUM_SIGNAL_SOURCE_ADSHIELD)));
                    if (zzfh.zzar(zzcxVar3.zzns) || zzcxVar3.zzns.equals("E")) {
                        int i = zzfs.zzabd[zzcdVar.ordinal()];
                        if (i == 1) {
                            zzcxVar3.zzns = this.zzabb.zzaa().zzaf();
                        } else if (i == 2) {
                            String zzcy = zzcy();
                            if (!zzfh.zzar(zzcy)) {
                                zzcxVar3.zzns = zzcy;
                            }
                        }
                    }
                    zzas.set(zzcxVar3);
                }
                zzcxVar = zzas.get();
            }
            z = true;
            if (z) {
            }
            zzcxVar = zzas.get();
        }
        synchronized (this.zzabg) {
            if (zzcxVar != null) {
                this.zzabg.zzae(zzcxVar.zzns);
                this.zzabg.zzba(zzcxVar.zznt);
                this.zzabg.zzag(zzcxVar.zznu);
                this.zzabg.zzah(zzcxVar.zznv);
                this.zzabg.zzai(zzcxVar.zznw);
            }
        }
    }

    private static String zza(zzcb.zza zzaVar) {
        if (zzaVar == null || !zzaVar.zzz() || zzfh.zzar(zzaVar.zzaa().zzaf())) {
            return null;
        }
        return zzaVar.zzaa().zzaf();
    }

    private final String zzcy() {
        try {
            if (this.zzwh.zzcq() != null) {
                this.zzwh.zzcq().get();
            }
            zzcf.zza zzcp = this.zzwh.zzcp();
            if (zzcp == null || !zzcp.zzai()) {
                return null;
            }
            return zzcp.zzaf();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
