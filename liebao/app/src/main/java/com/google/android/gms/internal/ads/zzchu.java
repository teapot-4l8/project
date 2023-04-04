package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchu {
    private final Context context;
    private final zzbfq zzbqk;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzcsh zzdji;
    private final zzbar zzdvi;
    private final zzei zzeus;
    private final zzdup zzftn;
    private final Executor zzfur;
    private final com.google.android.gms.ads.internal.zzb zzgkn;
    private final zzcic zzglg = new zzcic(null);
    private final zzais zzglh = new zzais();
    private zzebt<zzbfi> zzgli;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchu(zzcih zzcihVar) {
        this.context = zzcih.zza(zzcihVar);
        this.zzfur = zzcih.zzb(zzcihVar);
        this.zzeus = zzcih.zzc(zzcihVar);
        this.zzdvi = zzcih.zzd(zzcihVar);
        this.zzgkn = zzcih.zze(zzcihVar);
        this.zzbqk = zzcih.zzf(zzcihVar);
        this.zzdji = zzcih.zzg(zzcihVar);
        this.zzftn = zzcih.zzh(zzcihVar);
        this.zzdje = zzcih.zzi(zzcihVar);
        this.zzdjf = zzcih.zzj(zzcihVar);
    }

    public final synchronized void zzaqh() {
        zzebt<zzbfi> zzb = zzebh.zzb(zzbfq.zza(this.context, this.zzdvi, (String) zzww.zzra().zzd(zzabq.zzctp), this.zzeus, this.zzgkn), new zzdxw(this) { // from class: com.google.android.gms.internal.ads.zzchx
            private final zzchu zzglk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzglk = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                return this.zzglk.zzj((zzbfi) obj);
            }
        }, this.zzfur);
        this.zzgli = zzb;
        zzbba.zza(zzb, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void destroy() {
        if (this.zzgli == null) {
            return;
        }
        zzebh.zza(this.zzgli, new zzchz(this), this.zzfur);
        this.zzgli = null;
    }

    public final synchronized zzebt<JSONObject> zzc(final String str, final JSONObject jSONObject) {
        if (this.zzgli == null) {
            return zzebh.zzag(null);
        }
        return zzebh.zzb(this.zzgli, new zzear(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.zzchw
            private final String zzdkl;
            private final zzchu zzglk;
            private final JSONObject zzgll;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzglk = this;
                this.zzdkl = str;
                this.zzgll = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzglk.zza(this.zzdkl, this.zzgll, (zzbfi) obj);
            }
        }, this.zzfur);
    }

    public final synchronized void zza(String str, zzaig<Object> zzaigVar) {
        if (this.zzgli == null) {
            return;
        }
        zzebh.zza(this.zzgli, new zzchy(this, str, zzaigVar), this.zzfur);
    }

    public final synchronized void zzb(String str, zzaig<Object> zzaigVar) {
        if (this.zzgli == null) {
            return;
        }
        zzebh.zza(this.zzgli, new zzcib(this, str, zzaigVar), this.zzfur);
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzgli == null) {
            return;
        }
        zzebh.zza(this.zzgli, new zzcia(this, str, map), this.zzfur);
    }

    public final synchronized void zza(zzdot zzdotVar, zzdoy zzdoyVar) {
        if (this.zzgli == null) {
            return;
        }
        zzebh.zza(this.zzgli, new zzcid(this, zzdotVar, zzdoyVar), this.zzfur);
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzaig<T> zzaigVar) {
        zza(str, new zzcig(this, weakReference, str, zzaigVar, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, JSONObject jSONObject, zzbfi zzbfiVar) {
        return this.zzglh.zza(zzbfiVar, str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbfi zzj(zzbfi zzbfiVar) {
        zzbfiVar.zza("/result", this.zzglh);
        zzbgu zzaef = zzbfiVar.zzaef();
        zzcic zzcicVar = this.zzglg;
        zzaef.zza(null, zzcicVar, zzcicVar, zzcicVar, zzcicVar, false, null, new com.google.android.gms.ads.internal.zza(this.context, null, null), null, null, this.zzdji, this.zzftn, this.zzdje, this.zzdjf);
        return zzbfiVar;
    }
}
