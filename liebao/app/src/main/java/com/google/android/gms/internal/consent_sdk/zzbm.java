package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzbm implements Executor {
    private final Handler zza;

    private zzbm(Handler handler) {
        this.zza = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor zza(Handler handler) {
        return new zzbm(handler);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
