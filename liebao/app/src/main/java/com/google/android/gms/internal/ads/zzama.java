package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzama implements zzbbi<zzakv> {
    final /* synthetic */ zzalz zzdlq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzama(zzalz zzalzVar) {
        this.zzdlq = zzalzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbi
    public final /* synthetic */ void zzg(zzakv zzakvVar) {
        final zzakv zzakvVar2 = zzakvVar;
        zzbat.zzeki.execute(new Runnable(this, zzakvVar2) { // from class: com.google.android.gms.internal.ads.zzamd
            private final zzama zzdlr;
            private final zzakv zzdls;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlr = this;
                this.zzdls = zzakvVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.util.zzar zzarVar;
                zzama zzamaVar = this.zzdlr;
                zzakv zzakvVar3 = this.zzdls;
                zzarVar = zzamaVar.zzdlq.zzdkt;
                zzarVar.zzg(zzakvVar3);
                zzakvVar3.destroy();
            }
        });
    }
}
