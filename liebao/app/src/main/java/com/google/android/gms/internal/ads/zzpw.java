package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzpw implements ThreadFactory {
    private final /* synthetic */ String zzblc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpw(String str) {
        this.zzblc = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zzblc);
    }
}
