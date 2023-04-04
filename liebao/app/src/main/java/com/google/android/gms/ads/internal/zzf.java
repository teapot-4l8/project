package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzcv;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzduv;
import com.google.android.gms.internal.ads.zzdwb;
import com.google.android.gms.internal.ads.zzdwu;
import com.google.android.gms.internal.ads.zzdwx;
import com.google.android.gms.internal.ads.zzdy;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzww;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzf implements zzdy, Runnable {
    private Context context;
    private int zzbpf;
    private final boolean zzbpg;
    private final boolean zzbph;
    private final Context zzbpi;
    private zzbar zzbpj;
    private final zzbar zzbpk;
    private final Executor zzvy;
    private final zzduv zzxh;
    private final List<Object[]> zzbpc = new Vector();
    private final AtomicReference<zzdy> zzbpd = new AtomicReference<>();
    private final AtomicReference<zzdy> zzbpe = new AtomicReference<>();
    private CountDownLatch zzbpl = new CountDownLatch(1);

    public zzf(Context context, zzbar zzbarVar) {
        this.context = context;
        this.zzbpi = context;
        this.zzbpj = zzbarVar;
        this.zzbpk = zzbarVar;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.zzvy = newCachedThreadPool;
        this.zzxh = zzduv.zza(context, newCachedThreadPool);
        this.zzbph = ((Boolean) zzww.zzra().zzd(zzabq.zzcsk)).booleanValue();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsn)).booleanValue()) {
            this.zzbpf = zzcv.zznp;
        } else {
            this.zzbpf = zzcv.zzno;
        }
        zzdwb zzdwbVar = new zzdwb(this.context, this.zzxh);
        zzi zziVar = new zzi(this);
        this.zzbpg = new zzdwu(this.context, zzdwbVar.zzazf(), zziVar, ((Boolean) zzww.zzra().zzd(zzabq.zzcsl)).booleanValue()).zzes(zzdwx.zzhxv);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctc)).booleanValue()) {
            zzbat.zzeke.execute(this);
            return;
        }
        zzww.zzqw();
        if (zzbae.zzaaq()) {
            zzbat.zzeke.execute(this);
        } else {
            run();
        }
    }

    private final boolean zzkd() {
        try {
            this.zzbpl.await();
            return true;
        } catch (InterruptedException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Interrupted during GADSignals creation.", e2);
            return false;
        }
    }

    private final void zzke() {
        zzdy zzcb = zzcb();
        if (this.zzbpc.isEmpty() || zzcb == null) {
            return;
        }
        for (Object[] objArr : this.zzbpc) {
            if (objArr.length == 1) {
                zzcb.zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                zzcb.zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzbpc.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zzb(Context context) {
        zzdy zzcb;
        if (!zzkd() || (zzcb = zzcb()) == null) {
            return "";
        }
        zzke();
        return zzcb.zzb(zze(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, View view, Activity activity) {
        zzdy zzcb = zzcb();
        return zzcb != null ? zzcb.zza(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view, Activity activity) {
        zzdy zzcb;
        if (!zzkd() || (zzcb = zzcb()) == null) {
            return "";
        }
        zzke();
        return zzcb.zza(zze(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zzb(View view) {
        zzdy zzcb = zzcb();
        if (zzcb != null) {
            zzcb.zzb(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(MotionEvent motionEvent) {
        zzdy zzcb = zzcb();
        if (zzcb != null) {
            zzke();
            zzcb.zza(motionEvent);
            return;
        }
        this.zzbpc.add(new Object[]{motionEvent});
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(int i, int i2, int i3) {
        zzdy zzcb = zzcb();
        if (zzcb != null) {
            zzke();
            zzcb.zza(i, i2, i3);
            return;
        }
        this.zzbpc.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.google.android.gms.internal.ads.zzbar] */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbpj.zzekc;
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcqe)).booleanValue() && z2) {
                z = true;
            }
            if (zzkf() == zzcv.zzno) {
                zza(zzef.zzb(this.zzbpj.zzbrz, zze(this.context), z, this.zzbpf));
                if (this.zzbpf == zzcv.zznp) {
                    this.zzvy.execute(new zzh(this, z));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    this.zzbpe.set(zzds.zza(this.zzbpj.zzbrz, zze(this.context), z));
                } catch (NullPointerException e2) {
                    this.zzbpf = zzcv.zzno;
                    zza(zzef.zzb(this.zzbpj.zzbrz, zze(this.context), z, this.zzbpf));
                    this.zzxh.zza(2031, System.currentTimeMillis() - currentTimeMillis, e2);
                }
            }
        } finally {
            this.zzbpl.countDown();
            this.context = null;
            this.zzbpj = null;
        }
    }

    private final zzdy zzcb() {
        if (zzkf() == zzcv.zznp) {
            return this.zzbpe.get();
        }
        return this.zzbpd.get();
    }

    private final void zza(zzdy zzdyVar) {
        this.zzbpd.set(zzdyVar);
    }

    private final int zzkf() {
        if (this.zzbph && !this.zzbpg) {
            return zzcv.zzno;
        }
        return this.zzbpf;
    }
}
