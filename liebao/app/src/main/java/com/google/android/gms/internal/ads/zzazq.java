package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazq {
    private long zzedw = -1;
    private long zzedx = -1;
    private final /* synthetic */ zzazr zzedy;

    public zzazq(zzazr zzazrVar) {
        this.zzedy = zzazrVar;
    }

    public final long zzxy() {
        return this.zzedx;
    }

    public final void zzxz() {
        Clock clock;
        clock = this.zzedy.zzbqq;
        this.zzedx = clock.elapsedRealtime();
    }

    public final void zzya() {
        Clock clock;
        clock = this.zzedy.zzbqq;
        this.zzedw = clock.elapsedRealtime();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzedw);
        bundle.putLong("tclose", this.zzedx);
        return bundle;
    }
}
