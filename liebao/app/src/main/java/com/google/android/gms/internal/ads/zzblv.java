package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblv implements zzqw {
    private final Clock zzbqq;
    private zzbfi zzdkm;
    private final zzblg zzfuo;
    private final Executor zzfur;
    private boolean zzbwt = false;
    private boolean zzfvo = false;
    private zzblk zzfut = new zzblk();

    public zzblv(Executor executor, zzblg zzblgVar, Clock clock) {
        this.zzfur = executor;
        this.zzfuo = zzblgVar;
        this.zzbqq = clock;
    }

    private final void zzajv() {
        try {
            JSONObject zzi = this.zzfuo.zzi(this.zzfut);
            if (this.zzdkm != null) {
                this.zzfur.execute(new Runnable(this, zzi) { // from class: com.google.android.gms.internal.ads.zzblu
                    private final JSONObject zzfvb;
                    private final zzblv zzfvn;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfvn = this;
                        this.zzfvb = zzi;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzfvn.zzj(this.zzfvb);
                    }
                });
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed to call video active view js", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        this.zzfut.zzbrt = this.zzfvo ? false : zzqxVar.zzbrt;
        this.zzfut.timestamp = this.zzbqq.elapsedRealtime();
        this.zzfut.zzfva = zzqxVar;
        if (this.zzbwt) {
            zzajv();
        }
    }

    public final void zzd(zzbfi zzbfiVar) {
        this.zzdkm = zzbfiVar;
    }

    public final void disable() {
        this.zzbwt = false;
    }

    public final void enable() {
        this.zzbwt = true;
        zzajv();
    }

    public final void zzbi(boolean z) {
        this.zzfvo = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(JSONObject jSONObject) {
        this.zzdkm.zzb("AFMA_updateActiveView", jSONObject);
    }
}
