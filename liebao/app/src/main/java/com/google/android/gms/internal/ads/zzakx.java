package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzakx implements zzakq, zzakv {
    private final zzbfi zzdkm;

    public zzakx(Context context, zzbar zzbarVar, zzei zzeiVar, com.google.android.gms.ads.internal.zzb zzbVar) {
        com.google.android.gms.ads.internal.zzr.zzkw();
        zzbfi zza = zzbfq.zza(context, zzbgx.zzafg(), "", false, false, zzeiVar, null, zzbarVar, null, null, null, zztz.zznl(), null, null);
        this.zzdkm = zza;
        zza.getView().setWillNotDraw(true);
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, Map map) {
        zzakt.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakq, com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, JSONObject jSONObject) {
        zzakt.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, JSONObject jSONObject) {
        zzakt.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakq
    public final void zzi(String str, String str2) {
        zzakt.zza(this, str, str2);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzww.zzqw();
        if (zzbae.zzaaq()) {
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakq, com.google.android.gms.internal.ads.zzalf
    public final void zzcv(String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzakw
            private final zzakx zzdkk;
            private final String zzdkl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdkk = this;
                this.zzdkl = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdkk.zzdc(this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakv
    public final void zzcw(String str) {
        runOnUiThread(new Runnable(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)) { // from class: com.google.android.gms.internal.ads.zzakz
            private final zzakx zzdkk;
            private final String zzdkl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdkk = this;
                this.zzdkl = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdkk.zzdb(this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakv
    public final void zzcy(String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzaky
            private final zzakx zzdkk;
            private final String zzdkl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdkk = this;
                this.zzdkl = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdkk.zzda(this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakv
    public final void zzcx(String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzalb
            private final zzakx zzdkk;
            private final String zzdkl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdkk = this;
                this.zzdkl = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdkk.zzcz(this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzamc
    public final void zza(String str, zzaig<? super zzamc> zzaigVar) {
        this.zzdkm.zza(str, new zzalc(this, zzaigVar));
    }

    @Override // com.google.android.gms.internal.ads.zzamc
    public final void zzb(String str, final zzaig<? super zzamc> zzaigVar) {
        this.zzdkm.zza(str, new Predicate(zzaigVar) { // from class: com.google.android.gms.internal.ads.zzala
            private final zzaig zzdkn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdkn = zzaigVar;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzaig zzaigVar2;
                zzaig zzaigVar3 = this.zzdkn;
                zzaig zzaigVar4 = (zzaig) obj;
                if (zzaigVar4 instanceof zzalc) {
                    zzaigVar2 = ((zzalc) zzaigVar4).zzdko;
                    return zzaigVar2.equals(zzaigVar3);
                }
                return false;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakv
    public final void zza(zzaku zzakuVar) {
        zzbgu zzaef = this.zzdkm.zzaef();
        zzakuVar.getClass();
        zzaef.zza(zzald.zzb(zzakuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzakv
    public final zzamf zzuu() {
        return new zzame(this);
    }

    @Override // com.google.android.gms.internal.ads.zzakv
    public final void destroy() {
        this.zzdkm.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzakv
    public final boolean isDestroyed() {
        return this.zzdkm.isDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzcz(String str) {
        this.zzdkm.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzda(String str) {
        this.zzdkm.loadData(str, "text/html", "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdb(String str) {
        this.zzdkm.loadData(str, "text/html", "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdc(String str) {
        this.zzdkm.zzcv(str);
    }
}
