package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzech extends zzebp<zzebt<V>> {
    private final /* synthetic */ zzece zzief;
    private final zzeas<V> zzieg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzech(zzece zzeceVar, zzeas<V> zzeasVar) {
        this.zzief = zzeceVar;
        this.zzieg = (zzeas) zzdyi.checkNotNull(zzeasVar);
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final boolean isDone() {
        return this.zzief.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final String zzbbb() {
        return this.zzieg.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final /* synthetic */ void zzb(Object obj, Throwable th) {
        zzebt zzebtVar = (zzebt) obj;
        if (th == null) {
            this.zzief.setFuture(zzebtVar);
        } else {
            this.zzief.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final /* synthetic */ Object zzbba() {
        return (zzebt) zzdyi.zza(this.zzieg.zzauk(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzieg);
    }
}
