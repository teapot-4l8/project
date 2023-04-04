package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdjk implements zzesa<zzdhd<JSONObject>> {
    public static zzdhd<JSONObject> zza(zzazk zzazkVar, Object obj, zzdhy zzdhyVar, zzdiv zzdivVar, zzeru<zzdhs> zzeruVar, zzeru<zzdic> zzeruVar2, zzeru<zzdig> zzeruVar3, zzeru<zzdim> zzeruVar4, zzeru<zzdir> zzeruVar5, zzeru<zzdja> zzeruVar6, zzeru<zzdjm> zzeruVar7, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdin) obj);
        hashSet.add(zzdhyVar);
        hashSet.add(zzdivVar);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxs)).booleanValue()) {
            hashSet.add(zzeruVar.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxt)).booleanValue()) {
            hashSet.add(zzeruVar2.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxu)).booleanValue()) {
            hashSet.add(zzeruVar3.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxv)).booleanValue()) {
            hashSet.add(zzeruVar4.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcya)).booleanValue()) {
            hashSet.add(zzeruVar6.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyb)).booleanValue()) {
            hashSet.add(zzeruVar7.get());
        }
        return (zzdhd) zzesg.zzbd(new zzdhd(executor, hashSet));
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
