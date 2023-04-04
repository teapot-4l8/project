package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaiq implements com.google.android.gms.ads.internal.overlay.zzv {
    private boolean zzdjm = false;
    private final /* synthetic */ Map zzdjn;
    private final /* synthetic */ Map zzdjo;
    private final /* synthetic */ zzve zzdjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaiq(zzaio zzaioVar, Map map, Map map2, zzve zzveVar) {
        this.zzdjn = map;
        this.zzdjo = map2;
        this.zzdjp = zzveVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzv
    public final void zzb(zzacs zzacsVar) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzv
    public final void zzaf(boolean z) {
        if (this.zzdjm) {
            return;
        }
        this.zzdjm = true;
        this.zzdjn.put((String) this.zzdjo.get("event_id"), Boolean.valueOf(z));
        ((zzakr) this.zzdjp).zza("openIntentAsync", this.zzdjn);
    }
}
