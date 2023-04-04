package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzalm implements zzaig<zzamc> {
    private final /* synthetic */ zzei zzdlc;
    private final /* synthetic */ zzakv zzdld;
    private final /* synthetic */ com.google.android.gms.ads.internal.util.zzbs zzdle;
    private final /* synthetic */ zzale zzdlf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalm(zzale zzaleVar, zzei zzeiVar, zzakv zzakvVar, com.google.android.gms.ads.internal.util.zzbs zzbsVar) {
        this.zzdlf = zzaleVar;
        this.zzdlc = zzeiVar;
        this.zzdld = zzakvVar;
        this.zzdle = zzbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzamc zzamcVar, Map map) {
        Object obj;
        int i;
        obj = this.zzdlf.lock;
        synchronized (obj) {
            com.google.android.gms.ads.internal.util.zzd.zzey("JS Engine is requesting an update");
            i = this.zzdlf.status;
            if (i == 0) {
                com.google.android.gms.ads.internal.util.zzd.zzey("Starting reload.");
                this.zzdlf.status = 2;
                this.zzdlf.zza(this.zzdlc);
            }
            this.zzdld.zzb("/requestReload", (zzaig) this.zzdle.get());
        }
    }
}
