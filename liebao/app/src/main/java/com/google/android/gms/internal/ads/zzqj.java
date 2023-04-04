package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqj {
    private final Handler handler;
    private final zzqk zzbnj;

    public zzqj(Handler handler, zzqk zzqkVar) {
        this.handler = zzqkVar != null ? (Handler) zzpg.checkNotNull(handler) : null;
        this.zzbnj = zzqkVar;
    }

    public final void zza(zzjm zzjmVar) {
        if (this.zzbnj != null) {
            this.handler.post(new zzqm(this, zzjmVar));
        }
    }

    public final void zza(String str, long j, long j2) {
        if (this.zzbnj != null) {
            this.handler.post(new zzql(this, str, j, j2));
        }
    }

    public final void zzb(zzht zzhtVar) {
        if (this.zzbnj != null) {
            this.handler.post(new zzqo(this, zzhtVar));
        }
    }

    public final void zzf(int i, long j) {
        if (this.zzbnj != null) {
            this.handler.post(new zzqn(this, i, j));
        }
    }

    public final void zza(int i, int i2, int i3, float f) {
        if (this.zzbnj != null) {
            this.handler.post(new zzqq(this, i, i2, i3, f));
        }
    }

    public final void zza(Surface surface) {
        if (this.zzbnj != null) {
            this.handler.post(new zzqp(this, surface));
        }
    }

    public final void zzb(zzjm zzjmVar) {
        if (this.zzbnj != null) {
            this.handler.post(new zzqr(this, zzjmVar));
        }
    }
}
