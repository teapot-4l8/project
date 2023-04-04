package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzik {
    private final Handler handler;
    private final zzil zzajn;

    public zzik(Handler handler, zzil zzilVar) {
        this.handler = zzilVar != null ? (Handler) zzpg.checkNotNull(handler) : null;
        this.zzajn = zzilVar;
    }

    public final void zza(zzjm zzjmVar) {
        if (this.zzajn != null) {
            this.handler.post(new zzin(this, zzjmVar));
        }
    }

    public final void zza(String str, long j, long j2) {
        if (this.zzajn != null) {
            this.handler.post(new zzim(this, str, j, j2));
        }
    }

    public final void zzb(zzht zzhtVar) {
        if (this.zzajn != null) {
            this.handler.post(new zzip(this, zzhtVar));
        }
    }

    public final void zza(int i, long j, long j2) {
        if (this.zzajn != null) {
            this.handler.post(new zzio(this, i, j, j2));
        }
    }

    public final void zzb(zzjm zzjmVar) {
        if (this.zzajn != null) {
            this.handler.post(new zzir(this, zzjmVar));
        }
    }

    public final void zzz(int i) {
        if (this.zzajn != null) {
            this.handler.post(new zziq(this, i));
        }
    }
}
