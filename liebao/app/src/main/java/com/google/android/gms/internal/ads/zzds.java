package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzds implements zzdy {
    private static zzds zzvs;
    private final Context context;
    private final zzdwp zzvt;
    private final zzdwu zzvu;
    private final zzdwz zzvv;
    private final zzex zzvw;
    private final zzduv zzvx;
    private final Executor zzvy;
    private final zzgp zzvz;
    private final zzdwv zzwa;
    private volatile long zzwb = 0;
    private final Object zzwc = new Object();
    private volatile boolean zzwd;

    public static synchronized zzds zza(String str, Context context, boolean z) {
        zzds zzdsVar;
        synchronized (zzds.class) {
            if (zzvs == null) {
                zzduz zzayn = zzduz.zzayq().zzhf(str).zzbt(z).zzayn();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzds zza = zza(context, zzduv.zza(context, newCachedThreadPool), zzayn, newCachedThreadPool);
                zzvs = zza;
                zza.zzbr();
                zzvs.zzbu();
            }
            zzdsVar = zzvs;
        }
        return zzdsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzds zza(Context context, zzduv zzduvVar, zzduz zzduzVar) {
        return zza(context, zzduvVar, zzduzVar, Executors.newCachedThreadPool());
    }

    private static zzds zza(Context context, zzduv zzduvVar, zzduz zzduzVar, Executor executor) {
        zzdvl zza = zzdvl.zza(context, executor, zzduvVar, zzduzVar);
        zzfa zzfaVar = new zzfa(context);
        zzex zzexVar = new zzex(zzduzVar, zza, new zzfj(context, zzfaVar), zzfaVar);
        zzgp zzazf = new zzdwb(context, zzduvVar).zzazf();
        zzduu zzduuVar = new zzduu();
        return new zzds(context, zzduvVar, new zzdwp(context, zzazf), new zzdwu(context, zzazf, new zzdr(zzduvVar), ((Boolean) zzww.zzra().zzd(zzabq.zzcsl)).booleanValue()), new zzdwz(context, zzexVar, zzduvVar, zzduuVar), zzexVar, executor, zzduuVar, zzazf);
    }

    private zzds(Context context, zzduv zzduvVar, zzdwp zzdwpVar, zzdwu zzdwuVar, zzdwz zzdwzVar, zzex zzexVar, Executor executor, zzduu zzduuVar, zzgp zzgpVar) {
        this.context = context;
        this.zzvx = zzduvVar;
        this.zzvt = zzdwpVar;
        this.zzvu = zzdwuVar;
        this.zzvv = zzdwzVar;
        this.zzvw = zzexVar;
        this.zzvy = executor;
        this.zzvz = zzgpVar;
        this.zzwa = new zzdu(this, zzduuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzbr() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdwm zzp = zzp(zzdwx.zzhxv);
        if (zzp != null) {
            this.zzvv.zzb(zzp);
        } else {
            this.zzvx.zzh(4013, System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public final void zzbs() {
        if (zzdwb.zza(this.zzvz)) {
            this.zzvy.execute(new zzdt(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa A[Catch: zzenn -> 0x0127, TryCatch #1 {zzenn -> 0x0127, blocks: (B:6:0x0022, B:8:0x0033, B:11:0x003a, B:12:0x0048, B:14:0x0058, B:16:0x0066, B:19:0x0072, B:32:0x00aa, B:34:0x00b7, B:38:0x00d0, B:44:0x00e9, B:46:0x00f6, B:48:0x00fe, B:41:0x00da, B:42:0x00e1, B:22:0x007b, B:25:0x0082, B:27:0x0094, B:50:0x010d, B:52:0x011a), top: B:59:0x0022, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7 A[Catch: zzenn -> 0x0127, TryCatch #1 {zzenn -> 0x0127, blocks: (B:6:0x0022, B:8:0x0033, B:11:0x003a, B:12:0x0048, B:14:0x0058, B:16:0x0066, B:19:0x0072, B:32:0x00aa, B:34:0x00b7, B:38:0x00d0, B:44:0x00e9, B:46:0x00f6, B:48:0x00fe, B:41:0x00da, B:42:0x00e1, B:22:0x007b, B:25:0x0082, B:27:0x0094, B:50:0x010d, B:52:0x011a), top: B:59:0x0022, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzbt() {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        zzdwm zzp = zzp(zzdwx.zzhxv);
        if (zzp != null) {
            String zzdh = zzp.zzazj().zzdh();
            str2 = zzp.zzazj().zzdi();
            str = zzdh;
        } else {
            str = null;
            str2 = null;
        }
        try {
            zzdwt zza = zzdvh.zza(this.context, 1, this.zzvz, str, str2, "1", this.zzvx);
            if (zza.zzhxp == null || zza.zzhxp.length == 0) {
                this.zzvx.zzh(5009, System.currentTimeMillis() - currentTimeMillis);
                return;
            }
            try {
                zzgr zza2 = zzgr.zza(zzelq.zzt(zza.zzhxp), zzemn.zzbiv());
                boolean z = true;
                boolean z2 = false;
                if (!zza2.zzdd().zzdh().isEmpty()) {
                    if (!zza2.zzdd().zzdi().isEmpty()) {
                        if (zza2.zzdf().toByteArray().length != 0) {
                            zzdwm zzp2 = zzp(zzdwx.zzhxv);
                            if (zzp2 != null) {
                                zzgv zzazj = zzp2.zzazj();
                                if (zzazj != null) {
                                    if (zza2.zzdd().zzdh().equals(zzazj.zzdh())) {
                                        if (!zza2.zzdd().zzdi().equals(zzazj.zzdi())) {
                                        }
                                    }
                                }
                            }
                            if (z) {
                                this.zzvx.zzh(5010, System.currentTimeMillis() - currentTimeMillis);
                                return;
                            }
                            zzdwv zzdwvVar = this.zzwa;
                            int i = zza.status;
                            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcsj)).booleanValue()) {
                                z2 = this.zzvt.zza(zza2, zzdwvVar);
                            } else if (i == 3) {
                                z2 = this.zzvu.zza(zza2);
                            } else if (i == 4) {
                                z2 = this.zzvu.zza(zza2, zzdwvVar);
                            }
                            if (!z2) {
                                this.zzvx.zzh(4009, System.currentTimeMillis() - currentTimeMillis);
                                return;
                            }
                            zzdwm zzp3 = zzp(zzdwx.zzhxv);
                            if (zzp3 != null) {
                                this.zzvv.zzb(zzp3);
                                this.zzwb = System.currentTimeMillis() / 1000;
                                return;
                            }
                            return;
                        }
                    }
                }
                z = false;
                if (z) {
                }
            } catch (NullPointerException unused) {
                this.zzvx.zzh(2030, System.currentTimeMillis() - currentTimeMillis);
            }
        } catch (zzenn e2) {
            this.zzvx.zza(4002, System.currentTimeMillis() - currentTimeMillis, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(MotionEvent motionEvent) {
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu != null) {
            try {
                zzazu.zza(null, motionEvent);
            } catch (zzdww e2) {
                this.zzvx.zza(e2.zzazt(), -1L, e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view, Activity activity) {
        zzbu();
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zza = zzazu.zza(context, null, str, view, activity);
            this.zzvx.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, null);
            return zza;
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zzb(View view) {
        this.zzvw.zzc(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, View view, Activity activity) {
        zzbu();
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zzb = zzazu.zzb(context, null, view, activity);
            this.zzvx.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, null);
            return zzb;
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zzb(Context context) {
        zzbu();
        zzdvb zzazu = this.zzvv.zzazu();
        if (zzazu != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zzs = zzazu.zzs(context, null);
            this.zzvx.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzs, null);
            return zzs;
        }
        return "";
    }

    public final void zzbu() {
        if (this.zzwd) {
            return;
        }
        synchronized (this.zzwc) {
            if (!this.zzwd) {
                if ((System.currentTimeMillis() / 1000) - this.zzwb < 3600) {
                    return;
                }
                zzdwm zzazv = this.zzvv.zzazv();
                if (zzazv == null || zzazv.zzfg(3600L)) {
                    zzbs();
                }
            }
        }
    }

    private final zzdwm zzp(int i) {
        if (zzdwb.zza(this.zzvz)) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcsj)).booleanValue()) {
                return this.zzvu.zzp(i);
            }
            return this.zzvt.zzp(i);
        }
        return null;
    }
}
