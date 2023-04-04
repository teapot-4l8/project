package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzuh;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcli implements zzesa<Set<zzbzl<zzdtm>>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<String> zzgno;
    private final zzesn<Map<zzdth, zzcln>> zzgnp;

    public zzcli(zzesn<String> zzesnVar, zzesn<Context> zzesnVar2, zzesn<Executor> zzesnVar3, zzesn<Map<zzdth, zzcln>> zzesnVar4) {
        this.zzgno = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzeyl = zzesnVar3;
        this.zzgnp = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Set emptySet;
        String str = this.zzgno.get();
        Context context = this.zzeyq.get();
        Executor executor = this.zzeyl.get();
        Map<zzdth, zzcln> map = this.zzgnp.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwb)).booleanValue()) {
            zztz zztzVar = new zztz(new zzue(context));
            zztzVar.zza(new zzty(str) { // from class: com.google.android.gms.internal.ads.zzclk
                private final String zzdmo;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdmo = str;
                }

                @Override // com.google.android.gms.internal.ads.zzty
                public final void zza(zzuh.zzi.zza zzaVar) {
                    zzaVar.zzbx(this.zzdmo);
                }
            });
            emptySet = Collections.singleton(new zzbzl(new zzcll(zztzVar, map), executor));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzesg.zzbd(emptySet);
    }
}
