package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzgn implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzcf.zza.zzb zzabg;
    private final String zzabo;
    protected Method zzabq;
    private final int zzabt;
    private final int zzabu;
    protected final zzfc zzwh;

    public zzgn(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2) {
        this.zzwh = zzfcVar;
        this.className = str;
        this.zzabo = str2;
        this.zzabg = zzbVar;
        this.zzabt = i;
        this.zzabu = i2;
    }

    protected abstract void zzcx();

    @Override // java.util.concurrent.Callable
    /* renamed from: zzcz */
    public Void call() {
        long nanoTime;
        Method zza;
        try {
            nanoTime = System.nanoTime();
            zza = this.zzwh.zza(this.className, this.zzabo);
            this.zzabq = zza;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (zza == null) {
            return null;
        }
        zzcx();
        zzdw zzcm = this.zzwh.zzcm();
        if (zzcm != null && this.zzabt != Integer.MIN_VALUE) {
            zzcm.zza(this.zzabu, this.zzabt, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
