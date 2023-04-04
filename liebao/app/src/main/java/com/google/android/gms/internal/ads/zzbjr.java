package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbjr extends zzyk {
    private final Context context;
    private final zzbar zzbpx;
    private final zzayd zzbrf;
    private final zzckb zzfsr;
    private final zzcta<zzdqd, zzcuu> zzfss;
    private final zzczb zzfst;
    private final zzcna zzfsu;
    private final zzckd zzfsv;
    private boolean zzzq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjr(Context context, zzbar zzbarVar, zzckb zzckbVar, zzcta<zzdqd, zzcuu> zzctaVar, zzczb zzczbVar, zzcna zzcnaVar, zzayd zzaydVar, zzckd zzckdVar) {
        this.context = context;
        this.zzbpx = zzbarVar;
        this.zzfsr = zzckbVar;
        this.zzfss = zzctaVar;
        this.zzfst = zzczbVar;
        this.zzfsu = zzcnaVar;
        this.zzbrf = zzaydVar;
        this.zzfsv = zzckdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final synchronized void initialize() {
        if (this.zzzq) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Mobile ads is initialized already.");
            return;
        }
        zzabq.initialize(this.context);
        com.google.android.gms.ads.internal.zzr.zzkz().zzd(this.context, this.zzbpx);
        com.google.android.gms.ads.internal.zzr.zzlb().initialize(this.context);
        this.zzzq = true;
        this.zzfsu.zzarv();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrp)).booleanValue()) {
            this.zzfst.zzaqq();
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcum)).booleanValue()) {
            this.zzfsv.zzaqq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final synchronized void setAppVolume(float f) {
        com.google.android.gms.ads.internal.zzr.zzla().setAppVolume(f);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final synchronized float zzrg() {
        return com.google.android.gms.ads.internal.zzr.zzla().zzrg();
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final synchronized void setAppMuted(boolean z) {
        com.google.android.gms.ads.internal.zzr.zzla().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final synchronized boolean zzrh() {
        return com.google.android.gms.ads.internal.zzr.zzla().zzrh();
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final synchronized void zzcd(String str) {
        zzabq.initialize(this.context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcul)).booleanValue()) {
                com.google.android.gms.ads.internal.zzr.zzld().zza(this.context, this.zzbpx, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Context is null. Failed to open debug menu.");
            return;
        }
        com.google.android.gms.ads.internal.util.zzad zzadVar = new com.google.android.gms.ads.internal.util.zzad(context);
        zzadVar.setAdUnitId(str);
        zzadVar.zzu(this.zzbpx.zzbrz);
        zzadVar.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzabq.initialize(this.context);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcuo)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            str2 = com.google.android.gms.ads.internal.util.zzj.zzbb(this.context);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcul)).booleanValue() | ((Boolean) zzww.zzra().zzd(zzabq.zzcpw)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpw)).booleanValue()) {
            booleanValue = true;
            runnable = new Runnable(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper)) { // from class: com.google.android.gms.internal.ads.zzbjq
                private final zzbjr zzfsp;
                private final Runnable zzfsq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfsp = this;
                    this.zzfsq = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final zzbjr zzbjrVar = this.zzfsp;
                    final Runnable runnable2 = this.zzfsq;
                    zzbat.zzeki.execute(new Runnable(zzbjrVar, runnable2) { // from class: com.google.android.gms.internal.ads.zzbjt
                        private final zzbjr zzfsp;
                        private final Runnable zzfsq;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzfsp = zzbjrVar;
                            this.zzfsq = runnable2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzfsp.zzd(this.zzfsq);
                        }
                    });
                }
            };
        }
        if (booleanValue) {
            com.google.android.gms.ads.internal.zzr.zzld().zza(this.context, this.zzbpx, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final String getVersionString() {
        return this.zzbpx.zzbrz;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzce(String str) {
        this.zzfst.zzgq(str);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzann zzannVar) {
        this.zzfsr.zzb(zzannVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzajt zzajtVar) {
        this.zzfsu.zzb(zzajtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final List<zzajm> zzri() {
        return this.zzfsu.zzarw();
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzaat zzaatVar) {
        this.zzbrf.zza(this.context, zzaatVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzrj() {
        this.zzfsu.disable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzani> zzyt = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzg().zzyt();
        if (zzyt == null || zzyt.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzfsr.zzaqo()) {
            HashMap hashMap = new HashMap();
            for (zzani zzaniVar : zzyt.values()) {
                for (zzanj zzanjVar : zzaniVar.zzdmy) {
                    String str = zzanjVar.zzdod;
                    for (String str2 : zzanjVar.zzdnv) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzctb<zzdqd, zzcuu> zzf = this.zzfss.zzf(str3, jSONObject);
                    if (zzf != null) {
                        zzdqd zzdqdVar = zzf.zzdoy;
                        if (!zzdqdVar.isInitialized() && zzdqdVar.zzvj()) {
                            zzdqdVar.zza(this.context, zzf.zzgvk, (List) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            com.google.android.gms.ads.internal.util.zzd.zzdz(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (zzdpq e2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    com.google.android.gms.ads.internal.util.zzd.zzd(sb.toString(), e2);
                }
            }
        }
    }
}
