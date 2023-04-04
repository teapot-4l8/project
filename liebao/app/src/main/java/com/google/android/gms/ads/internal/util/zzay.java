package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzww;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzay {
    private static com.google.android.gms.internal.ads.zzaf zzeie;
    private static final Object zzeif = new Object();
    @Deprecated
    private static final zzbc<Void> zzeig = new zzax();

    public zzay(Context context) {
        zzbm(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    public static zzebt<com.google.android.gms.internal.ads.zzz> zzeq(String str) {
        zzbbe zzbbeVar = new zzbbe();
        zzeie.zzd(new zzbe(str, zzbbeVar));
        return zzbbeVar;
    }

    public final zzebt<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        zzbb zzbbVar = new zzbb(null);
        zzba zzbaVar = new zzba(this, str, zzbbVar);
        zzbai zzbaiVar = new zzbai(null);
        zzaz zzazVar = new zzaz(this, i, str, zzbbVar, zzbaVar, bArr, map, zzbaiVar);
        if (zzbai.isEnabled()) {
            try {
                zzbaiVar.zza(str, "GET", zzazVar.getHeaders(), zzazVar.zzg());
            } catch (com.google.android.gms.internal.ads.zzl e2) {
                zzd.zzez(e2.getMessage());
            }
        }
        zzeie.zzd(zzazVar);
        return zzbbVar;
    }

    public final zzebt<String> zzb(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:13:0x0027, B:15:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:22:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:13:0x0027, B:15:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:22:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.google.android.gms.internal.ads.zzaf zzbm(Context context) {
        com.google.android.gms.internal.ads.zzaf zzafVar;
        boolean z;
        com.google.android.gms.internal.ads.zzaf zza;
        synchronized (zzeif) {
            if (zzeie == null) {
                zzabq.initialize(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcvh)).booleanValue()) {
                        z = true;
                        if (!z) {
                            zza = zzan.zzbl(context);
                        } else {
                            zza = com.google.android.gms.internal.ads.zzbj.zza(context);
                        }
                        zzeie = zza;
                    }
                }
                z = false;
                if (!z) {
                }
                zzeie = zza;
            }
            zzafVar = zzeie;
        }
        return zzafVar;
    }
}
