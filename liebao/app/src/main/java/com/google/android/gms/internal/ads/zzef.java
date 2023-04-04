package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzef extends zzea {
    public static zzef zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcv.zzno);
    }

    public static zzef zzb(String str, Context context, boolean z, int i) {
        zza(context, z);
        zza(str, context, z, i);
        return new zzef(context, str, z, i);
    }

    private zzef(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzea
    protected final List<Callable<Void>> zza(zzfc zzfcVar, Context context, zzcf.zza.zzb zzbVar, zzcb.zza zzaVar) {
        if (zzfcVar.zzch() == null || !this.zzxk) {
            return super.zza(zzfcVar, context, zzbVar, zzaVar);
        }
        int zzbv = zzfcVar.zzbv();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzfcVar, context, zzbVar, zzaVar));
        arrayList.add(new zzfw(zzfcVar, "+TO/Mpw5B9Ysegk2ohW075Jqflr1OZ9qfpBhm7dfWn/YVCIrMVqb+Yemq/MJcA7W", "NFKeWWLJ9pOo7U7UIrMCAjT+FIdaFD6BH0lqisOKm88=", zzbVar, zzbv, 24));
        return arrayList;
    }
}
