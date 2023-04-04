package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import com.just.agentweb.DefaultWebClient;
import com.tencent.bugly.CrashModule;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzdx implements zzdy {
    protected static volatile zzfc zzwh;
    protected MotionEvent zzwm;
    protected double zzwv;
    private double zzww;
    private double zzwx;
    protected float zzwy;
    protected float zzwz;
    protected float zzxa;
    protected float zzxb;
    protected DisplayMetrics zzxe;
    protected LinkedList<MotionEvent> zzwn = new LinkedList<>();
    protected long zzwo = 0;
    protected long zzwp = 0;
    protected long zzwq = 0;
    protected long zzwr = 0;
    protected long zzws = 0;
    protected long zzwt = 0;
    protected long zzwu = 0;
    private boolean zzxc = false;
    protected boolean zzxd = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdx(Context context) {
        try {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcta)).booleanValue()) {
                zzda.zzbp();
            } else {
                zzff.zzb(zzwh);
            }
            this.zzxe = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr);

    protected abstract zzcf.zza.zzb zza(Context context, zzcb.zza zzaVar);

    protected abstract zzcf.zza.zzb zzb(Context context, View view, Activity activity);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzfi zzb(MotionEvent motionEvent);

    @Override // com.google.android.gms.internal.ads.zzdy
    public void zzb(View view) {
    }

    protected abstract zzcf.zza.zzb zzc(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzdy
    public String zzb(Context context) {
        if (zzfh.isMainThread()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zza(context, null, zzew.zzyo, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public String zza(Context context, View view, Activity activity) {
        return zza(context, null, zzew.zzyp, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzew.zzyq, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzxc) {
            zzby();
            this.zzxc = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwv = 0.0d;
            this.zzww = motionEvent.getRawX();
            this.zzwx = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d2 = this.zzww;
            Double.isNaN(rawX);
            double d3 = rawX - d2;
            double d4 = this.zzwx;
            Double.isNaN(rawY);
            double d5 = rawY - d4;
            this.zzwv += Math.sqrt((d3 * d3) + (d5 * d5));
            this.zzww = rawX;
            this.zzwx = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    this.zzwm = obtain;
                    this.zzwn.add(obtain);
                    if (this.zzwn.size() > 6) {
                        this.zzwn.remove().recycle();
                    }
                    this.zzwq++;
                    this.zzws = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zzwp += motionEvent.getHistorySize() + 1;
                    zzfi zzb = zzb(motionEvent);
                    if ((zzb == null || zzb.zzzz == null || zzb.zzaac == null) ? false : true) {
                        this.zzwt += zzb.zzzz.longValue() + zzb.zzaac.longValue();
                    }
                    if (this.zzxe != null && zzb != null && zzb.zzaaa != null && zzb.zzaad != null) {
                        z = true;
                    }
                    if (z) {
                        this.zzwu += zzb.zzaaa.longValue() + zzb.zzaad.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzwr++;
                }
            } catch (zzev unused) {
            }
        } else {
            this.zzwy = motionEvent.getX();
            this.zzwz = motionEvent.getY();
            this.zzxa = motionEvent.getRawX();
            this.zzxb = motionEvent.getRawY();
            this.zzwo++;
        }
        this.zzxd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public void zza(int i, int i2, int i3) {
        if (this.zzwm != null) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcso)).booleanValue()) {
                zzby();
            } else {
                this.zzwm.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzxe;
        if (displayMetrics != null) {
            this.zzwm = MotionEvent.obtain(0L, i3, 1, i * displayMetrics.density, this.zzxe.density * i2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzwm = null;
        }
        this.zzxd = false;
    }

    private final void zzby() {
        this.zzws = 0L;
        this.zzwo = 0L;
        this.zzwp = 0L;
        this.zzwq = 0L;
        this.zzwr = 0L;
        this.zzwt = 0L;
        this.zzwu = 0L;
        if (this.zzwn.size() > 0) {
            Iterator<MotionEvent> it = this.zzwn.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzwn.clear();
        } else {
            MotionEvent motionEvent = this.zzwm;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwm = null;
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzdw zzdwVar;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcsq)).booleanValue();
        zzcf.zza.zzb zzbVar = null;
        if (booleanValue) {
            zzdwVar = zzwh != null ? zzwh.zzcm() : null;
            str2 = ((Boolean) zzww.zzra().zzd(zzabq.zzcta)).booleanValue() ? "be" : "te";
        } else {
            zzdwVar = null;
            str2 = null;
        }
        try {
            if (i == zzew.zzyq) {
                zzbVar = zzb(context, view, activity);
                this.zzxc = true;
                i5 = 1002;
            } else if (i == zzew.zzyp) {
                zzbVar = zzc(context, view, activity);
                i5 = 1008;
            } else {
                zzbVar = zza(context, null);
                i5 = 1000;
            }
            if (booleanValue && zzdwVar != null) {
                zzdwVar.zza(i5, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e2) {
            if (booleanValue && zzdwVar != null) {
                if (i == zzew.zzyq) {
                    i2 = 1003;
                } else if (i == zzew.zzyp) {
                    i2 = 1009;
                } else {
                    i2 = i == zzew.zzyo ? DefaultWebClient.DERECT_OPEN_OTHER_PAGE : -1;
                }
                zzdwVar.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis, str2, e2);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zzbVar != null) {
            try {
                if (((zzcf.zza) ((zzena) zzbVar.zzbjv())).zzbjj() != 0) {
                    String zzj = zzda.zzj((zzcf.zza) ((zzena) zzbVar.zzbjv()), str);
                    if (!booleanValue || zzdwVar == null) {
                        return zzj;
                    }
                    if (i == zzew.zzyq) {
                        i4 = 1006;
                    } else if (i == zzew.zzyp) {
                        i4 = 1010;
                    } else {
                        i4 = i == zzew.zzyo ? CrashModule.MODULE_ID : -1;
                    }
                    zzdwVar.zza(i4, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return zzj;
                }
            } catch (Exception e3) {
                String num = Integer.toString(7);
                if (!booleanValue || zzdwVar == null) {
                    return num;
                }
                if (i == zzew.zzyq) {
                    i3 = 1007;
                } else if (i == zzew.zzyp) {
                    i3 = 1011;
                } else {
                    i3 = i == zzew.zzyo ? 1005 : -1;
                }
                zzdwVar.zza(i3, -1, System.currentTimeMillis() - currentTimeMillis2, str2, e3);
                return num;
            }
        }
        return Integer.toString(5);
    }
}
