package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzecc<V> implements Runnable {
    @NullableDecl
    private zzeca<V> zzied;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecc(zzeca<V> zzecaVar) {
        this.zzied = zzecaVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        r1 = ((com.google.android.gms.internal.ads.zzeca) r0).zzieb;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        zzebt<? extends V> zzebtVar;
        ScheduledFuture scheduledFuture;
        zzeca<V> zzecaVar = this.zzied;
        if (zzecaVar == null || zzebtVar == null) {
            return;
        }
        this.zzied = null;
        if (zzebtVar.isDone()) {
            zzecaVar.setFuture(zzebtVar);
            return;
        }
        try {
            scheduledFuture = ((zzeca) zzecaVar).zziec;
            ((zzeca) zzecaVar).zziec = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                if (abs > 10) {
                    StringBuilder sb = new StringBuilder("Timed out".length() + 66);
                    sb.append("Timed out");
                    sb.append(" (timeout delayed by ");
                    sb.append(abs);
                    sb.append(" ms after scheduled time)");
                    str = sb.toString();
                }
            }
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(zzebtVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
            sb2.append(valueOf);
            sb2.append(": ");
            sb2.append(valueOf2);
            zzecaVar.setException(new zzecf(sb2.toString()));
        } finally {
            zzebtVar.cancel(true);
        }
    }
}
