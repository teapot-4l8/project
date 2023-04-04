package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzduv {
    private static volatile zzbw.zza.zzc zzhvo = zzbw.zza.zzc.UNKNOWN;
    private final Context context;
    private final Executor executor;
    private final Task<zzue> zzhvn;

    public static void zza(zzbw.zza.zzc zzcVar) {
        zzhvo = zzcVar;
    }

    public static zzduv zza(Context context, Executor executor) {
        return new zzduv(context, executor, Tasks.call(executor, new Callable(context) { // from class: com.google.android.gms.internal.ads.zzdux
            private final Context zzdbt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbt = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzduv.zzcn(this.zzdbt);
            }
        }));
    }

    private zzduv(Context context, Executor executor, Task<zzue> task) {
        this.context = context;
        this.executor = executor;
        this.zzhvn = task;
    }

    public final Task<Boolean> zzh(int i, long j) {
        return zza(i, j, null, null, null, null);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return zza(i, j, exc, null, null, null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, null, str, null, null);
    }

    public final Task<Boolean> zzg(int i, String str) {
        return zza(i, 0L, null, null, null, str);
    }

    public final Task<Boolean> zzb(int i, long j, String str) {
        return zza(i, j, null, null, null, str);
    }

    private final Task<Boolean> zza(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbw.zza.zzb zzd = zzbw.zza.zzs().zzo(this.context.getPackageName()).zzd(j);
        zzd.zzb(zzhvo);
        if (exc != null) {
            zzd.zzp(zzdys.zza(exc)).zzq(exc.getClass().getName());
        }
        if (str2 != null) {
            zzd.zzr(str2);
        }
        if (str != null) {
            zzd.zzs(str);
        }
        return this.zzhvn.continueWith(this.executor, new Continuation(zzd, i) { // from class: com.google.android.gms.internal.ads.zzduw
            private final int zzehh;
            private final zzbw.zza.zzb zzhvp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhvp = zzd;
                this.zzehh = i;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzduv.zza(this.zzhvp, this.zzehh, task);
            }
        });
    }

    public static final /* synthetic */ Boolean zza(zzbw.zza.zzb zzbVar, int i, Task task) {
        if (task.isSuccessful()) {
            zzui zzf = ((zzue) task.getResult()).zzf(((zzbw.zza) ((zzena) zzbVar.zzbjv())).toByteArray());
            zzf.zzby(i);
            zzf.log();
            return true;
        }
        return false;
    }

    public static final /* synthetic */ zzue zzcn(Context context) {
        return new zzue(context, "GLAS", null);
    }
}
