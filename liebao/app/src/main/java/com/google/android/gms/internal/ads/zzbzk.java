package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzk extends zzbxq<zzqw> implements zzqw {
    private final Context context;
    private final zzdot zzeux;
    private Map<View, zzqs> zzgdg;

    public zzbzk(Context context, Set<zzbzl<zzqw>> set, zzdot zzdotVar) {
        super(set);
        this.zzgdg = new WeakHashMap(1);
        this.context = context;
        this.zzeux = zzdotVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final synchronized void zza(zzqx zzqxVar) {
        zza(new zzbxs(zzqxVar) { // from class: com.google.android.gms.internal.ads.zzbzn
            private final zzqx zzgdi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgdi = zzqxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzqw) obj).zza(this.zzgdi);
            }
        });
    }

    public final synchronized void zzv(View view) {
        zzqs zzqsVar = this.zzgdg.get(view);
        if (zzqsVar == null) {
            zzqsVar = new zzqs(this.context, view);
            zzqsVar.zza(this);
            this.zzgdg.put(view, zzqsVar);
        }
        if (this.zzeux != null && this.zzeux.zzdyk) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcri)).booleanValue()) {
                zzqsVar.zzen(((Long) zzww.zzra().zzd(zzabq.zzcrh)).longValue());
                return;
            }
        }
        zzqsVar.zzlx();
    }

    public final synchronized void zzw(View view) {
        if (this.zzgdg.containsKey(view)) {
            this.zzgdg.get(view).zzb(this);
            this.zzgdg.remove(view);
        }
    }
}
