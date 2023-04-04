package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzalx implements zzbbi<zzamc> {
    private final /* synthetic */ zzalv zzdlm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalx(zzalv zzalvVar) {
        this.zzdlm = zzalvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbi
    public final /* synthetic */ void zzg(zzamc zzamcVar) {
        zzalz zzalzVar;
        com.google.android.gms.ads.internal.util.zzd.zzed("Releasing engine reference.");
        zzalzVar = this.zzdlm.zzdlk;
        zzalzVar.zzux();
    }
}
