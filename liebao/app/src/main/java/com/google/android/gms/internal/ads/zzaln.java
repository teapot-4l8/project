package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaln implements zzaig<zzamc> {
    private final /* synthetic */ zzakv zzdld;
    private final /* synthetic */ zzale zzdlf;
    private final /* synthetic */ zzalz zzdlg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaln(zzale zzaleVar, zzalz zzalzVar, zzakv zzakvVar) {
        this.zzdlf = zzaleVar;
        this.zzdlg = zzalzVar;
        this.zzdld = zzakvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzamc zzamcVar, Map map) {
        Object obj;
        com.google.android.gms.ads.internal.util.zzar zzarVar;
        obj = this.zzdlf.lock;
        synchronized (obj) {
            if (this.zzdlg.getStatus() != -1 && this.zzdlg.getStatus() != 1) {
                this.zzdlf.status = 0;
                zzarVar = this.zzdlf.zzdks;
                zzarVar.zzg(this.zzdld);
                this.zzdlg.zzl(this.zzdld);
                this.zzdlf.zzdku = this.zzdlg;
                com.google.android.gms.ads.internal.util.zzd.zzed("Successfully loaded JS Engine.");
            }
        }
    }
}
