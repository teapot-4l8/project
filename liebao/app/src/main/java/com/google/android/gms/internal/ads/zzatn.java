package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzatn implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzatl zzdvk;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdvl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatn(zzatl zzatlVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdvk = zzatlVar;
        this.zzdvl = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.zzdvk.zza(thread, th);
            } catch (Throwable unused) {
                zzbao.zzex("AdMob exception reporter failed reporting the exception.");
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdvl;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        } finally {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdvl;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        }
    }
}
